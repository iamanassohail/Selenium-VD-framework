package objects;
import general.MainCall;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.util.List;
import static general.GenericFunctions.*;
import static general.CommonAssertions.*;
public class ScenarioTwo_Apparel {
    public static By Apparels = By.cssSelector("a[href='https://automationteststore.com/index.php?rt=product/category&path=68']");
    public static By TShirts = By.cssSelector("li:nth-child(2) a:nth-child(1) img");
    public static By SortDropDown = By.cssSelector("select#sort");
    public static By GetAllShirtsCartButtons = By.cssSelector("div.pricetag.jumbotron > a.productcart");
    public static By Shirt1size = By.cssSelector("#option348");
    public static By Shirt2size = By.cssSelector("#option353");
    public static By Shirt3size = By.cssSelector("#option352");
    public static By AddToCart = By.cssSelector("#product > fieldset > div:nth-child(6) > ul > li > a");                  //"ul.productpagecart >li >a.cart");
    public static By GetAllShoesCartButtons = By.cssSelector("div.pricetag.jumbotron > a.productcart");
    public static By Shoes = By.cssSelector("div[id='maincontainer'] li:nth-child(1) a:nth-child(1) img:nth-child(1)");
    public static By ItemQuantity = By.cssSelector("#product_quantity");
    public static void shirtsShoesTests() {
        sortingShirts();
        List<WebElement> elements =  MainCall.webDriverFactory.getDriver().findElements(GetAllShirtsCartButtons);
        add1stShirt(elements);
        List<WebElement> elements2 = MainCall.webDriverFactory.getDriver().findElements(GetAllShirtsCartButtons);
        add2ndShirt(elements2);
        List<WebElement> elements3 = MainCall.webDriverFactory.getDriver().findElements(GetAllShirtsCartButtons);
        add3rdShirt(elements3);
        shoesTests();
    }
    public static void shoesTests() {
        logInfo("User clicks in Apparels section");
        MainCall.webDriverFactory.getDriver().findElement(Apparels).click();
        logInfo("User clicks on Shoes in Apparels section");
        MainCall.webDriverFactory.getDriver().findElement(Shoes).click();
        logInfo("User selects high to low from drop down");
        selectElementFromDropDownByText(SortDropDown,"Price High > Low");
        List<WebElement> elements4 = MainCall.webDriverFactory.getDriver().findElements(GetAllShoesCartButtons);
        elements4.get(2).click();
        scrollToElement(ItemQuantity);
        MainCall.webDriverFactory.getDriver().findElement(ItemQuantity).clear();
        MainCall.webDriverFactory.getDriver().findElement(ItemQuantity).sendKeys("2");
        click(AddToCart);
    }
    public static void add1stShirt(List<WebElement> MyElements) {
        MyElements.get(0).click();
        try {
            selectElementFromDropDownByText(Shirt1size, "Medium");
            scrollToElement(ItemQuantity);
            MainCall.webDriverFactory.getDriver().findElement(ItemQuantity).clear();
            MainCall.webDriverFactory.getDriver().findElement(ItemQuantity).sendKeys("1");
            click(AddToCart);
            MainCall.webDriverFactory.getDriver().navigate().back();
            sortingShirts();
        }catch (Exception e) {
            System.out.println("medium size is NOT available");
            MainCall.webDriverFactory.getDriver().navigate().back();
        }
    }
    public static void add2ndShirt(List<WebElement> MyElements){
        MyElements.get(1).click();
        try {
            selectElementFromDropDownByText(Shirt2size,"Medium");
            scrollToElement(ItemQuantity);
            MainCall.webDriverFactory.getDriver().findElement(ItemQuantity).clear();
            MainCall.webDriverFactory.getDriver().findElement(ItemQuantity).sendKeys("1");
            click(AddToCart);
            MainCall.webDriverFactory.getDriver().navigate().back();
            sortingShirts();
        } catch (Exception e) {
            System.out.println("medium size is NOT available");
            MainCall.webDriverFactory.getDriver().navigate().back();
        }
    }
    public static void add3rdShirt(List<WebElement> MyElements){
        MyElements.get(2).click();
        try {
            selectElementFromDropDownByText(Shirt3size,"Medium");
            scrollToElement(ItemQuantity);
            MainCall.webDriverFactory.getDriver().findElement(ItemQuantity).clear();
            MainCall.webDriverFactory.getDriver().findElement(ItemQuantity).sendKeys("1");
            click(AddToCart);
            MainCall.webDriverFactory.getDriver().navigate().back();
            sortingShirts();
        } catch (Exception e) {
            System.out.println("medium size is NOT available");
            MainCall.webDriverFactory.getDriver().navigate().back();
        }
    }
    public static void sortingShirts(){
        MainCall.webDriverFactory.getDriver().findElement(Apparels).click();
        MainCall.webDriverFactory.getDriver().findElement(TShirts).click();
        selectElementFromDropDownByText(SortDropDown,"Price Low > High");
    }
}
