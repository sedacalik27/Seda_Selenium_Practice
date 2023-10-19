package day_01;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C04 {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver= new ChromeDriver();
        driver.manage().window().maximize();

        // maximize iken pencere konumunu ve pencere olcusunu yazdiriniz
        System.out.println(driver.manage().window().getPosition());

        System.out.println(driver.manage().window().getSize());




        // fullscreen iken pencere konumunu ve pencere olcusunu yazdiriniz
        driver.manage().window().fullscreen();

        System.out.println(driver.manage().window().getPosition());
        //getPosition==>bu bana pencerenin konumunu verir
        //getSize()==> pencerenin ölçüsünü verir.


        System.out.println(driver.manage().window().getSize());
        Thread.sleep(2000);

        // sayfayi kapatiniz
        driver.close();





    }
}
