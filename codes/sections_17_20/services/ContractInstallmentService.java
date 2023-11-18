package sections_17_20.services;

import sections_17_20.entities.Contract;
import sections_17_20.entities.Installment;
import sections_17_20.entities.interfaces.PaymentService;

public class ContractInstallmentService {

    private Contract contract;
    private PaymentService paymentService;
    private Integer months;

    public ContractInstallmentService(Contract contract, PaymentService paymentService, Integer months){
        this.contract = contract;
        this.paymentService = paymentService;
        this.months = months;
    }

    public void processContract(){
        Double basicQuota = contract.getTotalValue() / months;
        for (int i = 1; i <= months; i++){
            Double updatedQuota = basicQuota + paymentService.interest(basicQuota, i);
            Double fullQuota = updatedQuota + paymentService.paymentFee(updatedQuota);
            contract.addInstallment(new Installment(contract.getDate().plusMonths(i), fullQuota));
        }
    }
}
