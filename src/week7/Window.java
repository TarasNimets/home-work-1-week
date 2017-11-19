package week7;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.io.File;
import java.nio.file.Paths;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Window extends JFrame {

    public static final File CURRENT_DIRECTORY = Paths.get(".gitignore").toAbsolutePath().toFile();
    private static final String WINDOW_NAME = "Notepad";

    private JButton openButton = new JButton("OPEN");
    private JButton saveButton = new JButton("SAVE");
    private JButton saveAsButton = new JButton("SAVE AS");

    private JPanel mainPanel = new JPanel();
    private JPanel buttonPanel = new JPanel();
    private JPanel rightPanel = new JPanel();

    private JMenuItem openItem = new JMenuItem("open");
    private JMenuItem saveItem = new JMenuItem("save");
    private JMenuItem saveAsItem = new JMenuItem("save as..");

    private JTextArea textArea = new JTextArea(30, 30);

    private JTextField openedFileNameInput;

    public Window() {
        init();
        initComponents();
        initListeners();
        pack();
        setVisible(true);
        setResizable(false);
    }

    private void initListeners() {

        saveButton.addActionListener(e -> saveText());
        openButton.addActionListener(e -> openFile());
        saveAsButton.addActionListener(e -> saveAsText());
        saveItem.addActionListener(e -> saveText());
        openItem.addActionListener(e -> openFile());
        saveAsItem.addActionListener(e -> saveAsText());

    }

    private void saveAsText() {
        new SaveAsWindow(textArea.getText());
    }

    private void openFile() {
        OpenWindow openWindow = new OpenWindow(textArea);
        openedFileNameInput = openWindow.getInput();
    }

    private void saveText() {
        new Save(textArea.getText(), openedFileNameInput.getText());
    }

    private void initComponents() {
        buttonPanel.setLayout(new GridLayout(0, 1));
        buttonPanel.add(openButton);
        buttonPanel.add(saveButton);
        buttonPanel.add(saveAsButton);

        rightPanel.setLayout(new BorderLayout());
        rightPanel.add(buttonPanel, BorderLayout.NORTH);

        textArea.setLineWrap(true);

        mainPanel.setLayout(new BorderLayout());
        mainPanel.add(rightPanel, BorderLayout.EAST);
        mainPanel.add(textArea, BorderLayout.WEST);

        JScrollPane scroll = new JScrollPane(mainPanel, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
                JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

        add(scroll);

        JMenuBar menuBar = new JMenuBar();

        JMenu fileMenu = new JMenu("File");
        openItem = new JMenuItem("Open");
        saveItem = new JMenuItem("Save");
        saveAsItem = new JMenuItem("Save As..");
        fileMenu.add(openItem);
        fileMenu.add(saveItem);
        fileMenu.add(saveAsItem);

        menuBar.add(fileMenu);

        JMenu viewMenu = new JMenu("View");
        menuBar.add(viewMenu);

        JMenu editMenu = new JMenu("Edit");
        menuBar.add(editMenu);

        JMenu aboutMenu = new JMenu("About");
        menuBar.add(aboutMenu);

        setJMenuBar(menuBar);
    }

    private void init() {
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocation(400, 150);
        setTitle(WINDOW_NAME);
    }
}