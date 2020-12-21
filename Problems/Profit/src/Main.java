import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Create Scanner object for system standard input
        Scanner userIn = new Scanner(System.in);
        // Create variable for measuring years of duration
        int duration = 0;
        // Read in M, P, K
        //int balanceMoney = Integer.parseInt(userIn.next());
        double balanceMoney = Double.parseDouble(userIn.next());
        double percent = Double.parseDouble(userIn.next());
        double targetMoney = Double.parseDouble(userIn.next());
        // Calculate years until the original deposit reaches the target
        while (balanceMoney < targetMoney) {
            balanceMoney += (percent / 100) * balanceMoney;
            duration++;
        }

        // Print the duration (years)
        System.out.println(duration);
    }
}