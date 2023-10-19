package day_06;

import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utilities.TestBase;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class C01_ScreenShot extends TestBase {
        // https://www.amazon.com/ adresine gidin
        // arama kutusuna Nutella yazip aratın
        // ilk ürüne tıklayın
        // tüm sayfanın fotografını cekin


    @Test
    public void test01() throws IOException {
        // https://www.amazon.com/ adresine gidin
        driver.get("https://www.amazon.com/");

        // arama kutusuna Nutella yazip aratın
        driver.findElement(By.xpath("//*[@id='twotabsearchtextbox']")).sendKeys("Nutella", Keys.ENTER);

        // ilk ürüne tıklayın
        driver.findElement(By.xpath("(//img[@class='s-image'])[1]")).click();

        // tüm sayfanın fotografını cekin

        //tarih ve saat oluşturuyoruz çünkü üstene yazmasın fotografların hepsi kalsın diye

        LocalDateTime date= LocalDateTime.now();
        DateTimeFormatter dtf= DateTimeFormatter.ofPattern("YYMMddHHmmss");
        String tarih= date.format(dtf);




        TakesScreenshot ts= (TakesScreenshot) driver;//ilk önce obje oluşturmamız lazım

        //2. aşama:nereye kaydecegimizi yazmak
        //File kaydet= new File("target/ekranGoruntusu/tumSayfa.jpeg");

        //3. aşama:fotografı çekecegiz bunu obje sayesinde yapıyoruz
       //File geciciDosya= ts.getScreenshotAs(OutputType.FILE);//FOTOGRAFI BU SAYECE ÇEKTİK

        //3.aşama : çektiğim fotoyu geçici bir dosyaya assign ediyorum

        //4.aşama: geçici dosyadaki olana fotografı kaydete kopyalayacagız

        //FileUtils.copyFile(geciciDosya,kaydet); tek satırda yapabilmek için yoruma aldık hepsini


        //şimdi tek satırda yapıcaz

        FileUtils.copyFile(ts.getScreenshotAs(OutputType.FILE),new File("target/ekranGoruntusu/tumSayfa" + tarih + ".jpeg"));
        


    }


    @Test
    public void test02ReusableMethotCozumu() {
        // https://www.amazon.com/ adresine gidin
        driver.get("https://www.amazon.com/");



        // arama kutusuna Nutella yazip aratın
        driver.findElement(By.xpath("//*[@id='twotabsearchtextbox']")).sendKeys("Nutella" + Keys.ENTER);



        // ilk ürüne tıklayın

        driver.findElement(By.xpath("(//img[@class='s-image'])[1]")).click();




        // tüm sayfanın fotografını cekin

        tumSayfaEkranGoruntusu();
    }
}
