import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // initialize the product using long type for big integers.
        long product = 1;
        // Create Scanner object
        Scanner userInput = new Scanner(System.in);
        // Get the first two integers
        int a = Integer.parseInt(userInput.next());
        int b = Integer.parseInt(userInput.next());
        // Calculate product of the number range
        for (int i = a; i < b; i++) {
            product *= i;
        }
        // print the results
        System.out.println(product);
    }
}