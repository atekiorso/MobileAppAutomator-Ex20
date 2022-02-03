package tests.android;

import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.Before;
import org.junit.experimental.categories.Category;
import org.openqa.selenium.WebElement;
import tests.ArticlesInSearchResultTests;
import ui.android.AndroidMainPageObject;
import ui.android.AndroidSearchPageObject;

import java.util.List;

@Category(AndroidTests.class)
@Severity(value = SeverityLevel.BLOCKER)
public class AndroidArticlesInSearchResultsTests extends ArticlesInSearchResultTests {
    private AndroidMainPageObject androidMainPageObject;
    private AndroidSearchPageObject androidSearchPageObject;

    @Before
    public void setUp() throws Exception {
        this.driver = this.getAndroidDriver();
        androidMainPageObject = new AndroidMainPageObject(this.driver);
        androidSearchPageObject = new AndroidSearchPageObject(this.driver);
    }

    @Override
    protected void closeWelcomeScreen() {
        // В текущей версии приложения под Android экран Welcome не реализован
    }

    @Override
    protected void searchArticles(String searchText) {
        androidMainPageObject.clickSearchContainer();
        androidSearchPageObject.sendKeysSearchSrcText(searchText);
        androidSearchPageObject.checkSearchResultsPresent();
        androidSearchPageObject.attachScreenshot(androidSearchPageObject.takeScreenshot("AndroidSearchResults"));
    }

    @Override
    protected List<WebElement> getTitleElementsInSearchResults() {
        return androidSearchPageObject.getPageListItemTitleElements();
    }
}
