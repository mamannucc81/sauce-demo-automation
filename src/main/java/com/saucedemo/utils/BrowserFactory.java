package com.saucedemo.utils;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Playwright;

public class BrowserFactory {
    public static Browser createBrowser(Playwright playwright) {
        String browserType = System.getProperty("browser", "chromium");
        boolean headless = !Boolean.parseBoolean(System.getProperty("headful", "false"));
        int tiempoEspera = Integer.parseInt(System.getProperty("slowMo","2000"));

        BrowserType.LaunchOptions options = new BrowserType.LaunchOptions()
                .setHeadless(headless)
                .setSlowMo(tiempoEspera);

        switch (browserType.toLowerCase()) {
            case "firefox":
                return playwright.firefox().launch(options);
            case "webkit":
                return playwright.webkit().launch(options);
            case "chromium":
            default:
                return playwright.chromium().launch(options);
        }
    }
}
