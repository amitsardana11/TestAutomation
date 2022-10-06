package com.amazon.qa.testcases;

import com.amazon.qa.base.TestBase;
import com.amazon.qa.pages.Homepage;
import com.amazon.qa.pages.Signup;
import org.testng.annotations.*;

public class SignupTest extends TestBase {
    Signup signup;
    Homepage homepage;

    public SignupTest(){
        super();
    }
    @BeforeSuite
    public void setup() {
        initialization();
        signup = new Signup();
    }
     @Test (priority =1)
     public void loginTest(){
         homepage = signup.login(prop.getProperty("UserName"),prop.getProperty("Password"));
     }



    @AfterSuite
    public void Teardown(){
        driver.quit();

    }

}
