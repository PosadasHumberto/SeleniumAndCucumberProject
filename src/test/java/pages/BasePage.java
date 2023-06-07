package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

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

    public static void closeBrowser(){
        driver.quit();
    }


    private WebElement find(String locator){
        try {
            return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
        } catch (TimeoutException e) {
            throw new NoSuchElementException("Element not found: " + locator);
        }
    }

    public void clickElement(String locator) {
        find(locator).click();
    }

    public void write(String locator, String textToWrite) {
        find(locator).clear();
        find(locator).sendKeys(textToWrite);
    }

    //funcion que devuelve valor de una celda dentro de una tabla
    public String getValueFromTable(String locator, int row, int column){
        // /html[1]/body[1]/p[8]/table[1]/tbody[1]/tr[2]/td[2]
        String cellINeed = locator + "/tbody[1]/tr[" + row + "]/td[" + column + "]";
        return find(cellINeed).getText();
    }

    //funcion que va a establecer el valor de una celda dentro de una tabla determinada
    public void setValueOnTable(String locator, int row, int column, String stringToSend){
        String cellToFill = locator + "/tbody[1]/tr[" + row + "]/td[" + column + "]";
        find(cellToFill).sendKeys(stringToSend);
    }

    //funciones que van a cambiar el IFrame al principal
    public void switchToIFrame(Integer iFrameId){
        driver.switchTo().frame(iFrameId);
    }

    public void switchToParentFrame(){
        driver.switchTo().parentFrame();
    }

    //funcion que va a cerrar una alerta si esta se produce y pueda estropear nuestra automatizacion
    public void dismissAlert(){
        try{
            driver.switchTo().alert().dismiss();
        } catch(NoAlertPresentException e) {
            e.printStackTrace();
        }
    }

    //funcion que devuelve el texto de un elemento para poder hacer aserciones en los steps
    public String textFromElement(String locator) {
        return find(locator).getText();
    }

    //funcion que nos devuelve true si un elemento esta siendo mostrado es decir que no esta oculto
    public boolean elementIsDisplayed(String locator) {
        return find(locator).isDisplayed();
    }

    //funcion que nos devuelve true si un elemento esta seleccionado
    public boolean elementIsSelected(String locator){
        return find(locator).isSelected();
    }

    //funcion que va a recuperar una lista de elementos WebElement
    public List<WebElement> bringMeAllElements(String locator) {
        return driver.findElements(By.className(locator));
    }

}
