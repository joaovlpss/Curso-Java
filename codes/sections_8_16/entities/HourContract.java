package sections_8_16.entities;

import java.time.LocalDate;

public class HourContract {
    private LocalDate date;
    private double valuePerHour;
    private int hours;

    public HourContract(LocalDate date, double valuePerHour, int hours){
        this.date = date;
        this.valuePerHour = valuePerHour;
        this.hours = hours;
    }
    public int getHours(){
        return hours;
    }

    public double getValuePerHour(){
        return valuePerHour;
    }
    
    public LocalDate getDate(){
        return date;
    }

    public double totalValue(){
        return hours * valuePerHour;
    }
}
