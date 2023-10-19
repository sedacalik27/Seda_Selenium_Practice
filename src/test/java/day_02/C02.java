package day_02;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.security.Key;
import java.util.Arrays;

public class C02 extends TestBase {


    // https://www.google.com/ adresine gidin
    // sayfa baslıgının "Google" kelimesini icerdigini test edin
    // arama cubuguna "Nutella" yazıp aratın
    // bulunan sonuc sayısını yazdırın
    // sonuc sayısının 100000000  fazla oldugunu test edin

    @Test
    public void test01() {
        // https://www.google.com/ adresine gidin

        driver.get("https://www.google.com/");


        // sayfa baslıgının "Google" kelimesini icerdigini test edin

        String googleTitle=driver.getTitle();

        Assert.assertTrue(googleTitle.contains("Google" ));


        // arama cubuguna "Nutella" yazıp aratın
        //WebElement aramaCubugu = driver.findElement(By.xpath("//*[@class='gLFyf']"));
        //aramaCubugu.sendKeys("Nutella" + Keys.ENTER);
        driver.findElement(By.xpath("//*[@class='gLFyf']")).sendKeys("Nutella" + Keys.ENTER);

        // bulunan sonuc sayısını yazdırın
        WebElement sonucYazisi = driver.findElement(By.xpath("//div[@id='result-stats']"));

        //webelementi direk sout içinde yazdıramayız getText ile almalıyız
        System.out.println(sonucYazisi.getText());

        String arr[] = sonucYazisi.getText().split(" ");

        System.out.println(Arrays.toString(arr));

        //arrayın 1. indexindeki elemanı alıyorum sonuc sayısını alabilmek için
        String sonuc=arr[1];
        System.out.println(sonuc);


        // sonuc sayısının 100000000  fazla oldugunu test edin

        //noktalardan kurtulmam lazım

        String sonucc = sonuc.replaceAll("\\D","");//DİGİT OLMAYANLARI HİÇLİKLE DEĞİŞTİR

        Assert.assertTrue(Integer.parseInt(sonucc)>100000000);













    }
}
