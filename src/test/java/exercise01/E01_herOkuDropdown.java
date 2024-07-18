package exercise01;

import Utilities.ReusableMethods;
import Utilities.TestBaseAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class E01_herOkuDropdown extends TestBaseAll {

    @Test
    public void dropdownTest(){
        //● https://the-internet.herokuapp.com/dropdown adresine gidin.
        driver.get("https://the-internet.herokuapp.com/dropdown");

        //1.Index kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
        WebElement ddm=driver.findElement(By.id("dropdown"));
        Select select=new Select(ddm);
        select.selectByIndex(1);
        //2.Value kullanarak Seçenek 2'yi (Option 2) seçin ve yazdırın
        Select select1=new Select(ddm);
        select1.selectByValue("2");
        //3.Visible Text(Görünen metin) kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
        Select select2=new Select(ddm);
        select2.selectByVisibleText("Option 1");
        //4.Tüm dropdown değerleri(value) yazdırın
        System.out.println(select.getFirstSelectedOption().getText());
        System.out.println(select1.getFirstSelectedOption().getText());
        System.out.println(select2.getFirstSelectedOption().getText());

        //5. Dropdown’un boyutunun 4 olduğunu test edin
        List<WebElement> size=select.getOptions();

        int expectedSize=4;
        int actualSize=size.size();
        Assertions.assertEquals(expectedSize,actualSize);
        ReusableMethods.bekle(3);


    }

}
