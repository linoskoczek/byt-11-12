import java.time.LocalDateTime;
import java.util.List;
import java.util.TreeSet;

public class FakeAppointmentBrowser implements IAppointmentBrowser {
    private TreeSet<Appointment> appointments = new TreeSet<>();

    @Override
    public TreeSet<Appointment> getAppointments() {
        return appointments;
    }

    @Override
    /* STUB METHOD
       does not care about already booked dates
    */
    public List<WorkingHours> getAvailableDates(Agent agent, LocalDateTime from, LocalDateTime to) {
        return agent.getWorkingHours();
    }

    @Override
    /* STUB METHOD
       does not care about already booked dates
    */
    public void addAppointment(Appointment appointment) {
        appointments.add(appointment);
    }
}
