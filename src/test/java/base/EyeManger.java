package base;

import com.applitools.eyes.BatchInfo;
import com.applitools.eyes.selenium.Eyes;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.apache.commons.io.IOUtils;
import java.io.IOException;

public class EyeManger {
    protected static Eyes eyes;
    private WebDriver driver;
    private String appname;

    public EyeManger(WebDriver driver, String appname) {
        this.driver = driver;
        this.appname = appname;
        eyes =new Eyes();
        eyes.setApiKey(System.getProperty("applitools.api.key"));

    }
   public void setBatchName(String batchName){
        eyes.setBatch(new BatchInfo(batchName));
    }

    public void setTestGroup(String group){
        eyes.addProperty("Test Group", group);
    }
    public void validateElement(By locator ){

        // used for check element
        eyes.open(driver,appname,
                Thread.currentThread().getStackTrace()[2].getMethodName());
// to vlidate element
        eyes.checkElement(locator);
        eyes.close();
    }
    public void validateFrame(int  locator ){

        // used for check element
        eyes.open(driver,appname, Thread.currentThread().getStackTrace()[2].getMethodName());
// to vlidate element
        //  eyes.checkFrame(locator);
        // eyes.checkFrame(locator);
        eyes.checkFrame(locator);
        eyes.close();
    }

    public void validateWindow(){
        // use for test Search page


        //  eyes.open(driver,"automation BookStore",
        //       Thread.currentThread().getStackTrace()[2].getMethodName());

        // used for test Dynanmic content
        eyes.open(driver,appname,
                Thread.currentThread().getStackTrace()[2].getMethodName());

        // to determint about mtch level of image

        // to check about the content only
        // eyes.setMatchLevel(MatchLevel.CONTENT);

        // verfiy the lay out of app
        //eyes.setMatchLevel(MatchLevel.LAYOUT);
        // to take screenshot of windows

        // to take all page if it scrollable
        eyes.setForceFullPageScreenshot(true);
        eyes.checkWindow();
        eyes.close();
    }
    public void abort(){
        eyes.abortIfNotClosed();
    }

    public Eyes getEyes(){
        return eyes;
    }
    public static boolean validatePDF(String filepath) throws IOException, InterruptedException {
        String command = String.format(
                "java -jar resources/ImageTester.jar -k %s -f %s",
                System.getProperty("applitools.api.key"),
                filepath);

        Process process = Runtime.getRuntime().exec(command);
        process.waitFor();
        String stream = IOUtils.toString(process.getInputStream(), "UTF-8");
        System.out.println(stream);

        if(stream != null && stream.contains("Mismatch")){
            return false;
        }

        return true;
    }

}
