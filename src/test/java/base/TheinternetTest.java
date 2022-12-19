package base;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TheinternetTest extends  Basetest{
    //@Test
    /*public  void  testBottomFrame(){
    //    driver.get(System.getProperty("site.frames.url"));
        eyesManager.validateFrame(2);
            }

   */

    @BeforeClass
    public static void startVisualTestSuite(){
        eyesManager.setBatchName("Sort Table");

    }

    @Test
    public void testSortByLastName(){
        tablesPage.sortLastNameColumn();
        eyesManager.validateElement(tablesPage.getTableElementLocator());
    }

    @Test
    public void testSortByFirstName(){
        tablesPage.sortFirstNameColumn();
        eyesManager.validateElement(tablesPage.getTableElementLocator());
    }

    @Test
    public void testSortByEmail(){
        tablesPage.sortEmailColumn();
        eyesManager.validateElement(tablesPage.getTableElementLocator());
    }

    @Test
    public void testSortByDueDate(){
        tablesPage.sortDueColumn();
        eyesManager.validateElement(tablesPage.getTableElementLocator());
    }

    @Test
    public void testSortByWebsite(){
        tablesPage.sortWebsiteColumn();
        eyesManager.validateElement(tablesPage.getTableElementLocator());
    }


}
