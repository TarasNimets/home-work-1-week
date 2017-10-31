package week7;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class SaveAsWindow {

    private JFileChooser fileChooser = new JFileChooser();
    private String inputText;

    public SaveAsWindow(String inputText) {
        this.inputText = inputText;
        fileChooser.setCurrentDirectory(Window.CURRENT_DIRECTORY);
        fileChooser.setApproveButtonText("Save As..");
        initListeners();
    }

    private void initListeners() {

        if (fileChooser.showSaveDialog(null) != JFileChooser.CANCEL_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();

            if (selectedFile.exists()) {
                int answer = JOptionPane.showConfirmDialog(null, "Replace file: " + selectedFile, "Warning",
                        JOptionPane.YES_NO_CANCEL_OPTION);
                if (answer != JOptionPane.YES_OPTION) {
                    System.out.println("User cancel this operation");
                    return;
                }
                    
            }
            Path path = Paths.get(selectedFile.getAbsolutePath());
            try {
                Files.write(path, inputText.getBytes());
                System.out.println("File " + selectedFile.getName() + " was saved");
            } catch (IOException ex) {
                System.out.println("File not saved");
                ex.getMessage();
            }
        }

    }

}
