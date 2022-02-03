package ui.ios;

import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import ui.CorePageObject;

import java.util.List;

public class IosSearchPageObject extends CorePageObject {
    final String
            SEARCH_WIKIPEDIA_FIELD = "xpath://XCUIElementTypeSearchField[@name='Search Wikipedia' and (following-sibling::XCUIElementTypeButton[@name='Cancel'])]",
            NO_RESULTS_FOUND_LABEL = "id:No results found",
            SEARCH_RESULTS_TITLES = "xpath://XCUIElementTypeToolbar[@name='Toolbar']/../.." +
                "/XCUIElementTypeOther/XCUIElementTypeCollectionView/XCUIElementTypeCell/XCUIElementTypeOther/XCUIElementTypeStaticText[1]";

    public IosSearchPageObject(RemoteWebDriver driver) {
        super(driver);
    }

    @Step("Ввод текста поиска (iOS)")
    public void sendKeysSearchWikipediaField(String searchText) {
        this.waitForElementAndSendKeys(SEARCH_WIKIPEDIA_FIELD, searchText);
    }

    @Step("Проверка наличия результатов поиска (iOS)")
    public void checkSearchResultsPresent() {
        this.waitForElementNotPresent(NO_RESULTS_FOUND_LABEL);
    }

    @Step("Получение результатов поиска (iOS)")
    public List<WebElement> getPageListItemTitleElements() {
        return this.getElements(SEARCH_RESULTS_TITLES);
    }
}
