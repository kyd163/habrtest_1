package Page;

import habrtest.AllureLogger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.LoggerFactory;

public class ChangePage {
    private final AllureLogger LOG = new AllureLogger(LoggerFactory.getLogger(ChangePage.class));
    WebDriver driver;

    @FindBy(css = "a[class=\"tab-link active\"]") // Вынести в отдельный класс
    private WebElement importantButton;

    public ChangePage(WebDriver driver) {
        LOG.info("Инициализация драйвера");
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public boolean importantButtonVisible(){
        LOG.infoWithScreenshot("Кнопка Самое важное отображается на странице");
        return importantButton.isDisplayed();
    }
}
