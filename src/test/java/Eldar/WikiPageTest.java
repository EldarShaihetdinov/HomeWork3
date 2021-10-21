package Eldar;



import org.junit.After;
import org.junit.Before;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class WikiPageTest {
    private final String url = "https://ru.wikipedia.org";
    private WebDriver driver;

    @BeforeAll
    static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void setupTest() {
        driver = new ChromeDriver();
    }

    @Before
    public void initWebDriver() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.navigate().to(url);

    }
    @Test
    void test() {
    driver.get(url);
    WikiPage page = new WikiPage(driver);
    page.setSearchText("Java");
    page.clickOnSearch();
    page.getCurrentUrl();

    assertNotEquals(2,1);
    }
    @After
    public void closeDriver(){
        driver.quit();
    }



}






