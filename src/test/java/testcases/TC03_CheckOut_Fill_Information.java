package testcases;

import org.testng.annotations.Test;
import pages.P03_Checkout_Fill_Information;

import static drivers.DriverHolder.getDriver;

public class TC03_CheckOut_Fill_Information extends TestBase {

    @Test(priority = 1, description = "Verify the ability to passing random data to information page")

    public void FillInformation()
    {

        new P03_Checkout_Fill_Information(getDriver()).EnterFirstName()
                .EnterLastName()
                .EnterZIPCode()
                .ClickOnContinue();
    }

    }


