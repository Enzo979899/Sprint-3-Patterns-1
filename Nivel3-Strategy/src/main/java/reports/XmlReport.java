package reports;

import service.Report;

import java.io.FileWriter;
import java.io.IOException;

public class XmlReport implements Report {

    @Override
    public void generateReport(String content, String fileName) {

        try (FileWriter writer = new FileWriter(fileName + ".xml")) {
            writer.write(content);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
