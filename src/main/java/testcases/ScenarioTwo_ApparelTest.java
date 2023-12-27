package testcases;
import general.BaseTest;
import org.testng.annotations.Test;
import static objects.ScenarioTwo_Apparel.*;
public class ScenarioTwo_ApparelTest extends BaseTest {
    @Test(description = "Adding Shirts, Shoes Test")
    public static void ShirtsAndShoesTest() throws InterruptedException {
        //shirtsShoesTests();
        shoesTests();
    }
}
