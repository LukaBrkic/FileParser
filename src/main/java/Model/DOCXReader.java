package Model;

import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import org.apache.poi.ooxml.POIXMLProperties;
public class DOCXReader implements FileReader{
    @Override
    public void readFile(String filePath) throws IOException {
        try {
            File file = new File(filePath);
            FileInputStream fileInputStream = new FileInputStream(file.getAbsolutePath());

            populateObject(fileInputStream);

            fileInputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void populateObject(FileInputStream fileInputStream)  {
        XWPFDocument document = null;
        try {
            document = new XWPFDocument(fileInputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }

        POIXMLProperties props = document.getProperties();
        POIXMLProperties.CoreProperties coreProps = props.getCoreProperties();
        List<XWPFParagraph> paragraphs = document.getParagraphs();
        paragraphs.toString();
        for (XWPFParagraph para : paragraphs) {
            System.out.println(para.getText());
        }
    }


}
