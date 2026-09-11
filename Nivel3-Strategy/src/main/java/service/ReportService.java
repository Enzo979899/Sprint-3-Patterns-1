package service;

public class ReportService {
    private final Report doc;

    public ReportService(Report doc) {
        this.doc = doc;
    }

    public void generateReport(String content, String fileName) {
      doc.generateReport(content, fileName);
    }
}
