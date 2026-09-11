package service;

import org.junit.jupiter.api.Test;
import reports.*;

import java.io.File;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ReportServiceTest {

    @Test
    public void shouldGenerateJsonReport() {

        ReportService service = new ReportService(new JsonReport());

        service.generateReport("funciona", "Prueba");

        File file = new File("Prueba.json");

        assertTrue(file.exists());

        file.delete();
    }

    @Test
    public void shouldGenerateHtmlReport() {

        ReportService service = new ReportService(new HtmlReport());

        service.generateReport("funciona guay", "Test");

        File file = new File("Test.html");

        assertTrue(file.exists());

        file.delete();
    }

    @Test
    public void shouldGenerateXmlReport() {

        ReportService service = new ReportService(new XmlReport());

        service.generateReport("Valido", "Funciona");

        File file = new File("Funciona.xml");

        assertTrue(file.exists());

        file.delete();
    }

    @Test
    public void shouldGenerateCsvReport() {

        ReportService service = new ReportService(new CsvReport());

        service.generateReport("helicoptero negro", "Vuela");

        File file = new File("Vuela.csv");

        assertTrue(file.exists());

        file.delete();
    }

    @Test
    public void shouldGeneratePdfReport() {

        ReportService service = new ReportService(new PdfReport());

        service.generateReport("comprar adobe", "Nunca_lo_hacen");

        File file = new File("Nunca_lo_hacen.pdf");

        assertTrue(file.exists());

        file.delete();
    }

    @Test
    public void shouldGenerateExcelReport() {

        ReportService service = new ReportService(new ExcelReport());

        service.generateReport("4x3", "Mates");

        File file = new File("Mates.xlsx");

        assertTrue(file.exists());

        file.delete();
    }

    @Test
    public void shouldGenerateWordReport() {

        ReportService service = new ReportService(new WordReport());

        service.generateReport("curriculum", "CV Enzo");

        File file = new File("CV Enzo.docx");

        assertTrue(file.exists());

        file.delete();
    }
}
