package sections_8_16.entities;

public class Employee {
    public String name;
    public double grossSalary;
    public double tax;

    public double netSalary(){
        return grossSalary - tax;
    }

    public void increaseSalary(double percentage){
        grossSalary += (percentage * grossSalary / 100);
    }
}
