package sections_17_20.entities.interfaces;

public interface PaymentService {
    Double paymentFee(Double amount);
    Double interest(Double amount, Integer months);
}
