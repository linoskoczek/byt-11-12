import Exceptions.InvalidBirthDateException;
import Exceptions.InvalidNameOrSurnameException;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

enum Specialization {
    DENTIST,
    ORTHOPEDIST,
    PEDIATRICIAN
}

public class Agent extends Person {
    private static List<Agent> agents = new LinkedList<>();
    private List<WorkingHours> workingHours = new ArrayList<>();

    private String description;
    private Specialization specialization;

    public Agent(String name, String surname, LocalDate birthdate, String description, Specialization specialization) throws InvalidBirthDateException, InvalidNameOrSurnameException {
        super(name, surname, birthdate);
        setSpecialization(specialization);
        setDescription(description);
        agents.add(this);
    }

    public static List<Agent> getListOfAgents() {
        return agents;
    }

    public List<WorkingHours> getWorkingHours() {
        return workingHours;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Specialization getSpecialization() {
        return specialization;
    }

    public void setSpecialization(Specialization specialization) {
        this.specialization = specialization;
    }
}
