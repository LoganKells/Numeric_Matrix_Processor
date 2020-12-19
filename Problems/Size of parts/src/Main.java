import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // Create a Scanner object.
        Scanner userInput = new Scanner(System.in);
        // Initialize summation variables
        int sumShip = 0;
        int sumReject = 0;
        int sumFix = 0;
        // Get the size from the user
        int size = Integer.parseInt(userInput.nextLine());
        // Create an array for storing test results
        int[] results = new int[size];
        // Get number of parts and sequence of test results
        for (int i = 0; i < size; i++) {
            int testResult = Integer.parseInt(userInput.nextLine());
            if (testResult == 0) {
                sumShip++;
            } else if (testResult == 1) {
                sumFix++;
            } else {
                sumReject++;
            }
        }
        // Print the results
        System.out.println(sumShip + " " + sumFix + " " + sumReject);
    }
}