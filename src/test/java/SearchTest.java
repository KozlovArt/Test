
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class SearchTest {

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.pageLoadStrategy = "eager";
    }


    @Test
    void successfulSearchTest() {
        open("https://yandex.ru"); // открыть google

        $("textarea[name=q]").setValue("selenide").pressEnter(); // ввести в поле поиска selenide

        $("div[id=search]").shouldHave(text("https://ru.selenide.org")); // проверить выдачу

        sleep(2000);
    }
}
