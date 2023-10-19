package day_10;

import utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import utilities.TestBase;


public class C02_kopy extends TestBase {
    // 'https://www.amazon.com' adresine gidin
    // arama kutusuna "Java" yazip aratın
    // sonuc yazisinin "Java" icerdigini test edin
    // kontrollu olarak yeni bir sayfa acın
    // yeni acılan sayfada "Kitap" aratın
    // sonuc yazisinin Kitap icerdigini test edin
    // sayfayı kapatınız

    // test raporu alınız


    @Test
    public void name() {

        rapor("Chrome","Smoke Test");

        extentTest = extentReport.createTest("Amazon Test","Test Raporu");



        // 'https://www.amazon.com' adresine gidin
        driver.get("https://www.amazon.com");
        extentTest.info("AMAZON SAYFASINA GİDİLDİ");



        // arama kutusuna "Java" yazip aratın
        WebElement aramaKutusu = driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
        aramaKutusu.sendKeys("Java" + Keys.ENTER);
        extentTest.info("ARAMA KUTUSUNA JAVA YAZIP ARATILDI");


        // sonuc yazisinin "Java" icerdigini test edin
        WebElement sonucYazisi = driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));
        Assert.assertTrue(sonucYazisi.getText().contains("Java"));
        extentTest.info("SONUC YAZISININ JAVA İCERDİGİ TEST EDİLDİ");




        // kontrollu olarak yeni bir sayfa acın
        driver.switchTo().newWindow(WindowType.WINDOW);
        extentTest.info("KONTROLLU YENİ SAYFA ACILDI");




        // yeni acılan sayfada "Kitap" aratın
        driver.get("https://www.amazon.com");
        aramaKutusu = driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
        aramaKutusu.sendKeys("Kitap" + Keys.ENTER);
        extentTest.info("YENİ ACILAN SAYFADA KİTAP ARATILDI");



        // sonuc yazisinin Kitap icerdigini test edin
        sonucYazisi = driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));
        Assert.assertTrue(sonucYazisi.getText().contains("Kitap"));
        extentTest.pass("SONUC YAZISININ KİTAP İCERDİGİ TEST EDİLDİ");



        extentReport.flush();



    }
}
