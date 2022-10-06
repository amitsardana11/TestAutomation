package com.amazon.qa.util;

import com.amazon.qa.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public  class Utiltest extends TestBase {
    public static long page_load_timeout =30;
    public static long implicit_wait=30;

    public  void windowswitch(){
        ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());
        driver.switchTo().window(tabs2.get(1));
        driver.close();
        driver.switchTo().window(tabs2.get(0));
    }
    public static void movetoelement(WebElement name){
        Actions builder = new Actions(driver);
        builder.moveToElement( name );
        builder.perform();
    }

    public static void ClickonUser(List<WebElement> elementlist, String objName){
        for(int i=0; i<elementlist.size(); i++){
            String username= elementlist.get(i).getText();
            if(username.equals(objName)){
                elementlist.get(i).click();
            }
    }
}}
