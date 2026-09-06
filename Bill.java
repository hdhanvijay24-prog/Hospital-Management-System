/**
 * Bill.java
 * ---------
 * Represents an invoice generated for a patient, made up of four
 * charge categories. total() is a computed method, not a stored field,
 * so the total is always accurate even if charges change.
 */
public class Bill {

    private String id;
    private Patient patient;
    private double consultation;
    private double medicine;
    private double test;
    private double room;
    private String status; // "Paid" or "Pending"

    public Bill(String id, Patient patient, double consultation, double medicine,
                double test, double room, String status) {
        this.id = id;
        this.patient = patient;
        this.consultation = consultation;
        this.medicine = medicine;
        this.test = test;
        this.room = room;
        this.status = status;
    }

    public String getId() { return id; }
    public Patient getPatient() { return patient; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public double total() {
        return consultation + medicine + test + room;
    }

    public String getSummary() {
        return String.format("%s | %-18s | Consult: Rs.%-6.0f Med: Rs.%-6.0f Test: Rs.%-6.0f Room: Rs.%-6.0f | Total: Rs.%-8.0f | %s",
                id, patient.getName(), consultation, medicine, test, room, total(), status);
    }
}
