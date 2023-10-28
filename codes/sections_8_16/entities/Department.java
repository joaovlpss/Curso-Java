package sections_8_16.entities;

public class Department {
    private String depName;

    public Department(String name){
        depName = name;
    }

    public String getDepName(){
        return depName;
    }
    
    public void setDepName(String newName){
        depName = newName;
    }
}
