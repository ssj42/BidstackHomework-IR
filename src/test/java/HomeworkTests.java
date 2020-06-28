import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pages.*;
import static org.junit.jupiter.api.Assertions.*;

public class HomeworkTests {
    private final String PRODUCT_TO_SEARCH = "Thrustmaster Race Gear Sparco Mod 4060131";
    private final String PRODUCT_COUNT = "2";
    private BaseFunc baseFunc = new BaseFunc();

    @Test
    public void addingProductAndValidation() {
        baseFunc.openHomePage();
        HomePage homePage = new HomePage(baseFunc);
        homePage.acceptPrivacyMessage();
        homePage.searchForProduct(PRODUCT_TO_SEARCH);
        ProductPage productPage = new ProductPage(baseFunc);
        productPage.enterQuantity(PRODUCT_COUNT);
        productPage.clickCheckToCartBtn();
        CartPage cartPage = new CartPage(baseFunc);
        assertEquals(PRODUCT_TO_SEARCH, cartPage.getProductText());
        assertEquals(PRODUCT_COUNT + " gab.", cartPage.getProductQuantity());
    }

    @Test
    public void addingProductAndCheckingTheSum() {
        baseFunc.openHomePage();
        HomePage homePage = new HomePage(baseFunc);
        homePage.acceptPrivacyMessage();
        homePage.chooseProduct(baseFunc.randomProductSelect());
        ProductPage productPage = new ProductPage(baseFunc);
        double priceOfFirstItem = productPage.itemPrice();
        productPage.clickSendToCart();
        productPage.clickContinueShopping();
        homePage.clickMainLogo();
        homePage.chooseProduct(baseFunc.randomProductSelect());
        double priceOfSecondItem = productPage.itemPrice();
        productPage.clickSendToCart();
        productPage.clickGoToShoppingCart();
        CartPage cartPage = new CartPage(baseFunc);
        double TotalPriceInCart = cartPage.totalItemPriceInCart();
        Assertions.assertEquals(priceOfFirstItem + priceOfSecondItem, TotalPriceInCart, "Something went wrong, expected sum: " + priceOfFirstItem + priceOfSecondItem + "But was: " + TotalPriceInCart);
    }

    @AfterEach
    public void closeBrowser() {
       baseFunc.closeBrowser();
    }
}
