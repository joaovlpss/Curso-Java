package sections_8_16.entities;

public class Employee {
    protected String name;
    protected int hours;
    protected double valuePerHour;

    public Employee(String name, int hours, double valuePerHour){
        this.name = name;
        this.hours = hours;
        this.valuePerHour = valuePerHour;
    }

    public String getName(){
        return name;
    }

    public int getHours(){
        return hours;
    }

    public double getValuePerHour(){
        return valuePerHour;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setHours(int hours){
        this.hours = hours;
    }

    public void setValuePerHour(double valuePerHour){
        this.valuePerHour = valuePerHour;
    }

    public double payment(){
        return hours * valuePerHour;
    }
}
