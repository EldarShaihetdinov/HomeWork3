package Eldar;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;


public class WikiPage {
    private final WebDriver driver;
    private final WebElement searchInputElement;


    public WikiPage(WebDriver driver) {
        this.driver = driver;
        this.searchInputElement = driver.findElement(By.id("searchInput"));
    }
    public void setSearchText(String text) {
        this.searchInputElement.click();
        driver.findElement(By.xpath("//input[@class=\"search mw-ui-background-icon-search\"]")).sendKeys(text);
    }
    public void clickOnSearch() {
        driver.findElement(By.xpath("//div//p[@class=\"with-results\"]")).click();
    }
    public int getCurrentWebElements() {
        WebElement element = driver.findElement(By.xpath("//ul[@class=\"mw-search-results\"]"));
        List<WebElement> list = element.findElements(By.tagName("li"));
        int count = list.size();
        return count;
    }
}
