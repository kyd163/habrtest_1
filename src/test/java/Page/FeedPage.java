package Page;

import habrtest.AllureLogger;
import habrtest.MyExtension;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.LoggerFactory;

import static habrtest.MyWait.myWait;

public class FeedPage {
    private final AllureLogger LOG = new AllureLogger(LoggerFactory.getLogger(FeedPage.class));
    WebDriver driver;

    @FindBy(css = "a.footer-menu__item-link[href='/ru/articles/']")
    private WebElement articlesButton;

    @FindBy(css = "button.tm-header__button")
    private WebElement burgerButton;

    @FindBy(css = "button[aria-expanded=true]")
    private WebElement crossButton;

    @FindBy(css = "a[data-test-id = \"search-button\"]")
    private WebElement searchButton;

    @FindBy(css = "svg[class*=\"menu__icon_write\"]")
    private WebElement changeButton;

    @FindBy(css = "a[role = \"button\"]")
    private WebElement enterButton;

    @FindBy(css = "button[data-test-id*=settings]")
    private WebElement propertiesButton;

    @FindBy(css = "form[class=tm-page-settings-form]")
    private WebElement propertiesWindow;

    @FindBy(css = "a[class*=all-flows]")
    private WebElement allFlowsButton;

    public FeedPage(WebDriver driver) {
        LOG.info("Инициализация драйвера");
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public boolean articlesButtonVisible() {
        LOG.infoWithScreenshot("Видимость кнопки Статьи");
       // myWait(10).visible(articlesButton);
        return articlesButton.isDisplayed();
    }

    public void articlesButtonClick() {
        LOG.infoWithScreenshot("Нажатие на кнопку Статьи");
        articlesButton.click();
    }

    public void burgerButtonClick() {
        LOG.infoWithScreenshot("Клик по иконке Бургер");
        burgerButton.click();
    }

    public boolean burgerButtonInvisible() {
        LOG.infoWithScreenshot("Кнопка бургера изменилась на крестик");
        return crossButton.isEnabled();
    }

    public boolean searchButtonVisible() {
        LOG.infoWithScreenshot("Кнопка поиска отображается на странице");
        return searchButton.isDisplayed();
    }

    public void searchButtonClick() {
        LOG.infoWithScreenshot("Нажатие на иконку поиска");
        searchButton.click();
    }

    public boolean changeButtonVisible() {
        LOG.infoWithScreenshot("Кнопка изменить отображается на странице");
        return changeButton.isDisplayed();
    }

    public void changeButtonClick() {
        LOG.infoWithScreenshot("Нажатие на кнопку Изменить");
        changeButton.click();
    }

    public boolean enterButtonVisible() {
        LOG.infoWithScreenshot("Кнопка Войти отображается на странице");
        return enterButton.isDisplayed();
    }

    public void enterButtonClick() {
        LOG.infoWithScreenshot("Нажатие на кнопку Войти");
        enterButton.click();
    }

    public boolean propertiesButtonVisible() {
        LOG.infoWithScreenshot("Кнопка Настройки отображается на странице");
        return propertiesButton.isDisplayed();
    }

    public void propertiesButtonClick() {
        LOG.infoWithScreenshot("Нажатие на кнопку Настройки");
        propertiesButton.click();
    }

    public boolean propertiesWindowVisible() {
        LOG.infoWithScreenshot("Отображение окна Настройки страницы");
        return propertiesWindow.isDisplayed();
    }

    public boolean allFlowsButtonVisible() {
        LOG.infoWithScreenshot("Отображение кнопки Все потоки");
        return allFlowsButton.isDisplayed();
    }

    public void allFlowsButtonClick() {
        LOG.infoWithScreenshot("Нажатие на кнопку Все потоки");
        allFlowsButton.click();
    }

}
