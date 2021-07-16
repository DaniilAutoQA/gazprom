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
        step("Перейти к рассчету дохода", () -> {
            $$(".nn-btn__text ").find(text("Рассчитать доход")).click();
        });
        step("Ввести данные для рассчета", () -> {
            $(".nn-range__value").setValue("9000000");
        });
        step("Снять чекбокс 'Капитализация'", () -> {
            $(".nn-checkbox").click();
        });
        step("Проверка рассчета", () -> {
            step("Сумма в конце срока должна быть  9 494 092", () ->{
                $(".js-nn-calc-rSum").shouldHave(text("9 494 092"));
            });
            step("Доход должен быть 494 092", () ->{
                $(".js-nn-calc-rProfit").shouldHave(text("494 092"));
            });
            step("Процентная ставка должна быть 5.46%", () ->{
                $(".js-nn-calc-rRate").shouldHave(text("5.46"));
            });
            step("Эффективная ставка не должна отображаться", () ->{
                $(".js-nn-calc-effective").shouldNot(visible);
            });
        });
    }
}
