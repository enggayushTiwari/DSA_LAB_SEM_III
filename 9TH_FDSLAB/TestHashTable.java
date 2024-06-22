import java.util.*;

// class for testing the hash table implementations
public class TestHashTable {

    // main method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); // scanner for user input
        boolean exit = false; // flag for exiting the program
        while (!exit) {
            try {
            System.out.println("Choose an option:");
            System.out.println("1. Test ChainHashMap");
            System.out.println("2. Test ProbeHashMap");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            int choice = getIntInput(sc); // read user choice with exception handling
            switch (choice) {
                case 1:
                    testChainHashMap(sc); // test the ChainHashMap implementation
                    break;
                case 2:
                    testProbeHashMap(sc); // test the ProbeHashMap implementation
                    break;
                case 3:
                    exit = true; // exit the program
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
            } catch (NullPointerException e) {
                System.out.println("Key not aviable!, Please enter a valid key.");
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid integer.");
                sc.next(); // consume the invalid input
            } catch (NoSuchElementException e) {
                System.out.println("Input not available. Please try again.");
                sc.nextLine(); // consume the invalid input
            }
        }
        sc.close(); // close the scanner
        System.out.println("Thank you for using the test application.");
    }

    // method for testing the ChainHashMap implementation
    public static void testChainHashMap(Scanner sc) {
        System.out.println("Testing ChainHashMap...");
        ChainHashMap<String, Integer> map = new ChainHashMap<>(); // create a new ChainHashMap
        boolean done = false; // flag for exiting the test
        while (!done) {
            try {
            System.out.println("Choose an option:");
            System.out.println("1. Put a key-value pair");
            System.out.println("2. Get a value by key");
            System.out.println("3. Remove a key-value pair");
            System.out.println("4. Check the size of the map");
            System.out.println("5. Check if the map is empty");
            System.out.println("6. Display the map entries");
            System.out.println("7. Go back to the main menu");
            System.out.print("Enter your choice: ");
            int choice = getIntInput(sc); // read user choice with exception handling
            switch (choice) {
                case 1:
                    System.out.print("Enter the key: ");
                    String keyPut = sc.next(); // read the key
                    System.out.print("Enter the value: ");
                    int valuePut = getIntInput(sc); // read the value with exception handling
                    map.put(keyPut, valuePut); // put the key-value pair in the map
                    System.out.println("Successfully put (" + keyPut + ", " + valuePut + ") in the map.");
                    break;
                case 2:
                    System.out.print("Enter the key: ");
                    String keyGet = sc.next(); // read the key
                    int valueGet = map.get(keyGet); // get the value by the key
                    if (valueGet == 0) {
                        System.out.println("No value found for the key " + keyGet + ".");
                    } else {
                        System.out.println("The value for the key " + keyGet + " is " + valueGet + ".");
                    }
                    break;
                case 3:
                    System.out.print("Enter the key: ");
                    String keyRemove = sc.next(); // read the key
                    int valueRemove = map.remove(keyRemove); // remove the key-value pair from the map
                    if (valueRemove == 0) {
                        System.out.println("No key-value pair found for the key " + keyRemove + ".");
                    } else {
                        System.out.println("Successfully removed (" + keyRemove + ", " + valueRemove + ") from the map.");
                    }
                    break;
                case 4:
                    System.out.println("The size of the map is " + map.size() + ".");
                    break;
                case 5:
                    System.out.println("The map is " + (map.isEmpty() ? "empty." : "not empty."));
                    break;
                case 6:
                    System.out.println("The map entries are:");
                    for (AbstractHashMap.Entry<String, Integer> entry : map.entrySet()) {
                        System.out.println("(" + entry.getKey() + ", " + entry.getValue() + ")");
                    }
                    break;
                case 7:
                    done = true; // exit the test
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }   catch (NullPointerException e) {
                System.out.println("Key not aviable!, Please enter a valid key.");
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid integer.");
                sc.next(); // consume the invalid input
            } catch (NoSuchElementException e) {
                System.out.println("Input not available. Please try again.");
                sc.nextLine(); // consume the invalid input
            }
        } 
    }

    // method for testing the ProbeHashMap implementation
    public static void testProbeHashMap(Scanner sc) {
        System.out.println("Testing ProbeHashMap...");
        ProbeHashMap<String, Integer> map = new ProbeHashMap<>(); // create a new ProbeHashMap
        boolean done = false; // flag for exiting the test
        while (!done) {
            try {
            System.out.println("Choose an option:");
            System.out.println("1. Put a key-value pair");
            System.out.println("2. Get a value by key");
            System.out.println("3. Remove a key-value pair");
            System.out.println("4. Check the size of the map");
            System.out.println("5. Check if the map is empty");
            System.out.println("6. Display the map entries");
            System.out.println("7. Go back to the main menu");
            System.out.print("Enter your choice: ");
            int choice = getIntInput(sc); // read user choice with exception handling
            switch (choice) {
                case 1:
                    System.out.print("Enter the key: ");
                    String keyPut = sc.next(); // read the key
                    System.out.print("Enter the value: ");
                    int valuePut = getIntInput(sc); // read the value with exception handling
                    map.put(keyPut, valuePut); // put the key-value pair in the map
                    System.out.println("Successfully put (" + keyPut + ", " + valuePut + ") in the map.");
                    break;
                case 2:
                    System.out.print("Enter the key: ");
                    String keyGet = sc.next(); // read the key
                    int valueGet = map.get(keyGet); // get the value by the key
                    if (valueGet == 0) {
                        System.out.println("No value found for the key " + keyGet + ".");
                    } else {
                        System.out.println("The value for the key " + keyGet + " is " + valueGet + ".");
                    }
                    break;
                case 3:
                    System.out.print("Enter the key: ");
                    String keyRemove = sc.next(); // read the key
                    int valueRemove = map.remove(keyRemove); // remove the key-value pair from the map
                    if (valueRemove == 0) {
                        System.out.println("No key-value pair found for the key " + keyRemove + ".");
                    } else {
                        System.out.println("Successfully removed (" + keyRemove + ", " + valueRemove + ") from the map.");
                    }
                    break;
                case 4:
                    System.out.println("The size of the map is " + map.size() + ".");
                    break;
                case 5:
                    System.out.println("The map is " + (map.isEmpty() ? "empty." : "not empty."));
                    break;
                case 6:
                    System.out.println("The map entries are:");
                    for (AbstractHashMap.Entry<String, Integer> entry : map.entrySet()) {
                        System.out.println("(" + entry.getKey() + ", " + entry.getValue() + ")");
                    }
                    break;
                case 7:
                    done = true; // exit the test
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } catch (NullPointerException e) {
                System.out.println("Key not aviable!, Please enter a valid key.");
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid integer.");
                sc.next(); // consume the invalid input
            } catch (NoSuchElementException e) {
                System.out.println("Input not available. Please try again.");
                sc.nextLine(); // consume the invalid input
            }
        }
    }

    // method to get integer input with exception handling
    private static int getIntInput(Scanner sc) {
        int input = 0;
        boolean validInput = false;

        while (!validInput) {
            try {
                input = sc.nextInt();
                validInput = true;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid integer.");
                sc.next(); // consume the invalid input
            } catch (NoSuchElementException e) {
                System.out.println("Input not available. Please try again.");
                sc.nextLine(); // consume the invalid input
            }
        }

        return input;
    }
}
