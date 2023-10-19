package day_04;

import org.junit.Assert;
import org.junit.Test;
import utilities.TestBase;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C_03_Files {//hiçbir web sayfasına gitmeyecegim için extend yapmama gerek yok

    // Desktop(masaustu)'da bir text dosyası olusturun
    // Desktop(masaustu)'da text dosyasının olup olmadıgını test edin


    @Test
    public void test01() {
        // Desktop(masaustu)'da bir text dosyası olusturun

        // Desktop(masaustu)'da text dosyasının olup olmadıgını test edin



        //kopyaladıgımız dosya yolu:"C:\Users\SEDA                   \Desktop\text.txt"
        //                           herkeste farklı olan kısım      herkeste ortak olan kısım

       // String farkliKisim= "C:\\Users\\SEDA";//bunu daha dinamik hale getirmek için aşagıdaki kodu yazıyoruz
        String farkliKisim= System.getProperty("user.home");

        String ortakKisim= "//Desktop//text.txt";
        //kopyala yapıştır yaptıgında boşluklara dikkat et

        String dosyaYolu= farkliKisim+ ortakKisim;

        Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));//bu dosya yolundaki dosya mevcutmu?






    }
}
