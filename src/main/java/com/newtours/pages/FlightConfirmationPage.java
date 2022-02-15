package com.newtours.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class FlightConfirmationPage {

    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(xpath = "//font[contains(text(), 'Flight Itinerary Page')]")
    private WebElement FlightConfirmationHeader;

    @FindBy(xpath = "//font[contains(text(), 'USD')]")
    private List<WebElement> prices;

    @FindBy(linkText = "SIGN-OFF")
    private WebElement signOff;

    public FlightConfirmationPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 30);
        PageFactory.initElements(driver, this);
    }

    public String PrintFlightConfirmationDetails() {
        wait.until(ExpectedConditions.visibilityOf(FlightConfirmationHeader));
        System.out.println(FlightConfirmationHeader.getText());
        System.out.println(prices.get(1).getText());
        return prices.get(1).getText();
    }

    public void SignOff() {
        signOff.click();
    }
}
