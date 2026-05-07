package Page;

import habrtest.AllureLogger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.LoggerFactory;

public class AllFlowsPage {
    private final AllureLogger LOG = new AllureLogger(LoggerFactory.getLogger(AllFlowsPage.class));
    WebDriver driver;

    @FindBy (css = "h1[class*=text]")
    private WebElement text;

    @FindBy (css = "[data-test-id=\"tab-new-counter-1\"]")
    private WebElement post;

    @FindBy(xpath = "//a[@class='tab-link active' and contains(., 'Посты')]")
    private WebElement postActive;

    @FindBy (xpath = "//span[@data-test-id='tab-new-counter-2']/parent::a")
    private WebElement news;

    @FindBy (xpath = "//span[@data-test-id='tab-new-counter-2']/parent::a")
    private WebElement newsActive;

    @FindBy (xpath = "//a[contains(@class, 'tab-link') and contains(., 'Хабы')]")
    private WebElement hab;

    @FindBy (css = "input[placeholder=\"Поиск\"]")
    private WebElement stringSearch;

    @FindBy (xpath = "//a[contains(., 'Авторы')]")
    private WebElement authorTab;

    public AllFlowsPage(WebDriver driver) {
        LOG.info("Инициализация драйвера");
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public boolean textVisible(){
        return text.isDisplayed();
    }

    public boolean postVisible(){
        return post.isDisplayed();
    }

    public void postClick(){
        post.click();
        postActive.isDisplayed();
    }

    public boolean postTabActive(){
        return postActive.isEnabled();
    }

    public boolean newsVisible(){
        return news.isEnabled();
    }

    public void newsClick(){
        news.click();
        newsActive.isDisplayed();
    }

    public boolean newsTabActive(){
        return newsActive.isEnabled();
    }

    public boolean habVisible(){
        return hab.isDisplayed();
    }

    public void habTabClick(){
        hab.click();
        stringSearch.isDisplayed();
    }

    public boolean authorTabVisible(){
       return authorTab.isEnabled();
    }

    public void authorTabClick(){
        authorTab.click();
    }

    public boolean stringSearchAuthorTab(){
       return stringSearch.isEnabled();
    }
}
