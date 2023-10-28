package sections_1_8.entities;

public class Room {
    private String tenantName;
    private double rent;
    private int roomNumber;

    public Room() {}

    public Room(String tenantName, int roomNumber) {
        this.tenantName = tenantName;
        this.roomNumber = roomNumber;
    }

    public String getName() {
        return tenantName;
    }

    public double getRent() {
        return rent;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public void calculateRent(int tenantAge) {
        if (tenantAge <= 20) {
            this.rent = 50 * tenantAge;
        } else if (tenantAge <= 30) {
            this.rent = 75 * tenantAge;
        } else {
            this.rent = 100 * tenantAge;
        }
    }

    // No sets since these values are to be immutable after initiation.
}
