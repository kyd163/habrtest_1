package Page;

import habrtest.AllureLogger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.LoggerFactory;

public class SearchPage {
    private final AllureLogger LOG = new AllureLogger(LoggerFactory.getLogger(SearchPage.class));
    WebDriver driver;

    @FindBy(css = "input[placeholder = \"Поиск\"]") // Вынести в отдельный класс
    private WebElement stringSearch;

    public SearchPage (WebDriver driver) {
        LOG.info("Инициализация драйвера");
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public boolean stringSearchVisible(){
        LOG.infoWithScreenshot("Строка поиска отображается на странице");
        return stringSearch.isDisplayed();
    }
}
