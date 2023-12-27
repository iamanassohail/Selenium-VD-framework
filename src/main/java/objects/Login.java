package objects;
import general.CommonAssertions;
import general.MainCall;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.util.List;

public class Login {
    public static By Login_button = By.xpath("//ul[@id='customer_menu_top']//a[@href=\"https://automationteststore.com/index.php?rt=account/login\"]");
    public static By username = By.xpath("//input[@name='loginname']");
    public static By password = By.xpath("//input[@name='password']");
    public static By Login_press = By.xpath("//button[@title='Login']");
    public static By RemoveButton = By.xpath("//descendant::a[@class=\"btn btn-sm btn-default\"]");
    public static By Cart = By.xpath("/descendant::a[@class='dropdown-toggle'][2]");
    //public static By Continue = By.xpath("//*[@id=\"maincontainer\"]/div/div/div/div/div/div/a");
    public static void clickLogin(){
        MainCall.log.logInfo("User clicks on Login button");
        WebElement elements = MainCall.webDriverFactory.getDriver().findElement(Login_button);
        elements.click();
    }
    public static void enterUsernamePassword(String UserMail, String pass) {
        MainCall.log.logInfo("User enters email and password");
        MainCall.webDriverFactory.getDriver().findElement(username).sendKeys(UserMail);
        MainCall.webDriverFactory.getDriver().findElement(password).sendKeys(pass);
    }
    public static void clickLoginButton(){
        MainCall.webDriverFactory.getDriver().findElement(Login_press).click();
    }

    public static void clearCart() {
        MainCall.webDriverFactory.getDriver().findElement(Cart).click();
        List<WebElement> e = MainCall.webDriverFactory.getDriver().findElements(RemoveButton);
        while(e.size() != 0)
        {
            e.get(0).click();
            e = MainCall.webDriverFactory.getDriver().findElements(RemoveButton);
        }
        //MainCall.webDriverFactory.getDriver().findElement(Continue).click();
    }
}