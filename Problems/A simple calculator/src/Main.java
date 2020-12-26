import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here

        Scanner userInput = new Scanner(System.in);

        long numberA = Long.valueOf(userInput.next());
        String operation = userInput.next();
        long numberB = Long.valueOf(userInput.next());

        switch (operation) {
            case "+":
                System.out.println(numberA + numberB);
                break;
            case "-":
                System.out.println(numberA - numberB);
                break;
            case "/":
                if (numberB == 0) {
                    System.out.println("Division by 0!");
                    break;
                } else {
                    System.out.println(numberA / numberB);
                    break;
                }
            case "*":
                System.out.println(numberA * numberB);
                break;
            default:
                System.out.println("Unknown operator");
                break;
        }
    }
}