package ui.android;

import io.qameta.allure.Step;
import org.openqa.selenium.remote.RemoteWebDriver;
import ui.CorePageObject;

public class AndroidMainPageObject extends CorePageObject {
    final String SEARCH_CONTAINER = "id:org.wikipedia:id/search_container";

    public AndroidMainPageObject(RemoteWebDriver driver) {
        super(driver);
    }

    @Step("Инициализация поиска (Android)")
    public void clickSearchContainer() {
        this.waitForElementAndClick(SEARCH_CONTAINER);
    }
}
