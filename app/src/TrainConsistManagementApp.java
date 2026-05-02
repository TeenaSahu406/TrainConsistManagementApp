// Train Consist Management App - UC15

// Custom Runtime Exception
class CargoSafetyException extends RuntimeException {
    public CargoSafetyException(String message) {
        super(message);
    }
}

// GoodsBogie Class
class GoodsBogie {
    private String bogieId;
    private String shape; // Rectangular or Cylindrical
    private String cargo;

    public GoodsBogie(String bogieId, String shape) {
        this.bogieId = bogieId;
        this.shape = shape;
    }

    public void assignCargo(String cargoType) {
        try {
            System.out.println("\nAttempting to assign " + cargoType + " to " + shape + " bogie...");

            // Validation logic
            if (shape.equalsIgnoreCase("Rectangular") &&
                cargoType.equalsIgnoreCase("Petroleum")) {

                throw new CargoSafetyException(
                    "Unsafe Assignment! Petroleum cannot be loaded in Rectangular bogie."
                );
            }

            // Safe assignment
            this.cargo = cargoType;
            System.out.println("Cargo assigned successfully: " + cargoType);

        } catch (CargoSafetyException e) {
            // Handle exception
            System.out.println("Error: " + e.getMessage());

        } finally {
            // Always executes
            System.out.println("Assignment process completed for Bogie ID: " + bogieId);
        }
    }

    public String getCargo() {
        return cargo;
    }
}

// Main Class
public class TrainConsistManagementApp {
    public static void main(String[] args) {

        // Create bogies
        GoodsBogie bogie1 = new GoodsBogie("GB1", "Cylindrical");
        GoodsBogie bogie2 = new GoodsBogie("GB2", "Rectangular");

        // Safe assignment
        bogie1.assignCargo("Petroleum");

        // Unsafe assignment (exception handled)
        bogie2.assignCargo("Petroleum");

        // Program continues
        bogie2.assignCargo("Grain");

        // Final check
        System.out.println("\nFinal Cargo in GB2: " + bogie2.getCargo());
    }
}