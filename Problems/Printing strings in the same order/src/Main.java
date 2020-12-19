import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here

        // Create scanner for system input
        Scanner userInput = new Scanner(System.in);

        // Read four words in
        String token1 = userInput.next();
        String token2 = userInput.next();
        String token3 = userInput.next();
        String token4 = userInput.next();

        // Print the tokens on a separate line
        System.out.println(token1);
        System.out.println(token2);
        System.out.println(token3);
        System.out.println(token4);
    }
}