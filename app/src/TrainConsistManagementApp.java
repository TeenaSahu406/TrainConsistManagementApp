// Train Consist Management App - UC20
// Exception Handling During Search Operations (Fail-Fast)

import java.util.Arrays;

public class TrainConsistManagementApp {

    // Search method with validation
    public static boolean searchBogie(String[] bogieIds, String key) {

        // ✅ Fail-fast validation
        if (bogieIds == null || bogieIds.length == 0) {
            throw new IllegalStateException("No bogies available in the train. Cannot perform search.");
        }

        // (Optional) Using Binary Search logic after validation
        Arrays.sort(bogieIds);

        int low = 0;
        int high = bogieIds.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;

            int result = key.compareTo(bogieIds[mid]);

            if (result == 0) {
                return true; // Found
            } else if (result < 0) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return false; // Not found
    }

    public static void main(String[] args) {

        // Test Case 1: Empty array (should throw exception)
        try {
            String[] empty = {};
            System.out.println("Searching in empty array...");
            searchBogie(empty, "BG101");
        } catch (IllegalStateException e) {
            System.out.println("Error: " + e.getMessage());
        }

        // Test Case 2: Valid search allowed
        String[] bogies1 = {"BG101", "BG205"};
        System.out.println("\nSearch BG101: " + searchBogie(bogies1, "BG101"));

        // Test Case 3: Found after validation
        String[] bogies2 = {"BG101", "BG205", "BG309"};
        System.out.println("Search BG205: " + searchBogie(bogies2, "BG205"));

        // Test Case 4: Not found after validation
        System.out.println("Search BG999: " + searchBogie(bogies2, "BG999"));

        // Test Case 5: Single element
        String[] single = {"BG101"};
        System.out.println("Search in single array: " + searchBogie(single, "BG101"));
    }
}