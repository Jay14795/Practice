package Library;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class ExcelDataConfig
{

    XSSFWorkbook wb;
    XSSFSheet sheet1;
    public ExcelDataConfig(String excelpath)
    {
    try {
            File src= new File(excelpath);
            FileInputStream fis= new FileInputStream(src);
            wb= new XSSFWorkbook(fis);
            sheet1 = wb.getSheetAt(0);

        } catch (Exception e) {

        }


    }
}
