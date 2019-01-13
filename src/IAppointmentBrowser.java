import java.time.LocalDateTime;
import java.util.List;
import java.util.TreeSet;

public interface IAppointmentBrowser {
    TreeSet<Appointment> getAppointments();

    List<WorkingHours> getAvailableDates(Agent agent, LocalDateTime from, LocalDateTime to);

    void addAppointment(Appointment appointment);
}
