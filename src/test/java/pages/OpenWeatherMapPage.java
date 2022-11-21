package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

public class OpenWeatherMapPage extends BasePage{

    final By LOGO_CO_UK = By.xpath("//li[@class='logo']/a/img");

    final By LOGO_MAIN = LOGO_CO_UK;

    final By POP_UP_HEADER3 = By.xpath("//div[@class='pop-up-header']/h3");

    final By DESKTOP_MENU_FOR_BUSINESS = By.linkText("For Business");

    final By DIFFERENT_WEATHER_SWITCH =
            By.xpath("//div[@class='controls']/span[@class='control-el owm-switch']");

    final By CO_UK_MOBILE_PADDING_H1 = By.xpath("//div[@class='mobile-padding']/h1");

    final By MAIN_MOBILE_PADDING_H2 = By.xpath("//div[@class='mobile-padding']/h2");

    final By DIALOG_DESC_WEATHER_ICON =
            By.xpath("//div[@id='dialogDesc']/div/ul[@class='icons']/li/*[local-name()='svg']");

    final By POPUP_ICON_SPAN_TEXT =
            By.xpath("//div[@id='dialogDesc']/div/ul/li/span");

    final String CURRENT_SRC = "src";

    final String ATTRIBUTE_NAME = "class";

    public OpenWeatherMapPage(WebDriver driver) {
        super(driver);
    }

    private WebElement getLogoCoUk() {

        return getDriver().findElement(LOGO_CO_UK);
    }

    private WebElement getLogoMain() {

        return getDriver().findElement(LOGO_MAIN);
    }

    private WebElement getPopUpHeader3() {

        return getDriver().findElement(POP_UP_HEADER3);
    }

    public String getPropertyLogoCoUk() {

        return getLogoCoUk().getDomProperty(CURRENT_SRC);
    }

    public String getPropertyLogoMain() {

        return getLogoMain().getDomProperty(CURRENT_SRC);
    }

    public String getTextPopUpHeader3() {

        return getPopUpHeader3().getText();
    }

    public void clickMenuForBusiness(WebDriverWait wait) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(DESKTOP_MENU_FOR_BUSINESS));
        wait.until(ExpectedConditions.elementToBeClickable(DESKTOP_MENU_FOR_BUSINESS)).click();
    }

    public void clickDifferentWeatherSwitch(WebDriverWait wait) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(DIFFERENT_WEATHER_SWITCH));
        wait.until(ExpectedConditions.elementToBeClickable(DIFFERENT_WEATHER_SWITCH)).click();
    }

    public void switchToWindowCoUk(String windowDescriptor, WebDriverWait wait) {
        getDriver().switchTo().window(windowDescriptor);
        wait.until(ExpectedConditions.visibilityOfElementLocated(CO_UK_MOBILE_PADDING_H1));
    }

    public void switchToWindowMain(String windowDescriptor, WebDriverWait wait) {
        getDriver().switchTo().window(windowDescriptor);
        wait.until(ExpectedConditions.visibilityOfElementLocated(MAIN_MOBILE_PADDING_H2));
    }
    public List<WebElement> getListDialogDeskWeatherIcon() {

        return getDriver().findElements(DIALOG_DESC_WEATHER_ICON);
    }

    private List<WebElement> getListWebElementPopUpIconSpanText() {

        return getDriver().findElements(POPUP_ICON_SPAN_TEXT);
    }

    public List<String> getListAttributeOfDialogDeskWeatherIcon() {
        List<String> svgAttribute = new ArrayList<>();

        for (WebElement svg : getListDialogDeskWeatherIcon()) {
            svgAttribute.add(svg.getAttribute(ATTRIBUTE_NAME));
        }

        return svgAttribute;
    }

    public String getSameAttributeName() {
        String sameAttributeName= "";

        for (int i = 0; i < getListAttributeOfDialogDeskWeatherIcon().size(); i++) {
            if (getListAttributeOfDialogDeskWeatherIcon().get(0).equals(getListAttributeOfDialogDeskWeatherIcon().get(i))
            ) {
                sameAttributeName = getListAttributeOfDialogDeskWeatherIcon().get(i);
            }
        }

        return sameAttributeName;
    }

    public List<String> getListPopUpIconText() {
        List<String> iconTexts = new ArrayList<>();

        for (WebElement span : getListWebElementPopUpIconSpanText()) {
            iconTexts.add(span.getText());
        }

        return iconTexts;
    }

    public String getStringFromListPopUpIconText() {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < getListPopUpIconText().size(); i++) {
            sb.append(getListPopUpIconText().get(i));
            if(i != (getListPopUpIconText().size() - 1)) {
                sb.append(", ");
            }
        }

        return sb.toString();
    }
}