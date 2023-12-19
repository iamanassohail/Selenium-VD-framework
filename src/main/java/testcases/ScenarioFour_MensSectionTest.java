package testcases;
import general.BaseTest;
import org.testng.annotations.Test;
import static objects.ScenarioFour_MensSection.*;
public class ScenarioFour_MensSectionTest extends BaseTest {
    @Test(description = "MensSection Cases")
    public static void selectMensProduct(){
        clickCategory();
        addItemsToCart();
        getCartItemStartingWithM();
    }
}
