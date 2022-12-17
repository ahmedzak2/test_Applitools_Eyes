package base;

import org.testng.annotations.Test;

public class DynamicTest extends Basetest{
    @Test
    public void  testDynaimcContent(){
        eyesManager.validateWindow();
    }
}
