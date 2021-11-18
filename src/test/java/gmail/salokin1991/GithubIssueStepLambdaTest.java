package gmail.salokin1991;

import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static io.qameta.allure.Allure.step;

public class GithubIssueStepLambdaTest extends TestBase {

    @Test
    public void positiveTest() {

        step("Find repository" + REPOSITORY, () -> {
            $(".header-search-input").click();
            $(".header-search-input").setValue(REPOSITORY)
                    .pressEnter();
        });
        step("Go to repository" + REPOSITORY, () -> {
            $(By.linkText(REPOSITORY)).click();
        });
        step("Open Issue tab", () -> {
            $("#issues-repo-tab-count").click();
        });
        step("Check issue #" + ISSUE_NUMBER, () -> {
            $(".js-check-all-container").shouldHave(Condition.text("#" + ISSUE_NUMBER));
        });

    }

    @Test
    public void failedTest() {

        step("Find repository" + REPOSITORY, () -> {
            $(".header-search-input").click();
            $(".header-search-input").setValue(REPOSITORY)
                    .pressEnter();
        });
        step("Go to repository" + REPOSITORY, () -> {
            $(By.linkText(REPOSITORY)).click();
        });
        step("Open Issue tab", () -> {
            $("#issues-repo-tab-count").click();
        });
        step("Check issue #" + 86, () -> {
            $(".js-check-all-container").shouldHave(Condition.text("#" + 86));
        });

    }

    @Test
    public void brokenTest() {

        step("Find repository" + REPOSITORY, () -> {
            $(".header-search-input").click();
            $(".header-search-input").setValue(REPOSITORY)
                    .pressEnter();
        });
        step("Go to repository" + REPOSITORY, () -> {
            try {
                $(By.partialLinkText("eroshenkoam")).wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        step("Open Issue tab", () -> {
            $("#issues-repo-tab-count").click();
        });
        step("Check issue #" + ISSUE_NUMBER, () -> {
            $(".js-check-all-container").shouldHave(Condition.text("#" + ISSUE_NUMBER));
        });

    }
}
