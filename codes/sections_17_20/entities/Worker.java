package sections_17_20.entities;

public class Worker implements Comparable<Worker> {
    private String name;
    private Double salary;

    public Worker() {
    }
    
    public Worker(String name, Double salary) {
        this.name = name;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    @Override
    public int compareTo(Worker other) {
        return this.salary.compareTo(other.getSalary());
    }
}
