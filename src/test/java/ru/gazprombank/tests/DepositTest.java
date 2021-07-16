package ru.gazprombank.tests;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

public class DepositTest extends TestBase {

    @Test
    void verifyDeposits() {
        step("��������� ������� �������� ������� �����", () -> {
            open("https://www.gazprombank.ru/");
        });
        step("�������� ��������� ����������", () -> {
            $$(".nr-categories-tabs__tab").find(text("����������")).scrollTo().click();
        });
        step("�������� ����� '��� �����'", () -> {
            $("[href='/personal/increase/deposits/detail/6049/']").click();
        });
        step("��������� ������� �� �������� '����� ��� �����'", () -> {
            //      assertThat(title()).isEqualTo("����� ���� ������");
        });
        step("������� � �������� ������", () -> {
            $$(".nn-btn__text ").find(text("���������� �����")).click();
        });
        step("������ ������ ��� ��������", () -> {
            $(".nn-range__value").setValue("9000000");
            $(".nn-checkbox").click();
        });
        step("�������� ��������", () -> {
            $(".js-nn-calc-rSum").shouldHave(text("9 494 092"));
            $(".js-nn-calc-rProfit").shouldHave(text("494 092"));
            $(".js-nn-calc-rRate").shouldHave(text("5.46"));
            $(".js-nn-calc-effective").shouldNot(visible);
        });

    }
}
