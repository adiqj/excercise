package utilities;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public abstract class BaseTest {

    @BeforeTest
    public void beforeTest() {
        AndroidModel.startDriver();
    }

    @AfterTest
    public void afterTests() {
        AndroidModel.closeDriver();
    }
}
