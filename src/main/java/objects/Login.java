package objects;
import general.CommonAssertions;
import general.MainCall;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.util.List;

public class Login {
    public static By login_button = By.xpath("//ul[@id='customer_menu_top']//a[@href=\"https://automationteststore.com/index.php?rt=account/login\"]");
    public static By username = By.xpath("//input[@name='loginname']");
    public static By password = By.xpath("//input[@name='password']");
    public static By login_press = By.xpath("//button[@title='Login']");
    public static By cartItem = By.xpath("//a[@href=\"https://automationteststore.com/index.php?rt=checkout/cart\"]//span[@class=\"label label-orange font14\"]");
    public static By itemprice = By.xpath("//a[@href=\"https://automationteststore.com/index.php?rt=checkout/cart\"]//span[@class=\"cart_total\"]");
    public static By removeButton = By.xpath("//descendant::a[@class=\"btn btn-sm btn-default\"]");
    public static By cart = By.xpath("/descendant::a[@class='dropdown-toggle'][2]");
    public static int actualItems;
    public static String  actualValue;
    public static String  actualValue2;
    public static void values(){
        actualItems = Integer.parseInt(MainCall.webDriverFactory.getDriver().findElement(cartItem).getText());
        actualValue = MainCall.webDriverFactory.getDriver().findElement(itemprice).getText();
        actualValue2 = MainCall.webDriverFactory.getDriver().findElement(itemprice).getText();
    }
    public static void clickLogin(){
        MainCall.log.logInfo("User clicks on Login button");
        WebElement elements = MainCall.webDriverFactory.getDriver().findElement(login_button);
        elements.click();
    }
    public static void enterUsernamePassword(String userMail, String pwd) {
        CommonAssertions.logActualReult("enter the username");
        MainCall.log.logInfo("User enters email and password");
        MainCall.webDriverFactory.getDriver().findElement(username).sendKeys(userMail);
        CommonAssertions.logExpectedResult("email will be display on text box");
        MainCall.webDriverFactory.getDriver().findElement(password).sendKeys(pwd);
    }
    public static void clickLoginButton(){
        MainCall.webDriverFactory.getDriver().findElement(login_press).click();
    }

    public static void clearCart() {
        MainCall.webDriverFactory.getDriver().findElement(cart).click();
        List<WebElement> e = MainCall.webDriverFactory.getDriver().findElements(removeButton);
        while(e.size() != 0)
        {
            e.get(0).click();
            e = MainCall.webDriverFactory.getDriver().findElements(removeButton);
        }
    }
}