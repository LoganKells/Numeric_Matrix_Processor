import java.util.Scanner;

/**
 * Fizz Buzz
 * Fizz Buzz is a classic programming problem. Here is its slightly modified version.
 *
 * Write a program that takes the input of two integers:
 * the beginning and the end of the interval (both numbers belong to the interval).
 *
 * The program should output the numbers from this interval,
 * but if the number is divisible by 3, you should output Fizz
 * instead of it; if the number is divisible by 5, output Buzz;
 * and if it is divisible both by 3 and by 5, output FizzBuzz.
 *
 * Output each number or the word on a separate line.
 *
 *
 * Sample Input:
 * 8 16
 *
 * Sample Output:
 * 8
 * Fizz
 * Buzz
 * 11
 * Fizz
 * 13
 * 14
 * FizzBuzz
 * 16
 */
class Main {
    public static void main(String[] args) {
        // Gather user input
        Scanner userInput = new Scanner(System.in);
        int num1 = Integer.parseInt(userInput.next());
        int num2 = Integer.parseInt(userInput.next());

        // Determine which value is greater
        int max = Math.max(num1, num2);
        int min = Math.min(num1, num2);

        // Output the numbers in the interval from num1 to num2
        for (int i = min; i <= max; i++) {
            // Use ternary operators to solve
            System.out.println(i % 15 == 0 ? "FizzBuzz" : i % 5 == 0 ? "Buzz" : i % 3 == 0 ? "Fizz" : i);
        }

    }
}