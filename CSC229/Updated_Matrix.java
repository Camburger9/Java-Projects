
import java.io.*;
import java.util.Scanner;

public class Matrix {
    private int rows;
    private int cols;
    private double[][] data;

    // Constructor for an empty matrix of given size
    public Matrix(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        data = new double[rows][cols];
    }

    // Constructor to initialize from a 2D array
    public Matrix(double[][] inputData) {
        this.rows = inputData.length;
        this.cols = inputData[0].length;
        data = new double[rows][cols];
        for (int i = 0; i < rows; i++) {
            System.arraycopy(inputData[i], 0, data[i], 0, cols);
        }
    }

    // Constructor to initialize from a file
    public Matrix(String fileName) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File(fileName));
        this.rows = scanner.nextInt();
        this.cols = scanner.nextInt();
        data = new double[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                data[i][j] = scanner.nextDouble();
            }
        }
        scanner.close();
    }

    // Method to generate an identity matrix of size n x n
    public static Matrix identity(int n) {
        Matrix identityMatrix = new Matrix(n, n);
        for (int i = 0; i < n; i++) {
            identityMatrix.data[i][i] = 1.0;
        }
        return identityMatrix;
    }

    // Matrix multiplication
    public Matrix multiply(Matrix other) {
        if (this.cols != other.rows) {
            throw new IllegalArgumentException("Matrix dimensions do not match for multiplication.");
        }
        Matrix result = new Matrix(this.rows, other.cols);
        for (int i = 0; i < result.rows; i++) {
            for (int j = 0; j < result.cols; j++) {
                for (int k = 0; k < this.cols; k++) {
                    result.data[i][j] += this.data[i][k] * other.data[k][j];
                }
            }
        }
        return result;
    }

    // Matrix addition
    public Matrix add(Matrix other) {
        if (this.rows != other.rows || this.cols != other.cols) {
            throw new IllegalArgumentException("Matrix dimensions do not match for addition.");
        }
        Matrix result = new Matrix(this.rows, this.cols);
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result.data[i][j] = this.data[i][j] + other.data[i][j];
            }
        }
        return result;
    }

    // Matrix subtraction
    public Matrix subtract(Matrix other) {
        if (this.rows != other.rows || this.cols != other.cols) {
            throw new IllegalArgumentException("Matrix dimensions do not match for subtraction.");
        }
        Matrix result = new Matrix(this.rows, this.cols);
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result.data[i][j] = this.data[i][j] - other.data[i][j];
            }
        }
        return result;
    }

    // Matrix transpose
    public Matrix transpose() {
        Matrix result = new Matrix(this.cols, this.rows);
        for (int i = 0; i < this.rows; i++) {
            for (int j = 0; j < this.cols; j++) {
                result.data[j][i] = this.data[i][j];
            }
        }
        return result;
    }

    // String representation of the matrix
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (double[] row : data) {
            for (double value : row) {
                sb.append(value).append(" ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}
