package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountLogin {
    WebDriver driver;

    @FindBy(id = "user_email")
    WebElement userName;

    @FindBy(id = "user_password")
    WebElement userPassword;

    @FindBy(name = "commit")
    WebElement clickSummitButton;

    public AccountLogin(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public void account1(){
        userName.sendKeys("minionmatbua@gmail");
        userPassword.sendKeys("12345678");
        clickSummitButton.click();
    }
    public void account2(){
        userName.sendKeys("minionmatbua@gmail.com");
        userPassword.sendKeys("123456789");
        clickSummitButton.click();
    }
    public void account3(){
        userName.sendKeys("minionmatbua@gmail");
        userPassword.sendKeys("123456");
        clickSummitButton.click();
    }
}
