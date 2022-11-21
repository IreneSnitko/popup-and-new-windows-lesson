package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.OpenWeatherMapPage;
import runner.BaseTest;

import java.util.Set;

import static runner.TestUtils.createPopUpIconTexts;

public class OpenWeatherMapTest extends BaseTest {

    @Test
    public void testPopUpHeader(){

        final String expectedPopUpHeader = "Different weather";

        openBaseURL_OpenWeatherMap();

        OpenWeatherMapPage owp = new OpenWeatherMapPage(getDriver());

        owp.clickDifferentWeatherSwitch(getWait20());

        String actualPopUpHeader = owp.getTextPopUpHeader3();

        Assert.assertEquals(actualPopUpHeader, expectedPopUpHeader);
    }

    @Test
    public void testQuantityIconsInPopUp(){

        final int expectedQuantityIconsInPopUp = 9;

        openBaseURL_OpenWeatherMap();

        OpenWeatherMapPage owp = new OpenWeatherMapPage(getDriver());

        owp.clickDifferentWeatherSwitch(getWait20());

        int actualQuantityIconsInPopUp = owp.getListDialogDeskWeatherIcon().size();

        Assert.assertTrue(actualQuantityIconsInPopUp != 0);
        Assert.assertEquals(actualQuantityIconsInPopUp, expectedQuantityIconsInPopUp);
    }

    @Test
    public void testSameClassAttributeOfPopUpWeatherIcons(){

        final String expectedSameClassAttribute = "owm-weather-icon";

        openBaseURL_OpenWeatherMap();

        OpenWeatherMapPage owp = new OpenWeatherMapPage(getDriver());

        owp.clickDifferentWeatherSwitch(getWait20());

        Assert.assertTrue(owp.getListAttributeOfDialogDeskWeatherIcon().size() != 0);

        String actualSameClassAttribute = owp.getSameAttributeName();

        Assert.assertEquals(actualSameClassAttribute, expectedSameClassAttribute);
    }

    @Test
    public void testPopUpIconTexts(){

        openBaseURL_OpenWeatherMap();

        OpenWeatherMapPage owp = new OpenWeatherMapPage(getDriver());

        owp.clickDifferentWeatherSwitch(getWait20());

        Assert.assertFalse(owp.getListPopUpIconText().size() == 0);

        Assert.assertEquals(owp.getStringFromListPopUpIconText(), createPopUpIconTexts());
    }

    @Test
    public void testLogoPropertyOnMainAreNotEqualsLogoPropertyOnCoUk(){

        openBaseURL_OpenWeatherMap();

        /*
        Дескриптор окна (window handle) —
        это уникальный идентификатор,
        основная задача которого
        заключается в хранении адресов всех окон.
        При создании экземпляра Selenium WebDriver
        окну назначается алфавитно-цифровой ID
        Считать дескриптор: метод getWindowHandle()
        */

        String window1 = getDriver().getWindowHandle(); // CDwindow-21EF9AD6EC9B2D4E58B7B4F6F858AC8B

        OpenWeatherMapPage owp = new OpenWeatherMapPage(getDriver());

        owp.clickMenuForBusiness(getWait10());

        String window2 = "";

        /*
        Интерфейс Set хранит множество —
        это такой же способ хранения данных,
        как массив или список.
        Но особенность множества в том,
        что оно может хранить только уникальные значения.
        Дублироваться в множествах ничего не будет.
        */

        Set<String> currentWindows = getDriver().getWindowHandles();

        //Определить дескриптор 2-го окна:

        for (String window : currentWindows) {
            if (!window.equals(window1)) {
                window2 = window;
                break;
            }
        }

        //Переключиться на 2-е окно:

        owp.switchToWindowCoUk(window2, getWait20());

        String LogoPropertyOnCoUk = owp.getPropertyLogoCoUk();

        /*
        Методы getAttribute(), getDomProperty() возвращают значение из вкладки DevTools/Properties

        String logoSrcOnCoUk =
                getDriver()
                        .findElement(By.xpath("//li[@class='logo']/a/img"))
                        .getAttribute("src");

        System.out.println(logoSrcOnCoUk);
        */

        getDriver().close();

        //Переключиться на 1-е окно:

        owp.switchToWindowMain(window1, getWait20());

        String logoPropertyOnMain = owp.getPropertyLogoMain();

        Assert.assertFalse( logoPropertyOnMain.equals(LogoPropertyOnCoUk));
    }
}