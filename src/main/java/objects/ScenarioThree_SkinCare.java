package objects;
import general.MainCall;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import java.util.List;
import static general.CommonAssertions.*;
public class ScenarioThree_SkinCare {
    public static By skinCare_button = By.xpath("//a[@href=\"https://automationteststore.com/index.php?rt=product/category&path=43\"]");
    public static By sale_Tag = By.xpath("//div[@class=\"thumbnail\"]/span[@class=\"sale\"]");
    public static By outOfStockAndonSale = By.xpath("//div[@class=\"thumbnail\" and ./span/@class=\"sale\"]//span[@class=\"nostock\"]");
    public static By addToCartSale = By.xpath("//div[@class=\"thumbnail\" and ./span/@class=\"sale\"]//a[@class=\"productcart\"]");
    public static By cartItem = By.xpath("//a[@href=\"https://automationteststore.com/index.php?rt=checkout/cart\"]//span[@class=\"label label-orange font14\"]");
    public static By itemprice = By.xpath("//a[@href=\"https://automationteststore.com/index.php?rt=checkout/cart\"]//span[@class=\"cart_total\"]");
    public static By newprice = By.xpath("//div[@class=\"pricetag jumbotron added_to_cart\"]//div[@class=\"price\"]//div[@class=\"pricenew\"]");
    public static double  actualValue;
    public static int  actualItems;
    public static int items;
    public static float price;
    public static By totalAmount=  By.xpath("//span[@class='bold totalamout']");
    public static double  total;
    public static void clickCategory(){
        logInfo("User clicks on SkinCare category button");
        WebElement elements = MainCall.webDriverFactory.getDriver().findElement(skinCare_button);
        elements.click();
    }
    public static void countSale(){
        List<WebElement> elements = MainCall.webDriverFactory.getDriver().findElements(sale_Tag);
        int size = elements.size();
        logInfo("Total number of items on Sale are: "+size);
    }
    public static void countSaleAndOutOfStock(){
        List<WebElement> elements = MainCall.webDriverFactory.getDriver().findElements(outOfStockAndonSale);
        int size = elements.size();
        logInfo("Total number of items on Sale and Out of stock: "+size);
    }
    public static void addSaleItemsToCart(){
        List<WebElement> elements = MainCall.webDriverFactory.getDriver().findElements(addToCartSale);
        items= elements.size();
        for (WebElement i:elements) {
            i.click();
        }
    }
    public static float calculateTotalPrice(){
        List<WebElement> elements = MainCall.webDriverFactory.getDriver().findElements(newprice);
        for (WebElement i:elements) {
            price+=Float.parseFloat(i.getText().replace("$",""));;
        }
        return price;
    }
    public static void logVerifyFloatEqual(float actual,float expected , String comment)
    {
        Assert.assertEquals(actual,expected,comment);
        logInfo(comment);
    }
    public static void logVerifyDoubleEqual(double actual,double expected , String comment)
    {
        Assert.assertEquals(actual,expected,comment);
        logInfo(comment);
    }
    public static void Assertion(){
        //int RemoveDoveItem = 1;
        //double RemoveDovePrice = 7.20;
        actualItems = Integer.parseInt(MainCall.webDriverFactory.getDriver().findElement(cartItem).getText());
        //actualItems = actualItems - RemoveDoveItem;
        System.out.println(actualItems);
        actualValue = Double.parseDouble(MainCall.webDriverFactory.getDriver().findElement(itemprice).getText().replace("$",""));
        //actualValue = actualValue - RemoveDovePrice;
        System.out.println(actualValue);
        //  GenericFunctions.scrollToElement(totalAmount);
        //total = Double.parseDouble(MainCall.webDriverFactory.getDriver().findElement(totalAmount).getText().replace("$",""));
        logVerifyIntEqual(actualItems,items,"Total items verified");
        logVerifyDoubleEqual(actualValue,calculateTotalPrice(),"Total amount verified");
    }
}
