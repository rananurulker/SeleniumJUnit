package Utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static Utilities.TestBaseAll.driver;

public class ReusableMethods {
    public static void bekle(int saniye) {
        try {
            Thread.sleep(saniye * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static List<String> getStringList(List<WebElement> kaynakList) {

        List<String> stringList = new ArrayList<>();

        for (WebElement eachElement : kaynakList
        ) {

            stringList.add(eachElement.getText());

        }


        return stringList;
    }

    public static void SwitchWindowbyURL(WebDriver driver, String hedefURl) {
        Set<String> acikWindowlarinWHDSeti = driver.getWindowHandles();
        for (String eachWHD : acikWindowlarinWHDSeti) {
            //once eachWHD nin getirdigi WHD ile bir windowa gecis yapalim
            driver.switchTo().window(eachWHD);
            String gecilenSyafaURL = driver.getCurrentUrl();

            if (gecilenSyafaURL.equals(hedefURl)) {
                break;
            }

        }
    }

    public static void SwitchWindowByTitle(WebDriver driver, String hedefTitle) {
        Set<String> acikWindowlarinWHDSeti = driver.getWindowHandles();
        for (String eachWHD : acikWindowlarinWHDSeti) {
            //once eachWHD nin getirdigi WHD ile bir windowa gecis yapalim
            driver.switchTo().window(eachWHD);
            String gecilenSyafaTitle = driver.getCurrentUrl();

            if (gecilenSyafaTitle.equals(hedefTitle)) {
                break;
            }


        }

    }
}