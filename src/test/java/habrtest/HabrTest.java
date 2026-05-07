package habrtest;

import Page.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.WebDriver;

import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(MyExtension.class)
public class HabrTest extends BaseTest {
    private WebDriver driver;
    private FeedPage feedPage;
    private SearchPage searchPage;
    private ChangePage changePage;
    private LoginPage loginPage;
    private AllFlowsPage allFlowsPage;

    @BeforeEach
    @Override
    public void setUp() {
        super.setUp();
        getDriver().get("https://habr.com/ru/feed");
        feedPage = new FeedPage(getDriver());
        searchPage = new SearchPage(getDriver());
        changePage = new ChangePage(getDriver());
        loginPage = new LoginPage(getDriver());
        allFlowsPage = new AllFlowsPage(getDriver());
    }

    @Test
    @DisplayName("1. Отображение блока Статьи и нажатие")
    public void articles() {
        feedPage.articlesButtonVisible();
        feedPage.articlesButtonClick();
        assertTrue(feedPage.articlesButtonVisible(), "Блок Статьи не найден");
    }

    @Test
    @DisplayName("2. Изменение иконки Бургера, на Крестик")
    public void burger() {
        feedPage.burgerButtonClick();
        assertTrue(feedPage.burgerButtonInvisible(), "Кнопка Крестика не найдена");
    }

    @Test
    @DisplayName("3. Отображение иконки поиска на странице и нажатие")
    public void search (){
        feedPage.searchButtonVisible();
        assertTrue(feedPage.searchButtonVisible(),"Кнопка поиска не найдена");
    }

    @Test
    @DisplayName("4. Отображение поисковой строки")
    public void searchClick(){
        feedPage.searchButtonClick();
        searchPage.stringSearchVisible();
        assertTrue(searchPage.stringSearchVisible(),"Поисковая строка не найдена");
    }

    @Test
    @DisplayName("5. Отображение иконки Изменить на странице и нажатие")
    public void change(){
        feedPage.changeButtonVisible();
        feedPage.changeButtonClick();
        assertTrue(feedPage.changeButtonVisible(),"Кнопка изменить не найдена");
    }

    @Test
    @DisplayName("6. Отображение вкладки Самое важное")
    public void important(){
        feedPage.changeButtonClick();
        assertTrue(changePage.importantButtonVisible(),"Вкладка Самое Важное не отображается");
    }

    @Test
    @DisplayName("7. Отображение кнопки Войти на главной странице и нажатие")
    public void enter(){
        feedPage.enterButtonVisible();
        feedPage.enterButtonClick();
    }

    @Test
    @DisplayName("8. Отображение кнопки Войти на странице авторизации")
    public void enterLogin(){
        feedPage.enterButtonClick();
        loginPage.enterButtonVisible();
        assertTrue(loginPage.enterButtonVisible(),"Кнопка Войти не отображается");
    }

    @Test
    @DisplayName("9. Отображение кнопки Настройки на главной странице и нажатие")
    public void properties(){
        feedPage.propertiesButtonVisible();
        feedPage.propertiesButtonClick();
        assertTrue(feedPage.propertiesButtonVisible(),"Кнопка Настройки не отображается");
    }

    @Test
    @DisplayName("10. Отображение окна Настройки страницы")
    public void propertiesPage(){
        feedPage.propertiesButtonClick();
        feedPage.propertiesWindowVisible();
        assertTrue(feedPage.propertiesWindowVisible(),"Окно настройки страницы не отображается");
    }

    @Test
    @DisplayName("11. Отображение кнопки Все потоки")
    public void allFlows(){
        feedPage.allFlowsButtonVisible();
        assertTrue(feedPage.allFlowsButtonVisible(),"Кнопка все потоки не найдена");
    }

    @Test
    @DisplayName("12. Открытие блога Все потоки ")
    public void allFlowsBlog(){
        feedPage.allFlowsButtonClick();
        allFlowsPage.textVisible();
        assertTrue(allFlowsPage.textVisible(),"Заголовок все потоки не найден");
    }

    @Test
    @DisplayName("13. Отображение вкладки Посты")
    public void postTab(){
        feedPage.allFlowsButtonClick();
        allFlowsPage.postVisible();
    }

    @Test
    @DisplayName("14. Нажатие на вкладку Посты")
    public void postTabClick(){
        feedPage.allFlowsButtonClick();
        allFlowsPage.postClick();
        allFlowsPage.postTabActive();
        assertTrue(allFlowsPage.postTabActive(),"Вкладка посты не поменяла цвет");
    }

    @Test
    @DisplayName("15.Отображение вкладки Новости")
    public void newsTab(){
        feedPage.allFlowsButtonClick();
        allFlowsPage.newsVisible();
    }

    @Test
    @DisplayName("16.Нажатие на вкладку Новости")
    public void newsTabClick(){
        newsTab();
        allFlowsPage.newsClick();
        assertTrue(allFlowsPage.newsTabActive(),"Вкладка новости не поменяла цвет");
    }

    @Test
    @DisplayName("17. Отображение вкладки ХАБЫ")
    public void habTab(){
        feedPage.allFlowsButtonClick();
        allFlowsPage.habVisible();
        assertTrue(allFlowsPage.habVisible(),"Вкладка ХАБЫ не найдена");
    }

    @Test
    @DisplayName("18. Открытие вкладки ХАБЫ")
    public void habTabClick(){
        habTab();
        allFlowsPage.habTabClick();
    }

    @Test
    @DisplayName("19. Отображение вкладки Авторы")
    public void authorTabVisible(){
        allFlowsPage.authorTabVisible();
        assertTrue(allFlowsPage.authorTabVisible(),"Вкладка Авторы не отображается");
    }

    @Test
    @DisplayName("20.Нажатие на вкладку Авторы")
    public void authorTabClick(){
        feedPage.allFlowsButtonClick();
        allFlowsPage.authorTabVisible();
        allFlowsPage.authorTabClick();
        assertTrue(allFlowsPage.stringSearchAuthorTab(),"Строка поиска не отображается");
    }
}
