package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;

public class WaitToLoad {
WebDriver driver;
@FindBy (name = "q")
WebElement searchBox;

public void WaitToLoad(WebDriver driver){
    this.driver = driver;
    PageFactory.initElements(driver,this);
}
public void WaitLoad(){
    Wait<WebDriver>wait = new FluentWait<WebDriver>(driver)
            .withTimeout(Duration.ofSeconds(10))
            .pollingEvery(Duration.ofSeconds(2));
    wait.until(s-> searchBox.isDisplayed());
}
}
