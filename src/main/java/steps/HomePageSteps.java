package steps;

import org.openqa.selenium.WebDriver;
import pages.HomePage;

public class HomePageSteps {

    private HomePage homePage;

    public HomePageSteps(WebDriver driver){
        homePage = new HomePage(driver);
    }

    public void checkMonitorsInMenu(){
        homePage.getFragmentHomePage().mouseHover(homePage.chooseMonitorsMenu());
        homePage.waitForMonitorMenu();
        homePage.clickOnMonitorsMenu();
    }


}
