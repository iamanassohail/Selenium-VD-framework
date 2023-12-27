package objects;
import general.MainCall;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static general.CommonAssertions.logVerifyIntEqual;
import static general.CommonAssertions.logVerifyStringEqual;
public class ScenarioOne_Dove {
    public static By Home_button = By.xpath("//a[@class=\"active menu_home\"]");
    public static By Dove_category = By.xpath("//img[@alt='Dove']");
    public static By DropDownSelector = By.xpath("//select[@class='form-control ']");
    public static By AddToCart = By.xpath("//i[@class=\"fa fa-cart-plus fa-fw\"]");
    public static By CartItem = By.xpath("//a[@href=\"https://automationteststore.com/index.php?rt=checkout/cart\"]//span[@class=\"label label-orange font14\"]");
    public static By Itemprice = By.xpath("//a[@href=\"https://automationteststore.com/index.php?rt=checkout/cart\"]//span[@class=\"cart_total\"]");
    public static By Cart = By.xpath("/html/body/div/header/div[2]/div/div[3]/ul/li/a");
    public static By RemoveButton = By.xpath("//descendant::a[@class=\"btn btn-sm btn-default\"]");
    //public static By Continue = By.xpath("//*[@id=\"maincontainer\"]/div/div/div/div/div/div/a");
    public static int TotalItems;
    public static String TotalValue;
    public static void Assertion(){
        TotalItems = Integer.parseInt(MainCall.webDriverFactory.getDriver().findElement(CartItem).getText());
        TotalValue = MainCall.webDriverFactory.getDriver().findElement(Itemprice).getText();
        logVerifyIntEqual(TotalItems,1,"Total items verified");
        logVerifyStringEqual(TotalValue,"$6.00","total cost verified");
    }
    public static void addToCart()
    {
        MainCall.webDriverFactory.getDriver().findElements(AddToCart).get(0).click();
    }
    public static void clickHomeButton(){
        MainCall.webDriverFactory.getDriver().findElement(Home_button).click();
    }
    public static void scrollToElement()
    {
        MainCall.genericFunctions.scrollToElement(Dove_category);
    }
    public static void clickDoveCategory(){
        MainCall.webDriverFactory.getDriver().findElement(Dove_category).click();
    }
    public static void selectValues(String value1)
    {
        MainCall.genericFunctions.selectElementFromDropDownByText(DropDownSelector,value1);
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
