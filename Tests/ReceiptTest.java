import Exceptions.PriceLowerThanZeroException;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

import static org.junit.Assert.*;

public class ReceiptTest {
    private Receipt receiptCash;
    private Receipt receiptCard;
    LocalDateTime testInitTime;

    @Before
    public void setUp() throws Exception {
        receiptCash = new Receipt(new BigDecimal(100), PaymentMethod.CASH);
        receiptCard = new Receipt(new BigDecimal(200), PaymentMethod.CARD);
        testInitTime = LocalDateTime.now();
    }

    @Test
    public void getPrice() {
        assertEquals(new BigDecimal(100), receiptCash.getPrice());
        assertEquals(new BigDecimal(200), receiptCard.getPrice());
    }

    @Test
    public void setPrice() throws PriceLowerThanZeroException {
        receiptCard.setPrice(new BigDecimal(300));
        assertEquals(new BigDecimal(300), receiptCard.getPrice());
    }

    @Test(expected = PriceLowerThanZeroException.class)
    public void setPriceException() throws PriceLowerThanZeroException {
        receiptCard.setPrice(new BigDecimal(-300));
        assertEquals(new BigDecimal(-300), receiptCard.getPrice());
    }

    @Test
    public void getPaymentMethod() {
        assertEquals(PaymentMethod.CASH, receiptCash.getPaymentMethod());
        assertEquals(PaymentMethod.CARD, receiptCard.getPaymentMethod());
    }

    @Test
    public void getTime() {
        long nanos = receiptCard.getTime().until(LocalDateTime.now(), ChronoUnit.NANOS);
        assertTrue(nanos < 5000000);
    }

    @Test
    public void isPaid() {
        assertFalse(receiptCash.isPaid());
        assertFalse(receiptCard.isPaid());
    }

    @Test
    public void setPaymentMethod() {
        receiptCash.setPaymentMethod(PaymentMethod.CARD);
        assertEquals(PaymentMethod.CARD, receiptCash.getPaymentMethod());
    }

    @Test
    public void setPaid() {
        receiptCash.setPaid(true);
        assertTrue(receiptCash.isPaid());
    }
}
