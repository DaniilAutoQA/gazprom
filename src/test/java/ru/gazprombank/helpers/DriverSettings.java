package ru.gazprombank.helpers;

import com.codeborne.selenide.Configuration;
import org.openqa.selenium.remote.DesiredCapabilities;
import ru.gazprombank.config.Project;

public class DriverSettings {

    public static void configure() {
        Configuration.browser = Project.config.browser();
        Configuration.browserVersion = Project.config.browserVersion();
        Configuration.browserSize = Project.config.browserSize();

        DesiredCapabilities capabilities = new DesiredCapabilities();


        capabilities.setCapability("enableVNC", true);
        capabilities.setCapability("enableVideo", true);
        Configuration.remote = "https://user1:1234@selenoid.autotests.cloud/wd/hub/";


        Configuration.browserCapabilities = capabilities;
    }
}
