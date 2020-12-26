import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // put your code here
        double distance = Double.valueOf(scanner.nextLine());
        double duration = Double.valueOf(scanner.nextLine());

        double speed = distance / duration;
        System.out.println(speed);
    }
}