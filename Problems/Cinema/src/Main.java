import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // The program should output the row number in which there are k consecutive available seats.
        // If there are several such rows, output the number of the smallest such row.
        // If there is no such row, output the number 0.


        // Create Scanner object for standard system input
        Scanner inputData = new Scanner(System.in);

        // Read the dimensions as the first line -> n x m array
        int n = inputData.nextInt();
        int m = inputData.nextInt();

        // Use a loop to read the array (representing available seats).
        int[][] seatMap = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                seatMap[i][j] = inputData.nextInt();
            }
        }

        // Read the last value as the number of consecutive open seats to search for
        int k = inputData.nextInt();
        int rowFound = 0;

        for (int i = 0; i < n; i++) {
            int countConsecutive = 0;
            // If a row with enough consecutive empty seats was found, then end the loops.
            if (rowFound > 0) {
                break;
            }
            // Search for consecutive empty seats.
            for (int j = 0; j < m; j++) {
                if (seatMap[i][j] == 0) {
                    countConsecutive++;
                    // Once enough consecutive empty seats are found, then end the loop.
                    if (countConsecutive == k) {
                        rowFound = i + 1;
                        break;
                    }
                } else {
                    // If a non-empty seat is found then reset the counter of consecutive empty seats to zero.
                    countConsecutive = 0;
                }
            }
        }
        System.out.println(rowFound);
    }
}