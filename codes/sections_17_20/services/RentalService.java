package sections_17_20.services;

import java.time.Duration;

import sections_17_20.entities.CarRental;
import sections_17_20.entities.interfaces.TaxService;
import sections_17_20.entities.InVoice;

public class RentalService {
    private Double pricePerHour;
    private Double pricePerDay;

    private TaxService taxService;

    public RentalService() {
    }

    public RentalService(Double pricePerHour, Double pricePerDay, TaxService taxService) {
        this.pricePerHour = pricePerHour;
        this.pricePerDay = pricePerDay;
        this.taxService = taxService;
    }

    public Double getPricePerHour() {
        return pricePerHour;
    }

    public void setPricePerHour(Double pricePerHour) {
        this.pricePerHour = pricePerHour;
    }

    public Double getPricePerDay() {
        return pricePerDay;
    }

    public void setPricePerDay(Double pricePerDay) {
        this.pricePerDay = pricePerDay;
    }

    public TaxService getTaxService() {
        return taxService;
    }

    public void setTaxService(TaxService taxService) {
        this.taxService = taxService;
    }

    public void processInVoice(CarRental carRental){
        double minutes = Duration.between(carRental.getStart(), carRental.getFinish()).toMinutes();
        double hours = minutes / 60.0;

        double basicPayment;
        if(hours <= 12.0){
            basicPayment = Math.ceil(hours) * pricePerHour;
        }else{
            basicPayment = Math.ceil(hours / 24) * pricePerDay;
        }

        double tax = taxService.tax(basicPayment);

        carRental.setInVoice(new InVoice(basicPayment, tax));
    }
}
