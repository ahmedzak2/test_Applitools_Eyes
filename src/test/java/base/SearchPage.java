package base;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SearchPage extends Basetest{


    @Test
    public void testSearchBodyFullTitle(){
        // in case of you want to see it success
        String title = "Agile Testing";
       // in case pf fail
      //  String title = "test";
page.search(title);
        eyesManager.validateWindow();

    }
    @Test
    public void testSearchForElement(){
        // in case of you want to see it success
        String title = "Agile Testing";
        // in case pf fail
        //  String title = "test";
        page.search(title);

      eyesManager.validateElement(By.id("pid3_thumb"));
        Assert.assertEquals(page.getNumberOfVisibleBooks(),1,"Number of book returned");

    }
}
