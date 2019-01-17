import Exceptions.InvalidBirthDateException;
import Exceptions.InvalidNameOrSurnameException;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;

import static org.junit.Assert.assertEquals;

public class PersonTest {
    private Person person;

    @Before
    public void setUp() throws Exception {
        person = new Client("Name", "Surname", LocalDate.of(1996, 3, 15));
    }

    @Test
    public void setName() throws InvalidNameOrSurnameException {
        person.setName("NewName");
        assertEquals("NewName", person.getName());
    }

    @Test
    public void setSurname() throws InvalidNameOrSurnameException {
        person.setSurname("NewSurname");
        assertEquals("NewSurname", person.getSurname());
    }

    @Test
    public void setBirthdate() throws InvalidBirthDateException {
        LocalDate newDate = LocalDate.of(1990, 3, 15);
        person.setBirthdate(newDate);
        assertEquals(newDate, person.getBirthdate());
    }

    @Test
    public void getName() {
        assertEquals("Name", person.getName());
    }

    @Test
    public void getSurname() {
        assertEquals("Surname", person.getSurname());
    }

    @Test
    public void getBirthdate() {
        assertEquals(LocalDate.of(1996, 3, 15), person.getBirthdate());
    }
}
