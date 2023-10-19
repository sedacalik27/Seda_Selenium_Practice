package day_09;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class C02_WriteExcel {
    // Ulkeler dosyasındaki 0. satır indexin, 4. hücre index'ine yeni bir cell olusturalım.
    // olusturdugumuz hucreye "Batch171" yazdıralım.


    @Test
    public void test01() throws IOException {
        FileInputStream fis= new FileInputStream("src/resources/ulkeler.xlsx");
        Workbook workbook= WorkbookFactory.create(fis);

        workbook.getSheet("Sayfa1").getRow(0).createCell(4).setCellValue("Batch171");
        workbook.getSheet("Sayfa1").getRow(1).createCell(4).setCellValue(30);
        workbook.getSheet("Sayfa1").getRow(2).createCell(4).setCellValue("50");



        //classtaki verileri excele aktarmak için fileOutStream objesi oluşturucaz
        FileOutputStream fos= new FileOutputStream("src/resources/ulkeler.xlsx");

        workbook.write(fos);
        fis.close();
        fos.close();
        workbook.close();



















    }
}
