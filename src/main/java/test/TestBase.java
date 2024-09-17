package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public abstract class TestBase {

    WebDriver driver;

    public void testInit(){

        driver = new ChromeDriver();
        driver.get("https://openweathermap.org/");
        driver.manage().window().maximize();
    }

}
