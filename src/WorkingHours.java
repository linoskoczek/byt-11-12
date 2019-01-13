import javax.management.InvalidAttributeValueException;

public class WorkingHours {
    int weekDay;
    int startingHour;
    int endindHour;

    public WorkingHours(int weekDay, int startingHour, int endindHour) throws InvalidAttributeValueException {
        this.weekDay = weekDay;
        this.startingHour = startingHour;
        this.endindHour = endindHour;

        if (!validateData()) throw new InvalidAttributeValueException("Working hours values are not correct.");
    }

    public boolean validateData() {
        return
                weekDay > 0
                        && weekDay <= 6
                        && startingHour >= 0
                        && startingHour < 24
                        && endindHour <= 24
                        && endindHour > startingHour;
    }
}
