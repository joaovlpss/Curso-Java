package entities.util;

public class CurrencyConverter {
    public static double conversion = 5.03;

    public static double calculate(Double currency){
        return (conversion * currency) + (6/100 * (conversion*currency));
    }
}
