package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ProductPage {
    private final By CHECK_TO_CART_BTN = By.linkText("Pārlūkot pirkumu grozu");
    private final By QUANTITY = By.id("product_quantity");
    private final By CART_BTN = By.id("add_to_cart_btn");
    private final By CONTINUE_SHOPPING_BTN = By.id("continue_shopping");
    private final By GO_TO_SHOPPING_CART_BTN = By.linkText("Pārlūkot pirkumu grozu");
    private BaseFunc baseFunc;

    public ProductPage(BaseFunc baseFunc) {
        this.baseFunc = baseFunc;
    }

    public void enterQuantity(String quantity) {
        baseFunc.enterText(QUANTITY, quantity);
        baseFunc.findElement(CART_BTN).click();
    }

    public void clickCheckToCartBtn() {
        baseFunc.click(CHECK_TO_CART_BTN);
    }

    public double itemPrice() {
        baseFunc.wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='price']/span[1]")));
        return Double.parseDouble(baseFunc.findElement(By.xpath("//span[@class='price']/span[1]")).getText().replace(",", "."));
    }

    public void clickSendToCart() {
        baseFunc.click(CART_BTN);
    }

    public void clickContinueShopping() {
        baseFunc.click(CONTINUE_SHOPPING_BTN);
    }

    public void clickGoToShoppingCart() {
        baseFunc.click(GO_TO_SHOPPING_CART_BTN);
    }


}
