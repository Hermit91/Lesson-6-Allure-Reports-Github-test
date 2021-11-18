package gmail.salokin1991.steps;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import static com.codeborne.selenide.Selenide.$;

public class WebSteps {

    @Step("Find repository {repository}")
    public void searchForRepository(String repository) {
        $(".header-search-input").click();
        $(".header-search-input").setValue(repository)
                .pressEnter();
    }

    @Step("Go to repository {repository}")
    public void goToRepository(String repository) {
        $(By.linkText(repository)).click();
    }

    @Step("Go to repository {repository}")
    public void dontGoToRepository(String repository) {
        try {
            $(By.partialLinkText(repository)).wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Step("Open Issue tab")
    public void openIssueTab() {
        $("#issues-repo-tab-count").click();
    }

    @Step("Check issue # {number}")
    public void shouldSeeIssueNumber(int number) {
        $(".js-check-all-container").shouldHave(Condition.text("#" + number));
    }


    @Attachment(value = "Screenshot", type = "image/png", fileExtension = "png")
    public byte[] takeScreenshot() {
        final WebDriver driver = WebDriverRunner.getWebDriver();
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }
}
