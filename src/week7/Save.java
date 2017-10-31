package week7;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Save {

    private final String text;
    private final String fileName;

    public Save(String text, String fileName){
        this.text = text;
        this.fileName = fileName;
        saveFile();
    }
    
    public void saveFile() {
        if (fileName != null && !fileName.isEmpty()) {
            Path path = Paths.get(fileName);
            try {
                Files.write(path, text.getBytes());
            } catch (IOException e1) {
                System.err.println("Exception : " + e1.getClass().getSimpleName());
                System.err.println("message : " + e1.getMessage());
            }
        }else {
            new SaveAsWindow(text);
        }
    }
}
