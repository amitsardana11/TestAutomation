package com.amazon.qa.testcases;

import com.amazon.qa.base.TestBase;
import com.amazon.qa.pages.Homepage;
import com.amazon.qa.pages.Signup;
import com.amazon.qa.pages.TransferPage;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import java.time.Duration;

public class HomePageTest extends TestBase {
    Signup signup;
    Homepage homepage;
    TransferPage transferpage;

    public HomePageTest(){
        super();
    }

   @BeforeSuite
    public void setup() {
        initialization();
        signup = new Signup();
        homepage = signup.login(prop.getProperty("UserName"),prop.getProperty("Password"));
    }

    @Test(priority=1)
    public void verifytransferlinkTest(){
       homepage.clickOnTransferlink();
    }


    @AfterSuite
    public void Teardown(){
        driver.quit();

    }







}
