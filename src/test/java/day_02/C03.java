package day_02;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.List;

public class C03 extends TestBase {

    // https://ebay.com sayfasına gidiniz
    // electronics bolumune tıklayınız
    // genisligi 225 ve uzunlugu 225 olan resimlerin hepsine sırasıyla tıklayınız ve sayfa baslıgını yazdırınız


    @Test
    public void test01() {

        // https://ebay.com sayfasına gidiniz
        driver.get("https://ebay.com");

        bekle(2);

        // electronics bolumune tıklayınız
        driver.findElement(By.xpath(" (//a[text()='Electronics'])[2]")).click();


        // genisligi 225 ve uzunlugu 225 olan resimlerin hepsine sırasıyla tıklayınız ve sayfa baslıgını yazdırınız

        //önümüze gelen herhangi bir resmi tıklayıp locate almaya çalışıcam
        //birden fazla eleman elde etmek istediğimizden listte assign ediyoruz
        List<WebElement> resimler=driver.findElements(By.xpath("//img[@width='225' and @height='225']"));
       //sırasıyla resimlere tıklamak için for loop yapmamız gerekiyor

        for (int i = 0; i <resimler.size() ; i++) {
            resimler = driver.findElements(By.xpath("//img[@width='225' and @height='225']"));
            //üstteki satırı navigate bayatladıgı için for loop içine aldık

            resimler.get(i).click();//resimleri tek tek almak için get kullanıyorum ve hepsine tek tek tıklamak için click
            System.out.println(i + ". Title : " + driver.getTitle());//tıkladıgım her resmin başlıgını getirmesi için böyle yazdırıyoruz
            //tıkladıgımız resimden bir geri gelmemiz lazım diğer resme tıklamamız gerekiyor back kullanıyoruz.
            driver.navigate().back();
            //navigate işlemini kullandıgımız için ilk resme tıkladıktan sonra ikinciye geçemedi çünkü bayatladı
            //bunun için web elementi tekrar hatırlatmak için web elementi tekrar hatırlatmamız gerekli

        }









    }
}
