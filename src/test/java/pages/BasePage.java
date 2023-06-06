package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {

    protected static WebDriver driver;
    private static WebDriverWait wait;
    private static Actions actions;

    static {
        ChromeOptions chromeOptions = new ChromeOptions();
        driver = new ChromeDriver(chromeOptions);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));       //espera explicita, en el momento en que se encuentre e WebElement va a continuar con el flujo.
    }

    public BasePage(WebDriver driver) {
        BasePage.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public static void navigateTo(String url) {
        driver.get(url);
    }

    private WebElement find(String locator){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
    }

    public void clickElement(String locator) {
        find(locator).click();
    }

    public void write(String locator, String textToWrite) {
        find(locator).clear();
        find(locator).sendKeys(textToWrite);
    }

    public String getValueFromTable(String locator, int row, int column){
        // /html[1]/body[1]/p[8]/table[1]/tbody[1]/tr[2]/td[2]
        String cellINeed = locator + "/tbody[1]/tr[" + row + "]/td[" + column + "]";
        return find(cellINeed).getText();
    }

    public void setValueOnTable(String locator, int row, int column, String stringToSend){
        String cellToFill = locator + "/tbody[1]/tr[" + row + "]/td[" + column + "]";
        find(cellToFill).sendKeys(stringToSend);
    }

    public void switchToIFrame(Integer iFrameId){
        driver.switchTo().frame(iFrameId);
    }

    public void switchToParentFrame(){
        driver.switchTo().parentFrame();
    }

    public void dismissAlert(){
        driver.switchTo().alert().dismiss();
    }
}
