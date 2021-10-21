package Eldar;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class WikiPage {
    private final WebDriver driver;
    private final WebElement searchInputElement;
    private final WebElement searchButton;

    public WikiPage(WebDriver driver) {
        this.driver = driver;
        this.searchInputElement = driver.findElement(By.id("searchInput"));
        this.searchButton = driver.findElement(By.id("searchButton"));
    }
    public void setSearchText(String text){
        this.searchInputElement.sendKeys(text);
    }
    public void clickOnSearch(){
        this.searchButton.click();
    }
    public String getCurrentUrl(){
        return driver.getCurrentUrl();
    }



}
