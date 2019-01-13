import Exceptions.PersonDoesNotExistException;
import Exceptions.PriceLowerThanZeroException;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class Appointment implements Comparable<Appointment> {
    public static IAppointmentBrowser appointmentBrowser = new FakeAppointmentBrowser();

    private Client client;
    private Agent agent;
    private LocalDateTime timeFrom;
    private LocalDateTime timeTo;

    public Appointment(Agent agent, Client client, LocalDateTime timeFrom, LocalDateTime timeTo) throws PersonDoesNotExistException {
        setAgent(agent);
        setClient(client);
        this.timeFrom = timeFrom;
        this.timeTo = timeTo;
        appointmentBrowser.addAppointment(this);
    }

    public Receipt generateRecepit(BigDecimal price, PaymentMethod method) throws PriceLowerThanZeroException {
        return new Receipt(price, method);
    }

    public long getDuration() {
        return timeFrom.until(timeTo, ChronoUnit.MINUTES);
    } //TODO: In tests check if value can be negative.

    public Agent getAgent() {
        return agent;
    }

    private void setAgent(Agent agent) throws PersonDoesNotExistException {
        if (!Agent.getListOfAgents().contains(agent)) throw new PersonDoesNotExistException();
        this.agent = agent;
    }

    private void setClient(Client client) throws PersonDoesNotExistException {
        if (!Client.getListOfClients().contains(client)) throw new PersonDoesNotExistException();
        this.client = client;
    }

    public void setTimeFrom(LocalDateTime timeFrom) {
        this.timeFrom = timeFrom;
    }

    public void setTimeTo(LocalDateTime timeTo) {
        this.timeTo = timeTo;
    }

    @Override
    public int compareTo(Appointment o) {
        return timeFrom.compareTo(o.timeFrom);
    }
}
