package sections_8_16.entities;

public class OutsourcedEmployee extends Employee{
    private double additionalCharge;

    public OutsourcedEmployee(String name, int hours, double valuePerHour, double additionalCharge){
        super(name, hours, valuePerHour);
        this.additionalCharge = additionalCharge;
    }

    @Override
    public double payment(){
        return this.valuePerHour * this.hours + (1.10 * additionalCharge);
    }
}
