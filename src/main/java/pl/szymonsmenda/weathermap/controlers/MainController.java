package pl.szymonsmenda.weathermap.controlers;


import pl.szymonsmenda.weathermap.models.DownloadWeatherService;
import pl.szymonsmenda.weathermap.views.MainView;
import java.util.Scanner;

public class MainController {
    private MainView mainView;
    private Scanner scanner;
    private DownloadWeatherService downloadWeatherService = DownloadWeatherService.getInstance();

    public MainController(){
        mainView = new MainView();
        scanner = new Scanner(System.in);
    }

    public void start() {
        mainView.showWelcomeText();
        createMainLoop();
    }

    public void createMainLoop() {
        String userAnswerCity;
        String userAnswerCountry;
        do{
            mainView.showCityRequestText();
            userAnswerCity = scanner.nextLine();

            mainView.showCountryCodeRequestText();
            userAnswerCountry = scanner.nextLine();

            mainView.showWeather(downloadWeatherService.getWeather(userAnswerCity, userAnswerCountry));
        }while (!userAnswerCity.equals("exit"));
    }
}