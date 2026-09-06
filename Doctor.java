/**
 * Doctor.java
 * -----------
 * Represents a hospital doctor. Inherits from Person and adds
 * doctor-specific details like specialization and available time.
 */
public class Doctor extends Person {

    private String specialization;
    private String availableTime;

    public Doctor(String id, String name, int age, String gender,
                  String contact, String specialization, String availableTime) {
        super(id, name, age, gender, contact);
        this.specialization = specialization;
        this.availableTime = availableTime;
    }

    public String getSpecialization() { return specialization; }
    public String getAvailableTime() { return availableTime; }

    @Override
    public String getSummary() {
        return String.format("%s | %s | %s | Age %d | Available: %s",
                getId(), getName(), specialization, getAge(), availableTime);
    }
}
