package objects;
import general.MainCall;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static general.CommonAssertions.logVerifyIntEqual;
import static general.CommonAssertions.logVerifyStringEqual;
public class ScenarioOne_Dove {
    public static By home_button = By.xpath("//a[@class=\"active menu_home\"]");
    public static By dove_category = By.xpath("//img[@alt='Dove']");
    public static By bySelector = By.xpath("//select[@class='form-control ']");
    public static By addToCart = By.xpath("//i[@class=\"fa fa-cart-plus fa-fw\"]");
    public static By cartItem = By.xpath("//a[@href=\"https://automationteststore.com/index.php?rt=checkout/cart\"]//span[@class=\"label label-orange font14\"]");
    public static By itemprice = By.xpath("//a[@href=\"https://automationteststore.com/index.php?rt=checkout/cart\"]//span[@class=\"cart_total\"]");
    public static By cart = By.xpath("/descendant::a[@class='dropdown-toggle'][2]");
    public static By removeButton = By.xpath("//descendant::a[@class=\"btn btn-sm btn-default\"]");
    public static int actualItems;
    public static String  actualValue;
    public static String  actualValue2;
    public static void Assertion(){
        actualItems = Integer.parseInt(MainCall.webDriverFactory.getDriver().findElement(cartItem).getText());
        actualValue = MainCall.webDriverFactory.getDriver().findElement(itemprice).getText();
        logVerifyIntEqual(actualItems,1,"Total items verified");
        logVerifyStringEqual(actualValue,"$7.20","total cost verified");
    }
    public static void addToCart()
    {
        MainCall.webDriverFactory.getDriver().findElements(addToCart).get(0).click();
    }
    public static void clickHomeButton(){
        MainCall.webDriverFactory.getDriver().findElement(home_button).click();
    }
    public static void scrollToElement()
    {
        MainCall.genericFunctions.scrollToElement(dove_category);
    }
    public static void clickDove(){
        MainCall.webDriverFactory.getDriver().findElement(dove_category).click();
    }
    public static void selectValues(String value1)
    {
        MainCall.genericFunctions.selectElementFromDropDownByText(bySelector,value1);
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
