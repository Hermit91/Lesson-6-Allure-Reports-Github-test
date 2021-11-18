package gmail.salokin1991;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;

import static com.codeborne.selenide.Selenide.open;

public class TestBase {

    public static final String REPOSITORY = "eroshenkoam/allure-example";
    public static final int ISSUE_NUMBER = 68;

    @BeforeAll
    static void beforeAll() {

        Configuration.startMaximized = true;
        open("https://github.com/");

    }
}