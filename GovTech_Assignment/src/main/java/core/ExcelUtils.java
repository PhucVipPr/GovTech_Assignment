package core;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.List;

public class ExcelUtils {

    public static Object[][] getTableArray(String filePath, String sheetName, int startCol, int totalCol){
        String[][] tableArray = null;
        try {
            FileInputStream inputStream = new FileInputStream(filePath);
            XSSFWorkbook xssfWorkbook = new XSSFWorkbook(inputStream);
            XSSFSheet xssfSheet = xssfWorkbook.getSheet(sheetName);
            int startRow = 1;
            int ci,cj;
            int totalRows = xssfSheet.getLastRowNum();
            ci = 0;
            tableArray = new String[totalRows][totalCol];
            for (int i = startRow; i<= totalRows;i++,ci++){
                cj=0;
                for (int j = startCol; i < totalCol;j++,cj++){
                    XSSFCell cell = xssfSheet.getRow(i).getCell(j);
                    String cellValue = "";
                    if (cell != null) {
                        if (cell.getCellType() == CellType.NUMERIC) {
                            double numericValue = cell.getNumericCellValue();
                            DecimalFormat decimalFormat = new DecimalFormat("#");
                            cellValue = decimalFormat.format(numericValue);
                        } else {
                            cellValue = cell.getStringCellValue();
                        }
                    }
                    tableArray[ci][cj] = cellValue;
                }
            }
            inputStream.close();
        } catch (Exception e) {
            System.out.println(e);;
        }
        return tableArray;
    }

    public static void updateTestResult(String filePath, List<TestResult> testResultList) throws IOException {

        FileInputStream fileInputStream = new FileInputStream(new File(filePath));

        XSSFWorkbook workbook = new XSSFWorkbook(fileInputStream);

        for (TestResult testResult: testResultList) {
            System.out.println(testResult.getTCID());
            System.out.println(testResult.getResult());
            XSSFSheet sheet = workbook.getSheet(testResult.getTCID());

            XSSFRow row = sheet.getRow(1);
            short maxColIx = row.getLastCellNum();
            row.getCell(maxColIx-1).setCellValue(testResult.getResult());

        }
        FileOutputStream fileOutputStream = new FileOutputStream(new File(filePath));
        workbook.write(fileOutputStream);
        fileOutputStream.close();
    }
}