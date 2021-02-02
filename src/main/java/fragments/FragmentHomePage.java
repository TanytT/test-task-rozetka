package fragments;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;


public class FragmentHomePage {

        protected WebDriver driver;

        public FragmentHomePage(WebDriver driver){
            this.driver = driver;
        }

        public void mouseHover(WebElement element) {
            Actions action = new Actions(driver);
            action.build();
            action.moveToElement(element);
            action.perform();
        }

}
