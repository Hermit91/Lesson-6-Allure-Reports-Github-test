package gmail.salokin1991;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class GithubIssueListenerTest extends TestBase {

    @Test
    public void positiveTest() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        $(".header-search-input").click();
        $(".header-search-input").setValue("eroshenkoam/allure-example").pressEnter();

        $(By.linkText("eroshenkoam/allure-example")).click();
        $("#issues-repo-tab-count").click();

        $(".js-check-all-container").shouldHave(Condition.text("#68"));
    }

    @Test
    public void failedTest() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        $(".header-search-input").click();
        $(".header-search-input").setValue("eroshenkoam/allure-example").pressEnter();

        $(By.linkText("eroshenkoam/allure-example")).click();
        $("#issues-repo-tab-count").click();

        $(".js-check-all-container").shouldHave(Condition.text("#86"));
    }

    @Test
    public void brokenTest() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        $(".header-search-input").click();
        $(".header-search-input").setValue("eroshenkoam/allure-example").pressEnter();

        try {
            $(By.partialLinkText("eroshenkoam")).wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        $("#issues-repo-tab-count").click();

        $(".js-check-all-container").shouldHave(Condition.text("#86"));
    }
}
