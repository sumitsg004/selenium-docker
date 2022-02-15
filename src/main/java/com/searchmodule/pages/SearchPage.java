package com.searchmodule.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class SearchPage {

    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(name = "q")
    private WebElement searchBox;

    @FindBy(id = "search_button_homepage")
    private WebElement submitButton;

    @FindBy(linkText = "Videos")
    private WebElement videosLink;

    @FindBy(className = "tile--vid")
    private List<WebElement> allVideos;

    public SearchPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 30);
        PageFactory.initElements(driver, this);
    }

    public void goTo() {
        this.driver.get("https://duckduckgo.com/");
    }

    public void Search(String searchText) {
        wait.until(ExpectedConditions.visibilityOf(searchBox));
        searchBox.sendKeys(searchText);
        submitButton.click();
    }

    public void goToVideos() {
        wait.until(ExpectedConditions.visibilityOf(videosLink));
        videosLink.click();
    }

    public int getResult() {
        By by = By.className("tile--vid");
        wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(by, 0));
        return allVideos.size();
    }
}
