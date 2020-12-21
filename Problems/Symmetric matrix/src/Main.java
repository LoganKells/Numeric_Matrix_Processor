import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // Create a Scanner object to read the standard system in
        Scanner userInput = new Scanner(System.in);
        // Get the next input integer as the size, n, of the array.
        int n = Integer.parseInt(userInput.nextLine());

        // Initialize array of appropriate size
        int[][] arrayA = new int[n][n];
        int[] list = new int[n * n];
        // Read in the array values using nested loop.
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arrayA[i][j] = userInput.nextInt();
            }
        }
        // Determine if the array is symmetric.
        // Array is symmetric if A[i][j] = A[j][i] where i != j (diagonal).
        String symmetric = "YES";
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i != j && arrayA[i][j] != arrayA[j][i]) {
                    symmetric = "NO";
                    break;
                }
            }
        }
        System.out.println(symmetric);
    }
}
