package treeQ2;
import java.util.Scanner;
// Main.java
public class Main {
    // A static method to find the gcd of two numbers using Euclid's algorithm
    public static int gcd(int a, int b) {
        // If b is zero, return a as the gcd
        if (b == 0) {
            return a;
        }
        // Otherwise, recursively call gcd with b and the remainder of a and b
        else {
            return gcd(b, a % b);
        }
    }

    // The main method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // Declare and initialize two numbers
        int a = sc.nextInt();
        int b = sc.nextInt();
        // Call the gcd method and print the result
        int result = gcd(a, b);
        System.out.println("The gcd of " + a + " and " + b + " is " + result);
    }
}
