package com.demo.webshopautomation.business;

import com.demo.webshopautomation.repository.IBrowserHelper;
import com.demo.webshopautomation.utils.BrowserSelector;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserHelper implements IBrowserHelper {
    private WebDriver _driver;
    private final BrowserSelector _browserSelector;

    public BrowserHelper(BrowserSelector browserSelector){
        _browserSelector = browserSelector;
    }

    @Override
    public void closeBrowser() {
        if(_driver != null)
            _driver.quit();
    }

    @Override
    public void initializeWebBrowser() {
        switch(_browserSelector){
            case FIREFOX -> _driver = new FirefoxDriver();
            case CHROME -> _driver = new ChromeDriver();
            case EDGE -> _driver = new EdgeDriver();
            default -> System.out.println("No compatible WebDriver found!");
        }

        _driver.manage().window().fullscreen();
    }

    @Override
    public WebDriver getWebDriver() {
        if(_driver != null)
            return _driver;

        return null;
    }

    @Override
    public void navigateToUrl(String url) {
        if(_driver != null &&
                !url.isEmpty() &&
                !url.isBlank())
            _driver.get(url.toLowerCase());
    }
}
