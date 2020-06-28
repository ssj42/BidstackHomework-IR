package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CartPage {
    private BaseFunc baseFunc;

    public CartPage(BaseFunc baseFunc) {
        this.baseFunc = baseFunc;
    }

    public String getProductText() {
        return baseFunc.findElement(By.className("detailed-cart-item__name-link")).getText();
    }

    public String getProductQuantity() {
        return baseFunc.findElement(By.name("cart_item[quantity]")).getAttribute("value");
    }

    public double totalItemPriceInCart() {
        baseFunc.wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("cart-full-total-price")));
        String TotalPrice = baseFunc.findElement(By.id("cart-full-total-price")).getText().replace(",", ".");
        String TotalPriceWithoutEuroSign = TotalPrice.substring(0, TotalPrice.length() - 2);
        return Double.parseDouble(TotalPriceWithoutEuroSign);
    }
}
