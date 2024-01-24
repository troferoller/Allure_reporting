import org.junit.jupiter.api.BeforeAll;
import com.codeborne.selenide.Configuration;

import static com.codeborne.selenide.Selenide.open;

public class TestBase {
    @BeforeAll
    static void configs(){
        Configuration.browserSize = "2560x1440";
        Configuration.baseUrl = "https://github.com";
        Configuration.pageLoadStrategy = "eager";
    }
}