package day_08;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C02_WebTables extends TestBase {
    // girisYap methodu olusturun
    // https://www.hotelmycamp.com adresine gidin
    // Log in butonuna tıklayın
    // Username: manager
    // Password: Manager1!

    // input olarak verilen satır sayısı ve sutun sayısına sahip cell'deki text'i dinamik olarak yazdırın.


    @Test
    public void test01() {

        // girisYap methodu olusturun
        // https://www.hotelmycamp.com adresine gidin
        // Log in butonuna tıklayın
        // Username: manager
        // Password: Manager1!
        girisYap();

        // input olarak verilen satır sayısı ve sutun sayısına sahip cell'deki text'i dinamik olarak yazdırın.

        int satir = 5;
        int sutun = 2;

        WebElement arananCell = driver.findElement(By.xpath("//tbody//tr["+satir+"]//td["+sutun+"]"));
        System.out.println(arananCell.getText());

    }

    private void girisYap() {
        // https://www.hotelmycamp.com adresine gidin
        driver.get("https://www.hotelmycamp.com");

        driver.findElement(By.xpath("//button[@id='details-button']")).click(); // Gelişmiş
        driver.findElement(By.xpath("//a[@id='proceed-link']")).click(); // Güvenli Degil

        // Log in butonuna tıklayın
        driver.findElement(By.xpath("//a[text()='Log in']")).click();



        // Username: manager
        // Password: Manager1!
        WebElement userName = driver.findElement(By.xpath("//input[@id='UserName']"));

        Actions actions = new Actions(driver);

        actions.click(userName).sendKeys("manager").sendKeys(Keys.TAB).sendKeys("Manager1!").sendKeys(Keys.ENTER).perform();

    }

}
