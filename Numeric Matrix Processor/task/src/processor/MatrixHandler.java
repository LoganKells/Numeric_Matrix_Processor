package processor;

import java.util.Scanner;

/**MatrixHandler provides matrix operations.
 * Operations:
 * - readCreateMatrix()
 * - runMatrixAddition()
 * */
class MatrixHandler {
    // Class variables
    private Scanner dataInput;
    private Matrix matrixA;
    private Matrix matrixB;
    private Double scalar;

    // Constructor
    MatrixHandler() {
        this.dataInput = new Scanner(System.in);
    }

    public void setUserSelection() {
        int userSelection;
        int userSelectionTranspose;
        do {
            // Let the user select which matrix operation to run.
            System.out.println("1. Add matrices");
            System.out.println("2. Multiply matrix by a constant");
            System.out.println("3. Multiply matrices");
            System.out.println("4. Transpose matrix");
            System.out.println("0. Exit");
            System.out.print("Your choice: ");
            userSelection = this.dataInput.nextInt();

            // Run the selected matrix operation.
            switch (userSelection) {
                case 1:
                    runMatrixAddition();
                    break;
                case 2:
                    runMatrixScalar();
                    break;
                case 3:
                    runMatrixMultiplication();
                    break;
                case 4:
                    // Let the user select which type of matrix transpose operation to run.
                    System.out.println("1. Main diagonal");
                    System.out.println("2. Side diagonal");
                    System.out.println("3. Vertical line");
                    System.out.println("4. Horizontal line");
                    System.out.print("Your choice: ");
                    userSelectionTranspose = this.dataInput.nextInt();
                    // Run the proper transpose operation based on the user selection
                    switch (userSelectionTranspose) {
                        case 1:
                            runMatrixTranspose("main");
                            break;
                        case 2:
                            runMatrixTranspose("side");
                            break;
                        case 3:
                            runMatrixTranspose("vertical");
                            break;
                        case 4:
                            runMatrixTranspose("horizontal");
                        default:
                            break;
                    }
                default:
                    break;
            }

        } while (userSelection != 0);
    }

    /** Read the first two integers as the n x m matrix dimensions, then read the subsequent n*m integers
     * and store in the matrix.*/
    private Matrix readCreateMatrix(int n, int m) {
        // Create an empty Matrix
        Matrix myMatrix = new Matrix(n, m);

        // Read the next n*m integers
        double[] dataList = new double[n * m];
        for (int i = 0; i < dataList.length; i++) {
            dataList[i] = Double.valueOf(this.dataInput.next());
        }

        // Load the integer data to the matrix
        myMatrix.loadMatrix(dataList);
        // Return the matrix populated with data.
        return myMatrix;
    }

    private void readScalar() {
        this.scalar = Double.valueOf(this.dataInput.next());
    }

    private void runMatrixAddition() {
        // Create matrices
        System.out.print("Enter the size of first matrix: ");
        int n = this.dataInput.nextInt();
        int m = this.dataInput.nextInt();
        System.out.println("Enter first matrix:");
        Matrix matrixA = readCreateMatrix(n, m);

        System.out.print("Enter the size of second matrix: ");
        n = this.dataInput.nextInt();
        m = this.dataInput.nextInt();
        System.out.println("Enter second matrix:");
        Matrix matrixB = readCreateMatrix(n, m);

        // Calculate matrix addition
        boolean equalDimensions = matrixA.checkEquivalentDimensions(matrixB);
        if (equalDimensions) {
            Matrix matrixC = matrixA.matrixAddition(matrixB);
            System.out.println("The result is:");
            matrixC.printMatrix();
        } else {
            System.out.println("ERROR");
        }
        System.out.print('\n');
    }

    private void runMatrixScalar() {
        // Create matrix
        System.out.print("Enter the size of matrix: ");
        int n = this.dataInput.nextInt();
        int m = this.dataInput.nextInt();

        System.out.println("Enter matrix:");
        Matrix matrixA = readCreateMatrix(n, m);

        // Read in the scalar
        System.out.print("Enter constant: ");
        readScalar();

        // Calculate the scalar matrix operation: alpha * A
        matrixA.matrixScalar(this.scalar);

        // Print the final matrix after scaling by a scalar.
        System.out.println("The result is:");
        matrixA.printMatrix();
        System.out.print('\n');
    }

    private void runMatrixMultiplication() {
        // Create matrix A
        System.out.print("Enter the size of first matrix: ");
        int n = this.dataInput.nextInt();
        int m = this.dataInput.nextInt();
        System.out.println("Enter first matrix:");
        Matrix matrixA = readCreateMatrix(n, m);

        // Create matrix A
        System.out.print("Enter the size of second matrix: ");
        n = this.dataInput.nextInt();
        m = this.dataInput.nextInt();
        System.out.println("Enter second matrix:");
        Matrix matrixB = readCreateMatrix(n, m);

        // Check that the matrices have compatible dimensions for matrix multiplication operation.
        boolean definedDimensions = matrixA.checkMultiplicationDimensions(matrixB);
        if (definedDimensions) {
            // Calculate matrix multiplication
            Matrix matrixC = matrixA.matrixMultiplication(matrixB);
            System.out.println("The result is:");
            matrixC.printMatrix();
        } else {
            System.out.println("ERROR");
        }
        System.out.print('\n');
    }

    private void runMatrixTranspose(String type) {
        // Create matrix
        System.out.print("Enter matrix size: ");
        int n = this.dataInput.nextInt();
        int m = this.dataInput.nextInt();
        System.out.println("Enter matrix:");
        Matrix matrixA = readCreateMatrix(n, m);

        if (type.equals("main")) {
            Matrix matrixA_T = matrixA.matrixTransposeMain();
            System.out.println("The result is:");
            matrixA_T.printMatrix();
        }
        else if (type.equals("side")) {
            Matrix matrixA_T = matrixA.matrixTransposeSide();
            System.out.println("The result is:");
            matrixA_T.printMatrix();
        }
        else if (type.equals("vertical")) {
            Matrix matrixA_T = matrixA.matrixTransposeVertical();
            System.out.println("The result is:");
            matrixA_T.printMatrix();
        } else {
            Matrix matrixA_T = matrixA.matrixTransposeHorizontal();
            System.out.println("The result is:");
            matrixA_T.printMatrix();
        }
    }


}
