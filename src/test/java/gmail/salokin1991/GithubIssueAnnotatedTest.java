package gmail.salokin1991;

import gmail.salokin1991.steps.WebSteps;
import org.junit.jupiter.api.Test;

public class GithubIssueAnnotatedTest extends TestBase {

    private WebSteps steps = new WebSteps();

    @Test
    public void positiveTest() {

        steps.searchForRepository(REPOSITORY);
        steps.goToRepository(REPOSITORY);
        steps.openIssueTab();
        steps.shouldSeeIssueNumber(68);

    }

    @Test
    public void failedTest() {

        steps.searchForRepository(REPOSITORY);
        steps.goToRepository(REPOSITORY);
        steps.openIssueTab();
        steps.shouldSeeIssueNumber(86);

    }

    @Test
    public void brokenTest() {

        steps.searchForRepository(REPOSITORY);
        steps.dontGoToRepository("eroshenkoam");
        steps.openIssueTab();
        steps.shouldSeeIssueNumber(68);

    }
}
