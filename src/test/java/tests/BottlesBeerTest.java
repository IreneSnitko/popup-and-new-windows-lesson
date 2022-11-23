package tests;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.BottlesBeerPage;
import runner.BaseTest;

public class BottlesBeerTest extends BaseTest {

    @Test
    public void workWithAlerts() {

        //Перейти пошагово к странице, где вызываются alerts

        openBaseURL_99Bottles();

        BottlesBeerPage bp = new BottlesBeerPage(getDriver());

        bp.clickMenuGuestbook();
        bp.clickSubmenuSignGuestbook();

        //Создать экземпляр класса WebDriverWait — явное ожидание
        //WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(5));
        //Внимание! Данный способ некорректен
        //Правильный метод создания явного ожидания: runner/BaseTest/getWait10()

        //Искать по локатору, где вызывается alert и кликнуть

        getDriver().findElement(By.cssSelector("a[onclick*='url']")).click();

        //Создать переменную класса Alert, переключить активность драйвера на alert
        //Это классический способ переключения, но нельзя понять, появился alert на странице или нет
        // Alert alertUrl = getDriver().switchTo().alert();

        //Класс ExpectedConditions - предоставляет подтверждение появления окна, связан с явным ожиданием
        //Данную конструкцию переключения на alert используют чаще
        //Переменная класса Alert присваивается окну только после подтверждения появления alert
        //Используется правильно созданный метод явного ожидания

        Alert alertUrl = getWait10().until(ExpectedConditions.alertIsPresent());

        //Инициализировать переменную String для последующего Assert, значение: текст в alert
        //Переменная инициализирована для примера работы метода getText(), далее не используется
        // String actualTextFromPromptURL = alertUrl.getText();

        //Напечатать в alert field текст

        alertUrl.sendKeys("mySite.my");

        //Нажать на кнопку ОК
        //Особенность — данный alert закрывается после двойного клика на ОК

        alertUrl.accept();
        alertUrl.accept();

        Assert.assertFalse(bp.isAlertPresent());
    }

    @Test
    public void testTextFromUrlPrompts() {

        final String expectedTextFromUrlPrompts =
                "Enter the URL for the link you want to add.";

        openBaseURL_99Bottles();

        BottlesBeerPage bp = new BottlesBeerPage(getDriver());

        bp.clickMenuGuestbook();
        bp.clickSubmenuSignGuestbook();
        bp.clickIconPromptURL();

        //Используем правильно созданный метод явного ожидания:

        Alert alertURL = getWait10().until(ExpectedConditions.alertIsPresent());

        String actualTextFromUrlPrompts = alertURL.getText();

        alertURL.accept();
        alertURL.accept();

        Assert.assertTrue(actualTextFromUrlPrompts.length() != 0);
        Assert.assertEquals(actualTextFromUrlPrompts, expectedTextFromUrlPrompts);
    }
}