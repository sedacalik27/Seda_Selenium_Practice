package day_01;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C01 {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();//browseri tanımlıyoruz burada
        WebDriver driver =new ChromeDriver();//driver objesini oluşturduk

        driver.manage().window().maximize();//açılan sayfayı max boyuta aldık sayfanın bütün veri elementlerini görebilmek için

        // "https://www.amazon.com/" adresine gidiniz.
        driver.get("https://www.amazon.com/ ");
        //driver.navigate().to("https://www.amazon.com/");
        //driver.get ve driver.navigate().to ikiside aynı görevi görüyor ama genelde driver.get kullanılır.
        Thread.sleep(1000);

        // "https://www.n11.com/" adresine gidiniz.
        driver.get("https://www.n11.com/");
        Thread.sleep(1000);

        // amazon adresine geri donunuz= navigate=gezinmek demek
        driver.navigate().back();
        Thread.sleep(1000);


        // n11 adresine ilerleyiniz
        driver.navigate().forward();
        Thread.sleep(1000);

        // sayfayi yenileyiniz
        driver.navigate().refresh();
        Thread.sleep(1000);

        // pencereyi kapat
        driver.close();

        // Konsola "HER ŞEY YOLUNDA" yazdir
        System.out.println("HER ŞEY YOLUNDA");
















    }
}
