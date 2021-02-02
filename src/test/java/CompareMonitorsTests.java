
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.ProductsResultPage;
import steps.HomePageSteps;
import steps.ProductsResultPageSteps;


public class CompareMonitorsTests extends Base{

    private ProductsResultPage productsResultPage;
    private final int maxPrice = 9000;
    private ProductsResultPageSteps productsResultPageSteps;
    private HomePageSteps homePageSteps;

    @BeforeMethod
    public void startUp(){
        driver.get(Base.url);
        driver.manage().window().maximize();
        productsResultPage = new ProductsResultPage(driver);
        productsResultPageSteps = new ProductsResultPageSteps(driver);
        homePageSteps = new HomePageSteps(driver);

    }

    @Test
    public void compareMonitorsTest(){
        homePageSteps.checkMonitorsInMenu();
        productsResultPageSteps.check4KFilter();
        productsResultPageSteps.verify4KOfAllMonitors();
        productsResultPageSteps.checkFilterPrice(maxPrice);
        productsResultPageSteps.verifyPricesOfAllMonitors(maxPrice);
        productsResultPageSteps.outputMonitorsSortedByComments();

    }
}
