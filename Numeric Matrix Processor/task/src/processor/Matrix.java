package processor;

import java.util.Arrays;

/**This class is a n x m dimensioned matrix.
 * Operations:
 * - loadMatrix - use a data list to load a n x m matrix.
 * - printMatrix - prints all elements in the 2D matrix
 * */
public class Matrix {
    // Variables
    private int n;
    private int m;
    int[][] matrix;

    // Constructor
    public Matrix(int n, int m) {
        this.n = n;
        this.m = m;
        matrix = new int[n][m];
    }

    // Accessors
    public int getN() {
        return this.n;
    }
    public int getM() {
        return this.m;
    }

    // Mutators
    public void loadMatrix(int[] data) {
        int dataIndex = 0;
        for (int i = 0; i < this.n; i++) {
            for (int j = 0; j < this.m; j++) {
                matrix[i][j] = data[dataIndex];
                dataIndex++;
            }
        }
    }
    public void printMatrix() {
        for (int i = 0; i < this.n; i++) {
            for (int j = 0; j < this.m; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.print('\n');
        }
    }
}
