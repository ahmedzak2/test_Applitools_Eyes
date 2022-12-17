package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SortableDataTablesPage {

    private WebDriver driver;
    public SortableDataTablesPage(WebDriver driver){
        this.driver = driver;
    }
    public void getTest(){
        driver.getTitle();
    }

    private By TABLE = By.xpath("//table[@id='table1']");

    private String HEADER_FORMAT = "//table[@id='table1']/descendant::span[text()='%s']/parent::th[contains(@class, 'header')]";
    private String test1= "/html/body/div[2]/div/div/table[1]/tbody/tr[4]/td[1]";
    private By test =  By.xpath(test1);


    private By LAST_NAME_HEADER = By.xpath(String.format(HEADER_FORMAT, "Last Name"));
    private By FIRST_NAME_HEADER = By.xpath(String.format(HEADER_FORMAT, "First Name"));
    private By EMAIL_HEADER = By.xpath(String.format(HEADER_FORMAT, "Email"));
    private By DUE_HEADER = By.xpath(String.format(HEADER_FORMAT, "Due"));
    private By WEBSITE_HEADER = By.xpath(String.format(HEADER_FORMAT, "Web Site"));


    public By getTableElementLocator(){
        return TABLE;
    }


    public void sortLastNameColumn(){
     driver.findElement(LAST_NAME_HEADER).click();
     //   driver.findElement(test).getText();
       // System.out.println(        driver.findElement(test).getText());
        //System.out.println("test success ");

    }

    public void sortFirstNameColumn(){
        driver.findElement(FIRST_NAME_HEADER).click();
    }
    public void sortEmailColumn(){
        driver.findElement(EMAIL_HEADER).click();
    }
    public void sortDueColumn(){
        driver.findElement(DUE_HEADER).click();
    }
    public void sortWebsiteColumn(){
        driver.findElement(WEBSITE_HEADER).click();
    }

}