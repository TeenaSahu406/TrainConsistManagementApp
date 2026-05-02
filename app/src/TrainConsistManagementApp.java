// Train Consist Management App - UC16
// Bubble Sort Implementation (No Arrays.sort / Collections.sort)

public class TrainConsistManagementApp {

    // Method to perform Bubble Sort
    public static void bubbleSort(int[] capacities) {
        int n = capacities.length;

        // Outer loop for passes
        for (int i = 0; i < n - 1; i++) {

            // Inner loop for comparison
            for (int j = 0; j < n - i - 1; j++) {

                // Compare adjacent elements
                if (capacities[j] > capacities[j + 1]) {

                    // Swap logic
                    int temp = capacities[j];
                    capacities[j] = capacities[j + 1];
                    capacities[j + 1] = temp;
                }
            }
        }
    }

    // Method to print array
    public static void display(int[] capacities) {
        for (int cap : capacities) {
            System.out.print(cap + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {

        // Test Case 1: Basic unsorted array
        int[] capacities1 = {72, 56, 24, 70, 60};
        System.out.print("Before Sorting: ");
        display(capacities1);

        bubbleSort(capacities1);

        System.out.print("After Sorting:  ");
        display(capacities1);

        // Test Case 2: Already sorted
        int[] capacities2 = {24, 56, 60, 70, 72};
        bubbleSort(capacities2);

        // Test Case 3: Duplicate values
        int[] capacities3 = {72, 56, 56, 24};
        bubbleSort(capacities3);

        // Test Case 4: Single element
        int[] capacities4 = {50};
        bubbleSort(capacities4);

        // Test Case 5: All equal values
        int[] capacities5 = {40, 40, 40};
        bubbleSort(capacities5);
    }
}