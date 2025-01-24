package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static util.Utility.generateRandomName;
import static util.Utility.getRandomZipCodePrefix;

public class P03_Checkout_Fill_Information extends PageBase{

    public P03_Checkout_Fill_Information(WebDriver driver) {
        super(driver);
    }

    private final By FirstName = By.id("first-name");
    private final By LastName = By.id("last-name");
    private final By ZIP = By.id("postal-code");
    private final By ContinueButton = By.xpath("//input[@value='CONTINUE']");

    String FirstNameR = generateRandomName(1);
    String LastNameR = generateRandomName(1);
    String ZIPCode = getRandomZipCodePrefix();


    public P03_Checkout_Fill_Information EnterFirstName()
    {
        driver.findElement(FirstName).sendKeys(FirstNameR);
        return this;
    }

    public P03_Checkout_Fill_Information EnterLastName()
    {
        driver.findElement(LastName).sendKeys(LastNameR);
        return this;
    }

    public P03_Checkout_Fill_Information EnterZIPCode()
    {
        driver.findElement(ZIP).sendKeys(ZIPCode);
        return this;
    }

    public P03_Checkout_Fill_Information ClickOnContinue()
    {
        driver.findElement(ContinueButton).click();
        return this;
    }

}

