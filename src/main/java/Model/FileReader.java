package Model;

import java.io.FileInputStream;
import java.io.IOException;

public interface FileReader {

    void readFile(String filePath) throws IOException;

    void populateObject(FileInputStream fileInputStream);


}
