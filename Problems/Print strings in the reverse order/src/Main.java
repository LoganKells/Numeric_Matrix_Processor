//put imports you need here
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here

        // Create a scanner object
        Scanner userInput = new Scanner(System.in);

        // Read strings (not lines) from scanner input
        String s1 = userInput.next();
        String s2 = userInput.next();
        String s3 = userInput.next();

        // Print the strings in reverse order.
        System.out.println(s3 + '\n' + s2 + '\n' + s1);
    }
}