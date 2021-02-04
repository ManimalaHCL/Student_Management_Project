package TestSuites;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import Utilities.ExcelApiTest;
import Utilities.ExcelBaseSetup;
import Utilities.*;



public class TestBase {

    String xlFilePath = "C:\\Users\\Manimala\\Desktop\\Project_Files\\Student_Datas.xlsx";
    String sheetName = "Student";
    ExcelApiTest eat = null;
    ExcelBaseSetup base;
    WebDriver driver;

    @BeforeMethod
    public void setup()
    {
        System.setProperty("webdriver.chrome.driver", "C:/Users/Manimala/Desktop/ChromeDriver/chromedriver_win32/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("http://localhost:4200/");
    }

    @DataProvider(name="StudentData")
    public Object[][] userFormData() throws Exception
    {
        Object[][] data = testData(xlFilePath, sheetName);
        return data;
    }

    public Object[][] testData(String xlFilePath, String sheetName) throws Exception
    {
        Object[][] excelData = null;
        eat = new ExcelApiTest(xlFilePath);
        //base = new ExcelBaseSetup();
        int rows = eat.getRowCount(sheetName);
        int columns = eat.getColumnCount(sheetName);

        excelData = new Object[rows-1][columns];

        for(int i=1; i<rows; i++)
        {
            for(int j=0; j<columns; j++)
            {
                excelData[i-1][j] = eat.getCellData(sheetName, j, i);
            }

        }
        return excelData;
    }

    @AfterMethod
    public void tearDown(){
        driver.close();
    }

}
