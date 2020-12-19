import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // Create a string array for storing/retrieving data
        String[] tokens = new String[5];

        // Create scanner for system input
        Scanner userInput = new Scanner(System.in);

        for (int i = 0; i < 5; i++) {
            tokens[i] = userInput.next();
        }

        for (String token : tokens) {
            System.out.println(token);
        }
    }
}