package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TopMenu {
    WebDriver driver;
    public TopMenu(WebDriver driver){
        this.driver = driver;
    }
    public LoginPage clickLoginButton(){
        driver.findElement(By.linkText("Sign in")).click();
        return new LoginPage(driver);
    }
    public BlogPage clickBlogButton(){
        driver.findElement(By.linkText("Blog")).click();
        return new BlogPage(driver);
    }
    public LoginPage clickLoginInBlogPage(){
        driver.findElement(By.linkText("Sign In")).click();
        return new LoginPage(driver);
    }
}
