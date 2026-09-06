import java.util.ArrayList;
import java.util.List;

/**
 * HospitalService.java
 * ---------------------
 * This is the "backend logic" of the system. It stores all patients,
 * doctors, appointments, and bills in memory (ArrayLists) and provides
 * methods to add, search, and update them.
 *
 * This class mirrors the `state` object and functions in the website's
 * script.js (addPatient, addDoctor, addAppointment, addBill,
 * cancelAppointment, payBill, etc.) so both projects represent the
 * same hospital data model.
 */
public class HospitalService {

    private List<Patient> patients = new ArrayList<>();
    private List<Doctor> doctors = new ArrayList<>();
    private List<Appointment> appointments = new ArrayList<>();
    private List<Bill> bills = new ArrayList<>();

    /** Loads the same demo data used in the website's script.js */
    public void loadSampleData() {
        patients.add(new Patient("P001", "Rahul Sharma", 34, "Male", "9876543210", "Fever", "Nagpur", "Active"));
        patients.add(new Patient("P002", "Priya Patel", 28, "Female", "9823456712", "Migraine", "Nagpur", "Active"));
        patients.add(new Patient("P003", "Amit Verma", 52, "Male", "9765432108", "Diabetes", "Wardha", "Discharged"));
        patients.add(new Patient("P004", "Sneha Joshi", 41, "Female", "9898123456", "Hypertension", "Nagpur", "Active"));

        doctors.add(new Doctor("D001", "Dr. Anjali Mehta", 42, "Female", "9876500011", "Cardiologist", "10:00 AM - 2:00 PM"));
        doctors.add(new Doctor("D002", "Dr. Rohan Deshmukh", 39, "Male", "9876500022", "Neurologist", "11:00 AM - 3:00 PM"));
        doctors.add(new Doctor("D003", "Dr. Neha Kulkarni", 36, "Female", "9876500033", "General Physician", "9:00 AM - 1:00 PM"));

        appointments.add(new Appointment("A001", findPatient("P001"), findDoctor("D001"), "2026-08-21", "10:30", "Follow-up", "Booked"));
        appointments.add(new Appointment("A002", findPatient("P002"), findDoctor("D002"), "2026-08-21", "12:00", "Consultation", "Booked"));
        appointments.add(new Appointment("A003", findPatient("P004"), findDoctor("D003"), "2026-08-22", "09:30", "Check-up", "Booked"));

        bills.add(new Bill("B001", findPatient("P001"), 500, 800, 700, 1000, "Paid"));
        bills.add(new Bill("B002", findPatient("P002"), 500, 450, 900, 0, "Pending"));
        bills.add(new Bill("B003", findPatient("P004"), 600, 700, 500, 1200, "Paid"));
    }

    // ---------------- PATIENTS ----------------

    public boolean addPatient(Patient p) {
        if (findPatient(p.getId()) != null) return false; // duplicate ID
        patients.add(p);
        return true;
    }

    public Patient findPatient(String id) {
        for (Patient p : patients) if (p.getId().equalsIgnoreCase(id)) return p;
        return null;
    }

    public boolean deletePatient(String id) {
        return patients.removeIf(p -> p.getId().equalsIgnoreCase(id));
    }

    public List<Patient> getPatients() { return patients; }

    // ---------------- DOCTORS ----------------

    public boolean addDoctor(Doctor d) {
        if (findDoctor(d.getId()) != null) return false;
        doctors.add(d);
        return true;
    }

    public Doctor findDoctor(String id) {
        for (Doctor d : doctors) if (d.getId().equalsIgnoreCase(id)) return d;
        return null;
    }

    public List<Doctor> getDoctors() { return doctors; }

    // ---------------- APPOINTMENTS ----------------

    /** Returns true if the doctor is already booked at that date+time. */
    public boolean isDoctorBusy(String doctorId, String date, String time) {
        for (Appointment a : appointments) {
            if (a.getDoctor().getId().equalsIgnoreCase(doctorId)
                    && a.getDate().equals(date)
                    && a.getTime().equals(time)
                    && a.getStatus().equals("Booked")) {
                return true;
            }
        }
        return false;
    }

    public String addAppointment(String id, String patientId, String doctorId,
                                  String date, String time, String reason) {
        if (findAppointment(id) != null) return "Appointment ID already exists";
        Patient p = findPatient(patientId);
        Doctor d = findDoctor(doctorId);
        if (p == null) return "Patient not found";
        if (d == null) return "Doctor not found";
        if (isDoctorBusy(doctorId, date, time)) return "Doctor is already booked at this time";

        appointments.add(new Appointment(id, p, d, date, time, reason, "Booked"));
        return null; // null = success
    }

    public Appointment findAppointment(String id) {
        for (Appointment a : appointments) if (a.getId().equalsIgnoreCase(id)) return a;
        return null;
    }

    public boolean cancelAppointment(String id) {
        Appointment a = findAppointment(id);
        if (a == null) return false;
        a.setStatus("Cancelled");
        return true;
    }

    public List<Appointment> getAppointments() { return appointments; }

    // ---------------- BILLING ----------------

    public String addBill(String id, String patientId, double consultation,
                           double medicine, double test, double room) {
        if (findBill(id) != null) return "Bill ID already exists";
        Patient p = findPatient(patientId);
        if (p == null) return "Patient not found";
        bills.add(new Bill(id, p, consultation, medicine, test, room, "Pending"));
        return null;
    }

    public Bill findBill(String id) {
        for (Bill b : bills) if (b.getId().equalsIgnoreCase(id)) return b;
        return null;
    }

    public boolean payBill(String id) {
        Bill b = findBill(id);
        if (b == null) return false;
        b.setStatus("Paid");
        return true;
    }

    public List<Bill> getBills() { return bills; }

    public double totalRevenue() {
        double sum = 0;
        for (Bill b : bills) sum += b.total();
        return sum;
    }

    // ---------------- DASHBOARD STATS ----------------

    public void printDashboard() {
        long activeAppointments = appointments.stream().filter(a -> !a.getStatus().equals("Cancelled")).count();
        long paidBills = bills.stream().filter(b -> b.getStatus().equals("Paid")).count();
        long pendingBills = bills.stream().filter(b -> b.getStatus().equals("Pending")).count();

        System.out.println("\n===== DASHBOARD =====");
        System.out.println("Total Patients     : " + patients.size());
        System.out.println("Total Doctors      : " + doctors.size());
        System.out.println("Active Appointments: " + activeAppointments);
        System.out.println("Total Revenue      : Rs." + String.format("%.0f", totalRevenue()));
        System.out.println("Paid Bills         : " + paidBills);
        System.out.println("Pending Bills      : " + pendingBills);
        System.out.println("======================\n");
    }
}
