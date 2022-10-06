package com.amazon.qa.pages;

import com.amazon.qa.base.TestBase;
import com.amazon.qa.util.Utiltest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class TransferPage extends TestBase
    {
    @FindBy(xpath=".//*[contains(text(),'Transfer Between Accounts')]")
    WebElement TransferAcc;

    @FindBy(xpath=".//div[text()='Select a user']//parent::div//following-sibling::div[@class='ng-input']/input")
    WebElement SelectAUser_Dropdown;

    @FindBy(xpath=".//*[@title='Outgoing Amount']")
    WebElement AmountTransfer;

    @FindBy(xpath=".//*[@id='description']")
    WebElement Description;

    @FindBy(xpath=".//*[@type='submit']")
    WebElement continuebtn;

    @FindBy(xpath=".//*[contains(text(),'Confirm')]")
    WebElement confirmbtn;

    @FindBy(xpath=".//*[@class='popup-message']")
    WebElement PopupMessage;

    @FindBy(xpath=".//*[@ng-reflect-placeholder='Select a user']//parent::div//descendant::ng-dropdown-panel//div[contains(@class,'scroll-host')]//div//div//span")
    List<WebElement> Userlist;



    public TransferPage() {
        PageFactory.initElements(driver, this);
    }


    public void transferAccountclick(){
        TransferAcc.click();
    }

    public void Selectuser(){
        try{
        SelectAUser_Dropdown.click();
        Utiltest.ClickonUser(Userlist,prop.getProperty("SelectUser"));

        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

    public void selectcards(String cardname, String cardvalue){
        try{
        driver.findElement(By.xpath(".//*[@class='account-select']//app-account-select[@selectlabel='"+cardname+"']")).click();
       List<WebElement> cards = driver.findElements(By.xpath(".//*[@class='account-select']//app-account-select[@selectlabel='"+cardname+"']//descendant::div[contains(@class,'scroll-host')]//div//div//span"));
        for(int i=0; i<cards.size(); i++){
            String username= cards.get(i).getText();
            if(username.equals(cardvalue)){
                cards.get(i).click();
            }
        }}
        catch(Exception e){
            System.out.println(e.getMessage());
    }
    }

    public void AmountToBeTransfer(String amount){
        AmountTransfer.sendKeys(amount);

    }

    public void EnterDescription(String text){
        Description.sendKeys(text);

    }

    public void clickOnBtn(){
        Utiltest.movetoelement(continuebtn);
       continuebtn.click();
    }

    public void clickOnConfirmBtn(){
        confirmbtn.click();
    }

    public String VerifyPopupMessage(){
        return PopupMessage.getText();

    }

}
