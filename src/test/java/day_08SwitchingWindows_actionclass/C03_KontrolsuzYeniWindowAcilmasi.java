package day_08SwitchingWindows_actionclass;

import Utilities.ReusableMethods;
import Utilities.TestBaseEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class C03_KontrolsuzYeniWindowAcilmasi extends TestBaseEach {
    @Test
    public void test01(){
        //https://testotomasyonu.com/addremove/ url e gidin

        driver.get("https://testotomasyonu.com/addremove/");

        System.out.println("Addremove: "+ driver.getCurrentUrl());//Addremove: https://testotomasyonu.com/addremove/
        System.out.println("Addremove: "+ driver.getWindowHandle());//Addremove: 39E075C42C58B4AA711EA2F81661C728
        String ilkWindowWhd=driver.getWindowHandle();
        ReusableMethods.bekle(3);

        //Electronics linkine tikla
        driver.findElement(By.xpath("(//a[text()='Electronics'])[3]"))
                .click();

        System.out.println("Electronics linkine tiklayinca "+ driver.getCurrentUrl());//https://testotomasyonu.com/category/7/products
        System.out.println("Electronics linkine tiklayinca "+ driver.getWindowHandle());//4D7BD67DF7DC2D9517151F7AA7ED292F


        //back tusuna basin ve
        //https://testotomasyonu.com/addremove/ adresine dondugunuzu test edi

        driver.navigate().back();
        String expectedURL="https://testotomasyonu.com/addremove/";
        String actualURL=driver.getCurrentUrl();
        Assertions.assertEquals(expectedURL,actualURL);

        //Please clic for Electronic Products Linkine tiklayin
        ReusableMethods.bekle(3);

        driver.findElement(By.xpath("//*[text() = 'Electronics Products']")).click();
        System.out.println("Please click for Electronic Products linkine basinca : "+ driver.getCurrentUrl());
        // Yeni Tab acildiginda : about:blank
        System.out.println("Please click for Electronic Products linkine basinca : "+ driver.getWindowHandle());
        // 83E84E3762FDEB38AF2F6DB152CD78AF
        System.out.println("Please click for Electronic Products linkine basinca : "+ driver.getWindowHandles());
        // 83E84E3762FDEB38AF2F6DB152CD78AF

        //kategori olarak Electronics sayfasiin acildigini test edin
        //home elctronics yazisinin ciktigini test edin
        WebElement seciliKategoriElementi=driver.findElement(By.xpath("//li[@class='current']"));

        String expectedSeciliKategori="Electronics";
        String actualSeciliKategori=seciliKategoriElementi.getText();
        Assertions.assertEquals(expectedSeciliKategori,actualSeciliKategori);
        ReusableMethods.bekle(2);

        //yeni window aciliyor ama driver bundan haberdar olmadigi icin eski sayfada bekliyor.




    }
}
