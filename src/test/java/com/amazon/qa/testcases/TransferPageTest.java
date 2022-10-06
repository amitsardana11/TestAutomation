package com.amazon.qa.testcases;

import com.amazon.qa.base.TestBase;
import com.amazon.qa.pages.Homepage;
import com.amazon.qa.pages.Signup;
import com.amazon.qa.pages.TransferPage;
import org.testng.Assert;
import org.testng.annotations.*;

public class TransferPageTest extends TestBase {
    Signup signup;
    Homepage homepage;
    TransferPage transferpage;

    public TransferPageTest(){
        super();
    }

    @BeforeSuite
    public void setup() {
        initialization();
        signup = new Signup();
       // transferpage = new TransferPage();
        homepage = signup.login(prop.getProperty("UserName"),prop.getProperty("Password"));
        transferpage= homepage.clickOnTransferlink();
    }

    @Test(priority=1)
    public void clickTransferAccTest(){
        transferpage.transferAccountclick();
    }

    @Test(priority=2)
    public void SelectUserTest(){
        transferpage.Selectuser();
    }

   @Test(priority=3)
   public void selectDcardTest(){
        transferpage.selectcards("Debit from *",prop.getProperty("debitcard"));
   }
    @Test(priority=4)
    public void selectCcardTest(){
        transferpage.selectcards("Credit to *",prop.getProperty("creditcard"));
    }

    @Test(priority =5)
    public void EnterAmountTest(){
        transferpage.AmountToBeTransfer(prop.getProperty("amount"));
    }

    @Test(priority = 6)
    public void DecriptionTest(){
        transferpage.EnterDescription("`Admin user triggered auto transfer with amount" +" "+ prop.getProperty("amount"));
    }

    @Test(priority = 7)
    public void ContinueBtnTest(){
        transferpage.clickOnBtn();
    }

    @Test(priority = 8)
    public void ConfirmBtnTest(){
        transferpage.clickOnConfirmBtn();
    }

    @Test(priority =9)
    public void VerifyPopupmessageTest(){
       String message= transferpage.VerifyPopupMessage();
        Assert.assertEquals(message,"Transfer has been executed successfully.\n"
                + "Back to transfers.");

    }


   @AfterSuite
    public void Teardown(){
        driver.quit();

    }
}
