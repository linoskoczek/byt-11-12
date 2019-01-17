import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class AgentTest {
    private List<Agent> agents = new LinkedList<>();

    @Before
    public void setUp() throws Exception {
        agents.add(new Agent(
            "Name1", "Surname1",
            LocalDate.of(1996, 3, 15),
            "Some dentist dude.", Specialization.DENTIST
        ));
        agents.add(new Agent(
            "Name2", "Surname2",
            LocalDate.of(1997, 8, 5),
            "Some orthopedist dude.", Specialization.ORTHOPEDIST
        ));
        agents.add(new Agent(
                "Name3", "Surname3",
                LocalDate.of(1993, 9, 22),
                "Some pediatrician dude.", Specialization.PEDIATRICIAN
        ));
    }

    @After
    public void tearDown(){
        Agent.getListOfAgents().clear();
    }

    @Test
    public void getListOfAgents() {
        List<Agent> otherAgents = Agent.getListOfAgents();
        assertEquals(agents.size(), otherAgents.size());
    }

    @Test
    public void getWorkingHours() {
    }

    @Test
    public void getDescription() {
        assertEquals("Some dentist dude.", agents.get(0).getDescription());
        assertEquals("Some orthopedist dude.", agents.get(1).getDescription());
        assertEquals("Some pediatrician dude.", agents.get(2).getDescription());
    }

    @Test
    public void getSpecialization() {
        assertEquals(Specialization.DENTIST, agents.get(0).getSpecialization());
        assertEquals(Specialization.ORTHOPEDIST, agents.get(1).getSpecialization());
        assertEquals(Specialization.PEDIATRICIAN, agents.get(2).getSpecialization());
    }

    @Test
    public void setDescription() {
        agents.get(0).setDescription("Some pediatrician dude.");
        assertEquals("Some pediatrician dude.", agents.get(2).getDescription());
    }

    @Test
    public void setSpecialization() {
        agents.get(0).setSpecialization(Specialization.PEDIATRICIAN);
        assertEquals(Specialization.PEDIATRICIAN, agents.get(0).getSpecialization());
    }
}
