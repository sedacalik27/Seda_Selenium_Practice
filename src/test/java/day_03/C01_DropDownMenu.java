package day_03;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

public class C01_DropDownMenu extends TestBase {
    //dropdown demek tıkladıgımızda aşagısında birçok seçenek olması demek
    //dropdown deyince aklımıza select gelecek
    //selectByVisibleText demek göründüğü seçilde demek


    @Test
    public void test01() {
        // https://www.amazon.com/ sayfasina gidin
        driver.get("https://www.amazon.com/");
        bekle(3);
        // dropdown'dan "Books" secenegini secin
        //DropDown 3 adimda handle edilir.
        //1. adım:DropDown LOCATE edilmelidir
        WebElement ddm= driver.findElement(By.xpath("//select[@id='searchDropdownBox']"));
        bekle(2);
        //2.adım select objesi oluşturulur
        Select select =new Select(ddm);
        bekle(2);

        //3.adım:opsiyonlardan birtanesi seçilmelidir

        //select.selectByVisibleText("Books");//nasıl görünüyorsa o şekilde yazıyoruz.
        //ddmVisibleText(ddm,"Books");//methodla yaptık


        //select.selectByIndex(5);
        //ddmindex(ddm,5);//methodla aldık

        //select.selectByValue("search-alias=stripbooks-intl-ship");
        ddmValue(ddm,"search-alias=stripbooks-intl-ship");//methodla aldık
        bekle(2);


        // arama cubuguna "Java" aratın
        driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("Java"+ Keys.ENTER);
        // arama sonuclarinin Java icerdigini test edin
        // arama sonuclarinin Java icerdigini test edin
        WebElement aramaSonucElementi =  driver.findElement(By.xpath("(//div[@class='a-section a-spacing-small a-spacing-top-small'])[1]"));
        Assert.assertTrue(aramaSonucElementi.getText().contains("Java"));

        //aramaSonucElementi.getText() yapmamızın sebebi java string bir ifade oldugundan
        //aramaSonucElementi.contains diyemiyoruz .gettext() yapmamız lazımki webelementi Stringe çeviriyoruz
        //bunuda .getText yapıyoruz böylece webelement stringe çevrilmiş oldu

    }
}
