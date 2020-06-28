package pages;

import org.openqa.selenium.By;
import static org.openqa.selenium.By.*;

public class HomePage {

    private final By SEARCH = id("q");
    private final By ACCEPT_PRIVACY_MESSAGE = id("CybotCookiebotDialogBodyButtonAccept");
    private final By MAIN_LOGO = By.className("main-logo");
    private BaseFunc baseFunc;

    public HomePage(BaseFunc baseFunc) {
        this.baseFunc = baseFunc;
    }

    public void acceptPrivacyMessage() {
        baseFunc.click(ACCEPT_PRIVACY_MESSAGE);
    }

    public void searchForProduct(String nameOfProduct) {
        baseFunc.enterText(SEARCH, nameOfProduct);
        baseFunc.click(xpath("//div[@title='" + nameOfProduct + "']"));
    }

    public void chooseProduct(String nmbr){
        baseFunc.click(By.xpath("//div[2]/div/div/div/div/a["+ nmbr +"]"));
    }

    public void clickMainLogo() {
        baseFunc.click(MAIN_LOGO);
    }

}


