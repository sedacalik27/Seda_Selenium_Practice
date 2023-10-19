package day_01;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C03 {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver= new ChromeDriver();

        driver.manage().window().maximize();

        // https://www.amazon.com/ adresine gidin
        driver.get("https://www.amazon.com/");
        driver.navigate().refresh();
        Thread.sleep(1000);


        // Kaynak Kodlarini konsola yazdiriniz
        String sayfaKaynakKodlari=driver.getPageSource();
        System.out.println(sayfaKaynakKodlari);



        // Kaynak Kodlarinda "window" yazdigini test edin
        if(sayfaKaynakKodlari.contains("window")){
            System.out.println("Kaynak kodlarında window yaziyor.");
        }else System.out.println("Kaynak kodlarında window yaziyor.");

        // sayfayi kapatiniz
        driver.close();





















    }
}
