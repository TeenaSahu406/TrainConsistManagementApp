// Custom Exception
class InvalidCapacityException extends Exception {
    public InvalidCapacityException(String message) {
        super(message);
    }
}

// Passenger Bogie Class
class PassengerBogie {

    private String type;
    private int capacity;

    public PassengerBogie(String type, int capacity) throws InvalidCapacityException {

        // Validation (Fail-Fast)
        if (capacity <= 0) {
            throw new InvalidCapacityException("Capacity must be greater than zero");
        }

        this.type = type;
        this.capacity = capacity;
    }

    public String getType() {
        return type;
    }

    public int getCapacity() {
        return capacity;
    }
}

// Main Class
public class TrainConsistManagementApp {

    public static void main(String[] args) {

        System.out.println("=== Train Consist Management App ===");

        try {
            // Valid Bogie
            PassengerBogie b1 = new PassengerBogie("Sleeper", 72);
            System.out.println("Created Bogie: " + b1.getType() + 
                               " | Capacity: " + b1.getCapacity());

            // Invalid Bogie (will throw exception)
            PassengerBogie b2 = new PassengerBogie("AC Chair", 0);

            // This line will NOT execute if exception occurs above
            System.out.println("Created Bogie: " + b2.getType());

        } catch (InvalidCapacityException e) {
            System.out.println("Error: " + e.getMessage());
        }

        System.out.println("Program continues safely...");
    }
}