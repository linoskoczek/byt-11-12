import org.junit.Before;
import org.junit.Test;

public class ReceiptTest {
    private Receipt receiptCash;
    private Receipt receiptCard;

    @Before
    public void setUp() throws Exception {
        receiptCash = new Receipt(new BigDecimal(100), CASH);
        receiptCard = new Receipt(new BigDecimal(200), CARD);
    }

    @Test
    public void getPrice() {
        assertEquals(new BigDecimal(100), receiptCash.getPrice());
        assertEquals(new BigDecimal(200), receiptCard.getPrice());
    }

    @Test
    public void setPrice() {
        receiptCard.setPrice(new BigDecimal(300));
        assertEquals(new BigDecimal(300), receiptCard.getPrice());
    }

    @Test
    public void getPaymentMethod() {
        assertEquals(CASH, receiptCash.getPaymentMethod());
        assertEquals(CARD, receiptCard.getPaymentMethod());
    }

    @Test
    public void getTime() {
        assertEquals(LocalDateTime.now(), receiptCash.getTime());
        assertEquals(LocalDateTime.now(), receiptCard.getTime());
    }

    @Test
    public void isPaid() {
        assertFalse(receiptCash.isPaid());
        assertFalse(receiptCard.isPaid());
    }

    @Test
    public void setPaymentMethod() {
        receiptCash.setPaymentMethod(CARD);
        assertEquals(CARD, receiptCash.getPaymentMethod())
    }

    @Test
    public void setPaid() {
        receiptCash.setPaid(true);
        assertTrue(receiptCash.isPaid());
    }
}
