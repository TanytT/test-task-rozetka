package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import fragments.FragmentHomePage;

public class HomePage {

    private WebDriver driver;
    private WebDriverWait wait;
    private FragmentHomePage fragmentHomePage;
    private By mainMenuBy = By.cssSelector("ul.menu-categories_type_main>li:first-child>a");
    private By monitorsMenuBy = By.cssSelector("li:first-child>a[href$=\"monitors/c80089/\"]");

    public HomePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver,10);
        fragmentHomePage = new FragmentHomePage(driver);
    }

    public WebElement chooseMonitorsMenu(){
        return driver.findElement(mainMenuBy);
    }
    public void waitForMonitorMenu(){
        wait.until(ExpectedConditions.elementToBeClickable(monitorsMenuBy));
    }

    public void clickOnMonitorsMenu(){
        driver.findElement(monitorsMenuBy).click();
    }

    public FragmentHomePage getFragmentHomePage(){
        return fragmentHomePage;
    }
}
