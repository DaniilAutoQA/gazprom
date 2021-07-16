package ru.gazprombank.config;

import org.aeonbits.owner.ConfigFactory;

public class Project {
    public static ru.gazprombank.config.ProjectConfig config = ConfigFactory.create(ru.gazprombank.config.ProjectConfig.class, System.getProperties());

    public static boolean isRemoteWebDriver() {
        return !config.remoteDriverUrl().equals("");
    }

    public static boolean isVideoOn() {
        return !config.videoStorage().equals("");
    }
}
