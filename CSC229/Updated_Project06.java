
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Random;

public class Project06 {

    private static Matrix matrix;

    public static void main(String[] args) {
        // Create the main JFrame
        JFrame frame = new JFrame("Matrix Manipulation");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);

        // Menu Bar
        JMenuBar menuBar = new JMenuBar();

        // File Menu
        JMenu fileMenu = new JMenu("File");
        JMenuItem aboutItem = new JMenuItem("About");
        aboutItem.addActionListener(e -> JOptionPane.showMessageDialog(frame,
                "This program allows matrix manipulations such as:
" +
                "- Creating matrices randomly or from a file
" +
                "- Performing statistics (min, max, avg, std deviation)
" +
                "- Matrix operations (add, subtract, multiply, transpose)"));
        JMenuItem exitItem = new JMenuItem("Exit");
        exitItem.addActionListener(e -> System.exit(0));
        fileMenu.add(aboutItem);
        fileMenu.add(exitItem);
        menuBar.add(fileMenu);

        // One Dimensional Array Menu
        JMenu matrixMenu = new JMenu("One Dimensional Array");
        
        // Create Array Menu
        JMenu createArrayMenu = new JMenu("Create Array");
        JMenuItem randomArrayItem = new JMenuItem("Randomly");
        randomArrayItem.addActionListener(e -> createRandomMatrix(frame));
        JMenuItem fileArrayItem = new JMenuItem("From File");
        fileArrayItem.addActionListener(e -> loadMatrixFromFile(frame));
        createArrayMenu.add(randomArrayItem);
        createArrayMenu.add(fileArrayItem);
        matrixMenu.add(createArrayMenu);

        // Array Statistics Menu
        JMenu statisticsMenu = new JMenu("Array Statistics");
        JMenuItem minItem = new JMenuItem("Array Minimum");
        JMenuItem maxItem = new JMenuItem("Array Maximum");
        JMenuItem avgItem = new JMenuItem("Array Average");
        JMenuItem stdDevItem = new JMenuItem("Array Standard Deviation");
        JMenuItem rowColStatsItem = new JMenuItem("Row & Column Statistics");
        // Add dummy action listeners (to be implemented fully)
        minItem.addActionListener(e -> JOptionPane.showMessageDialog(frame, "Minimum: TBD"));
        maxItem.addActionListener(e -> JOptionPane.showMessageDialog(frame, "Maximum: TBD"));
        avgItem.addActionListener(e -> JOptionPane.showMessageDialog(frame, "Average: TBD"));
        stdDevItem.addActionListener(e -> JOptionPane.showMessageDialog(frame, "Standard Deviation: TBD"));
        rowColStatsItem.addActionListener(e -> JOptionPane.showMessageDialog(frame, "Row & Column Stats: TBD"));
        statisticsMenu.add(minItem);
        statisticsMenu.add(maxItem);
        statisticsMenu.add(avgItem);
        statisticsMenu.add(stdDevItem);
        statisticsMenu.add(rowColStatsItem);
        matrixMenu.add(statisticsMenu);

        // Search Array
        JMenuItem searchArrayItem = new JMenuItem("Search Array");
        searchArrayItem.addActionListener(e -> JOptionPane.showMessageDialog(frame, "Search functionality TBD"));
        matrixMenu.add(searchArrayItem);

        // Operations Menu
        JMenu operationsMenu = new JMenu("Operations");
        JMenuItem addItem = new JMenuItem("Add Arrays");
        JMenuItem subtractItem = new JMenuItem("Subtract Arrays");
        JMenuItem multiplyItem = new JMenuItem("Multiply Arrays");
        // Add dummy action listeners (to be implemented fully)
        addItem.addActionListener(e -> JOptionPane.showMessageDialog(frame, "Addition functionality TBD"));
        subtractItem.addActionListener(e -> JOptionPane.showMessageDialog(frame, "Subtraction functionality TBD"));
        multiplyItem.addActionListener(e -> JOptionPane.showMessageDialog(frame, "Multiplication functionality TBD"));
        operationsMenu.add(addItem);
        operationsMenu.add(subtractItem);
        operationsMenu.add(multiplyItem);
        matrixMenu.add(operationsMenu);

        menuBar.add(matrixMenu);

        frame.setJMenuBar(menuBar);
        frame.setVisible(true);
    }

    private static void createRandomMatrix(JFrame frame) {
        String rowsInput = JOptionPane.showInputDialog(frame, "Enter number of rows:");
        String colsInput = JOptionPane.showInputDialog(frame, "Enter number of columns:");
        String lowerBoundInput = JOptionPane.showInputDialog(frame, "Enter lower bound of values:");
        String upperBoundInput = JOptionPane.showInputDialog(frame, "Enter upper bound of values:");

        try {
            int rows = Integer.parseInt(rowsInput);
            int cols = Integer.parseInt(colsInput);
            int lowerBound = Integer.parseInt(lowerBoundInput);
            int upperBound = Integer.parseInt(upperBoundInput);

            Random random = new Random();
            double[][] data = new double[rows][cols];
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    data[i][j] = lowerBound + random.nextInt(upperBound - lowerBound + 1);
                }
            }
            matrix = new Matrix(data);
            JOptionPane.showMessageDialog(frame, "Matrix created successfully:\n" + matrix);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(frame, "Invalid input. Please enter numeric values.");
        }
    }

    private static void loadMatrixFromFile(JFrame frame) {
        JFileChooser fileChooser = new JFileChooser();
        int result = fileChooser.showOpenDialog(frame);
        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            try {
                matrix = new Matrix(selectedFile.getAbsolutePath());
                JOptionPane.showMessageDialog(frame, "Matrix loaded successfully:\n" + matrix);
            } catch (FileNotFoundException ex) {
                JOptionPane.showMessageDialog(frame, "File not found: " + selectedFile.getAbsolutePath());
            }
        }
    }
}
