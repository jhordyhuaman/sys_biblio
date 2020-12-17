/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils;

import com.itextpdf.text.Anchor;
import com.itextpdf.text.BadElementException;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chapter;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Section;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Desktop;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

/**
 *
 * @author codsi
 */
public class PDFGen {

    public PDFGen() {
    }
    
         private static String FILE = "c:/temp/ReporteFile.pdf";
    private static Font catFont = new Font(Font.FontFamily.TIMES_ROMAN, 18,
            Font.BOLD);
    private static Font redFont = new Font(Font.FontFamily.TIMES_ROMAN, 12,
            Font.NORMAL, BaseColor.RED);
    private static Font subFont = new Font(Font.FontFamily.TIMES_ROMAN, 16,
            Font.BOLD);
    private static Font smallBold = new Font(Font.FontFamily.TIMES_ROMAN, 12,
            Font.BOLD);
    
     private static void addMetaData(Document document) {
        document.addTitle("My first PDF");
        document.addSubject("Using iText");
        document.addKeywords("Java, PDF, iText");
        document.addAuthor("Lars Vogel");
        document.addCreator("Lars Vogel");
    }
     private static void addTitlePage(Document document,String titulo,String table)
            throws DocumentException {
       
        
        Anchor anchor = new Anchor(titulo, catFont);
        anchor.setName(titulo);
        
        document.add(new Paragraph(anchor));
        document.add(new Paragraph(table));
        // Start a new page
        document.newPage();
    }

    public  void generateReporte(String titulo,String content){
         try {
            Document document = new Document();
            PdfWriter.getInstance(document, new FileOutputStream(FILE));
            document.open();
            addMetaData(document);
            addTitlePage(document,titulo,content);
            document.close();
            
           if (Desktop.isDesktopSupported()) {
            try {
                    File myFile = new File(FILE);
                    Desktop.getDesktop().open(myFile);
                } catch (IOException ex) {
                    // no application registered for PDFs
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
     }
    
    private void createTable(Document document,List<String> headersList, List<List<String>> rowsList)throws DocumentException {
         Paragraph paragraph = new Paragraph();
        Anchor anchor = new Anchor("First Chapter", catFont);
        anchor.setName("First Chapter");
        Chapter catPart = new Chapter(new Paragraph(anchor), 1);
        Paragraph subPara = new Paragraph("Subcategory 1", subFont);
        Section subCatPart = catPart.addSection(subPara);
        subCatPart.add(new Paragraph("Hello"));
        
        PdfPTable table = new PdfPTable(3);

        // t.setBorderColor(BaseColor.GRAY);
        // t.setPadding(4);
        // t.setSpacing(4);
        // t.setBorderWidth(1);
        PdfPCell c1;
        for (String header : headersList) {
             c1 = new PdfPCell(new Phrase(header));
                c1.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(c1);
        }
  
        table.setHeaderRows(1);
        
        for (List<String> list : rowsList) {
            
            table.addCell(list.get(0));
            table.addCell(list.get(1));
            table.addCell(list.get(2));

        }
       
        subCatPart.add(table);
        document.add(subCatPart);
        // Start a new page
        document.newPage();
    }


    public void generateReporte(String reporte_Autores, List<String> headersList, List<List<String>> rowsList) {
        
        try {
            Document document = new Document();
            PdfWriter.getInstance(document, new FileOutputStream(FILE));
            document.open();
            createTable(document,headersList,rowsList);
            document.close();
            
           if (Desktop.isDesktopSupported()) {
            try {
                    File myFile = new File(FILE);
                    Desktop.getDesktop().open(myFile);
                } catch (IOException ex) {
                    // no application registered for PDFs
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

   
}
