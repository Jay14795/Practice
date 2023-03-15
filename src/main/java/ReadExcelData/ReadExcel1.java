package ReadExcelData;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;

public class ReadExcel
{
    public static void main(String[] args) throws Exception {

        File src= new File("C:\\ExcelData\\SheetData.xlsx");
        FileInputStream fis= new FileInputStream(src);

        XSSFWorkbook wb= new XSSFWorkbook(fis);
        XSSFSheet sheet1 = wb.getSheetAt(0);

        String Data0= sheet1.getRow(0).getCell(0).getStringCellValue();
        System.out.println("Data from Excel"+ " " +Data0);

        String Data1= sheet1.getRow(0).getCell(1).getStringCellValue();
        System.out.println("Data from Excel"+ " " +Data1);

        wb.close();
    }
}
