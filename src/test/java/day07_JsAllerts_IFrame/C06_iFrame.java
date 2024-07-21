package day07_JsAllerts_IFrame;

import Utilities.ReusableMethods;
import Utilities.TestBaseAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class C06_iFrame extends TestBaseAll {
    @Test
    public void test01(){
        //1- https://testotomasyonu.com/discount adresine gidin
        driver.get("https://testotomasyonu.com/discount");
        //2- Elektronics Products yazisinin gorunur olduğunu test edin
        //Elektronik product bir iframe icinde oldugundan once o iframe e gecis yapmaliyiz.

        WebElement electronicsIframe= driver.findElement(By.xpath("//iframe[1]"));
        driver.switchTo().frame(electronicsIframe);

        WebElement electronicsProducts=driver.findElement(By.xpath("//*[text()='Electronics Products']"));
        Assertions.assertTrue(electronicsProducts.isDisplayed());;

        //3- Dell bilgisayar urun isminin ‘DELL Core I3 11th Gen’ olduğunu test edin
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        WebElement dellElementi=driver.findElement(By.id("pictext1"));
        String expectedIsim="DELL Core I3 11th Gen";
        String actualIsim=dellElementi.getText();
        Assertions.assertEquals(expectedIsim,actualIsim);


        //4- Sagdaki bolumde gorunen urunler arasinda ‘Men Slim Fit’ içeren en az 1 urun olduğunu test edin

        //sag sol Iframeler arasinda gecis yapabilmek icin once default olan ana sayfaya geri donememiz gerekir
        driver.switchTo().defaultContent();
        WebElement fashionIframe=driver.findElement(By.xpath("(//iframe)[2]"));
        driver.switchTo().frame(fashionIframe);

        //men slim fit yazisi elementlere ait textlerin icinde geciyor
        // testi yapabilmek icin tum urunleri tek tek ele almali
        //ve isminde Men Slim Fit geciyor mu diye kontrol etmeliyiz
        List<WebElement> fashionElementleriList=driver.findElements(By.xpath("//*[@class='overlay']"));
        List<String> urunIsimleriList=ReusableMethods.getStringList(fashionElementleriList);

        boolean menSlimFitVarmi= false;
        for (String eachIsim: urunIsimleriList)
        {
            if (eachIsim.contains("Men Slim Fit")){
                menSlimFitVarmi=true;
            }
        }
        Assertions.assertTrue(menSlimFitVarmi);

        //5- ‘Fashion’ yazisinin gorunur olduğunu test edin
        WebElement fashionYaziElementi=driver.findElement(By.tagName("h2"));
        Assertions.assertTrue(fashionYaziElementi.isDisplayed());
        //6- ‘Here are some products’ yazisinin gorunur olduğunu test edin
        driver.switchTo().defaultContent();
        WebElement hereAreYaziElementi=driver.findElement(By.tagName("desc"));
        Assertions.assertTrue(hereAreYaziElementi.isDisplayed());

        //7- Sayfayi kapatin
        ReusableMethods.bekle(3);
    }
}
