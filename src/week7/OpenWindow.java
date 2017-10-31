package week7;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class OpenWindow {

    private JFileChooser fileChooser = new JFileChooser();

    private JTextArea textArea;
    private JTextField fileName = new JTextField();

    OpenWindow(JTextArea textArea) {
        this.textArea = textArea;
        fileChooser.setCurrentDirectory(Window.CURRENT_DIRECTORY);
        initListeners();
    }

    private void initListeners() {

        if (fileChooser.showOpenDialog(null) != JFileChooser.CANCEL_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();

            if (!selectedFile.exists()) {
                return;
            }

            System.out.println("Was opened file : " + selectedFile.getAbsolutePath());
            fileName.setText(selectedFile.getAbsolutePath());
            Path path = Paths.get(selectedFile.getAbsolutePath());

            try {
                List<String> strings = Files.readAllLines(path);
                StringBuilder sb = new StringBuilder();
                for (String line : strings) {
                    sb.append(line).append("\n");
                }
                textArea.setText(sb.toString());

            } catch (IOException e1) {
                System.err.println("Exception : " + e1.getClass().getSimpleName());
                System.err.println("message : " + e1.getMessage());
                JOptionPane.showMessageDialog(null, "File name " + fileName + " wrong.", "Error",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }
            System.out.println("File was read");
        }
    }

    public JTextField getInput() {
        return fileName;
    }
}