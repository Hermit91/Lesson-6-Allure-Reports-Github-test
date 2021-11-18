package gmail.salokin1991;

import com.codeborne.selenide.Condition;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class GithubIssueLablesTest extends TestBase {

    @Test
    @Link(name = "GitHub", url = "https://github.com")
    @DisplayName("Good test")
    @Severity(SeverityLevel.BLOCKER)
    @Owner("dsalokin")
    @Feature("Check value")
    @Story("Check Issue value")
    public void positiveTest() {

        $(".header-search-input").click();
        $(".header-search-input").setValue("eroshenkoam/allure-example").pressEnter();

        $(By.linkText("eroshenkoam/allure-example")).click();
        $("#issues-repo-tab-count").click();

        $(".js-check-all-container").shouldHave(Condition.text("#68"));

    }

    @Test
    @Link(name = "GitHub", url = "https://github.com")
    @DisplayName("Bad test")
    @Severity(SeverityLevel.MINOR)
    @Owner("dsalokin")
    @Feature("Check wrong value")
    @Story("Check wrong Issue value")
    public void failedTest() {

        $(".header-search-input").click();
        $(".header-search-input").setValue("eroshenkoam/allure-example").pressEnter();

        $(By.linkText("eroshenkoam/allure-example")).click();
        $("#issues-repo-tab-count").click();

        $(".js-check-all-container").shouldHave(Condition.text("#86"));

    }

    @Test
    public void brokenTest() {

        Allure.getLifecycle().updateTestCase(testCase -> {
            testCase.setName("Broken test");
            Allure.label("owner", "dsalokin");
            Allure.feature("Try to break the test");
            Allure.story("Trying to break the test with a bad condition");
            Allure.label("severity", "NORMAL");
            Allure.link("GitHub", "https://github.com");
        });

        $(".header-search-input").click();
        $(".header-search-input").setValue("eroshenkoam/allure-example").pressEnter();

        try {
            $(By.partialLinkText("eroshenkoam")).wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        $("#issues-repo-tab-count").click();

        $(".js-check-all-container").shouldHave(Condition.text("#68"));

    }
}
