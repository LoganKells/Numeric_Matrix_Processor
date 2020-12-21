import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // Create a Scanner object for reading system standard input
        Scanner userInput = new Scanner(System.in);

        // Obtain the dimensions of the matrix from the first line of the user input
        int n = userInput.nextInt();
        int m = userInput.nextInt();

        // Use a nested loop over the rows and columns to populate the matrix from user input
        int[][] myArray = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                myArray[i][j] = userInput.nextInt();
            }
        }

        // gain column indexes to swap
        int indexA = userInput.nextInt();
        int indexB = userInput.nextInt();

        // Swap the columns
        for (int i = 0; i < n; i++) {
            // Hold the original values in Column A in memory temporarily.
            int tempValueColumnA = myArray[i][indexA];
            // Replace the values in Column A with Column B (this is why temporary value above is needed).
            myArray[i][indexA] = myArray[i][indexB];
            // Replace the values in Column B with Column A
            myArray[i][indexB] = tempValueColumnA;
        }

        // Print the Array after the column swap
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (j < m - 1) {
                    System.out.print(myArray[i][j] + " ");
                } else {
                    System.out.print(myArray[i][j]);
                }
            }
            if (i < n - 1) {
                System.out.print('\n');
            }
        }
    }
}