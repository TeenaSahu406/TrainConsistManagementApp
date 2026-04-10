import java.util.*;
import java.util.stream.Collectors;

class Bogie {
    String type;
    int capacity;

    public Bogie(String type, int capacity) {
        this.type = type;
        this.capacity = capacity;
    }

    @Override
    public String toString() {
        return "Capacity: " + capacity;
    }
}

public class TrainConsistManagementApp {

    public static void main(String[] args) {

        System.out.println("=== Train Consist Management App ===");

        // Reuse list from UC7/UC8
        List<Bogie> bogies = new ArrayList<>();

        bogies.add(new Bogie("Sleeper", 72));
        bogies.add(new Bogie("AC Chair", 60));
        bogies.add(new Bogie("First Class", 50));
        bogies.add(new Bogie("Sleeper", 80));
        bogies.add(new Bogie("AC Chair", 65));

        System.out.println("\nAll Bogies:");
        bogies.forEach(b -> 
            System.out.println("Type: " + b.type + ", Capacity: " + b.capacity)
        );

        // =========================
        // ✅ UC9: Grouping
        // =========================
        System.out.println("\nGrouped Bogies by Type:");

        Map<String, List<Bogie>> groupedBogies =
                bogies.stream()
                      .collect(Collectors.groupingBy(b -> b.type));

        // Print grouped result
        for (Map.Entry<String, List<Bogie>> entry : groupedBogies.entrySet()) {

            System.out.println("\nBogie Type: " + entry.getKey());

            for (Bogie b : entry.getValue()) {
                System.out.println("  Capacity: " + b.capacity);
            }
        }
    }
}