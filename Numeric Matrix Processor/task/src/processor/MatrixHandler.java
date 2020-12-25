package processor;

import java.util.Scanner;

/**MatrixHandler provides matrix operations.
 * Operations:
 * - readCreateMatrix()
 * - runMatrixAddition()
 * */
public class MatrixHandler {
    // Class variables
    private Scanner dataInput;
    private Matrix matrixA;
    private Matrix matrixB;
    private int scalar;

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

    public void readScalar() {
        this.scalar = this.dataInput.nextInt();
    }

    public void runMatrixAddition() {
        // Create matrices
        Matrix matrixA = readCreateMatrix();
        Matrix matrixB = readCreateMatrix();

        // Calculate matrix addition
        Boolean equalDimensions = matrixA.checkEquivalentDimensions(matrixB);
        if (equalDimensions) {
            Matrix matrixC = matrixA.matrixAddition(matrixB);
            matrixC.printMatrix();
        } else {
            System.out.println("ERROR");
        }
    }

    public void runMatrixScalar() {
        // Create matrix
        Matrix matrixA = readCreateMatrix();
        // Read in the scalar
        readScalar();
        // Calculate the scalar matrix operation: alpha * A
        matrixA.matrixScalar(this.scalar);

        matrixA.printMatrix();
    }

}
