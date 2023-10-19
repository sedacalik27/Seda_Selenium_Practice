package day_08;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class C04_ReadExcel {
    @Test
    public void test01() throws IOException {

        // Ulkeler dosyasındaki "Başkent (İngilizce)" sutununu yazdırınız

        FileInputStream fis = new FileInputStream("src/resources/ulkeler.xlsx");

        Workbook workbook = WorkbookFactory.create(fis);

        int sonSatirIdx = workbook.getSheet("Sayfa1").getLastRowNum();
        System.out.println(sonSatirIdx);
        // getLastRowNum() son satir index'ini verir


        for (int i = 0; i <=sonSatirIdx ; i++) {

            String  satirdakiData = workbook.getSheet("Sayfa1").getRow(i).getCell(1).toString();
            System.out.println(satirdakiData);
        }


    }


}
