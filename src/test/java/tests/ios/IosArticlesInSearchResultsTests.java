package tests.ios;

import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.Before;
import org.junit.experimental.categories.Category;
import org.openqa.selenium.WebElement;
import tests.ArticlesInSearchResultTests;
import ui.ios.IosMainPageObject;
import ui.ios.IosSearchPageObject;
import ui.ios.IosWelcomePageObject;

import java.util.List;

@Category(IosTests.class)
@Severity(value = SeverityLevel.CRITICAL)
public class IosArticlesInSearchResultsTests extends ArticlesInSearchResultTests {
    private IosWelcomePageObject iosWelcomePageObject;
    private IosMainPageObject iosMainPageObject;
    private IosSearchPageObject iosSearchPageObject;

    @Before
    public void setUp() throws Exception {
        this.driver = this.getIOSDriver();
        iosWelcomePageObject = new IosWelcomePageObject(this.driver);
        iosMainPageObject = new IosMainPageObject(this.driver);
        iosSearchPageObject = new IosSearchPageObject(this.driver);
    }

    @Override
    protected void closeWelcomeScreen() {
        iosWelcomePageObject.clickSkipButton();
    }

    @Override
    protected void searchArticles(String searchText) {
        iosMainPageObject.clickSearchWikipediaContainer();
        iosSearchPageObject.sendKeysSearchWikipediaField(searchText);
        iosSearchPageObject.checkSearchResultsPresent();
        iosSearchPageObject.attachScreenshot(iosSearchPageObject.takeScreenshot("iOSSearchResults"));
    }

    @Override
    protected List<WebElement> getTitleElementsInSearchResults() {
        return iosSearchPageObject.getPageListItemTitleElements();
    }
}
