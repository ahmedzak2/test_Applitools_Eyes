package base;

import com.applitools.eyes.MatchLevel;
import com.applitools.eyes.selenium.Eyes;
import org.openqa.selenium.By;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v85.log.Log;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.WebDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import pages.SearchPage;
import pages.SortableDataTablesPage;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class Basetest {
    ChromeDriver driver;
    protected static EyeManger eyesManager;
    protected static Eyes eyes;
    protected static SearchPage page;
    public  SortableDataTablesPage tablesPage;

    @BeforeClass
    public void setUp(){
        Properties props = System.getProperties();
        try {
            props.load(new FileInputStream(new File("/home/zik/pratice/testAI/src/main/resources/test.properties")));
        } catch(Exception e) {
            e.printStackTrace();
            System.exit(-1);
        }

           WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        driver.manage().window().maximize();
        // for Test case SearchPage

     //  driver.get(System.getProperty("site.url"));
       // eyesManager = new EyeManger(driver, "automation BookStore ");

        // For the Dynamic Test

     //  driver.get("https://the-internet.herokuapp.com/dynamic_content");
       //        eyesManager = new EyeManger(driver, "The Internet");

        // For ScrollTests
      // driver.get("https://the-internet.herokuapp.com/large");
      //        eyesManager = new EyeManger(driver, "The Internet");

       // for testFrames

       // driver.get("https://the-internet.herokuapp.com/nested_frames");
        //         eyesManager = new EyeManger(driver, "The Internet");

        // to test tables
      //  driver.get("https://the-internet.herokuapp.com/tables");
        eyesManager = new EyeManger(driver, "The Internet");
         tablesPage = new SortableDataTablesPage(driver);

        System.out.println(driver.getTitle());
   //   page = new SearchPage(driver);
    }


// verify every thing about screen

     @AfterMethod
    public void tearDown(){

       driver.quit();
        // to close eye if we need
         eyesManager.abort();
    }

}
