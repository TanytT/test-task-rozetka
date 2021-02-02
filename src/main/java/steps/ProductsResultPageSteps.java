package steps;

import org.openqa.selenium.WebDriver;
import pages.ProductsResultPage;
import static org.testng.Assert.assertTrue;

public class ProductsResultPageSteps {

    private ProductsResultPage productsResultPage;

    public ProductsResultPageSteps(WebDriver driver){
        productsResultPage = new ProductsResultPage(driver);
    }

    public void check4KFilter() {
        productsResultPage.waitForLoadAllProducts();
        productsResultPage.checkFilter4K();
        productsResultPage.waitForLoadAllProducts();
    }

    public void verify4KOfAllMonitors() {
        assertTrue(productsResultPage.isContainingImg4K(),"Some monitor is not 4K!");
    }

    public void checkFilterPrice(int maxPrice) {
        productsResultPage.setMaxPrice(maxPrice);
        productsResultPage.waitForLoadAllProducts();

    }

    public void verifyPricesOfAllMonitors(int maxPrice) {
        assertTrue(productsResultPage.isPriceLessThanMax(maxPrice), "Some monitor's price is more than "+maxPrice);
    }

    public void outputMonitorsSortedByComments() {
        productsResultPage.outputMonitorsByNumberOfComments();
    }
}
