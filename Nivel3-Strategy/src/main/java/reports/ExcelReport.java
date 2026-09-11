package reports;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import service.Report;

import java.io.FileOutputStream;
import java.io.IOException;

public class ExcelReport implements Report {

    @Override
    public void generateReport(String content, String fileName) {

        try (XSSFWorkbook workbook = new XSSFWorkbook();
             FileOutputStream file = new FileOutputStream(fileName + ".xlsx")) {

            var sheet = workbook.createSheet("Report");
            var row = sheet.createRow(0);

            row.createCell(0).setCellValue(content);

            workbook.write(file);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}