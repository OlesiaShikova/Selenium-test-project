import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class GoogleSearchTest {
    private WebDriver driver;
    private GooglePage googlePage;

    @BeforeEach
    void setUp() {
        driver = new ChromeDriver();
        googlePage = new GooglePage(driver);
    }

    @Test
    void googleSearch_shouldShowResultsPage() {
        googlePage.open();
        googlePage.acceptCookies();
        googlePage.search("Continentale Versicherung");
        googlePage.waitForResultsTitleToContain("Continentale");
        assertTrue(googlePage.getTitle().contains("Continentale"));
    }

    @AfterEach
    void tearDown() {
        driver.quit();
    }
}












