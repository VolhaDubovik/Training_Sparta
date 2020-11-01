package by.issoft.tests;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class MyFirstTest {

/*    @Test
    public void loginTest() {
        System.out.println("login to store");
        boolean loginResult = false;
        //Assert.assertTrue(loginResult, "Unable to login to store."); //проверяем, что наш Act res = Exp res
        Assert.assertEquals(loginResult, true, "Unable to login to store."); // тоже самое

    }*/

    @Test
    @Parameters({"name", "age"})
    public void loginTest(String userName, int age) {
        System.out.println("login to store");
        boolean loginResult = userName.equals("artem") ? true : false;
        //Assert.assertTrue(loginResult, "Unable to login to store."); //проверяем, что наш Act res = Exp res
        Assert.assertEquals(loginResult, true, "Unable to login to store."); // тоже самое


    }

    @Test
    public void loginInvalidCredsTest() {
        System.out.println("login to store with invalid creds.");
    }


}
