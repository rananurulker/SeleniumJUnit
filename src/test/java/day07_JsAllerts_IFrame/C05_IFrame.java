package day07_JsAllerts_IFrame;

import Utilities.ReusableMethods;
import Utilities.TestBaseAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class C05_IFrame extends TestBaseAll {

    @Test
    public void tiFrameTest(){
    //1 ) https://the-internet.herokuapp.com/iframe adresine gidin.
        driver.get("https://the-internet.herokuapp.com/iframe");

    // 2 ) Bir metod olusturun: iframeTest

    // - “An IFrame containing….” textinin erisilebilir oldugunu test edin ve  konsolda yazdirin.
        WebElement anIFrameElement=driver.findElement(By.xpath("//*[text()='An iFrame containing the TinyMCE WYSIWYG Editor']"));

        Assertions.assertTrue(anIFrameElement.isEnabled());
        System.out.println(anIFrameElement.getText());
         /*
            iframe tag'i bir HTML sayfa icinde inner baska bir HTML sayfasi olusturulmasina izin verir

            bir sayfada birden fazla iframe olabilecegi gibi
            ic ice katmanli iframe'ler olusturmak da mumkundur

            Sunu bilmemiz ve dikkat etmemiz gerekir
            URL ile gittigimiz sayfa ve icindeki iframe'ler birbirinden bagimsizdir
            ve aralarinda gecis yapmak icin driver.switchTo() kullanilmalidir

         */

        // - Text Box’a “Merhaba Dunya!” yazin.

        WebElement iFrameElementi=driver.findElement(By.id("mce_0_ifr"));
        driver.switchTo().frame(iFrameElementi);

        WebElement textBoxElementi= driver.findElement(By.xpath("//body[@id='tinymce']"));
        textBoxElementi.clear();
        textBoxElementi.sendKeys("Merhaba Dunya!");

    // - TextBox’in altinda bulunan “Elemental Selenium” linkinin gorunur oldugunu dogrulayin
        // ve  yazisini konsolda yazdirin.

        driver.switchTo().defaultContent();
        WebElement elementalSeleniumElementi=driver.findElement(By.xpath("//*[@*='large-4 large-centered columns']"));
        Assertions.assertTrue(elementalSeleniumElementi.isDisplayed());
        System.out.println(elementalSeleniumElementi.getText());
        ReusableMethods.bekle(3);


}
}
