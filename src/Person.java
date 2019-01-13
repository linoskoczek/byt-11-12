import Exceptions.InvalidBirthDateException;
import Exceptions.InvalidNameOrSurnameException;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.chrono.ChronoLocalDate;

public abstract class Person {
    private String name;
    private String surname;
    private LocalDate birthdate;

    public Person(String name, String surname, LocalDate birthdate) throws InvalidNameOrSurnameException, InvalidBirthDateException {
        setName(name);
        setSurname(surname);
        setBirthdate(birthdate);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) throws InvalidNameOrSurnameException {
        if (name.length() < 1) throw new InvalidNameOrSurnameException();
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) throws InvalidNameOrSurnameException {
        if (surname.length() < 1) throw new InvalidNameOrSurnameException();
        this.surname = surname;
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(LocalDate birthdate) throws InvalidBirthDateException {
        if (birthdate.isAfter(ChronoLocalDate.from(LocalDateTime.now()))) throw new InvalidBirthDateException();
        this.birthdate = birthdate;
    }
}
