package gmail.salokin1991;

import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class GithubIssueTest extends TestBase {

    @Test
    public void positiveTest() {

        $(".header-search-input").click();
        $(".header-search-input").setValue("eroshenkoam/allure-example").pressEnter();

        $(By.linkText("eroshenkoam/allure-example")).click();
        $("#issues-repo-tab-count").click();

        $(".js-check-all-container").shouldHave(Condition.text("#68"));

    }

    @Test
    public void failedTest() {

        $(".header-search-input").click();
        $(".header-search-input").setValue("eroshenkoam/allure-example").pressEnter();

        $(By.linkText("eroshenkoam/allure-example")).click();
        $("#issues-repo-tab-count").click();

        $(".js-check-all-container").shouldHave(Condition.text("#86"));

    }

    @Test
    public void brokenTest() {

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
