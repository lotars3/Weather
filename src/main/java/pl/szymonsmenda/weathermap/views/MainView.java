package pl.szymonsmenda.weathermap.views;

public class MainView {
    public void showWelcomeText(){
        System.out.println("Witaj w WeatherMap!");
        System.out.println("Jesteśmy tu, aby Ci pomóc.. <3");
    }

    public void showCityRequestText(){
        System.out.println("Podaj miasto: ");
    }

    public void showCountryCodeRequestText(){
        System.out.println("Podaj kod: ");
    }

    public void showWeather(String weatherText){
        System.out.println(weatherText);
    }


}