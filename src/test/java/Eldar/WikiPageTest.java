package Eldar;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertNotEquals;


public class WikiPageTest {
    private final String wiki = "https://en.m.wikipedia.org/wiki/Main_Page";
    private WebDriver driver;

    @BeforeAll
    static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void setupTest() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    void test() {
        driver.get(wiki);
        WikiPage page = new WikiPage(driver);
        page.setSearchText("Java");
        page.clickOnSearch();

        assertNotEquals(page.getCurrentWebElements(), 1);
        System.out.println("Количество текущих элементов = " + page.getCurrentWebElements());
        driver.quit();
    }
}





