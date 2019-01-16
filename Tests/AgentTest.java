import org.junit.Before;
import org.junit.Test;

public class AgentTest {
    private List<Agent> agents = new LinkedList<>();

    @Before
    public void setUp() throws Exception {
        agents.add(new Agent(
            "Name1", "Surname1",
            LocalDate.of(1996, 3, 15),
            "Some dentist dude.", DENTIST
        ));
        agents.add(new Agent(
            "Name2", "Surname2",
            LocalDate.of(1997, 8, 5),
            "Some orthopedist dude.", ORTHOPEDIST
        ));
        agents.add(new Agent(
            "Name3", "Surname3",
            LocalDate.of(1993, 9, 22),
            "Some pediatrician dude.", PEDIATRICIAN
        ));
    }

    @Test
    public void getListOfAgents() {
        List<Agent> otherAgents = Agent.getListOfAgents();
        assertEquals(3, otherAgents.size());
    }

    @Test
    public void getWorkingHours() {
    }

    @Test
    public void getDescription() {
        assertEquals("Some dentist dude.", agents[0].getDescription());
        assertEquals("Some orthopedist dude.", agents[1].getDescription());
        assertEquals("Some pediatrician dude.", agents[2].getDescription());
    }

    @Test
    public void getSpecialization() {
        assertEquals(DENTIST, agents[0].getSpecialization());
        assertEquals(ORTHOPEDIST, agents[1].getSpecialization());
        assertEquals(PEDIATRICIAN, agents[2].getSpecialization());
    }

    @Test
    public void setDescription() {
        agents[0].setDescription("Some pediatrician dude.");
        assertEquals("Some pediatrician dude.", agents[0].getDescription());
    }

    @Test
    public void setSpecialization() {
        agents[0].setSpecialization(PEDIATRICIAN);
        assertEquals(PEDIATRICIAN, agents[0].getSpecialization());
    }
}
