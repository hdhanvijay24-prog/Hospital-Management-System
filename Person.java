/**
 * Person.java
 * -----------
 * Abstract base class for anyone in the hospital system who has a name,
 * age, gender, and contact number. Both Patient and Doctor inherit from
 * this class, which demonstrates OOP INHERITANCE and ABSTRACTION.
 */
public abstract class Person {

    // Fields are private -> ENCAPSULATION (accessed only through getters/setters)
    private String id;
    private String name;
    private int age;
    private String gender;
    private String contact;

    public Person(String id, String name, int age, String gender, String contact) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.contact = contact;
    }

    // ----- Getters -----
    public String getId() { return id; }
    public String getName() { return name; }
    public int getAge() { return age; }
    public String getGender() { return gender; }
    public String getContact() { return contact; }

    // ----- Setters -----
    public void setName(String name) { this.name = name; }
    public void setAge(int age) { this.age = age; }
    public void setGender(String gender) { this.gender = gender; }
    public void setContact(String contact) { this.contact = contact; }

    /**
     * Abstract method: every subclass MUST provide its own way of
     * describing itself. This is POLYMORPHISM -> each subclass
     * (Patient, Doctor) prints different details when this is called.
     */
    public abstract String getSummary();

    // Common toString used as a fallback / for quick debugging
    @Override
    public String toString() {
        return String.format("ID: %-6s Name: %-20s Age: %-3d Gender: %-6s Contact: %s",
                id, name, age, gender, contact);
    }
}
