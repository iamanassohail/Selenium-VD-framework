package testcases;
import org.testng.annotations.Test;
import static objects.Login.*;
public class LoginTest extends general.BaseTest {
    @Test(description = "Login test")
    public static void login() {
        clickLogin();
        enterUsernamePassword("anas123", "1234");
        clickLoginButton();
        clearCart();
    }
}
