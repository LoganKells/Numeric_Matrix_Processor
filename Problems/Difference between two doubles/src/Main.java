import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // put your code here

        double valueA = Double.valueOf(scanner.nextLine());
        double valueB = Double.valueOf(scanner.nextLine());

        double difference = valueB - valueA;

        System.out.println(difference);
    }
}