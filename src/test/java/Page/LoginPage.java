package Page;

import habrtest.AllureLogger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.LoggerFactory;

public class LoginPage {
    private final AllureLogger LOG = new AllureLogger(LoggerFactory.getLogger(LoginPage.class));
    WebDriver driver;

    @FindBy(css = "button[form=\"ident-form\"]") // Вынести в отдельный класс
    private WebElement enterButton;

    public LoginPage(WebDriver driver) {
        LOG.info("Инициализация драйвера");
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public boolean enterButtonVisible(){
        return enterButton.isDisplayed();
    }
}
