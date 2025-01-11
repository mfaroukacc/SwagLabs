package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class P02_ProductsPage extends PageBase{

    public P02_ProductsPage(WebDriver driver){
        super(driver);
    }

    private final By PRODUCT_BUTTON=By.xpath("(//button[text()='ADD TO CART'])[1]");

    public P02_ProductsPage clickFirstProduct(){
        this.driver.findElement(PRODUCT_BUTTON).click();
        return this;
    }
}
