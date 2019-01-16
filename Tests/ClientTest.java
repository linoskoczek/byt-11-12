import org.junit.Before;
import org.junit.Test;

public class ClientTest {
    private List<Client> clients = new LinkedList<>();

    @Before
    public void setUp() throws Exception {
        clients.add(new Client(
            "Name1", "Surname1",
            LocalDate.of(1996, 3, 15)
        ));
        clients.add(new Client(
            "Name2", "Surname2",
            LocalDate.of(1997, 8, 5)
        ));
        clients.add(new Client(
            "Name3", "Surname3",
            LocalDate.of(1993, 9, 22)
		));
    }

    @Test
    public void getListOfClients() {
		assertEquals(3, Client.getListOfClients().size());
    }

    @Test
    public void getAppointments() {
		// TODO: what to test yo
    }
}
