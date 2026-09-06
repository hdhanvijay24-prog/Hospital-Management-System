/**
 * Patient.java
 * ------------
 * Represents a hospital patient. Inherits shared fields (name, age,
 * gender, contact) from Person and adds patient-specific details.
 */
public class Patient extends Person {

    private String disease;
    private String address;
    private String status; // "Active" or "Discharged"

    public Patient(String id, String name, int age, String gender,
                   String contact, String disease, String address, String status) {
        super(id, name, age, gender, contact); // calls Person's constructor
        this.disease = disease;
        this.address = address;
        this.status = status;
    }

    public String getDisease() { return disease; }
    public String getAddress() { return address; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    // Overriding the abstract method from Person -> POLYMORPHISM
    @Override
    public String getSummary() {
        return String.format("%s | %s | Age %d | %s | Disease: %-12s | Status: %s",
                getId(), getName(), getAge(), getGender(), disease, status);
    }
}
