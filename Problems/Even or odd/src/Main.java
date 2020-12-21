import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // Create Scanner object to read system standard input
        Scanner userIn = new Scanner(System.in);
        int val = Integer.parseInt(userIn.nextLine());
        while (val != 0) {
            System.out.println(val % 2 == 0 ? "even" : "odd");
            val = Integer.parseInt(userIn.nextLine());
        }
    }
}