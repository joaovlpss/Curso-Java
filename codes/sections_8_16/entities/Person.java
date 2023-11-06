package sections_8_16.entities;

public abstract class Person {
    protected String name;
    protected double annualIncome;
    
    public Person(String name, double annualIncome){
        this.name = name;
        this.annualIncome = annualIncome;
    }
    
    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public double getAnnualIncome(){
        return annualIncome;
    }

    public void setAnnualIncome(double annualIncome){
        this.annualIncome = annualIncome;
    }

    public abstract double taxes();
}
