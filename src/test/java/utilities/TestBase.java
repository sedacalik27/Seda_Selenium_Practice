package utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public abstract class TestBase {
    protected ExtentReports extentReport;//-->raporlamayı başlatır
    protected ExtentHtmlReporter extentHtmlReporter;//-->Html formatında rapor oluşturur
    protected ExtentTest extentTest;//-->Test adımlarına bilgi eklenir

    //bu classa extend etiiğimiz classlaradan ulaşabiliriz.
    //abstract yapınca bu classtan obje oluşturulamaz
    //TestBase classından obje oluşturulmasının önüne geçilmesi için abstract yapılabilir.

     /*
    bu class a extends ettiğmiz classlardan ulaşabiliriz..
    testbase clasından obje oluşturulmasının önüne geçmek için abstract yaparz.
    biz test base clasının içinde before methodları yapıstıracağız gerektiğinde resaeable
    method olarak yapıstıracağız biz bu methodları farklı bir clastan kullanmak istiyoruz
    ve dolayısıyla aralarında inharitance islemi olacak testbase parent olacak diğeri child..
    parenttaki methodu childen direk kullanabiliriz..yani obje oluşturmanıza gerek yok..buna ihtiyac yok.
    bosu bosunada obje oluşturmayacağımız için abstrackt yapıyoruz ama zorunda değiliz..abstrack olmasada olur..
    ama obje oluşturmaya gerek yok..bu yüzden abstrack yaptık..
     */

    protected WebDriver driver;
    @Before
    public void setUp() throws Exception {
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }


    @After
    public void tearDown() throws Exception {//her test methodundan sonra çalışır
       // driver.close();
    }



    public void bekle(int saniye){

        try {
            Thread.sleep(saniye*1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }


    public void ddmVisibleText(WebElement ddm, String secenek){

        Select select = new Select(ddm);
        select.selectByVisibleText(secenek);
    }

    //Visible demek görünür demek



    public void ddmindex(WebElement ddm,int index){
        Select select =new Select(ddm);
        select.selectByIndex(index);
    }

    public void ddmValue(WebElement ddm,String value){
        Select select =new Select(ddm);
        select.selectByValue(value);
    }


    //UploadFile Robot Class
    public void uploadFilePath(String dosyaYolu) {
        try {
            bekle(3);
            StringSelection stringSelection = new StringSelection(dosyaYolu);
            Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);
            Robot robot = new Robot();
            robot.keyPress(KeyEvent.VK_CONTROL);
            bekle(3);
            robot.keyPress(KeyEvent.VK_V);
            bekle(3);
            robot.keyRelease(KeyEvent.VK_CONTROL);
            bekle(3);
            robot.keyRelease(KeyEvent.VK_V);
            bekle(3);
            robot.keyPress(KeyEvent.VK_ENTER);
            bekle(3);
            robot.keyRelease(KeyEvent.VK_ENTER);
            bekle(3);
        } catch (AWTException e) {
            throw new RuntimeException(e);
        }
    }




    public void tumSayfaEkranGoruntusu(){
        LocalDateTime date = LocalDateTime.now();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("YYMMddHHmmss");
        String tarih = date.format(dtf);

        TakesScreenshot ts = (TakesScreenshot) driver;

        File kaydet = new File("target/ekranGoruntusu/tumSayfa.jpeg");

        File geciciDosya = ts.getScreenshotAs(OutputType.FILE);

        try {
            FileUtils.copyFile(geciciDosya,kaydet);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }


    //Extent Report
    public void rapor(String browser,String reportName){
        extentReport = new ExtentReports();
        String tarih = new SimpleDateFormat("_hh_mm_ss_ddMMyyyy").format(new Date());
        String dosyaYolu = "target/extentReport/report"+tarih+".html";
        extentHtmlReporter = new ExtentHtmlReporter(dosyaYolu);
        extentReport.attachReporter(extentHtmlReporter);
        //Raporda gözükmesini istediğimiz bilgiler
        extentReport.setSystemInfo("Tester","Seda");
        extentReport.setSystemInfo(browser,"Chrome");
        extentHtmlReporter.config().setDocumentTitle("ExtentReport");
        extentHtmlReporter.config().setReportName(reportName);
    }











}
