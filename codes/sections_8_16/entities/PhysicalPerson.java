package sections_8_16.entities;

public class PhysicalPerson extends Person {
    static final double TAXATION_LIMIT = 20000.00;

    private double healthExpenses;

    public PhysicalPerson(double healthExpenses, double annualIncome, String name){
        super(name, annualIncome);
        this.healthExpenses = healthExpenses;
    }

    public double getHealthExpenses(){
        return healthExpenses;
    }
    
    public void setHealthExpenses(double healthExpenses){
        this.healthExpenses = healthExpenses;
    }

    public double taxes(){
        if (annualIncome <= TAXATION_LIMIT){
            if(healthExpenses != 0.00){
                return (annualIncome * 15 / 100) - (healthExpenses * 0.5);
            }
            else {
                return (annualIncome * 15 / 100);
            }
        }
        else {
            if(healthExpenses != 0.00){
                return (annualIncome * 25 / 100) - (healthExpenses * 0.5);
            }
            else {
                return (annualIncome * 25 / 100);
            }
        }
    }
}
