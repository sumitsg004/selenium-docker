package com.newtours.tests;

import com.newtours.pages.*;
import com.tests.BaseTests;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class BookFlightTest extends BaseTests {

    private String numberOfPassengers;
    private String expectedPrice;

    @BeforeTest
    @Parameters({"numberOfPassengers", "expectedPrice"})
    public void SetupDriver(String numberOfPassengers, String expectedPrice) {
    this.numberOfPassengers = numberOfPassengers;
    this.expectedPrice = expectedPrice;
    }

    @Test
    public void registrationPageTest() {
        RegistrationPage registrationpage = new RegistrationPage(driver);
        registrationpage.goTo();
        registrationpage.EnterRegistrationDetails("selenium", "docker");
        registrationpage.RegistrationDetailsSubmit();
    }

    @Test (dependsOnMethods = {"registrationPageTest"})
    public void registrationConfirmationPage() {
        RegistrationConfirmationPage registrationconfirmationpage = new RegistrationConfirmationPage(driver);
        registrationconfirmationpage.clickOnFlightsLink();
    }

    @Test (dependsOnMethods = "registrationConfirmationPage")
    public void flightDetailsTest() {
        FlightDetailsPage flightdetails = new FlightDetailsPage(driver);
        flightdetails.SelectNumberOfPassengers(numberOfPassengers);
        flightdetails.FlightDetailsSubmit();
    }

    @Test (dependsOnMethods = "flightDetailsTest")
    public void SelectFlightTest() {
        SelectFlights selectflights = new SelectFlights(driver);
        selectflights.ReserveFlight();
        selectflights.SubmitBillingDetails();
    }

    @Test (dependsOnMethods = "SelectFlightTest")
    public void FlightConfirmationTest() {
        FlightConfirmationPage flightconfirmation = new FlightConfirmationPage(driver);
        String actualPrice = flightconfirmation.PrintFlightConfirmationDetails();
        Assert.assertEquals(actualPrice, expectedPrice);
        flightconfirmation.SignOff();
    }
}
