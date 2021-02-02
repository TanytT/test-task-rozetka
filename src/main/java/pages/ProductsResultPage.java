package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;

public class ProductsResultPage {

    private WebDriver driver;
    private WebDriverWait wait;
    private By monitorsListBy = By.cssSelector("div.goods-tile__inner");
    private By checkButton4KBy = By.cssSelector(".sidebar div:nth-child(9) ul:first-child>li:nth-child(8)>a");
    private By allProductsListBy = By.cssSelector("img.ng-lazyloaded");
    private By img4KBy = By.cssSelector("img[alt='Ultra HD 4K (3840х2160)']");
    private By maxPriceFieldBy = By.cssSelector("input[formcontrolname='max']");
    private By priceOfProductBy = By.cssSelector("span.goods-tile__price-value");
    private By cntOfCommentBy = By.cssSelector("span.goods-tile__reviews-link");

    public ProductsResultPage(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver, 10);
    }

    public void checkFilter4K() {
        wait.until(presenceOfElementLocated(checkButton4KBy));
        driver.findElement(checkButton4KBy).click();
    }

    public void waitForLoadAllProducts() {
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(allProductsListBy));
    }

    public boolean isContainingImg4K(){
        List<WebElement> monitorsList= driver.findElements(monitorsListBy);
        for (WebElement elemMonit: monitorsList) {
            if(!elemMonit.findElement(img4KBy).getAttribute("src").contains("100838.png")){
                return false;
            }
        }
        return true;
    }

    public void setMaxPrice(int maxPrice) {
        driver.findElement(maxPriceFieldBy).clear();
        driver.findElement(maxPriceFieldBy).sendKeys(Integer.toString(maxPrice)+ Keys.ENTER);

    }

    public boolean isPriceLessThanMax(int maxPrice) {
        List<WebElement> monList = driver.findElements(monitorsListBy);
        for (WebElement elemPrice: monList) {
            String strPrice = elemPrice.findElement(priceOfProductBy).getText();
            if(strToInt(strPrice)>maxPrice){
                return false;
            }
        }
        return true;
    }

    private Integer strToInt(String str){
        return Integer.parseInt(str.replaceAll("\\D",""));
    }

    public void outputMonitorsByNumberOfComments() {
        List<WebElement> monitors = driver.findElements(monitorsListBy);
        Map<String,Integer> commentMonitorMap = new HashMap<>();
        for (WebElement elem: monitors) {
            try{
                commentMonitorMap.put(elem.getText(), strToInt(elem.findElement(cntOfCommentBy).getText()));
            }catch (NoSuchElementException e){
                commentMonitorMap.put(elem.getText(), 0);
            }
        }
        commentMonitorMap.entrySet().stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                .forEach(e -> System.out.println(e.getKey()+"\n"));

    }
}
