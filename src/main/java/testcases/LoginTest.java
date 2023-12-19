package testcases;
import org.testng.annotations.Test;
import static objects.Login.*;
public class LoginTest extends general.BaseTest {
    @Test(description = "Login test")
    public static void login() {
        //clearCache();
        objects.Login.clickLogin();
        objects.Login.enterUsernamePassword("anas123", "1234");
        clickLoginButton();
        clearCart();
    }
}
