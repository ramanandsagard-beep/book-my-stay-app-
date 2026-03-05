/**
 * Book My Stay application covering multiple use cases in one file.
 *
 * @author Admin
 * @version 2.1
 */
public class BookMyStayApp {

    public static void main(String[] args) {
        runUseCase1();
        System.out.println();
        runUseCase2();
    }

    private static void runUseCase1() {
        System.out.println("Use Case 1: Application Entry & Welcome Message");
        System.out.println("Welcome to Book My Stay");
        System.out.println("Application: Hotel Booking Management System");
        System.out.println("Version: v1.0");
    }

    private static void runUseCase2() {
        Room single = new SingleRoom();
        Room doubleRoom = new DoubleRoom();
        Room suite = new SuiteRoom();

        int singleAvailability = 10;
        int doubleAvailability = 6;
        int suiteAvailability = 2;

        System.out.println("Use Case 2: Basic Room Types & Static Availability");
        System.out.println("Application: Hotel Booking Management System");
        System.out.println("Version: v2.1");
        System.out.println("Available Room Types:");

        printRoomDetails(single, singleAvailability);
        printRoomDetails(doubleRoom, doubleAvailability);
        printRoomDetails(suite, suiteAvailability);
    }

    private static void printRoomDetails(Room room, int availability) {
        System.out.println("----------------------------------------");
        System.out.println("Type: " + room.getType());
        System.out.println("Beds: " + room.getBeds());
        System.out.println("Size: " + room.getSizeSqFt() + " sq ft");
        System.out.println("Price: $" + room.getPricePerNight() + " per night");
        System.out.println("Availability: " + availability);
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
