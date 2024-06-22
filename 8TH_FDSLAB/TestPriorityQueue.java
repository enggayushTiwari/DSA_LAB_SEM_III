import java.util.*;

// A test application for the priority queue
public class TestPriorityQueue {

  public static void main(String[] args) {
    // Create a priority queue of integers with natural order
    HeapPriorityQueue<Integer, Integer> pq = new HeapPriorityQueue<>();

    // Create a scanner for user input
    Scanner sc = new Scanner(System.in);

    // Display a menu of options
    System.out.println("Welcome to the priority queue test application!");
    System.out.println("Please choose one of the following options:");
    System.out.println("1. Insert an entry (key, value)");
    System.out.println("2. Remove and return the minimum entry");
    System.out.println("3. Return (but do not remove) the minimum entry");
    System.out.println("4. Check the size of the priority queue");
    System.out.println("5. Check if the priority queue is empty");
    System.out.println("6. Exit the application");

    // Declare a variable for user choice
    int choice;
    
    // Loop until the user chooses to exit
    do {
      try {
      // Prompt the user for a choice
      System.out.print("Enter your choice: ");
      choice = sc.nextInt();

      // Perform the corresponding action based on the choice
      switch (choice) {
        case 1: // Insert an entry
          // Prompt the user for a key and a value
          System.out.print("Enter the key: ");
          int key = sc.nextInt();
          System.out.print("Enter the value: ");
          int value = sc.nextInt();

          // Insert the entry into the priority queue
          pq.insert(key, value);

          // Display a confirmation message
          System.out.println("The entry (" + key + ", " + value + ") has been inserted into the priority queue.");
          break;
        case 2: // Remove and return the minimum entry
          // Check if the priority queue is empty
          if (pq.isEmpty()) {
            // Display an error message
            System.out.println("The priority queue is empty. There is no minimum entry to remove.");
          } else {
            // Remove and return the minimum entry
            Entry<Integer, Integer> min = pq.removeMin();

            // Display the removed entry
            System.out.println("The minimum entry (" + min.getKey() + ", " + min.getValue() + ") has been removed from the priority queue.");
          }
          break;
        case 3: // Return (but do not remove) the minimum entry
          // Check if the priority queue is empty
          if (pq.isEmpty()) {
            // Display an error message
            System.out.println("The priority queue is empty. There is no minimum entry to return.");
          } else {
            // Return (but do not remove) the minimum entry
            Entry<Integer, Integer> min = pq.min();

            // Display the returned entry
            System.out.println("The minimum entry (" + min.getKey() + ", " + min.getValue() + ") is in the priority queue.");
          }
          break;
        case 4: // Check the size of the priority queue
          // Get the size of the priority queue
          int size = pq.size();

          // Display the size
          System.out.println("The priority queue has " + size + " entries.");
          break;
        case 5: // Check if the priority queue is empty
          // Check if the priority queue is empty
          boolean isEmpty = pq.isEmpty();

          // Display the result
          if (isEmpty) {
            System.out.println("The priority queue is empty.");
          } else {
            System.out.println("The priority queue is not empty.");
          }
          break;
        case 6: // Exit the application
          // Display a farewell message
          System.out.println("Thank you for using the priority queue test application. Goodbye!");
          break;
        default: // Invalid choice
          // Display an error message
          System.out.println("Invalid choice. Please enter a number between 1 and 6.");
          break;
        }
      } catch (InputMismatchException e) {
        // Handle the case where the user enters a non-integer value
        System.out.println("Invalid input. Please enter a valid integer.");
        // Consume the invalid input to avoid an infinite loop
        sc.nextLine();
        // Set the choice to an invalid value to trigger the default error message
        choice = 0;
      }
      
      // Display a blank line for spacing
      System.out.println();

    } while (choice != 6); // Repeat until the user chooses to exit

    // Close the scanner
    sc.close();
  }
}