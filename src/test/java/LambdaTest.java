import com.codeborne.selenide.Condition;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

import static org.openqa.selenium.By.linkText;

public class LambdaTest extends TestBase {

    @Test
    public void repositoryLambdaIssueCheckTest() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        open("https://github.com/");
        step("Ищем репозиторий " + "eroshenkoam/allure-example", () -> {
            $(".header-search-button").click();
            $("#query-builder-test").sendKeys("eroshenkoam/allure-example");
            $("#query-builder-test").submit();
        });
        step("Открываем репозиторий " + "eroshenkoam/allure-example", () -> {
            $(linkText("eroshenkoam/allure-example")).click();
        });
        step("Открываем таб Issue ", () -> {
            $("#issues-tab").click();
        });
        step("Проверяем наличие Issue " + 84, () -> {
            $(withText("#"+ 84)).should(Condition.exist);
        });

    }

}