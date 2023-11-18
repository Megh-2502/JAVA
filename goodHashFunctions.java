import java.util.Scanner;
import java.util.Random;

// Hashing: 

/*
 * Hashing is a technique of mapping  a large set of arbitrary data to tabular indexes using a hash function.
 * A hash function is used for mapping each element of a dataset to indexes in the table.
 */

// Implementation of Hashing

/*
 *  --> Division Remainder Method.
 *  --> Multiplication Method.
 *  --> Mid-Square Hash. 
 */

class goodHashFunction {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;
        do {
            System.out.println("\t\t\t\t======================================================================");
            System.out.println("");
            System.out.println("\t\t\t\t\t\t\t1. Division Remainder Method");
            System.out.println("\t\t\t\t\t\t\t2. Multiplication Method");
            System.out.println("\t\t\t\t\t\t\t3. MidSquare Method");
            System.out.println("\t\t\t\t\t\t\t4. Exit");
            System.out.print("\t\t\t\t\t\t\tEnter your choice: ");
            choice = sc.nextInt();
            System.out.println("");
            System.out.println("\t\t\t\t======================================================================");
            switch (choice) {
                case 1:
                    System.out.println("\t\t\t\t\t\t\tDivision Remainder Method");
                    divisionRemainder();
                    break;
                case 2:
                    System.out.println("\t\t\t\t\t\t\tMultiplication Method");
                    multiplicationHash();
                    break;
                case 3:
                    System.out.println("\t\t\t\t\t\t\tMidSquare Method");
                    midSquare();
                    break;
                case 4:
                    System.out.println("\t\t\t\t\t\t\tExiting....");
                    System.out.println();
                    System.out.println();
                    System.out
                            .println("\t\t\t\t-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-x-");
                    break;

                default:
                    break;
            }
        } while (choice != 4);
    }

    static void divisionRemainder() {
        Scanner sc = new Scanner(System.in);
        System.out.print("\t\t\t\t\t\t\tEnter size of hashTable: ");
        int table_size = sc.nextInt();
        int hashTable[] = new int[table_size];
        for (int i = 0; i < table_size; i++) {
            hashTable[i] = -1;
        }
        System.out.print("\t\t\t\t\t\t\tHow many key you want to enter: ");
        int nkey = sc.nextInt();
        if (nkey > table_size) {
            System.out.println("\t\t\t\t\t\t\tInvalid");
            return;
        } else {
            for (int i = 0; i < nkey; i++) {
                System.out.println("");
                System.out.print("\t\t\t\t\t\t\tEnter Key: ");
                int key = sc.nextInt();
                int index = key % table_size;
                while (hashTable[index] != -1) {
                    index = (index + 1) % table_size;
                }
                hashTable[index] = key;
            }
        }
        System.out.println("");
        System.out.println("\t\t\t\t\t\t\tHash Table:");
        for (int i = 0; i < hashTable.length; i++) {
            if (hashTable[i] != -1) {
                System.out.println("\t\t\t\t\t\t\tIndex " + i + ": " + hashTable[i]);
            } else {
                System.out.println("\t\t\t\t\t\t\tIndex " + i + ": Empty");
            }
        }
    }

    /*
     * Division Remainder Method
     * Enter size of hashTable: 5
     * How many key you want to enter: 4
     * 
     * Enter Key: 25
     * Enter Key: 60
     * Enter Key: 15
     * Enter Key: 2
     * 
     * Hash Table:
     * Index 0: 25
     * Index 1: 60
     * Index 2: 15
     * Index 3: 2
     * Index 4: Empty
     */

    static void multiplicationHash() {
        Scanner sc = new Scanner(System.in);
        System.out.print("\t\t\t\t\t\t\tEnter size of hashTable: ");
        int table_size = sc.nextInt();
        int hashTable[] = new int[table_size];
        for (int i = 0; i < table_size; i++) {
            hashTable[i] = -1;
        }
        System.out.print("\t\t\t\t\t\t\tHow many key you want to enter: ");
        int nkey = sc.nextInt();
        if (nkey > table_size) {
            System.out.println("\t\t\t\t\t\t\tInvalid");
            return;
        } else {
            Random random_val = new Random();
            double random = random_val.nextDouble(0, 1);
            for (int i = 0; i < nkey; i++) {
                System.out.print("\t\t\t\t\t\t\tEnter Key: ");
                int key = sc.nextInt();
                System.out.println();
                int index = (int) (table_size * ((key * random) % 1));
                while (hashTable[index] != -1) {
                    index = (index + 1) % table_size;
                }
                hashTable[index] = key;
            }
        }
        System.out.println("");
        System.out.println("\t\t\t\t\t\t\tHash Table:");
        for (int i = 0; i < hashTable.length; i++) {
            if (hashTable[i] != -1) {
                System.out.println("\t\t\t\t\t\t\tIndex " + i + ": " + hashTable[i]);
            } else {
                System.out.println("\t\t\t\t\t\t\tIndex " + i + ": Empty");
            }
        }
    }

    /*
     * Multiplication Method
     * Enter size of hashTable: 5
     * How many key you want to enter: 4
     * 
     * Enter Key: 25
     * Enter Key: 60
     * Enter Key: 15
     * Enter Key: 2
     * 
     * Hash Table:
     * Index 0: 25
     * Index 1: 2
     * Index 2: Empty
     * Index 3: 60
     * Index 4: 15
     */

    static void midSquare() {
        Scanner sc = new Scanner(System.in);
        System.out.print("\t\t\t\t\t\t\tEnter size of hashTable: ");
        int table_size = sc.nextInt();
        int hashTable[] = new int[table_size];
        for (int i = 0; i < table_size; i++) {
            hashTable[i] = -1;
        }
        System.out.print("\t\t\t\t\t\t\tHow many key you want to enter: ");
        int nkey = sc.nextInt();
        if (nkey > table_size) {
            System.out.println("\t\t\t\t\t\t\tInvalid");
            return;
        } else {
            for (int i = 0; i < nkey; i++) {
                System.out.print("\t\t\t\t\t\t\tEnter Key: ");
                int key = sc.nextInt();
                long square_Key = (long) key * key;
                // System.out.println(square_Key);
                String string_sq_Key = Long.toString(square_Key);
                // System.out.println(string_sq_Key);
                int length = string_sq_Key.length();
                int index = 0;
                if (length > 5) {
                    int middle_Index = (int) length / 2;
                    String middle_Elements = string_sq_Key.substring(middle_Index - 1, middle_Index + 2);
                    index = Integer.parseInt(middle_Elements);
                    //System.out.println("Element " + key + " is at : " + index+ " index");
                     System.out.println("\t\t\t\t\t\t\tIndex " + index + ": " + key);
                    while (hashTable[index] != -1) {
                        index = (index + 1) % table_size;
                    }
                    hashTable[index] = key;
                } else {
                    index = (int) string_sq_Key.length() / 2;
                    // System.out.println("Index is : " + index);
                    while (hashTable[index] != -1) {
                        index = (index + 1) % table_size;
                    }
                    hashTable[index] = key;
                    System.out.println("");
                    System.out.println("\t\t\t\t\t\t\tHash Table:");
                    for (int k = 0; i < hashTable.length; i++) {
                        if (hashTable[k] != -1) {
                            System.out.println("\t\t\t\t\t\t\tIndex " + k + ": " + hashTable[i]);
                        } else {
                            System.out.println("\t\t\t\t\t\t\tIndex " + k + ": Empty");
                        }
                    }
                }
            }
        }
    }
    
    /*
     * MidSquare Method
     * Enter size of hashTable: 5
     * How many key you want to enter: 4
     * Enter Key: 25
     * Enter Key: 60
     * Enter Key: 15
     * Enter Key: 2
     * 
     * Hash Table:
     * Index 0: 2
     * Index 1: 25
     * Index 2: 60
     * Index 3: 15
     * Index 4: Empty
     */
}