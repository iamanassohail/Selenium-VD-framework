package testcases;
import general.BaseTest;
import org.testng.annotations.Test;
import static objects.ScenarioThree_SkinCare.*;
public class ScenarioThree_SkinCareTest extends BaseTest {
    @Test(description = "Count sale, out of stock items and adding sale items to cart test")
    public static void skinCareTest(){
        clickCategory();
        countSale();
        countSaleAndOutOfStock();
        addSaleItemsToCart();
        Assertion();
    }
}
