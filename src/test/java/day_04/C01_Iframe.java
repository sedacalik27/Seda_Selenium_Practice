package day_04;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C01_Iframe extends TestBase {
    /*
        iframe:web sayfasının içinde web sayfasının olmasıdır.mesela bir web sayfasını açınca youtube video var olması
        içteki web sayfasına geçebilmek için driverimızı içteki web sayfasına geçirmemiz gerekli
        içteki web sayfasınıda işimiz bitince driverı dıştaki web sayfasına geçiririz
         bunları hep switchto ile yapıyoruz
        */
    @Test
    public void test01() {
        // https://html.com/tags/iframe sayfasına gidiniz
        driver.get("https://html.com/tags/iframe");

        // Videoyu görecek kadar asagiya ininiz
        //sayfayı açtık fakat video görünmüyor aşagıya inmek için action objesiyle aşagıya indiricez
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN).sendKeys(Keys.PAGE_DOWN).perform();
         //manuel olarak 2 defa pagedown tuşuna bastıgımız için bunu yaptık
        //en son performu unutma actions işlemin bitti der demez performu yaz



        // Videoyu izlemek icin Play tusuna basiniz
        //iframe çıktı karşşımıza iframe min locateini alıyoruz
        WebElement iframe = driver.findElement(By.xpath("//iframe[@src='https://www.youtube.com/embed/owsfdh4gxyc']"));
        driver.switchTo().frame(iframe);

        WebElement play = driver.findElement(By.xpath("//button[@class='ytp-large-play-button ytp-button ytp-large-play-button-red-bg']"));
        play.click();
        /*
        play'i dogru locate edip click yapmamıza ragmen videoyu calıstırmadı
        bunun üzerine HTML kodlarını inceleyince play'in aslında bir iframe icerisinde oldugunu gorduk
        bu durumda once iframe'i locate edip
        switchTo() ile o iframe'e gecmeliyiz
         */


        // Videoyu calistirdiginizi test ediniz
        //vidoyu çalıştırınca sagda youtube yazısı çıkıyor o yazının locateni alıp
        //youtube yazının  görünür oldugunu test ettik asserttrue ile
        bekle(3);

        WebElement youTubeYazisi = driver.findElement(By.xpath("//a[@class='ytp-youtube-button ytp-button yt-uix-sessionlink']"));
        Assert.assertTrue(youTubeYazisi.isDisplayed());


        // 'Powerful,but easy to misuse' yazısının gorunur oldugunu test ediniz

        //bunu yanıtlamak için en başta driveri dışarı taşımam lazım
        driver.switchTo().defaultContent();

        WebElement powerYazisi = driver.findElement(By.xpath("//span[@id='Powerful_but_easy_to_misuse']"));

        Assert.assertTrue(powerYazisi.isDisplayed());





    }
}
