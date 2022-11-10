import java.util.Scanner;
import java.util.Arrays;

class test{

    //method that implements the Division method with Linear Probing for collision resolution
    public static void HF1(int key, int hashTable[][]){
//division method
        int n = key % 50;
        int probes = 0;
        int i = n;
//insert the key into the table with Linear Probing
        do{
            if(hashTable[i][0]==0){
                hashTable[i][0] = key;
                break;
            }
            probes++;
            i = (i+1)%50;
        }while(i!=n);
//stores number of probes in the second column of table
        hashTable[i][1] = probes;
    }

    //method that implements the Division method with Quadratic Probing for collision resolution
    public static void HF2(int key, int hashTable[][]){
//division method
        int n = key % 50;
        int probes = 0;
        int i = n, k = 1;
        boolean fg = false;
//insert the key into the table with Quadratic Probing
        do{
            if(hashTable[i][0]==0){
                hashTable[i][0] = key;
                fg = true;
                break;
            }
            probes++;
            i = (n+k*k)%50;
            k++;
        }while(i!=n);

        if(!fg){
            System.out.println ("Unable to store key " + key + " to the table");
            hashTable[i][1] = 0;
        }
        else{
//stores number of probes in the second column of table
            hashTable[i][1] = probes;
        }
    }

    //method that implements the Division method with Double Hashing for collision resolution
    public static void HF3(int key, int hashTable[][]){
//division hashing function
        int n = key % 50;
//second hashing function
        int k = 30 - key % 25;
        int probes = 0;
        int i = n;
        int j = 1;
        boolean fg = false;
//insert the key into the table with Double Hashing
        do{
            if(hashTable[i][0]==0){
                hashTable[i][0] = key;
                fg = true;
                break;
            }
            probes++;
            i = (n+j*k)%50;
            j++;
        }while(i!=n);
        if(!fg){
            System.out.println ("Unable to store key " + key + " to the table");
            hashTable[i][1] = 0;
        }
        else{
//stores number of probes in the second column of table
            hashTable[i][1] = probes;
        }
    }

    //method that implements a folding hash function with Double Hashing for collision resolution
    public static void HF4(int key, int hashTable[][]){
//folding hash function
        int sum = 0, m = key;
        while(m!=0){
            sum += m%100;
            m = m/100;
        }
        int n = sum % 50;
//second hashing function
        int k = 30 - key % 25;
        int probes = 0;
        int i = n;
        int j = 1;
        boolean fg = false;
//insert the key into the table with Double Hashing
        do{
            if(hashTable[i][0]==0){
                hashTable[i][0] = key;
                fg = true;
                break;
            }
            probes++;

            i = (n+j*k)%50;
            j++;
        }while(i!=n);
        if(!fg){
            System.out.println ("Unable to store key " + key + " to the table");
            hashTable[i][1] = 0;
        }
        else{
//stores number of probes in the second column of table
            hashTable[i][1] = probes;
        }
    }

    //method return the sum of all probes in the table
    public static int sumProbes(int table[][]){
        int probes = 0;
        for(int i=0; i<50; i++){
            probes += table[i][1];
        }
        return probes;
    }

    //main method
    public static void main (String[] args){
//create an instance of Scanner class
        Scanner sc = new Scanner(System.in);

//keys
        int[] keys = {1234, 8234, 7867, 1009, 5438, 4312, 3420, 9487, 5418, 5299,
                5078, 8239, 1208, 5098, 5195, 5329, 4543, 3344, 7698, 5412,
                5567, 5672, 7934, 1254, 6091, 8732, 3095, 1975, 3843, 5589,
                5439, 8907, 4097, 3096, 4310, 5298, 9156, 3895, 6673, 7871,
                5787, 9289, 4553, 7822, 8755, 3398, 6774, 8289, 7665, 5523};
//declare the table
        int [][]table = new int[50][2];
        int probes;
        while(true){
//display menu
            System.out.println ("-----MAIN MENU------");
            System.out.println ("0 - Exit Program----");
            System.out.println ("1 - Run HF1 (Division with Linear Probing)");
            System.out.println ("2 - Run HF2 (Division with Quadratic Probing)");
            System.out.println ("3 - Run HF3 (Division with Double Hashing)");
            System.out.println ("4 - Run HF4 (Student-Designed Function)");
            System.out.print ("Enter option (0-4) ");
//read menu option
            int op = sc.nextInt();
//exit from program
            if(op == 0) break;
//initialize the table
            for(int i=0; i<50; i++){
                for(int j=0; j<2; j++){
                    table[i][j] = 0;
                }
            }
//processing
            switch(op){

//Division with Linear Probing
                case 1:
//Double hashing
                    for(int i=0; i<keys.length; i++){
//insert to the hash table
                        HF1(keys[i], table);
                    }
//calculate the sum of probe values
                    probes = sumProbes(table);

//display the hash-table
                    System.out.println ("Index Key probes");
                    System.out.println ("----------------------------");
                    for(int i=0; i<table.length; i++){
                        if(table[i][0]!=0)
                            System.out.printf ("%-10d%-10d%d\n", i, table[i][0], table[i][1]);
                        else
                            System.out.printf ("%-10d%-10s\n", i, "-- Empty --");
                    }
                    System.out.println ("----------------------------");
                    System.out.println ("Sum of probe values = " + probes + " probes");
                    System.out.println ();
                    break;

//Division with Quadratic Probing
                case 2:
//Double hashing
                    for(int i=0; i<keys.length; i++){
//insert to the hash table
                        HF2(keys[i], table);
                    }
//calculate the sum of probe values
                    probes = sumProbes(table);
//display the hash-table
                    System.out.println ("Index Key probes");
                    System.out.println ("----------------------------");
                    for(int i=0; i<table.length; i++){
                        if(table[i][0]!=0)
                            System.out.printf ("%-10d%-10d%d\n", i, table[i][0], table[i][1]);
                        else
                            System.out.printf ("%-10d%-10s\n", i, "-- Empty --");
                    }
                    System.out.println ("----------------------------");
                    System.out.println ("Sum of probe values = " + probes + " probes");
                    System.out.println ();
                    break;

//Division with Double Hashing
                case 3:
//Double hashing
                    for(int i=0; i<keys.length; i++){
//insert to the hash table
                        HF3(keys[i], table);
                    }
//calculate the sum of probe values
                    probes = sumProbes(table);
//display the hash-table
                    System.out.println ("Index Key probes");
                    System.out.println ("----------------------------");
                    for(int i=0; i<table.length; i++){
                        if(table[i][0]!=0)
                            System.out.printf ("%-10d%-10d%d\n", i, table[i][0], table[i][1]);
                        else
                            System.out.printf ("%-10d%-10s\n", i, "-- Empty --");
                    }
                    System.out.println ("----------------------------");
                    System.out.println ("Sum of probe values = " + probes + " probes");
                    System.out.println ();
                    break;

//Own-Designed Function
                case 4:
//Double hashing
                    for(int i=0; i<keys.length; i++){
//insert to the hash table
                        HF4(keys[i], table);
                    }
//calculate the sum of probe values
                    probes = sumProbes(table);
//display the hash-table
                    System.out.println ("Index Key probes");
                    System.out.println ("----------------------------");
                    for(int i=0; i<table.length; i++){
                        if(table[i][0]!=0)
                            System.out.printf ("%-10d%-10d%d\n", i, table[i][0], table[i][1]);
                        else
                            System.out.printf ("%-10d%-10s\n", i, "-- Empty --");
                    }
                    System.out.println ("----------------------------");
                    System.out.println ("Sum of probe values = " + probes + " probes");
                    System.out.println ();
            }//end of switch
            System.out.println ();
        }//end of while loop
    }//end of main
}//end of class
