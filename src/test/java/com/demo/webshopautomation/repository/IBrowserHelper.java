package com.demo.webshopautomation.repository;

import org.openqa.selenium.WebDriver;

public interface IBrowserHelper {
    void closeBrowser();
    void initializeWebBrowser();
    WebDriver getWebDriver();
    void navigateToUrl(String url);
}