package com.amazon.qa.base;
import com.amazon.qa.util.Utiltest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class TestBase {
    public static WebDriver driver;
    public static Properties prop;
    public TestBase(){
        try {
            prop = new Properties();
            FileInputStream fp = new FileInputStream("/Users/amitkumar/TestAmazon/src/main/java/com/amazon/qa/config/config.properties");
              prop.load(fp);

        }catch ( FileNotFoundException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
    public static void initialization(){
        String Browsername= prop.getProperty("Browser");
        if (Browsername.equals("Chrome"))
        {
            System.setProperty("webdriver.chrome.driver","/Users/amitkumar/TestAmazon/driver/chromedriver");
            driver = new ChromeDriver();
        }else if (Browsername.equals("FF")) {
            System.setProperty("webdriver.gecko.driver", "/Users/amitkumar/TestAmazon/driver/geckodriver");
            driver = new FirefoxDriver();
        }
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(Utiltest.page_load_timeout));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Utiltest.implicit_wait));
        driver.get(prop.getProperty("URL"));
    }

}
