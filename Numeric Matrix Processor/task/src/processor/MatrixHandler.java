package processor;

import java.util.Scanner;

/**MatrixHandler provides matrix operations.
 * Operations:
 * - checkEquivalentDimensions - Checks if two 2D matrices have equal dimensions.
 * - matrixAddition - Adds two matrices
 * */
public class MatrixHandler {
    // Class variables
    private Scanner dataInput;
    private Matrix matrixA;
    private Matrix matrixB;

    // Constructor
    public MatrixHandler() {
        this.dataInput = new Scanner(System.in);
    }

    /** Read the first two integers as the n x m matrix dimensions, then read the subsequent n*m integers
     * and store in the matrix.*/
    public Matrix readCreateMatrix() {
        // Get dimensions
        int n = this.dataInput.nextInt();
        int m = this.dataInput.nextInt();

        // Create an empty Matrix
        Matrix myMatrix = new Matrix(n, m);

        // Read the next n*m integers
        int[] dataList = new int[n * m];
        for (int i = 0; i < dataList.length; i++) {
            dataList[i] = this.dataInput.nextInt();
        }

        // Load the integer data to the matrix
        myMatrix.loadMatrix(dataList);
        // Return the matrix populated with data.
        return myMatrix;
    }

    /**This method checks for equivalent dimensions between two 2D matrices.*/
    public Boolean checkEquivalentDimensions(Matrix matrixA, Matrix matrixB) {
        int nMatrixA = matrixA.getN();
        int mMatrixA = matrixA.getM();
        int nMatrixB = matrixB.getN();
        int mMatrixB = matrixB.getM();

        return nMatrixA == nMatrixB && mMatrixA == mMatrixB;
    }
    /**This method performs the matrix addition operation for two 2D matrices.*/
    public Matrix matrixAddition(Matrix matrixA, Matrix matrixB) {
        int n = matrixA.getN();
        int m = matrixA.getM();
        Matrix matrixC = new Matrix(n, m);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                matrixC.matrix[i][j] = matrixA.matrix[i][j] + matrixB.matrix[i][j];
            }
        }
        return matrixC;
    }
}
