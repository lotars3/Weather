package pl.szymonsmenda.weathermap.models;

import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class DownloadWeatherService {
    private static DownloadWeatherService INSTANCE = new DownloadWeatherService();

    private DownloadWeatherService(){ }

    public static DownloadWeatherService getInstance(){
        return INSTANCE;
    }

    public String getWeather(String cityName, String countryName){
        String url = Config.URL_TO_API + cityName + "," + countryName + "&appid=" + Config.API_KEY;
        String cleanJSON = readWebsite(url);

        JSONObject root = new JSONObject(cleanJSON);
        JSONObject main = root.getJSONObject("main");

        double temp = main.getDouble("temp");


        JSONObject sys = root.getJSONObject("sys");
        String country = sys.getString("country");

        return "Temp " + (temp - 273) + " "  + country;

        //return readWebsite(url);
        //return null; //todo uzyc readWebsite i odczytac JSON, zwracjac pogode
    }

    private String readWebsite(String url){
        StringBuilder stringBuilder = new StringBuilder();
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(url).openConnection();
            InputStream inputStream = httpURLConnection.getInputStream();

            int response = 0;
            while ((response = inputStream.read()) != -1) {
                stringBuilder.append((char) response);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return stringBuilder.toString();
    }
}