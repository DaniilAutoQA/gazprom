package ru.gazprombank.tests;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.CollectionCondition.texts;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;
import static java.util.Arrays.asList;

public class CategoriesMainPageTest extends TestBase {
    @Test
    void verifyTitleOfCategory() {
        step("Open home page", () -> {
            open("https://www.gazprombank.ru/");
        });
        step("Verify section", () -> {
            $(".nr-categories__title").should(visible);
            $(".nr-categories__title").shouldHave(text("Выберите категорию"));
        });
    }

    @Test
    void verifyListOfCategories(){
        step("Проверка списка категорий", () -> {
          open("https://www.gazprombank.ru/");
          $$(".nr-categories-tabs__el").shouldHave(size(6), texts(asList("Популярное","Накопления", "Ипотека","Автолюбителям", "Акции", "Устойчивое развитие")));
        });
    }
}
