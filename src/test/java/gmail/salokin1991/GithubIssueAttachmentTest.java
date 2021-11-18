package gmail.salokin1991;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Allure;
import io.qameta.allure.AllureLifecycle;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import static com.codeborne.selenide.Selenide.$;
import static io.qameta.allure.Allure.step;

public class GithubIssueAttachmentTest extends TestBase {


    @Test
    public void positiveTest() {
        AllureLifecycle lifecycle = Allure.getLifecycle();

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
            lifecycle.addAttachment("Screenshot", "image/png", "png", takeScreenshot());
        });
    }

    private byte[] takeScreenshot() {
        final WebDriver driver = WebDriverRunner.getWebDriver();
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }

    @Test
    public void failedTest() {
        AllureLifecycle lifecycle = Allure.getLifecycle();

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
            lifecycle.addAttachment("Screenshot", "image/png", "png", takeScreenshot2());
        });
    }

    private byte[] takeScreenshot2() {
        final WebDriver driver = WebDriverRunner.getWebDriver();
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }

    @Test
    public void brokenTest() {
        AllureLifecycle lifecycle = Allure.getLifecycle();

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
            lifecycle.addAttachment("Screenshot", "image/png", "png", takeScreenshot3());
        });
    }

    private byte[] takeScreenshot3() {
        final WebDriver driver = WebDriverRunner.getWebDriver();
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }

}
