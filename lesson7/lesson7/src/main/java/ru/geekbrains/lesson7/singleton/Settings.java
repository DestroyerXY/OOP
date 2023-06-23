package ru.geekbrains.lesson7.singleton;

public class Settings {

    private static Settings instance;

    private String param1;
    private  int param2;

    public String getParam1() {
        return param1;
    }

    public int getParam2() {
        return param2;
    }

    private Settings(){

    }

    public static Settings getInstance(){
        if (instance == null)
            instance = new Settings();
        return  instance;
    }


}
