package day_01;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;



public class C02 {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        // "https://teknosa.com/" adresine gidiniz
        driver.get("https://teknosa.com/");


        // Sayfanin Title'ini ve URL'ini aliniz ve yazdiriniz
        String teknosaTitle = driver.getTitle();
        System.out.println("teknosaTitle : " + teknosaTitle);

        String teknosaUrl = driver.getCurrentUrl();
        System.out.println("teknosaUrl : " + teknosaUrl);






        // Title'in "Teknoloji" kelimesini icerip icermedigini kontrol ediniz

        if(teknosaTitle.contains("Teknoloji")){
            System.out.println("Title Teknoloji iceriyor");
        }else{
            System.out.println("Title teknoloji icermiyor");
        }






        // URL'in "teknosa" kelimesini icerip icermedigini kontrol ediniz

        if(teknosaUrl.contains("teknosa")){
            System.out.println("URL teknosa iceriyor");
        }else{
            System.out.println("URL teknosa icermiyor");
        }




        // "https://medunna.com/" adresine gidiniz
        driver.get("https://medunna.com/");






        // Sayfanin Title'ini ve URL'ini aliniz ve yazdiriniz
        String medunnaTitle = driver.getTitle();
        System.out.println("medunnaTitle : " + medunnaTitle);

        String medunnaUrl = driver.getCurrentUrl();
        System.out.println("medunnaURL : " + medunnaUrl);



        // Title'in "MEDUNNA" kelimesini icerip icermedigini kontrol ediniz.

        if(medunnaTitle.contains("MEDUNNA")){
            System.out.println("Title MEDUNNA iceriyor");
        }else{
            System.out.println("Title MEDUNNA icermiyor");
        }



        // URL'in "medunna" kelimesini icerip icermedigini kontrol ediniz

        if(medunnaUrl.contains("medunna")){
            System.out.println("URL medunna iceriyor");
        }else{
            System.out.println("URL medunna icermiyor");
        }



        // teknosa adresine geri donunuz

        driver.navigate().back();








        // Sayfayı yenileyiniz
        driver.navigate().refresh();



        // medunna adresine ilerleyiniz
        driver.navigate().forward();



        // Sayfayı yenileyiniz
        driver.navigate().refresh();



        // pencereyi kapat
        driver.close();



    }
}
