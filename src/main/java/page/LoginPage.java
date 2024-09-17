package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class LoginPage {

    WebDriver driver;


    @FindBy(id = "user_email")
    WebElement userEmail;

    @FindBy(id = "user_password")
    WebElement userPassword;

    public  LoginPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);

    }

    public void login(String email, String password){ //-> gan string email va string pwd de co the khai bao 2 gia tri khi goi ham login
        userEmail.sendKeys(email);
        userPassword.sendKeys(password);
        driver.findElement(By.name("commit")).click();

    }

    public void verifyLogin(){
        String name = "Test Login";
        String checkName = driver.findElement(By.cssSelector("div.inner-user-container")).getText();
        Assert.assertTrue(checkName.equals(name));
    }

    public String getTextLogin(){
        String panelBody = driver.findElement(By.cssSelector(".panel-body")).getText();
        return panelBody;
    }






}
