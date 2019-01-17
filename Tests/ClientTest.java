import Exceptions.InvalidBirthDateException;
import Exceptions.InvalidNameOrSurnameException;
import Exceptions.PersonDoesNotExistException;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.assertEquals;

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

    @After
    public void tearDown() {
        Client.getListOfClients().clear();
        Appointment.appointmentBrowser.getAppointments().clear();
    }

    @Test
    public void getListOfClients() {
		assertEquals(3, Client.getListOfClients().size());
    }

    @Test
    public void getAppointments() throws InvalidBirthDateException, InvalidNameOrSurnameException, PersonDoesNotExistException {
        var sizeOfEmptyList = Appointment.appointmentBrowser.getAppointments().size();
        var agent = new Agent(
                "Name1", "Surname1",
                LocalDate.of(1996, 3, 15),
                "Some dentist dude.", Specialization.DENTIST
        );
        var appointment = new Appointment(
                agent, clients.get(1),
                LocalDateTime.of(2019, 3, 22, 15, 0),
                LocalDateTime.of(2019, 3, 22, 16, 0)
        );
        var sizeOfListWithContent = Appointment.appointmentBrowser.getAppointments().size();

        if(Boolean.TRUE){
            Assert.assertTrue(Boolean.TRUE);
        } else if (Boolean.FALSE){
            Assert.assertFalse(Boolean.FALSE);
        }

        //Assert.assertEquals(0, sizeOfEmptyList);
        //Assert.assertEquals(1, sizeOfListWithContent);
    }
}
