package com.friska.berkbot;

import com.friska.berkbot.trainer.TrainerListener;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.requests.GatewayIntent;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Random;

public class Main {

    public static final Config config;

    static {
        config = getConfig();
    }

    public static void main(String[] args) {
        JDABuilder jdaBuilder = JDABuilder.createDefault(config.token()).enableIntents(GatewayIntent.MESSAGE_CONTENT);
        jdaBuilder.addEventListeners(new TrainerListener());
        jdaBuilder.build();
    }

    private static Config getConfig(){
        Properties prop = new Properties();
        String fileName = "src/main/resources/berkbot.config";
        try (FileInputStream fis = new FileInputStream(fileName)) {
            prop.load(fis);
            return new Config(prop.getProperty("token"), prop.getProperty("prefix"), prop.getProperty("prefix2"));
        } catch (IOException ignored) {
            return null;
        }
    }
}
