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

    void printMatrix() {
        for (int i = 0; i < this.n; i++) {
            for (int j = 0; j < this.m; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.print('\n');
        }
    }

    /**This method checks for equivalent dimensions between two 2D matrices.*/
    boolean checkEquivalentDimensions(Matrix matrixB) {
        int nMatrixB = matrixB.getN();
        int mMatrixB = matrixB.getM();

        return this.n == nMatrixB && this.m == mMatrixB;
    }

    boolean checkMultiplicationDimensions(Matrix matrixB) {
        // the n x m matrix can only multiply m x k matrix.
        int nMatrixB = matrixB.getN();
        return nMatrixB == this.m;
    }

    /**This method performs the matrix addition operation for two 2D matrices.*/
    Matrix matrixAddition(Matrix matrixB) {
        Matrix matrixC = new Matrix(this.n, this.m);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                matrixC.matrix[i][j] = matrix[i][j] + matrixB.matrix[i][j];
            }
        }
        return matrixC;
    }

    void matrixScalar(double alpha) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                matrix[i][j] *= alpha;
            }
        }
    }

    double[] getMatrixColumn(int j) {
        // Create a column vector with the length equivalent to the row count of the matrix.
        double[] columnVector = new double[this.n];

        // Get the values
        for (int i = 0; i < this.n; i++) {
            columnVector[i] = this.matrix[i][j];
        }
        return columnVector;
    }

    Matrix matrixMultiplication(Matrix matrixB) {
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

    /** This method will return the matrix's main transpose.
     * Enter matrix:
     * 1 7 7
     * 6 6 4
     * 4 2 1
     * The result is:
     * 1 6 4
     * 7 6 2
     * 7 4 1
     * */
    Matrix matrixTransposeMain() {
        // Calculate new dimensions with the transpose and create this matrix
        int n_t = this.m;
        int m_t = this.n;
        Matrix matrixA_T = new Matrix(n_t, m_t); // transposed matrix A

        // Perform transpose
        for (int i = 0; i < n_t; i++) {
            for (int j = 0; j < m_t; j++) {
                matrixA_T.matrix[i][j] = matrix[j][i];
            }
        }
        return matrixA_T;
    }

    /** This method will return the matrix's main transpose.
     * Enter matrix:
     * 1 1 1 -1
     * 2 2 2 -2
     * 3 3 3 -3
     * The result is:
     * -3 -2 -1
     * 3 2 1
     * 3 2 1
     * 3 2 1
     * */
    Matrix matrixTransposeSide() {
        // Calculate new dimensions with the transpose and create this matrix
        int n_t = this.m;
        int m_t = this.n;
        Matrix matrixA_T = new Matrix(n_t, m_t); // transposed matrix A

        // Perform transpose
        int n_original;
        int m_original = this.m;
        for (int i = 0; i < n_t; i++) {
            n_original = this.n;
            for (int j = 0; j < m_t; j++) {
                matrixA_T.matrix[i][j] = matrix[n_original - 1][m_original - 1];
                n_original--;
            }
            m_original--;
        }
        return matrixA_T;
    }

    /** This method will return the matrix's vertical transpose.
     * Enter matrix:
     * 1 2 3 4
     * 5 6 7 8
     * 9 10 11 12
     * 13 14 15 16
     * The result is:
     * 4 3 2 1
     * 8 7 6 5
     * 12 11 10 9
     * 16 15 14 13
     * */
    Matrix matrixTransposeVertical()  {
        // Create a new matrix (dimensions remain the same as the original matrix)
        Matrix matrixA_T = new Matrix(this.n, this.m);

        // Perform transpose
        int m_original;
        for (int i = 0; i < this.n; i++) {
            m_original = this.m;
            for (int j = 0; j < this.m; j++) {
                matrixA_T.matrix[i][j] = matrix[i][m_original - 1];
                m_original--;
            }
        }
        return matrixA_T;
    }

    /** This method will return the matrix's main horizontal transpose.
     *
     * Enter matrix:
     * 1 2 3 4
     * 5 6 7 8
     * 9 10 11 12
     * 13 14 15 16
     *
     * The result is:
     * 13 14 15 16
     * 9 10 11 12
     * 5 6 7 8
     * 1 2 3 4
     * */
    Matrix matrixTransposeHorizontal() {
        // Create a new matrix (dimensions remain the same as the original matrix)
        Matrix matrixA_T = new Matrix(this.n, this.m);

        // Perform transpose
        int n_original = this.n;
        for (int i = 0; i < this.n; i++) {
            for (int j = 0; j < this.m; j++) {
                matrixA_T.matrix[i][j] = matrix[n_original - 1][j];
            }
            n_original--;
        }
        return matrixA_T;
    }

    /** This method with check if the matrix is square n x n dimensions.*/
    boolean isSquare() {
        return this.n == this.m;
    }

    /** This method will return the matrix's determinant: det(A)
     * See Laplace Expansion here: https://www.cliffsnotes.com/study-guides/algebra/linear-algebra/the-determinant/laplace-expansions-for-the-determinant
     *
     * Enter matrix:
     * 1 2 3 4 5
     * 4 5 6 4 3
     * 0 0 0 1 5
     * 1 3 9 8 7
     * 5 8 4 7 11
     *
     * The result is:
     * 191
     * */
    double determinant(Matrix A, int laplaceRow) {
        if (A.m <= 2) {
            // This will calculate the determinant of a 2 x 2 matrix.
            double a00 = A.matrix[0][0];
            double a11 = A.matrix[1][1];
            double a10 = A.matrix[1][0];
            double a01 = A.matrix[0][1];
            return a00 * a11 - a10 * a01;
        } else {
            // We will recursively calculate the determinant using laplace expansions.
            // The matrix is
            double det = 0;
            for (int j = 0; j < A.m; j++) {
                double sign = Math.pow(-1, (laplaceRow + 1 + j + 1));
                Matrix subMatrix = A.removeRowCol(laplaceRow, j);
                double cofactor = sign * A.matrix[laplaceRow][j] * determinant(subMatrix, laplaceRow);
                det += cofactor;
            }
            return det;
        }
    }

    /** This method will remove the i row and j column from the matrix*/
    Matrix removeRowCol(int deleteRow, int deleteCol) {
        // Create new, smaller matrix with 1 less row and column (after a row and column are removed).
        Matrix subMatrix = new Matrix(this.n - 1, this.m - 1);

        // Keep values
        for (int i = 0; i < this.n; i++) {
            for (int j = 0; j < this.m; j++) {
                if (j < deleteCol && i < deleteRow) {
                    subMatrix.matrix[i][j] = this.matrix[i][j];
                }
                else if (j < deleteCol && i > deleteRow) {
                    subMatrix.matrix[i - 1][j] = this.matrix[i][j];
                }
                else if (j > deleteCol && i < deleteRow) {
                    subMatrix.matrix[i][j - 1] = this.matrix[i][j];
                }
                else if (j > deleteCol && i > deleteRow) {
                    subMatrix.matrix[i - 1][j - 1] = this.matrix[i][j];
                } else {
                    continue;
                }
            }
        }
        return subMatrix;
    }
}
