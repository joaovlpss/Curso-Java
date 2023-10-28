package sections_1_8.entities;

public class Tenant {
    private String tenantName;
    private String tenantEmail;
    private int tenantAge;
    private Room tenantRoom; 

    public Tenant(String tenantName, String tenantEmail, int tenantAge, Room tenantRoom) {
        this.tenantAge = tenantAge;
        this.tenantName = tenantName;
        this.tenantEmail = tenantEmail;
        this.tenantRoom = tenantRoom;
    }

    public String getTenantEmail() {
        return tenantEmail;
    }

    public String getTenantName() {
        return tenantName;
    }

    public int getTenantAge() {
        return tenantAge;
    }

    public Room getTenantRoom() {
        return tenantRoom;
    }

    // No sets, since these values are supposed to be immutable after initialization.
}
