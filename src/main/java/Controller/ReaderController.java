package Controller;

import Model.DOCXReader;
import Model.FileReader;
import Model.XLSXReader;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class ReaderController {
    private  static final String[] fileExtensions = {".docx", ".xlsx"};
    private final String filePath = "C:\\Users\\Default\\Documents\\TestFolder";
    public void walkFiles()
    {
        try(Stream<Path> paths = Files.walk(Paths.get(filePath))){
            paths.filter(Files::isRegularFile).filter(Files::isReadable).forEach(ReaderController::examineFiles);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void examineFiles(@NotNull Path curFilePath) {
        String filePath = curFilePath.toString();
        if(!filePath.contains("~$"))
        {
            for (String fileExtension : fileExtensions)
            {
                if(filePath.endsWith(fileExtension))
                {
                    FileReader fileReader =  makeReader(fileExtension);
                    if (fileReader != null)
                    {
                        try {
                            fileReader.readFile(filePath);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    break;
                }
            }
        }
    }

    private static FileReader makeReader(String fileExtension) {
        FileReader fileReader = null;
        switch(fileExtension)
        {
            case(".docx"):
                fileReader = new DOCXReader();
                break;
            case(".xlsx"):
                fileReader = new XLSXReader();
                break;
        }
        return fileReader;
    }
}
