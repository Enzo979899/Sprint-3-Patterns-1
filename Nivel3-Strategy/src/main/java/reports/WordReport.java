package reports;

import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import service.Report;

import java.io.FileOutputStream;
import java.io.IOException;

public class WordReport implements Report {

    @Override
    public void generateReport(String content, String fileName) {

        try (XWPFDocument document = new XWPFDocument();
             FileOutputStream file = new FileOutputStream(fileName + ".docx")) {

            XWPFParagraph paragraph = document.createParagraph();
            paragraph.createRun().setText(content);

            document.write(file);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}