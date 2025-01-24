package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class P04_Checkout_Overview extends PageBase {


    public P04_Checkout_Overview(WebDriver driver) {
        super(driver);
    }

    private final By Price = By.className("inventory_item_price");
    private static final By Total = By.className("summary_subtotal_label");
    private final By FinishButton = By.partialLinkText("FINISH");
    public static final By Success = By.xpath("//h2[@class='complete-header' and text()='THANK YOU FOR YOUR ORDER']");

    public double calculateTotalPrice() {
        // Step 1: Find all elements with the class 'inventory_item_price'
        List<WebElement> priceElements = driver.findElements(Price);

        double total = 0.0;

        // Step 2: Loop through the list of price elements and calculate the total
        for (WebElement priceElement : priceElements) {
            // Extract the price text (e.g., "$29.99")
            String priceText = priceElement.getText().trim();

            // Step 3: Remove the dollar sign and parse the number
            try {
                double price = Double.parseDouble(priceText.replace("$", ""));
                total += price;
            } catch (NumberFormatException e) {
                // Handle the case where the price is not valid (e.g., if there's a non-numeric value)
                System.out.println("Error parsing price: " + priceText);
            }
        }

        // Step 4: Return the total sum
        return total;
    }

    public double ItemTotal() {

        // WebElement priceElement = driver.findElement(By.className("summary_subtotal_label"));
        // Step 1: Find the element with the class 'summary_subtotal_label'
        WebElement priceElement = driver.findElement(Total);

        // Step 2: Extract the text from the element (e.g., "Item total: $39.98")
        String priceText = priceElement.getText().trim();

        // Step 3: Remove the "Item total: $" part and parse the number
        String priceString = priceText.replace("Item total: $", "").trim();

        // Step 4: Convert the remaining string to a double (e.g., 39.98)
        double price = Double.parseDouble(priceString);

        // Return the extracted price
        return price;
    }




    public P04_Checkout_Overview ClickOnFinishButton() {

        driver.findElement(FinishButton).click();
        return this;
    }

    public String ExtractSuccessMessage()
    {

        String MSG = driver.findElement(Success).getText();
        return MSG;
    }



}

