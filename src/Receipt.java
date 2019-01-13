import Exceptions.PriceLowerThanZeroException;

import java.math.BigDecimal;
import java.time.LocalDateTime;

enum PaymentMethod {
    CASH,
    CARD
}

public class Receipt {
    private BigDecimal price;
    private boolean isPaid;
    private PaymentMethod paymentMethod;
    private LocalDateTime time;

    public Receipt(BigDecimal price, PaymentMethod method) throws PriceLowerThanZeroException {
        setPrice(price);
        this.time = LocalDateTime.now();
        paymentMethod = method;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) throws PriceLowerThanZeroException {
        if (!price.abs().equals(price)) throw new PriceLowerThanZeroException();
        this.price = price;
    }

    public PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public boolean isPaid() {
        return isPaid;
    }

    public void setPaid(boolean paid) {
        isPaid = paid;
    }
}
