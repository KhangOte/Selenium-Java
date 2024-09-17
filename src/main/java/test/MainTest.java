package test;

import org.testng.Assert;
import org.testng.annotations.*;
import page.*;


public class MainTest extends TestBase {


    @BeforeMethod
    public void testSetup(){
        super.testInit();

    }


    @Test
    public void test1() throws InterruptedException{
        TopMenu topMenu = new TopMenu(driver);
        LoginPage loginPage = new LoginPage(driver);
//        loginPage.login();
        topMenu.clickBlogButton();
        Object[] windowHandle = driver.getWindowHandles().toArray();
        driver.switchTo().window(windowHandle[1].toString());
//        System.out.println(windowHandle[0].toString());
//        System.out.println(windowHandle[1].toString());
        String messageFailed = "Invalid Email or password.";
        topMenu.clickLoginInBlogPage();
        loginPage.login("minionmatbua@gmail.com","12345678");
        String messageLogin = loginPage.getTextLogin();

        if (messageLogin.equals(messageFailed)==true) {
            System.out.println("Login Failed");
        }
        else
        {
            System.out.println("Login Successfully");

        }


        Thread.sleep(3000);
        driver.quit();
    }


    @Test
    @Parameters({"email-from-xml"})// -> include value from testng.xml
    public void test2(String email) throws InterruptedException{


        TopMenu topMenu = new TopMenu(driver);
        LoginPage loginPage = new LoginPage(driver);
        AccountLogin accountLogin = new AccountLogin(driver);
        topMenu.clickBlogButton();
        Object[] windowHandle = driver.getWindowHandles().toArray();
        driver.switchTo().window(windowHandle[1].toString());
        topMenu.clickLoginInBlogPage();
        loginPage.login(email,"12345678");
        String messageLogin = loginPage.getTextLogin();
        String messageFailed = "Invalid Email or password.";
        if (messageLogin.equals(messageFailed)==true){
            System.out.println("Login Failed");
        }
        else {
            System.out.println("Login Successfully");
        }

//        driver.quit();
    }


    @Test
    @DataProvider(name = "test3")// -> use to can assign a lot of values for test
    public static Object[][] primeNumbers() {
        return new Object[][] {{"",""},{"minionmatbua@gmail", "pasword1"},{"minionmatbua@gmail", ""},{"minionmatbua@gmail.com","12345678"}};// -> assign values
    }

    @Test(dataProvider = "test3")// -> 
    public void test3(String email, String password) throws InterruptedException{

        TopMenu topMenu = new TopMenu(driver);
        LoginPage loginPage = new LoginPage(driver);
        topMenu.clickBlogButton();
        Object[] windowHandle = driver.getWindowHandles().toArray();
        driver.switchTo().window(windowHandle[1].toString());
        topMenu.clickLoginInBlogPage();
        loginPage.login(email,password);
        String messageLogin = loginPage.getTextLogin();
        String messageFailed = "Invalid Email or password.";
        Assert.assertEquals(messageLogin,messageFailed);{
            System.out.println("Login Failed");
        }


//        if (messageLogin.equals(messageFailed)==true){
//            System.out.println("Login Failed");
//        }
//        else {
//            System.out.println("Login Successfully");
//        }

        driver.quit();
    }
}
