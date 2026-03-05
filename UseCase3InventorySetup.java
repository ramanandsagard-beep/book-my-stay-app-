import java.util.HashMap;
import java.util.Map;

/**
 * Demonstrates centralized room inventory management using HashMap.
 *
 * @author Admin
 * @version 3.0
 */
public class UseCase3InventorySetup {

    public static void main(String[] args) {
        Room single = new SingleRoom();
        Room doubleRoom = new DoubleRoom();
        Room suite = new SuiteRoom();

        RoomInventory inventory = new RoomInventory();
        inventory.registerRoomType(single.getType(), 12);
        inventory.registerRoomType(doubleRoom.getType(), 8);
        inventory.registerRoomType(suite.getType(), 3);

        System.out.println("Welcome to Book My Stay");
        System.out.println("Application: Hotel Booking Management System");
        System.out.println("Version: v3.0");
        System.out.println();
        System.out.println("Initial Inventory:");
        inventory.printInventory();

        inventory.updateAvailability(single.getType(), 10);
        inventory.updateAvailability(doubleRoom.getType(), 7);

        System.out.println();
        System.out.println("Updated Inventory:");
        inventory.printInventory();
    }
}

/**
 * Encapsulates all inventory state and operations.
 */
class RoomInventory {
    private final Map<String, Integer> availabilityByType;

    public RoomInventory() {
        this.availabilityByType = new HashMap<>();
    }

    public void registerRoomType(String roomType, int availableCount) {
        if (availableCount < 0) {
            throw new IllegalArgumentException("Availability cannot be negative.");
        }
        availabilityByType.put(roomType, availableCount);
    }

    public int getAvailability(String roomType) {
        Integer count = availabilityByType.get(roomType);
        return count == null ? 0 : count;
    }

    public void updateAvailability(String roomType, int newCount) {
        if (!availabilityByType.containsKey(roomType)) {
            throw new IllegalArgumentException("Unknown room type: " + roomType);
        }
        if (newCount < 0) {
            throw new IllegalArgumentException("Availability cannot be negative.");
        }
        availabilityByType.put(roomType, newCount);
    }

    public void printInventory() {
        for (Map.Entry<String, Integer> entry : availabilityByType.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
    }
}

abstract class Room {
    private final String type;
    private final int beds;
    private final int sizeSqFt;
    private final double pricePerNight;

    protected Room(String type, int beds, int sizeSqFt, double pricePerNight) {
        this.type = type;
        this.beds = beds;
        this.sizeSqFt = sizeSqFt;
        this.pricePerNight = pricePerNight;
    }

    public String getType() {
        return type;
    }

    public int getBeds() {
        return beds;
    }

    public int getSizeSqFt() {
        return sizeSqFt;
    }

    public double getPricePerNight() {
        return pricePerNight;
    }
}

class SingleRoom extends Room {
    public SingleRoom() {
        super("Single Room", 1, 180, 89.99);
    }
}

class DoubleRoom extends Room {
    public DoubleRoom() {
        super("Double Room", 2, 260, 139.99);
    }
}

class SuiteRoom extends Room {
    public SuiteRoom() {
        super("Suite Room", 3, 420, 249.99);
    }
}
