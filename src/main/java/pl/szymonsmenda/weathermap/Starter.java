package pl.szymonsmenda.weathermap;


import pl.szymonsmenda.weathermap.controlers.MainController;

import java.util.regex.Pattern;

public class Starter{

    public static void main(String[] args) {
        new MainController().start();

//        System.out.println(Pattern.matches("([0-9]{2}-[0-9]{3})", "30-384"));
//        System.out.println(Pattern.matches("[0-9]{9}", "515072034"));
//        System.out.println(Pattern.matches("(\\+?48)? ?[0-9]{9}", "+48 515072034"));
//        System.out.println(Pattern.matches("[A-ZĄŻŻÓĘ]{2,25} [a-złłąćżćł]{2,25}" , "Szymon Smenda"));
    }
}
