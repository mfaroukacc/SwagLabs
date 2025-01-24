package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Random;

public class P02_ProductsPage extends PageBase {

    public P02_ProductsPage(WebDriver driver) {
        super(driver);
    }

    private final By PRODUCT_BUTTON = By.xpath("(//button[text()='ADD TO CART'])");
    private final By CART_BUTTON = By.id("shopping_cart_container");
    private final By CHECKOUT_BUTTON = By.linkText("CHECKOUT");

    // Method to select a random number of products (without passing the number as an argument) and add them to the cart
    public P02_ProductsPage selectRandomAddToCartButton() {
        // Find all 'ADD TO CART' buttons
        List<WebElement> buttons = driver.findElements(PRODUCT_BUTTON);

        // Generate a random number of products to add, between 1 and the total number of buttons
        Random random = new Random();
        int productsToAdd = random.nextInt(buttons.size()) + 1; // Ensures at least 1 product is added

        // Loop through the selected number of products and click on each random product
        for (int i = 0; i < productsToAdd; i++) {
            // Generate a random index within the range of available buttons
            int randomIndex = random.nextInt(buttons.size());  // This ensures the index is within bounds

            // Get the random button and click it
            WebElement randomButton = buttons.get(randomIndex);
            randomButton.click();

            // Re-fetch the product buttons in case the DOM changes (after adding to cart, elements may change)
            buttons = driver.findElements(PRODUCT_BUTTON);

        }
        return this;
    }


        public P02_ProductsPage CartAction() {
            driver.findElement(CART_BUTTON).click();
            return this;
        }

        public P02_ProductsPage CheckoutAction() {
            driver.findElement(CHECKOUT_BUTTON).click();
            return this;
        }

    }


