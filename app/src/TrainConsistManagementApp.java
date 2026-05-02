// Train Consist Management App - UC19
// Binary Search for Bogie ID (with sorting precondition)

import java.util.Arrays;

public class TrainConsistManagementApp {

    // Binary Search Method
    public static boolean binarySearch(String[] bogieIds, String key) {

        // Handle empty array
        if (bogieIds.length == 0) {
            return false;
        }

        // Ensure array is sorted before binary search
        Arrays.sort(bogieIds);

        int low = 0;
        int high = bogieIds.length - 1;

        while (low <= high) {

            int mid = (low + high) / 2;

            // Compare using compareTo()
            int result = key.compareTo(bogieIds[mid]);

            if (result == 0) {
                return true; // Found
            } else if (result < 0) {
                high = mid - 1; // Search left half
            } else {
                low = mid + 1; // Search right half
            }
        }

        return false; // Not found
    }

    public static void main(String[] args) {

        // Test Case 1: Found
        String[] bogies1 = {"BG101","BG205","BG309","BG412","BG550"};
        System.out.println("Search BG309: " + binarySearch(bogies1, "BG309"));

        // Test Case 2: Not Found
        System.out.println("Search BG999: " + binarySearch(bogies1, "BG999"));

        // Test Case 3: First Element
        System.out.println("Search BG101: " + binarySearch(bogies1, "BG101"));

        // Test Case 4: Last Element
        System.out.println("Search BG550: " + binarySearch(bogies1, "BG550"));

        // Test Case 5: Single Element
        String[] single = {"BG101"};
        System.out.println("Search in single array: " + binarySearch(single, "BG101"));

        // Test Case 6: Empty Array
        String[] empty = {};
        System.out.println("Search in empty array: " + binarySearch(empty, "BG101"));

        // Test Case 7: Unsorted Input (auto sorted inside method)
        String[] unsorted = {"BG309","BG101","BG550","BG205","BG412"};
        System.out.println("Search in unsorted array (BG205): " + binarySearch(unsorted, "BG205"));
    }
}