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

    /**This method checks for equivalent dimensions between two 2D matrices.*/
    public Boolean checkEquivalentDimensions(Matrix matrixB) {
        int nMatrixB = matrixB.getN();
        int mMatrixB = matrixB.getM();

        return this.n == nMatrixB && this.m == mMatrixB;
    }
    /**This method performs the matrix addition operation for two 2D matrices.*/
    public Matrix matrixAddition(Matrix matrixB) {
        Matrix matrixC = new Matrix(this.n, this.m);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                matrixC.matrix[i][j] = matrix[i][j] + matrixB.matrix[i][j];
            }
        }
        return matrixC;
    }

    public void matrixScalar(int alpha) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                matrix[i][j] *= alpha;
            }
        }
    }
}
