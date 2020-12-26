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
    double[][] matrix;

    // Constructor
    public Matrix(int n, int m) {
        this.n = n;
        this.m = m;
        matrix = new double[n][m];
    }

    // Accessors
    public int getN() {
        return this.n;
    }
    public int getM() {
        return this.m;
    }

    // Mutators
    public void loadMatrix(double[] data) {
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
    public boolean checkEquivalentDimensions(Matrix matrixB) {
        int nMatrixB = matrixB.getN();
        int mMatrixB = matrixB.getM();

        return this.n == nMatrixB && this.m == mMatrixB;
    }

    public boolean checkMultiplicationDimensions(Matrix matrixB) {
        // the n x m matrix can only multiply m x k matrix.
        int nMatrixB = matrixB.getN();
        return nMatrixB == this.m;
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

    public void matrixScalar(double alpha) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                matrix[i][j] *= alpha;
            }
        }
    }

    public double[] getMatrixColumn(int j) {
        // Create a column vector with the length equivalent to the row count of the matrix.
        double[] columnVector = new double[this.n];

        // Get the values
        for (int i = 0; i < this.n; i++) {
            columnVector[i] = this.matrix[i][j];
        }
        return columnVector;
    }

    public Matrix matrixMultiplication(Matrix matrixB) {
        // Calculate new dimensions
        int nMatrixC = this.n;
        int mMatrixC = matrixB.getM();
        Matrix matrixC = new Matrix(nMatrixC, mMatrixC);

        // Calculate all elements of matrix C
        for (int i = 0; i < nMatrixC; i++) {
            for (int j = 0; j < mMatrixC; j++) {
                // Calculate a single element of matrix C as dot product: rowA * colB.
                // Use the current row from matrix A and column from matrix B for this dot product.
                // This dot product will result in a scalar.
                double[] columnMatrixB = matrixB.getMatrixColumn(j);
                for (int k = 0; k < columnMatrixB.length; k++) {
                    matrixC.matrix[i][j] += matrix[i][k] * columnMatrixB[k];
                }
            }

        }
        return matrixC;
    }
}
