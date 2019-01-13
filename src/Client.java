import Exceptions.InvalidBirthDateException;
import Exceptions.InvalidNameOrSurnameException;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Client extends Person {
    private static List<Person> clients = new LinkedList<>();
    private List<Appointment> appointments = new ArrayList<>();

    public Client(String name, String surname, LocalDate birthdate) throws InvalidBirthDateException, InvalidNameOrSurnameException {
        super(name, surname, birthdate);
        clients.add(this);
    }

    public static List<Person> getListOfClients() {
        return clients;
    }

    public List<Appointment> getAppointments() {
        return appointments;
    }
}
