import org.junit.Before;
import org.junit.Test;

public class AppointmentTest {
    private Agent agent;
    private Clinet agent;
    private Appointment app1;
    private Appointment app2;

    @Before
    public void setUp() throws Exception {
        agent = new Agent(
            "AgentName", "AgentSurname",
            LocalDate.of(1996, 3, 15),
            "Some dentist dude.", DENTIST
        );
        client = new Client(
            "ClientName", "ClientSurname",
            LocalDate.of(1995, 3, 15),
        );
        app1 = new Appointment(
            agent, client,
            LocalDateTime.of(2019, 3, 22, 15, 0),
            LocalDateTime.of(2019, 3, 22, 16, 0)
        );
        app1 = new Appointment(
            agent, client,
            LocalDateTime.of(2019, 3, 23, 12, 0),
            LocalDateTime.of(2019, 3, 23, 11, 0)
        );
    }

    @Test
    public void generateRecepit() {
        Receipt receipt = app1.generateRecepit(new BigDecimal(100), PaymentMethod.CARD);
        assertEquals(new BigDecimal(100), receipt.getPrice());
        assertEquals(PaymentMethod.CARD, receipt.getPaymentMethod());
    }

    @Test
    public void getDuration() {
        assertEquals(60, app1.getDuration());
        assertEquals(-60, app2.getDuration());

    @Test
    public void getAgent() {
        Agent agent = app1.getAgent();
        assertEquals("AgentName", agent.getName());
    }

    @Test
    public void setTimeFrom() {
        app1.setTimeFrom(LocalDateTime.of(2019, 3, 22, 14, 0));
        assertEquals(120, app1.getDuration());
    }

    @Test
    public void setTimeTo() {
        app1.setTimeTo(LocalDateTime.of(2019, 3, 22, 17, 0));
        assertEquals(120, app1.getDuration());
    }

    @Test
    public void compareTo() {
        assertTrue(app1.compareTo(app2) < 0);
        assertTrue(app2.compareTo(app1) > 0);
    }
}
