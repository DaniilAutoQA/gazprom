package ru.gazprombank.tests;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

public class DepositTest extends TestBase {

    @Test
    void verifyDeposits() {
        step("Открываем главную страницу Газпром банка", () -> {
            open("https://www.gazprombank.ru/");
        });
        step("Выбираем категорию Накопления", () -> {
            $$(".nr-categories-tabs__tab").find(text("Накопления")).scrollTo().click();
        });
        step("Выбираем вклад 'Ваш Успех'", () -> {
            $("[href='/personal/increase/deposits/detail/6049/']").click();
        });
        step("Проверяем переход на страницу 'Вклад Ваш Успех'", () -> {
            //      assertThat(title()).isEqualTo("Вклад «Ваш успех»");
        });
        step("Перейти к рассчету дохода", () -> {
            $$(".nn-btn__text ").find(text("Рассчитать доход")).click();
        });
        step("Ввести данные для рассчета", () -> {
            $(".nn-range__value").setValue("9000000");
            $(".nn-checkbox").click();
        });
        step("Проверка рассчета", () -> {
            $(".js-nn-calc-rSum").shouldHave(text("9 494 092"));
            $(".js-nn-calc-rProfit").shouldHave(text("494 092"));
            $(".js-nn-calc-rRate").shouldHave(text("5.46"));
            $(".js-nn-calc-effective").shouldNot(visible);
        });

    }
}
