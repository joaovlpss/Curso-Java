package sections_17_20.services;

import sections_17_20.entities.interfaces.TaxService;

public class BrazilTaxService implements TaxService{
    public Double tax(double amount){
        if(amount <= 100.0){
            return amount * 0.2;
        }else{
            return amount * 0.15;
        }
    }
}
