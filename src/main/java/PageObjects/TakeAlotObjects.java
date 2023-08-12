package PageObjects;

import org.openqa.selenium.By;

public class TakeAlotObjects {

    public static final By TypeInSearch = By.xpath ("//input[@placeholder='Search for products, brands...']");
    public static final By Search = By.xpath ("//button[contains(@type,'submit')]");
    public static final By SelectFirstItem =By.xpath("(//button[@data-ref='add-to-cart-button'])[1]");
    public static final By ClickAddToCart =By.xpath("(//a[normalize-space()='Add to Cart'])[1]");
    public static final By GoToCart =By.xpath("//div[@class='badge-button-module_badge-button-outer_1gN1K']");
    public static final By CartItem = By.xpath ("//article[@data-ref='cart-item']//h3");
}
