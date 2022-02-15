package com.newtours.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SelectFlights {

    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(name = "reserveFlights")
    private WebElement reserveFlights;

    @FindBy(id = "buyFlights")
    private WebElement SubmitBillingDetails;

    public SelectFlights(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 30);
        PageFactory.initElements(driver, this);
    }

    public void ReserveFlight() {
        wait.until(ExpectedConditions.visibilityOf(reserveFlights));
        reserveFlights.click();
    }

    public void SubmitBillingDetails() {
        wait.until(ExpectedConditions.visibilityOf(SubmitBillingDetails));
        SubmitBillingDetails.click();
    }
}
