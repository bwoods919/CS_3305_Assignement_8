import java.util.*;

// Name: Brendan Woods
// Class: CS 3305/01
// Term: fall 2022
// Instructor: Dr. Haddad
// Assignment: 8
// IDE Name: VS Code

public class hashFunctions {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int option;

        int[] keys = {1234, 8234, 7867, 1009, 5438, 4312, 3420, 9487, 5418, 5299,
                5078, 8239, 1208, 5098, 5195, 5329, 4543, 3344, 7698, 5412,
                5567, 5672, 7934, 1254, 6091, 8732, 3095, 1975, 3843, 5589,
                5439, 8907, 4097, 3096, 4310, 5298, 9156, 3895, 6673, 7871,
                5787, 9289, 4553, 7822, 8755, 3398, 6774, 8289, 7665, 5523};

        while(true) {
            printMenu();
            option = input.nextInt();

            switch (option) {
                case 1: // Linear Probing
                    break;

                case 2: // Quadratic Probing
                    break;

                case 3: // Double Hashing
                    break;

                case 4: // Student choice
                    break;

                case 5: // Exit
                    System.exit(255);
                    break;
            }
        }
    }

    public static void printMenu() {

        System.out.println("\n-----MAIN MENU--------------------------------------");
        System.out.println("1. Run HF1 (Division method with Linear Probing)");
        System.out.println("2. Run HF2 (Division method with Quadratic Probing)");
        System.out.println("3. Run HF3 (Division method with Double Hashing)");
        System.out.println("4. Run HF4 (Student Designed HF)");
        System.out.println("5. Exit program");

        System.out.print("\nEnter option number: ");
    }
}