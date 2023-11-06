package sections_8_16.entities;

public class JuridicPerson extends Person{

    static final double TAXATION_PERCENT = 16.0;

    private int employeeCount;

    public JuridicPerson(String name, double annualIncome, int employeeCount){
        super(name, annualIncome);
        this.employeeCount = employeeCount;
    }

    public double taxes(){
        if(employeeCount > 10){
            return (annualIncome * (TAXATION_PERCENT - 2.00));
        }
        else {
            return (annualIncome * TAXATION_PERCENT);
        }
    }
    
}
