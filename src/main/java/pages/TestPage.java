package pages;

import org.openqa.selenium.WebDriver;

public class TestPage {
    private WebDriver driver;

    public TestPage(WebDriver driver) {
        this.driver = driver;
    }
    public void testTitle(){
        driver.getTitle();
    }
}
