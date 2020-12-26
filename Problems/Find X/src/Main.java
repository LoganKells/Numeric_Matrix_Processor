import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // put your code here
        double a = Double.valueOf(scanner.next());
        double b = Double.valueOf(scanner.next());
        double c = Double.valueOf(scanner.next());

        double x = (c - b) / a;
        System.out.println(x);
    }
}