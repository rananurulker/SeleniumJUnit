package Utilities;

import org.openqa.selenium.WebElement;

import java.util.List;

public class ReusableMethods {
    public static void bekle(int saniye){
        try {
            Thread.sleep(saniye*1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static boolean getStringList(List<WebElement> ayDdmTumSecenekler) {
        return false;
    }
}
