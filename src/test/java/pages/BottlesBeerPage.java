package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BottlesBeerPage extends BasePage{

    private final By MENU_GUESTBOOK = By.xpath("//ul[@id='menu']/li/a[@href='/guestbookv2.html']");

    private  final By SUBMENU_SIGN_GUESTBOOK = By.linkText("Sign Guestbook");

    private  final By ICON_PROMPT_URL = By.cssSelector("a[onclick*='url']");

    public BottlesBeerPage(WebDriver driver) {
        super(driver);
    }

    private WebElement getMenuGuestbook() {

        return getDriver().findElement(MENU_GUESTBOOK);
    }

    private  WebElement getSubmenuSignGuestbook() {

        return getDriver().findElement(SUBMENU_SIGN_GUESTBOOK);
    }

    private  WebElement getIconPromptURL() {

        return getDriver().findElement(ICON_PROMPT_URL);
    }

    public  void clickMenuGuestbook() {
        getMenuGuestbook().click();
    }

    public  void clickSubmenuSignGuestbook() {
        getSubmenuSignGuestbook().click();
    }

    public  void clickIconPromptURL() {
        getIconPromptURL().click();
    }
}