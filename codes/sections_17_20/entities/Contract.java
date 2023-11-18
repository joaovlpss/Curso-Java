package sections_17_20.entities;

import java.time.LocalDate;
import java.util.List;
import java.util.ArrayList;


public class Contract {
    private Integer number;
    private LocalDate date;
    private Double totalValue;

    private List<Installment> installments = new ArrayList<>();

    public Contract() {
    }

    public Contract(Integer number, LocalDate date, Double totalValue) {
        this.number = number;
        this.date = date;
        this.totalValue = totalValue;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Double getTotalValue() {
        return totalValue;
    }

    public void setTotalValue(Double totalValue) {
        this.totalValue = totalValue;
    }

    public void addInstallment(Installment installment) {
        installments.add(installment);
    }

    public void removeInstallment(Installment installment) throws IllegalArgumentException {
        if (installments.contains(installment)) {
            installments.remove(installment);
        } else {
            throw new IllegalArgumentException("The installment does not exist.");
        }
    }
    
    public List<Installment> getInstallments() {
        return installments;
    }
    
}
