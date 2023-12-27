package objects;
import general.MainCall;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import java.util.List;
import static general.CommonAssertions.*;
public class ScenarioThree_SkinCare {
    public static By skinCare_button = By.xpath("//a[@href=\"https://automationteststore.com/index.php?rt=product/category&path=43\"]");
    public static By Sale_Tag = By.xpath("//div[@class=\"thumbnail\"]/span[@class=\"sale\"]");
    public static By OutOfStockAndonSale = By.xpath("//div[@class=\"thumbnail\" and ./span/@class=\"sale\"]//span[@class=\"nostock\"]");
    public static By AddToCartSale = By.xpath("//div[@class=\"thumbnail\" and ./span/@class=\"sale\"]//a[@class=\"productcart\"]");
    public static By CartItem = By.xpath("//a[@href=\"https://automationteststore.com/index.php?rt=checkout/cart\"]//span[@class=\"label label-orange font14\"]");
    public static By ItemPrice = By.xpath("//a[@href=\"https://automationteststore.com/index.php?rt=checkout/cart\"]//span[@class=\"cart_total\"]");
    public static By TotalPrice = By.xpath("//div[@class=\"pricetag jumbotron added_to_cart\"]//div[@class=\"price\"]//div[@class=\"pricenew\"]");
    public static double ActualValue;
    public static int ActualItems;
    public static int Items;
    public static float Price;
    public static void clickCategory(){
        logInfo("User clicks on SkinCare category button");
        WebElement elements = MainCall.webDriverFactory.getDriver().findElement(skinCare_button);
        elements.click();
    }
    public static void countSale(){
        List<WebElement> elements = MainCall.webDriverFactory.getDriver().findElements(Sale_Tag);
        int size = elements.size();
        logInfo("Total number of items on Sale are: "+size);
    }
    public static void countSaleAndOutOfStock(){
        List<WebElement> elements = MainCall.webDriverFactory.getDriver().findElements(OutOfStockAndonSale);
        int size = elements.size();
        logInfo("Total number of items on Sale and Out of stock: "+size);
    }
    public static void addSaleItemsToCart(){
        List<WebElement> elements = MainCall.webDriverFactory.getDriver().findElements(AddToCartSale);
        Items = elements.size();
        for (WebElement i:elements) {
            i.click();
        }
    }
    public static float calculateTotalPrice(){
        List<WebElement> elements = MainCall.webDriverFactory.getDriver().findElements(TotalPrice);
        for (WebElement i:elements) {
            Price+=Float.parseFloat(i.getText().replace("$",""));;
        }
        return Price;
    }
    public static void logVerifyDoubleEqual(double actual,double expected , String comment)
    {
        Assert.assertEquals(actual,expected,comment);
        logInfo(comment);
    }
    public static void Assertion(){
        ActualItems = Integer.parseInt(MainCall.webDriverFactory.getDriver().findElement(CartItem).getText());
        ActualValue = Double.parseDouble(MainCall.webDriverFactory.getDriver().findElement(ItemPrice).getText().replace("$",""));
        logVerifyIntEqual(ActualItems,Items,"Total items verified");
        logVerifyDoubleEqual(ActualValue,calculateTotalPrice(),"Total amount verified");
    }
}
