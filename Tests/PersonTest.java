import org.junit.Before;
import org.junit.Test;

public class PersonTest {
    private Person person;

    @Before
    public void setUp() throws Exception {
        person = new Person("Name", "Surname", LocalDate.of(1996, 3, 15);
    }

    @Test
    public void setName() {
        person.setName("NewName");
        assertEquals("NewName", person.getName());
    }

    @Test
    public void setSurname() {
        person.setSurname("NewSurname");
        assertEquals("NewSurname", person.getSurname());
    }

    @Test
    public void setBirthdate() {
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
