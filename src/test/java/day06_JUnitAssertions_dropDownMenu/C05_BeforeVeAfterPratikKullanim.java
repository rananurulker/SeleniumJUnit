package day06_JUnitAssertions_dropDownMenu;

import Utilities.TestBaseEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import javax.management.StringValueExp;

public class C05_BeforeVeAfterPratikKullanim extends TestBaseEach {

    //Testotomasyonu anasayfaya gidin
    //URLin testotomasyonu icerdigini test edin.
    @Test
    public void UrlTest(){
        driver.get("https://www.testotomasyonu.com");
        String expectedUrlIcerik="testotomasyonu";
        String actualUrl= driver.getCurrentUrl();

        Assertions.assertTrue(actualUrl.contains(expectedUrlIcerik));
    }
}
