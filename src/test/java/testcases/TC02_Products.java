package testcases;

import org.testng.annotations.Test;
import pages.P01_LoginPage;
import pages.P02_ProductsPage;

import java.util.concurrent.TimeUnit;

import static drivers.DriverHolder.getDriver;

public class TC02_Products extends TestBase {

    @Test(priority = 1, description = "Add Product from product page")
    public void verifyUserCanAddProductSuccessfully_P() throws InterruptedException {
        // TODO: login to app
        // new P01_LoginPage(getDriver()).enterUsername(username).enterPassword(password).clickLoginButton();

        getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        // TODO: select product - Open Cart - Navigate to CheckoutPage
        new P02_ProductsPage(getDriver()).selectRandomAddToCartButton().CartAction().CheckoutAction();

//        new P01_LoginPage(getDriver())
//                .enterUsername(username)
//                .enterPassword(password)
//                .clickLoginButton()
//                .clickFirstProduct();
        // TODO: sleep 3 sec
        Thread.sleep(3000);
    }
}


// List<WebElement> buttons = driver.findElements(By.xpath("//*[contains(text(), 'Add to cart')]"));
//
