package testcases;

import org.testng.annotations.Test;
import pages.P01_LoginPage;
import pages.P02_ProductsPage;

import static drivers.DriverHolder.getDriver;

public class TC02_Products extends TestBase {

    @Test(priority = 1, description = "Add Product from product page")
    public void verifyUserCanAddProductSuccessfully_P() throws InterruptedException {
        // TODO: login to app
        new P01_LoginPage(getDriver()).enterUsername(username).enterPassword(password).clickLoginButton();

        // TODO: select product
        new P02_ProductsPage(getDriver()).clickFirstProduct();

//        new P01_LoginPage(getDriver())
//                .enterUsername(username)
//                .enterPassword(password)
//                .clickLoginButton()
//                .clickFirstProduct();
        // TODO: sleep 3 sec
        Thread.sleep(3000);
    }
}
