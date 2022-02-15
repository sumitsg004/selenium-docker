package com.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.net.MalformedURLException;
import java.net.URL;

public class BaseTests {
    protected WebDriver driver;
    @BeforeTest
    public void setUpDriver() throws MalformedURLException {
        //BRWOSER => chrome/firefox
        //HUB_HOST => localhost/ip address/hostname
        String host = "localhost";
        DesiredCapabilities capabilities;
        if(System.getProperty("BROWSER") != null && System.getProperty("BROWSER").equalsIgnoreCase("firefox"))
            capabilities = DesiredCapabilities.firefox();
        else
            capabilities = DesiredCapabilities.chrome();

        if(System.getProperty("HUB_HOST") != null)
            host = System.getProperty("HUB_HOST");

        String url = "http://" + host + ":4444/wd/hub";
        this.driver = new RemoteWebDriver(new URL(url), capabilities);
        driver.manage().window().maximize();
    }

    @AfterTest
    public void tearDown() {
        this.driver.quit();
    }
}
