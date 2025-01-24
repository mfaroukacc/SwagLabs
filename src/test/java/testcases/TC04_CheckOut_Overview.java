package testcases;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.P04_Checkout_Overview;

import java.time.Duration;

import static drivers.DriverHolder.getDriver;
import static pages.P04_Checkout_Overview.Success;
import static pages.PageBase.captureScreenshot;

public class TC04_CheckOut_Overview extends TestBase {

    P04_Checkout_Overview test;

    @Test(priority = 1, description = "Verify that total calculated correctly", enabled = true)
    public void VerifyTotal() {

        test = new P04_Checkout_Overview(getDriver());

        // Get the actual total price from the page
        double actualTotal = test.calculateTotalPrice();

        // Get the expected total price from another method (or predefined value)
        double expectedTotal = test.ItemTotal(); // Assuming you have such a method

        // Assert that the actual total price equals the expected total price
        Assert.assertEquals(actualTotal, expectedTotal, "The total price does not match the expected value.");
    }

    @Test(priority = 2, description = "Verify that order creation success message shows")
    public void SuccessMessage() {
        // Create the Page object

        new P04_Checkout_Overview(getDriver()).ClickOnFinishButton();
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(Success));
        String orderCreated = test.ExtractSuccessMessage();
        Assert.assertTrue(orderCreated.contains("THANK YOU FOR YOUR ORDER"), "Success message is not as expected.");
        captureScreenshot(getDriver(),"CheckOutSuccessfully");
    }

    }




