package day05_maven_JunitFramework;

import Utilities.ReusableMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;

public class C02_ZeroWebAppTesti {
    private static final Logger log = LoggerFactory.getLogger(C02_ZeroWebAppTesti.class);

    public static void main(String[] args) {
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        //1. http://zero.webappsecurity.com
        driver.get("http://zero.webappsecurity.com");
        //   sayfasina gidin
        //2. Signin buttonuna tiklayin
        WebElement signinButtonn=driver.findElement(By.id("signin_button"));
        signinButtonn.click();
        ReusableMethods.bekle(2);
        //3. Login alanine  “username” yazdirin
        WebElement loginButton=driver.findElement(By.id("user_login"));
        loginButton.sendKeys("username");
        //4. Password alanina “password” yazdirin
        WebElement passWordKutusu=driver.findElement(By.id("user_password"));
        passWordKutusu.sendKeys("password");
        //5. Sign in buttonuna tiklayin
        driver.findElement(By.name("submit")).click();

        //6. Back tusu ile sayfaya donun
        driver.navigate().back();
        ReusableMethods.bekle(2);

        //7. Online Banking menusunden Pay Bills sayfasina gidin
        driver.findElement(By.xpath("//strong[text()='Online Banking']")).click();
        driver.findElement(By.id("pay_bills_link")).click();

        //8. amount kismina yatirmak istediginiz herhangi bir miktari yazin
        WebElement amountKutusu=driver.findElement(By.id("sp_amount"));
        amountKutusu.sendKeys("200");
        ReusableMethods.bekle(2);

        //9. tarih kismina “2024-07-16” yazdirin
        WebElement dateButton=driver.findElement(By.id("sp_date"));
        dateButton.sendKeys("2024-07-16");
        ReusableMethods.bekle(2);

        //10. Pay buttonuna tiklayin
        driver.findElement(By.id("pay_saved_payees")).click();

        //11. “The payment was successfully submitted.” mesajinin ciktigini test edin

        WebElement messageElement=driver.findElement(By.id("alert_content"));

        String expectedMessage="The payment was successfully submitted.";
        String actualMessage=messageElement.getText();

        if (expectedMessage.equals(actualMessage)){
            System.out.println("Test PASSED");

        }else System.out.println("Test FAILED");
        ReusableMethods.bekle(2);
        driver.quit();
    }
}
