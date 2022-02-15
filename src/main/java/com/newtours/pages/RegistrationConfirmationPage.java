package com.newtours.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegistrationConfirmationPage {

    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(linkText = "Flights")
    private WebElement FlightsLink;

    @FindBy(partialLinkText = "sign-in")
    private WebElement signInLink;

    public RegistrationConfirmationPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 30);
        PageFactory.initElements(driver, this);
    }

    public void clickOnFlightsLink() {
        wait.until(ExpectedConditions.visibilityOf(signInLink));
        FlightsLink.click();
    }

}
