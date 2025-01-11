package testcases;

import org.testng.annotations.Test;
import pages.P01_LoginPage;

import static drivers.DriverHolder.getDriver;

public class TC01_Login extends TestBase{

    @Test(priority = 1,description = "Login to SwagLabs With Valid Credientials")
    public void loginToSwagLabsWithValidCredientials_P() throws InterruptedException {
      new P01_LoginPage(getDriver())
              .enterUsername(username)
              .enterPassword(password)
              .clickLoginButton();
      Thread.sleep(4000);
    }

//    @Test(priority = 2,description = "Fill password field then click login button")
//    public void fillPasswordThenClickLogin_N(){
//        loginPage=new P01_LoginPage(getDriver());
//
//        loginPage.enterPassword(password);
//        loginPage.clickLoginButton();
//    }
//
//    @Test(priority = 3,description = "Login with invalid credientials")
//    public void loginWithInvalidCredientials(){
//        loginPage=new P01_LoginPage(getDriver());
//
//        // reinitialize username and password with invalid data
//        username="fsdkfj";
//        password="ksdf";
//
//        loginPage.enterUsername(username);
//        loginPage.enterPassword(password);
//        loginPage.clickLoginButton();
//
//    }
}
