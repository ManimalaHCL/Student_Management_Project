package Utilities;

import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.xssf.usermodel.*;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class WriteDataToExcel {
    public static void main(String args[]) throws Exception
    {
        FileInputStream fis = new FileInputStream("C:\\Users\\Ashish\\IdeaProjects\\DataDriver\\src\\test\\testdata\\Book1.xlsx");
        FileOutputStream fos = null;
        XSSFWorkbook workbook = new XSSFWorkbook(fis);
        XSSFSheet sheet = workbook.getSheet("Credentials");
        XSSFRow row = null;
        XSSFCell cell = null;
        XSSFFont font = workbook.createFont();
        XSSFCellStyle style = workbook.createCellStyle();

        row = sheet.getRow(1);
        if(row == null)
            row = sheet.createRow(1);

        cell = row.getCell(4);
        if(cell == null)
            cell = row.createCell(4);

        //font.setFontName("Comic Sans MS");
        //font.setFontHeight(14.0);
        font.setBold(true);
        //font.setColor(HSSFColor.WHITE.index);

        style.setFont(font);
        //style.setFillForegroundColor(HSSFColor.GREEN.index);
        style.setFillPattern(FillPatternType.SOLID_FOREGROUND);

        cell.setCellStyle(style);
        cell.setCellValue("PASS");

        fos = new FileOutputStream("C:\\Users\\Ashish\\IdeaProjects\\DataDriver\\src\\test\\testdata\\Book1.xlsx");
        workbook.write(fos);
        fos.close();
    }
}
