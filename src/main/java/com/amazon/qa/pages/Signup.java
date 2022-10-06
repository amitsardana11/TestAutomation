package com.amazon.qa.pages;

import com.amazon.qa.base.TestBase;
import com.amazon.qa.util.Utiltest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Signup extends TestBase {
    Utiltest ut = new Utiltest();

    @FindBy(xpath=".//*[@type='email']")
    WebElement Username;

    @FindBy(xpath=".//*[@type='password']")
    WebElement password;

    @FindBy(xpath=".//*[@type='submit']")
    WebElement Submit_btn;



    public Signup() {
        PageFactory.initElements(driver, this);
    }

    public Homepage login(String un,String pwd){
        Username.sendKeys(un);
        password.sendKeys(pwd);
        Submit_btn.click();
         return new Homepage();
    }







}
