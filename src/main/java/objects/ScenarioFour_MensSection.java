package objects;
import general.MainCall;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.util.List;
import static general.CommonAssertions.*;
public class ScenarioFour_MensSection {
    public static By Men_button = By.xpath("//a[@href=\"https://automationteststore.com/index.php?rt=product/category&path=58\"]");
    public static By ProductStartingWithM= By.xpath("//div[@class='col-md-3 col-sm-6 col-xs-12' ] //child::a[starts-with(@title,'M')]//parent::div[@class='fixed']//parent::div[@class='fixed_wrapper']//parent::div[@class='col-md-3 col-sm-6 col-xs-12']//div[@class='thumbnail']//a[@class='productcart']");
    public static By CartItemsStartWithM = By.xpath("//li[@class='dropdown hover' ]//a[starts-with(text(),'M')]");
    public static void clickMensCategory(){
        logInfo("User clicked on Mens category button");
        WebElement elements = MainCall.webDriverFactory.getDriver().findElement(Men_button);
        elements.click();
    }
    public static void addItemsToCart(){
        logInfo("User is adding items in the cart");
        List<WebElement> elements = MainCall.webDriverFactory.getDriver().findElements(ProductStartingWithM);
        for (WebElement i:elements) {
            i.click();
        }
    }
    public static void getCartItemStartingWithM(){
        List<WebElement> elements = MainCall.webDriverFactory.getDriver().findElements(CartItemsStartWithM);
        for (WebElement i:elements) {
            logVerifyStringEqual(i.getAttribute("innerHTML").replaceAll("(?!^).",""), "M", "item verified");
        }
    }
}