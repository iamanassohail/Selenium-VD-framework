package objects;
import general.MainCall;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.util.List;
import static general.GenericFunctions.*;
public class ScenarioTwo_Apparel {
    public static By apparels = By.cssSelector("a[href='https://automationteststore.com/index.php?rt=product/category&path=68']");
    public static By tShirts = By.cssSelector("li:nth-child(2) a:nth-child(1) img");
    public static By sortLtH = By.cssSelector("select#sort");
    public static By getAllShirtButtons = By.cssSelector("div.pricetag.jumbotron > a.productcart");
    public static By shirt1size = By.cssSelector("#option348");
    public static By addToCart = By.cssSelector("ul.productpagecart >li >a.cart");
    public static By shirt2size = By.cssSelector("#option353");
    public static By shirt3size = By.cssSelector("#option352");
    public static By shirt4size = By.cssSelector("#option351");
    public static By getAllShoeButtons = By.cssSelector("div.pricetag.jumbotron > a.productcart");
    public static By shoes = By.cssSelector("div[id='maincontainer'] li:nth-child(1) a:nth-child(1) img:nth-child(1)");
    public static By itemQuantity = By.cssSelector("#product_quantity");
    //    public static By highestShoe = By.cssSelector("body > div:nth-child(1) > div:nth-child(3) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(2) > div:nth-child(1) > div:nth-child(2) > div:nth-child(4) > a:nth-child(1) > i:nth-child(1)");
    public static void shirtsShoesTests() {
        sortingShirts();
        List<WebElement> elements =  MainCall.webDriverFactory.getDriver().findElements(getAllShirtButtons);
        add1stShirt(elements);
        List<WebElement> elements2 = MainCall.webDriverFactory.getDriver().findElements(getAllShirtButtons);
        add2ndShirt(elements2);
        List<WebElement> elements3 = MainCall.webDriverFactory.getDriver().findElements(getAllShirtButtons);
        add3rdShirt(elements3);
        List<WebElement> elements4 = MainCall.webDriverFactory.getDriver().findElements(getAllShirtButtons);
        add4thShirt(elements4);
        shoesTests();
    }
    public static void shoesTests() {
        MainCall.webDriverFactory.getDriver().findElement(apparels).click();
        MainCall.webDriverFactory.getDriver().findElement(shoes).click();
        selectElementFromDropDownByText(sortLtH,"Price High > Low");
        List<WebElement> elements5 = MainCall.webDriverFactory.getDriver().findElements(getAllShoeButtons);
        elements5.get(0).click();
        scrollToElement(itemQuantity);
        MainCall.webDriverFactory.getDriver().findElement(itemQuantity).clear();
        MainCall.webDriverFactory.getDriver().findElement(itemQuantity).sendKeys(String.valueOf(2));
        click(addToCart);
    }
    public static void add1stShirt(List<WebElement> MyElements) {
        MyElements.get(0).click();
        try {
            selectElementFromDropDownByText(shirt1size, "Medium");
            scrollToElement(itemQuantity);
            MainCall.webDriverFactory.getDriver().findElement(itemQuantity).clear();
            MainCall.webDriverFactory.getDriver().findElement(itemQuantity).sendKeys(String.valueOf(1));
            click(addToCart);
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
            selectElementFromDropDownByText(shirt2size,"Medium");
            scrollToElement(itemQuantity);
            MainCall.webDriverFactory.getDriver().findElement(itemQuantity).clear();
            MainCall.webDriverFactory.getDriver().findElement(itemQuantity).sendKeys(String.valueOf(1));
            click(addToCart);
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
            selectElementFromDropDownByText(shirt3size,"Medium");
            scrollToElement(itemQuantity);
            MainCall.webDriverFactory.getDriver().findElement(itemQuantity).clear();
            MainCall.webDriverFactory.getDriver().findElement(itemQuantity).sendKeys(String.valueOf(1));
            click(addToCart);
            MainCall.webDriverFactory.getDriver().navigate().back();
            sortingShirts();
        } catch (Exception e) {
            System.out.println("medium size is NOT available");
            MainCall.webDriverFactory.getDriver().navigate().back();
        }
    }
    public static void add4thShirt(List<WebElement> MyElements){
        MyElements.get(3).click();
        try {
            selectElementFromDropDownByText(shirt4size,"Medium");
            scrollToElement(itemQuantity);
            MainCall.webDriverFactory.getDriver().findElement(itemQuantity).clear();
            MainCall.webDriverFactory.getDriver().findElement(itemQuantity).sendKeys(String.valueOf(1));
            click(addToCart);
        } catch (Exception e) {
            System.out.println("medium size is NOT available");
            MainCall.webDriverFactory.getDriver().navigate().back();
        }
    }
    public static void sortingShirts(){
        MainCall.webDriverFactory.getDriver().findElement(apparels).click();
        MainCall.webDriverFactory.getDriver().findElement(tShirts).click();
        selectElementFromDropDownByText(sortLtH,"Price Low > High");
    }
//        for (WebElement element : MyElements) {
//            if (i < 3) {
//               element.click(); ;
//               GenericFunctions.selectElementFromDropDownByText();
//
//            }
//            i++;
//        }
}
