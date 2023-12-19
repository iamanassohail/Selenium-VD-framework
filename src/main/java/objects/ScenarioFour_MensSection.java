package objects;
import general.MainCall;
import org.jetbrains.annotations.Nullable;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.util.List;
import static com.sun.tools.xjc.reader.Ring.add;
import static general.CommonAssertions.*;
public class ScenarioFour_MensSection {
    public static By men_button = By.xpath("//a[@href=\"https://automationteststore.com/index.php?rt=product/category&path=58\"]");
    public static By productStartingWM= By.xpath("//div[@class='col-md-3 col-sm-6 col-xs-12' ] //child::a[starts-with(@title,'M')]//parent::div[@class='fixed']//parent::div[@class='fixed_wrapper']//parent::div[@class='col-md-3 col-sm-6 col-xs-12']//div[@class='thumbnail']//a[@class='productcart']");
    public static By cartItemsStartWM = By.xpath("//li[@class='dropdown hover' ]//a[starts-with(text(),'M')]");
    public static void clickCategory(){
        logInfo("User clicks on Mens category button");
        WebElement elements = MainCall.webDriverFactory.getDriver().findElement(men_button);
        elements.click();
    }
    public static void addItemsToCart(){
        List<WebElement> elements = MainCall.webDriverFactory.getDriver().findElements(productStartingWM);
        for (WebElement i:elements) {
            i.click();
        }
    }
    @Nullable
    public static void getCartItemStartingWithM(){
        List<WebElement> elements = MainCall.webDriverFactory.getDriver().findElements(cartItemsStartWM);
        for (WebElement i:elements) {
            logVerifyStringEqual(i.getAttribute("innerHTML").replaceAll("(?!^).",""), "M", "item verified");
        }
    }
}