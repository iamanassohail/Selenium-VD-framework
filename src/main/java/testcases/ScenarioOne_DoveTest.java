package testcases;
import general.BaseTest;
import general.MainCall;
import org.testng.annotations.Test;
import static objects.ScenarioOne_Dove.*;
import static objects.ScenarioOne_Dove.Assertion;
public class ScenarioOne_DoveTest extends BaseTest {
    @Test(description = "Select dove items")
    public static void DoveItemsTest() {
        clickHomeButton();
        scrollToElement();
        clickDoveCategory();
        selectValues("Date New > Old");
        addToCart();
        Assertion();
        clearCart();
    }
}