package processor;

public class Main {
    public static void main(String[] args) {
        MatrixHandler matrixHandler = new MatrixHandler();

        // Create matrices
        Matrix matrixA = matrixHandler.readCreateMatrix();
        Matrix matrixB = matrixHandler.readCreateMatrix();

        // Calculate matrix addition
        Boolean equalDimensions = matrixHandler.checkEquivalentDimensions(matrixA, matrixB);
        if (equalDimensions) {
            Matrix matrixC = matrixHandler.matrixAddition(matrixA, matrixB);
            matrixC.printMatrix();
        } else {
            System.out.println("ERROR");
        }
    }
}