package day_03;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

import java.util.List;

public class C02_DropDownOptions extends TestBase {
    @Test
    public void test01() {

        // https://www.amazon.com/ sayfasina gidin
        driver.get("https://www.amazon.com/");
        driver.navigate().refresh();
        // dropdown'dan "Baby" secenegini secin
        WebElement ddm=driver.findElement(By.xpath("//select[@id='searchDropdownBox']"));
        Select select =new Select(ddm);
        select.selectByVisibleText("Baby");
        // sectiginiz option'i yazdirin
        String sectigimOpsiyon=select.getFirstSelectedOption().getText();//seçtiğimiz optionu getirir.webelement olarak geldi
                                                    // Stringe çevirmek için getText kullandık
        System.out.println("sectigimOpsiyon = " + sectigimOpsiyon);


        // dropdown'daki optionlarin toplam sayısının 28'e esit oldugunu test edin

        //getOptions();//bu method bize butun opsiyonları webelementlerden oluşan list halinde getirir
        List<WebElement> optionlarList = select.getOptions();

        int expectedOptionSayisi=28;

        int actualOptionSayisi= optionlarList.size();

        Assert.assertEquals(expectedOptionSayisi,actualOptionSayisi);

        // dropdown'daki optionların tamamını yazdırın

        //lambda ile= optionlar.forEach(t-> System.out.println(t.getText()));

        int sayac=1;

        for (WebElement each:optionlarList) {
            System.out.println(sayac + ".option:" +each.getText());
            sayac++;
        }










    }
}
