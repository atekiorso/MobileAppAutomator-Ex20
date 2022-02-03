package ui.mobileweb;

import io.qameta.allure.Step;
import org.openqa.selenium.remote.RemoteWebDriver;
import ui.CorePageObject;

public class MobileWebMainPageObject extends CorePageObject {
    final String SEARCH_BUTTON = "css:button#searchIcon";

    public MobileWebMainPageObject(RemoteWebDriver driver) {
        super(driver);
    }

    @Step("Инициализация поиска (Mobile Web)")
    public void clickSearchButton() {
        this.waitForElementAndClick(SEARCH_BUTTON);
    }
}
