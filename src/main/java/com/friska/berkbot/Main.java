package com.friska.berkbot;

import net.dv8tion.jda.api.JDABuilder;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Main {

    public static void main(String[] args) {
        JDABuilder jdaBuilder = JDABuilder.createDefault(getToken());


    }

    private static String getToken(){
        Properties prop = new Properties();
        String fileName = "src/main/resources/berkbot.config";
        try (FileInputStream fis = new FileInputStream(fileName)) {
            prop.load(fis);
            return prop.getProperty("token");
        } catch (IOException ignored) {
            return null;
        }
    }
}
