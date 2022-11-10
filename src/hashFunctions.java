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

            int[][] Table=new int[50][];
            for(int i=0;i<50;i++) {
                Table[i]=new int[2];
                Table[i][0] = -1;
                Table[i][1] = 0;
            }

            printMenu();
            option = input.nextInt();

            switch (option) {
                case 1: // Linear Probing
                    System.out.println("Index    Keys     Probes");
                    System.out.println("------------------------");
                    HF1(Table,keys);
                    System.out.println("\nSum of probe values = " + sumProbes(Table));
                break;

                case 2: // Quadratic Probing
                    System.out.println("Index    Keys     Probes");
                    System.out.println("------------------------");
                    HF2(Table,keys);
                    System.out.println("\nSum of probe values = " + sumProbes(Table));
                break;

                case 3: // Double Hashing

                    System.out.println("Index    Keys     Probes");
                    System.out.println("------------------------");
                    HF3(Table,keys);
                    System.out.println("\nSum of probe values = " + sumProbes(Table));
                break;

                case 4: // Student choice
                break;

                case 5: // Exit
                    input.close();
                    System.exit(255);
                break;

                default:
                    System.out.println("Invalid option, please select 1 - 5.");
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

    public static int sumProbes(int [][]Table){
        int totalProbes=0;
    
        for(int i=0;i<50;i++){
            totalProbes += Table[i][1];
        }
        return totalProbes;
    }

    public static void HF1(int[][] Table,int keys[]){

        for (int i = 0; i < 50; i++) {

            // Computing the hash value
            int hash_value = keys[i] % 50;
    
            // Insert in the Table if there is no collision
            if (Table[hash_value][0] == -1){
                Table[hash_value][0] = keys[i];
    
            } else {
                // If there is a collision iterating through all possible quadratic values
                int probes=0;
                for (int j = 0; j < 50; j++)
                {
                    int temp = (keys[i] + j) % 50;
                    if (Table[temp][0] == -1)
                    {
                        Table[temp][0] = keys[i];
                        Table[temp][1] = probes;
                        break;
                    }
                    probes++;
                }
            }
        }
        for(int hash_value = 0;hash_value<50;hash_value++){
            System.out.println(hash_value + "       " + Table[hash_value][0] + "       " + Table[hash_value][1]);
    
        }
    }

    public static void HF2(int [][]Table,int keys[]){

        for (int i = 0; i < 50; i++)
        {
            int hash_value = keys[i] % 50;
            if (Table[hash_value][0] == -1){
                Table[hash_value][0] = keys[i];
            }
    
            else {

                // If there is a collision iterating through all possible quadratic values
                int probes=0;
                for (int j = 0; j < 50; j++)
                {
                    // Computing the new hash value
                    int temp = (keys[i] + j * j) % 50;
                    if (Table[temp][0] == -1)
                    {
                        Table[temp][0] = keys[i];
                        Table[temp][1] = probes;
                        break;
                    }
                    probes++;
                }
            }
        }

        for(int hash_value = 0; hash_value <50; hash_value++){
            System.out.println(hash_value + "       " + Table[hash_value][0] + "       " + Table[hash_value][1]);
        }
    }
    
    
    public static int H2(int key){
        return (30-(key%25));
    }

    public static void HF3(int [][]Table,int keys[]){

        for (int i = 0; i < 50; i++)
        {
            int hash_value = (keys[i] % 50) + ((0) * H2(keys[i]));
    
            if (Table[hash_value][0] == -1){
                Table[hash_value][0] = keys[i];
            } else {

                int probes=0;
                int j=1;
                while (j <= 50) {
                    hash_value = (keys[i] % 50) + ((j) * H2(keys[i]));
                    if ( hash_value < 50 && Table[hash_value][0] == -1 ) {
                        Table[hash_value][0] = keys[i];
                        Table[hash_value][1] = probes;
    
                        break;
                    }
                    j++;
                    probes++;
                }
                if(j > 50){
                    System.out.println("Unable to hash key " + keys[i] + " to the table ");
                }
            }
        }

        for(int hash_value = 0;hash_value<50;hash_value++){
            if(Table[hash_value][0] != -1)
                System.out.println(hash_value + "       " + Table[hash_value][0] + "       " + Table[hash_value][1]);
        }
    }

    
}