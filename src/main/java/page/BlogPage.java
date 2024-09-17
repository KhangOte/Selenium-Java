package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BlogPage {
    WebDriver driver;

    public  BlogPage(WebDriver driver){
        this.driver = driver;
    }
    public void clickAllButton(){
        driver.findElement(By.linkText("ALL")).click();
    }
}
