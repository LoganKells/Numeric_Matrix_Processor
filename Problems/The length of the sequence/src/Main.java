import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // Create Scanner object for reading system input
        Scanner userIn = new Scanner(System.in);
        // Create a variable for storing the count
        int countNonZero = 0;
        // Gather input so long as it is not 0
        while (Integer.parseInt(userIn.nextLine()) != 0) {
            countNonZero++;
        }
        // Print the sum of non zero values
        System.out.println(countNonZero);
    }
}