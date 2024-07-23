package com.demo.webshopautomation.pages;

import com.demo.webshopautomation.repository.IBrowserHelper;
import com.demo.webshopautomation.repository.IHomePageHelper;
import com.demo.webshopautomation.repository.IUrlHelper;
import com.demo.webshopautomation.utils.BaseUtils;
import com.demo.webshopautomation.utils.UrlSelector;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class HomePage implements IHomePageHelper {
    private final By _registerElement = By.className("ico-register");
    private final By _loginElement = By.className("ico-login");
    private final IBrowserHelper _browserHelper;
    private final IUrlHelper _urlHelper;
    private final List<WebElement> _elements;

    public HomePage(IBrowserHelper browserHelper, IUrlHelper urlHelper, ArrayList<WebElement> webElements){
        _browserHelper = browserHelper;
        _urlHelper = urlHelper;
        _elements = webElements;
        PageFactory.initElements(_browserHelper.getWebDriver(), this);
    }

    @Override
    public boolean isOnHomePage() {
        var actual = _browserHelper.getWebDriver().getCurrentUrl();
        var expected = _urlHelper.getUrl(UrlSelector.BASE);
        return actual.equalsIgnoreCase(expected);
    }

    @Override
    public void waitForElements() {
        waitForRequiredElements(_loginElement, _registerElement, _elements);
    }

    @Override
    public void clickLoginBtn() {
        if(_browserHelper.getWebDriver().findElement(_loginElement) != null)
            _browserHelper.getWebDriver().findElement(_loginElement).click();
    }

    private void waitForRequiredElements(By loginElement, By registerElement, List<WebElement> elements) {
        try{
            if(!elements.isEmpty())
                elements.clear();
            elements.add(_browserHelper.getWebDriver().findElement(loginElement));
            elements.add(_browserHelper.getWebDriver().findElement(registerElement));
            var wait = new WebDriverWait(_browserHelper.getWebDriver(), Duration.ofSeconds(BaseUtils.WAIT_TIME));
            wait.until(ExpectedConditions.visibilityOfAllElements(elements));
        }catch (Exception ex){
            System.out.printf("""
                    Wait for elements error: %s
                    """, ex.getMessage());
        }
    }
}
