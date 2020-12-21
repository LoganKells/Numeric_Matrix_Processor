import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // Create a Scanner object for system input
        Scanner userInput = new Scanner(System.in);
        // Create a variable for storing the sum
        int summation = 0;
        // Use a while loop to calculate the sum.
        // Initialize the current line value.
        int val = Integer.parseInt(userInput.nextLine());
        while (val != 0) {
            summation += val;
            val = Integer.parseInt(userInput.nextLine());
        }
        // Print the summation
        System.out.println(summation);
    }
}