package day_04;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.SQLOutput;

public class C04_FilesDownload extends TestBase {
    // 'https://the-internet.herokuapp.com/download' adresine gidiniz
    // some-file.txt dosyasini indirelim
    // dosyanin bilgisayarınızda Downloads(indirilenler)'a basariyla indirilip indirilmedigini test ediniz


    @Test
    public void test01() {
        // 'https://the-internet.herokuapp.com/download' adresine gidiniz
        driver.get("https://the-internet.herokuapp.com/download");

        //eger bizde daha önceden indirdiğimiz dosya adı varsa onu sil:

        String farkliKisimm=System.getProperty("user.home");
        String ortakKisimm= "\\Downloads\\some-file.txt";

        String dosyaYoluu= farkliKisimm+ortakKisimm;

        try {
            Files.delete(Paths.get(dosyaYoluu));
        } catch (IOException e) {
            System.out.println("Dosya Bulunamadı");
        }


        // some-file.txt dosyasini indirelim
        driver.findElement(By.xpath("//a[text()='some-file.txt']")).click();
        bekle(2);

        // dosyanin bilgisayarınızda Downloads(indirilenler)'a basariyla indirilip indirilmedigini test ediniz


        //C:\Users\SEDA\Downloads\some-file.txt

        String farkliKisim=System.getProperty("user.home");
        String ortakKisim= "\\Downloads\\some-file.txt";

        String dosyaYolu= farkliKisim+ortakKisim;
        Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));






    }
}
