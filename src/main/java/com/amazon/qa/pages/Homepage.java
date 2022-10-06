package com.amazon.qa.pages;

import com.amazon.qa.base.TestBase;
import com.amazon.qa.util.Utiltest;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.idealized.Javascript;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Homepage extends TestBase {

    @FindBy(xpath=".//*[@routerlink='/transfer']/label")
    WebElement Transferlink;

    public Homepage() {
        PageFactory.initElements(driver, this);
    }

        public TransferPage clickOnTransferlink(){
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40l));
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@routerlink='/transfer']/label")));
            Utiltest.movetoelement(Transferlink);
            Transferlink.click();

        }catch(Exception e){
           System.out.println(e.getMessage());
        }return new TransferPage();
        }
}
