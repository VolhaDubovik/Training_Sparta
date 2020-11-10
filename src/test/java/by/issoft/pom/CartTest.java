package by.issoft.pom;

import lombok.Data;
import lombok.experimental.Accessors;
import org.testng.annotations.Test;


import static com.codeborne.selenide.Selenide.$;

@Data
@Accessors(chain = true)
public class CartTest {

    LoginPage loginPage = new LoginPage();

    @Test
    public void cartTest(){
        loginPage.login("valid", "valid");

        $("cart").click();
        //validate
    }
}