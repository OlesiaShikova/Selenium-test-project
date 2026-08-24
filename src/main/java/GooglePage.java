import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;

public class GooglePage {
    private WebDriver driver;
    private WebDriverWait wait;

    public GooglePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void open() {
        driver.get("https://www.google.com");
    }

    public void acceptCookies() {
        try {
            WebElement button = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(., 'Alle akzeptieren')]")));
            button.click();
        } catch (Exception e) {}
    }

    public void search(String query) {
        WebElement box = wait.until(ExpectedConditions.elementToBeClickable(By.name("q")));
        box.sendKeys(query);
        box.submit();
    }

    public void waitForResultsTitleToContain(String text) {
        wait.until(ExpectedConditions.titleContains(text));
    }

    public String getTitle() {
        return driver.getTitle();
    }

}
