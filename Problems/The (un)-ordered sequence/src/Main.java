import java.util.Scanner;
import java.util.ArrayList;

class Main {
    public static void main(String[] args) {
        // Create a Scanner object for system standard input
        Scanner userInput = new Scanner(System.in);
        // Create an ArrayList for storing the values
        ArrayList<Integer> data = new ArrayList<>();

        // Read in the user input and store in the ArrayList
        int val = Integer.parseInt(userInput.next());
        // Loop
        while (val != 0) {
            // Add any non-zero values to the ArrayList.
            data.add(val);
            // Get the next integer token.
            val = Integer.parseInt(userInput.next());
        }

        // Determine if the integer sequence is in order as described by the prompt rules.
        // If the sequence is 1 character, then print true
        boolean ordered = true;
        if (data.size() < 2) {
            System.out.println(true);
        } else {
            // Determine if we should check for Ascending or Descending sequence. We can do this by
            // determining the first non-zero slope in the integer sequence. This first non-zero slope, whether positive
            // or negative determines if the sequence should be tested for ascending or descending order.
            int j = 0;
            int slope = 0;
            do {
                slope = data.get(j + 1) - data.get(j);
                j++;
            } while (slope == 0 && j < data.size() - 1);

            // If the slope is positive, then we check the sequence for consistent ascending integers.
            if (slope > 0) {
                for (int i = 0; i < data.size() - 1; i++) {
                    int valueA = data.get(i);
                    int valueB = data.get(i + 1);
                    int delta = valueB - valueA;
                    if (delta < 0) {
                        ordered = false;
                        break;
                    }
                }
            } else {
                for (int i = 0; i < data.size() - 1; i++) {
                    int valueA = data.get(i);
                    int valueB = data.get(i + 1);
                    int delta = valueB - valueA;
                    if (delta > 0) {
                        ordered = false;
                        break;
                    }
                }
            }
            System.out.println(ordered);
        }
    }
}