package tests;

import io.qameta.allure.*;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebElement;

import java.util.List;

public abstract class ArticlesInSearchResultTests extends CoreTest {
    protected final String SEARCH_TEXT = "warcraft";
    protected final int EXPECTED_MIN_SEARCH_RESULTS_COUNT = 3;

    @Test
    @DisplayName("Проверка заголовков статей в результатах поиска")
    @Description("Выполняем поиск статей по заданному тексту, проверяем наличие заданного текста в заголовках статей, выданных в результатах поиска")
    @Epic("Поиск статей")
    @Features(value = { @Feature(value = "Функции поиска"), @Feature(value = "Релевантность текстового поиска") })
    @Step("Старт теста проверки заголовков статей в результатах поиска")
    public void testArticleTitlesInSearchResults() {
        closeWelcomeScreen();
        searchArticles(SEARCH_TEXT);
        List<WebElement> elements = getTitleElementsInSearchResults();
        checkTitlesInFirstThreeArticles(elements);
    }

    @Step("Закрытие экрана 'Welcome' (только для iOS)")
    protected abstract void closeWelcomeScreen();

    @Step("Поиск статей по заданному тексту: '{searchText}'")
    @SuppressWarnings("SameParameterValue")
    protected abstract void searchArticles(String searchText);

    @Step("Получение перечня заголовков статей из результатов поиска")
    protected abstract List<WebElement> getTitleElementsInSearchResults();

    @Step("Проверка наличия искомого текста в заголовках найденных статей")
    private void checkTitlesInFirstThreeArticles(List<WebElement> titleElementsInSearchResults) {
        int resultsCount = titleElementsInSearchResults.size();
        Assert.assertTrue("Результаты поиска '" + this.SEARCH_TEXT + "' содержат количество статей: " + resultsCount +
                        ", что меньше ожидаемых " + this.EXPECTED_MIN_SEARCH_RESULTS_COUNT + "!",
                resultsCount >= this.EXPECTED_MIN_SEARCH_RESULTS_COUNT);

        for (int i = 0; i < this.EXPECTED_MIN_SEARCH_RESULTS_COUNT; i++) {
            String title = titleElementsInSearchResults.get(i).getText();
            Assert.assertTrue("Заголовок статьи № " + (i + 1) + ": '" + title +
                            "' в результатах поиска не содержит ожидаемый текст: '" + this.SEARCH_TEXT + "'",
                    title.toLowerCase().contains(this.SEARCH_TEXT));
        }
    }
}
