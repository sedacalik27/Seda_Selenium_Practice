package day_05;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C01_FilesUpload extends TestBase {
    // masaustunde bir deneme dosyası olusturun. İcine Merhaba Dunya yazınız.
    // 'https://cgi-lib.berkeley.edu/ex/fup.html' adresine gidiniz
    // 'Notes about the file' kısmına 'Benim Dosyam' notunu yazınız.
    // 'Dosya Seç' kısmına deneme dosyasını yükleyiniz.
    // 'Press' butonuna basın
    // Dosya notunun 'Benim Dosyam' oldugunu test ediniz
    // Dosya iceriginin 'Merhaba Dunya' icerdigini test ediniz.


    @Test
    public void test01() {
        // masaustunde bir deneme dosyası olusturun. İcine Merhaba Dunya yazınız.

        // 'https://cgi-lib.berkeley.edu/ex/fup.html' adresine gidiniz
        driver.get("https://cgi-lib.berkeley.edu/ex/fup.html");
        bekle(2);

        // 'Notes about the file' kısmına 'Benim Dosyam' notunu yazınız.
        driver.findElement(By.xpath("//input[@name='note']")).sendKeys("Benim Dosyam");
        bekle(2);

        // 'Dosya Seç' kısmına deneme dosyasını yükleyiniz.
        //deneme dosyasının yolunu almamız gerekiyor

        //"C:\Users\SEDA\Desktop\deneme.txt"
        String farkliKisim=System.getProperty("user.home");
        String ortakKisim="\\Desktop\\deneme.txt";

        String dosyaYolu=farkliKisim+ortakKisim;

        WebElement dosyaSec=driver.findElement(By.xpath("//input[@name='upfile']"));
        bekle(2);

        dosyaSec.sendKeys(dosyaYolu);//dosya sec kısmına dosyamızı gönderdik
        //bu kodla herzaman yükleme yapabiliyoruz fakat bazen göndermeye bilir o zamana robot class kullanıcaz




        // 'Press' butonuna basın
        driver.findElement(By.xpath("//input[@value='Press']")).click();
        bekle(2);

        // Dosya notunun 'Benim Dosyam' oldugunu test ediniz
        //benim dosyamı biz yazdıgımız için text olarak lacate alamamamız gerekir.
        WebElement dosyaNotu=driver.findElement(By.tagName("blockquote"));
        Assert.assertEquals("Benim Dosyam",dosyaNotu.getText());
        bekle(2);


        // Dosya iceriginin 'Merhaba Dunya' icerdigini test ediniz.
        WebElement dosyaIcerigi=driver.findElement(By.tagName("pre"));
        Assert.assertTrue(dosyaIcerigi.getText().contains("Merhaba Dunya"));
    }
}
