package tests.mobileweb;

import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.Before;
import org.junit.experimental.categories.Category;
import org.openqa.selenium.WebElement;
import tests.ArticlesInSearchResultTests;
import ui.mobileweb.MobileWebMainPageObject;
import ui.mobileweb.MobileWebSearchPageObject;

import java.util.List;

@Category(MobileWebTests.class)
@Severity(value = SeverityLevel.NORMAL)
public class MobileWebArticlesInSearchResultsTests extends ArticlesInSearchResultTests {
    private MobileWebMainPageObject mainPageObject;
    private MobileWebSearchPageObject searchPageObject;

    @Before
    public void setUp() {
        this.driver = this.getMobileWebDriver();
        mainPageObject = new MobileWebMainPageObject(this.driver);
        searchPageObject = new MobileWebSearchPageObject(this.driver);
    }

    @Override
    protected void closeWelcomeScreen() {
        // В MobileWeb-версии приложения экран приветствия отсутствует
    }

    @Override
    protected void searchArticles(String searchText) {
        mainPageObject.clickSearchButton();
        searchPageObject.sendKeysSearchInputField(searchText);
        searchPageObject.checkSearchResultsPresent();
        searchPageObject.attachScreenshot(searchPageObject.takeScreenshot("MobileWebSearchResults"));
    }

    @Override
    protected List<WebElement> getTitleElementsInSearchResults() {
        return searchPageObject.getSearchResultsTitles();
    }
}
