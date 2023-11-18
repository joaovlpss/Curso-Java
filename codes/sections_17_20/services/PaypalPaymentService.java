package sections_17_20.services;

import sections_17_20.entities.interfaces.PaymentService;

public class PaypalPaymentService implements PaymentService{
    public Double paymentFee(Double amount) {
        return amount * 0.02;
    }

    public Double interest(Double amount, Integer months) {
        return amount * 0.01 * months;
    }
}
