// Train Consist Management App - UC17
// Sorting Bogie Names using Arrays.sort()

import java.util.Arrays;

public class TrainConsistManagementApp {

    public static void main(String[] args) {

        // Test Case 1: Basic unsorted array
        String[] bogies1 = {"Sleeper", "AC Chair", "First Class", "General", "Luxury"};
        System.out.println("Before Sorting: " + Arrays.toString(bogies1));

        Arrays.sort(bogies1);

        System.out.println("After Sorting:  " + Arrays.toString(bogies1));


        // Test Case 2: Unsorted input
        String[] bogies2 = {"Luxury", "General", "Sleeper", "AC Chair"};
        Arrays.sort(bogies2);
        System.out.println("Sorted (Unsorted Input): " + Arrays.toString(bogies2));


        // Test Case 3: Already sorted
        String[] bogies3 = {"AC Chair", "First Class", "General"};
        Arrays.sort(bogies3);
        System.out.println("Sorted (Already Sorted): " + Arrays.toString(bogies3));


        // Test Case 4: Duplicate bogie names
        String[] bogies4 = {"Sleeper", "AC Chair", "Sleeper", "General"};
        Arrays.sort(bogies4);
        System.out.println("Sorted (Duplicates): " + Arrays.toString(bogies4));


        // Test Case 5: Single element
        String[] bogies5 = {"Sleeper"};
        Arrays.sort(bogies5);
        System.out.println("Sorted (Single Element): " + Arrays.toString(bogies5));
    }
}