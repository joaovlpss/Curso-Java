package sections_17_20.entities;

public class User implements Comparable<User> {
    private String name;
    private Integer id;
    private String ipAddress;

    public User() {
        // Empty constructor
    }

    public User(String name, Integer id, String ipAddress) {
        this.name = name;
        this.id = id;
        this.ipAddress = ipAddress;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        User other = (User) obj;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

    @Override
    public int compareTo(User otherUser) {
        int nameComparison = this.name.compareTo(otherUser.name);
        if (nameComparison != 0) {
            return nameComparison;
        }
        return this.id.compareTo(otherUser.id);
    }

    @Override
    public String toString() {
        return this.name + " (" + this.id + ") from " + this.ipAddress;
    }
}
