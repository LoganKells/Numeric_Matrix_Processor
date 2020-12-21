import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // Create Scanner object for reading system standard input
        Scanner userIn = new Scanner(System.in);
        // Summation variable
        int summation = 0;
        // Loop through user input until the input is 0.
        while (userIn.hasNextInt()) {
            int val = Integer.parseInt(userIn.nextLine());
            if (val == 0) {
                break;
            } else if (summation + val >= 1000) {
                summation += val - 1000;
                break;
            } else {
                summation += val;
            }
        }
        // Print the results.
        System.out.println(summation);
    }
}