/**
 * Appointment.java
 * ----------------
 * Represents a booking that links one Patient with one Doctor at a
 * given date and time. This is COMPOSITION: an Appointment "has a"
 * Patient and "has a" Doctor, rather than inheriting from them.
 */
public class Appointment {

    private String id;
    private Patient patient;
    private Doctor doctor;
    private String date; // format: YYYY-MM-DD
    private String time; // format: HH:MM (24-hour)
    private String reason;
    private String status; // "Booked", "Completed", or "Cancelled"

    public Appointment(String id, Patient patient, Doctor doctor,
                        String date, String time, String reason, String status) {
        this.id = id;
        this.patient = patient;
        this.doctor = doctor;
        this.date = date;
        this.time = time;
        this.reason = reason;
        this.status = status;
    }

    public String getId() { return id; }
    public Patient getPatient() { return patient; }
    public Doctor getDoctor() { return doctor; }
    public String getDate() { return date; }
    public String getTime() { return time; }
    public String getReason() { return reason; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public String getSummary() {
        return String.format("%s | %-18s -> %-20s | %s %s | %-12s | %s",
                id, patient.getName(), doctor.getName(), date, time, reason, status);
    }
}
