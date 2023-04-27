package com.automationexercise.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.stream.Collectors;

public class CartPage {

    @FindBy(xpath = "//td[contains(@class, 'cart_description')]//a")
    private List<WebElement> productName;

    @FindBy(xpath = "//td[contains(@class, 'cart_price')]/p")
    private List<WebElement> price;

    @FindBy(xpath = "//td[contains(@class, 'cart_quantity')]/button")
    private List<WebElement> quantity;

    @FindBy(xpath = "//p[contains(@class, 'cart_total_price')]")
    private List<WebElement> totalPrice;

    @FindBy(css = "li[class='active']")
    private WebElement shoppingCart;

    @FindBy(css = "a[class='btn btn-default check_out']")
    private WebElement proceedToCheckoutButton;

    @FindBy(css = "a[href='/login'] u")
    private WebElement registerLoginButton;

    private WebDriver driver;

    public CartPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public List<String> getProductsNames() {
        return productName
                .stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());
    }

    public List<String> getPrices() {
        return price
                .stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());
    }

    public List<String> getQuantity() {
        return quantity
                .stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());
    }

    public List<String> getTotalPrices() {
        return totalPrice
                .stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());
    }

    public WebElement getShoppingCart() {
        return shoppingCart;
    }

    public CartPage proceedToCheckoutButtonClick() {
        proceedToCheckoutButton.click();
        return this;
    }

    public CheckoutPage proceedToCheckoutLoggedButtonClick() {
        proceedToCheckoutButton.click();
        return new CheckoutPage(driver);
    }

    public LoginSignupPage registerLoginButtonClick() {
        registerLoginButton.click();
        return new LoginSignupPage(driver);
    }
}
