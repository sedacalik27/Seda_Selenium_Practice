package day_09;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class C01_ReadExcel {

    // Ulkeler dosyasındaki tum dataları map'a alınız ve yazdırınız


    @Test
    public void test01() throws IOException {

        // Ulkeler dosyasındaki tum dataları map'a alınız ve yazdırınız

        Map<String,String> ulkelerMap= new LinkedHashMap<>();


        //excelden verileri almak için 1. adım: file input objesii oluşturmak
                                    // 2. adım workbook objesi oluşturmak
        //excelden işlem yapmak için bu iki adımı yapmalıyız


        FileInputStream fis= new FileInputStream("src/resources/ulkeler.xlsx");
        //ülkeler axcel dosyasının yolunu giriyoruzparantez içine

        Workbook workbook= WorkbookFactory.create(fis);


        //şimdi ülkeler excel dosyasının son satır indexine kadar nereye kadar gideceğini belirtmek için
        int sonSatirIndex=workbook.getSheet("Sayfa1").getLastRowNum();//son satır indexini alıyoruz burda
        //getLastRowNum()--> son satir numarasını index olarak verir.


        //şimdi bütün verileri satır satır alacak bunun için fori oluşturuyoruz
        //satır satır key value olarak alıcam key=ülke sutunu olarak value olarak diğer 3 sutunu alıcaz


        for (int i = 0; i <=sonSatirIndex ; i++) {
            String key=workbook.getSheet("Sayfa1").getRow(i).getCell(0).toString();// keyi elde ettik

            String value=workbook.getSheet("Sayfa1").getRow(i).getCell(1).toString() + ","
                   + workbook.getSheet("Sayfa1").getRow(i).getCell(2).toString() + "," +
                     workbook.getSheet("Sayfa1").getRow(i).getCell(3).toString();


            ulkelerMap.put(key,value +"\n");//bununla biz key ve value yu mapa put ettik


        }
        System.out.println(ulkelerMap);







    }
}
