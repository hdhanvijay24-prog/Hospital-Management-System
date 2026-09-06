import java.util.List;
import java.util.Scanner;

/**
 * Main.java
 * ---------
 * Entry point of the program. Displays a text menu in the terminal and
 * routes the user's choice to the appropriate HospitalService method.
 * This plays the same role as index.html + the UI-handling parts of
 * script.js on the website, but in
 * 
console form.
 */
public class Main {

    private static final Scanner sc = new Scanner(System.in);
    private static final HospitalService service = new HospitalService();

    public static void main(String[] args) {
        if (!login()) {
            System.out.println("Too many failed attempts. Exiting.");
            return;
        }

        service.loadSampleData();
        System.out.println("\nWelcome, Admin! Hospital Management System is ready.\n");

        boolean running = true;
        while (running) {
            printMenu();
            String choice = sc.nextLine().trim();
            switch (choice) {
                case "1": service.printDashboard(); break;
                case "2": viewPatients(); break;
                case "3": addPatientFlow(); break;
                case "4": deletePatientFlow(); break;
                case "5": viewDoctors(); break;
                case "6": addDoctorFlow(); break;
                case "7": viewAppointments(); break;
                case "8": bookAppointmentFlow(); break;
                case "9": cancelAppointmentFlow(); break;
                case "10": viewBills(); break;
                case "11": generateBillFlow(); break;
                case "12": payBillFlow(); break;
                case "0": running = false; System.out.println("Goodbye!"); break;
                default: System.out.println("Invalid option. Try again.");
            }
        }
        sc.close();
    }

    // ---------------- LOGIN ----------------

    private static boolean login() {
        System.out.println("========================================");
        System.out.println("      Hospital Management System");
        System.out.println("========================================");
        for (int attempt = 0; attempt < 3; attempt++) {
            System.out.print("Username: ");
            String u = sc.nextLine().trim();
            System.out.print("Password: ");
            String p = sc.nextLine().trim();
            if (u.equals("admin") && p.equals("1234")) return true;
            System.out.println("Invalid username or password. Try again.\n");
        }
        return false;
    }

    // ---------------- MENU ----------------

    private static void printMenu() {
        System.out.println("---------------- MENU ----------------");
        System.out.println(" 1. View Dashboard");
        System.out.println(" 2. View Patients");
        System.out.println(" 3. Add Patient");
        System.out.println(" 4. Delete Patient");
        System.out.println(" 5. View Doctors");
        System.out.println(" 6. Add Doctor");
        System.out.println(" 7. View Appointments");
        System.out.println(" 8. Book Appointment");
        System.out.println(" 9. Cancel Appointment");
        System.out.println("10. View Bills");
        System.out.println("11. Generate Bill");
        System.out.println("12. Pay Bill");
        System.out.println(" 0. Logout / Exit");
        System.out.print("Choose an option: ");
    }

    // ---------------- PATIENTS ----------------

    private static void viewPatients() {
        List<Patient> list = service.getPatients();
        System.out.println("\n-- Patients (" + list.size() + ") --");
        for (Patient p : list) System.out.println(p.getSummary());
        System.out.println();
    }

    private static void addPatientFlow() {
        System.out.println("\n-- Add Patient --");
        String id = prompt("Patient ID");
        String name = prompt("Full Name");
        int age = promptInt("Age");
        String gender = prompt("Gender (Male/Female/Other)");
        String contact = prompt("Contact");
        String disease = prompt("Disease");
        String address = prompt("Address");

        boolean ok = service.addPatient(new Patient(id, name, age, gender, contact, disease, address, "Active"));
        System.out.println(ok ? "Patient added successfully.\n" : "Patient ID already exists.\n");
    }

    private static void deletePatientFlow() {
        String id = prompt("\nEnter Patient ID to delete");
        boolean ok = service.deletePatient(id);
        System.out.println(ok ? "Patient deleted.\n" : "Patient not found.\n");
    }

    // ---------------- DOCTORS ----------------

    private static void viewDoctors() {
        List<Doctor> list = service.getDoctors();
        System.out.println("\n-- Doctors (" + list.size() + ") --");
        for (Doctor d : list) System.out.println(d.getSummary());
        System.out.println();
    }

    private static void addDoctorFlow() {
        System.out.println("\n-- Add Doctor --");
        String id = prompt("Doctor ID");
        String name = prompt("Full Name");
        int age = promptInt("Age");
        String gender = prompt("Gender (Male/Female/Other)");
        String contact = prompt("Contact");
        String specialization = prompt("Specialization");
        String time = prompt("Available Time (e.g. 10:00 AM - 2:00 PM)");

        boolean ok = service.addDoctor(new Doctor(id, name, age, gender, contact, specialization, time));
        System.out.println(ok ? "Doctor added successfully.\n" : "Doctor ID already exists.\n");
    }

    // ---------------- APPOINTMENTS ----------------

    private static void viewAppointments() {
        List<Appointment> list = service.getAppointments();
        System.out.println("\n-- Appointments (" + list.size() + ") --");
        for (Appointment a : list) System.out.println(a.getSummary());
        System.out.println();
    }

    private static void bookAppointmentFlow() {
        System.out.println("\n-- Book Appointment --");
        String id = prompt("Appointment ID");
        String patientId = prompt("Patient ID");
        String doctorId = prompt("Doctor ID");
        String date = prompt("Date (YYYY-MM-DD)");
        String time = prompt("Time (HH:MM, 24-hour)");
        String reason = prompt("Reason (Consultation / Follow-up)");

        String error = service.addAppointment(id, patientId, doctorId, date, time, reason);
        System.out.println(error == null ? "Appointment booked successfully.\n" : error + "\n");
    }

    private static void cancelAppointmentFlow() {
        String id = prompt("\nEnter Appointment ID to cancel");
        boolean ok = service.cancelAppointment(id);
        System.out.println(ok ? "Appointment cancelled.\n" : "Appointment not found.\n");
    }

    // ---------------- BILLING ----------------

    private static void viewBills() {
        List<Bill> list = service.getBills();
        System.out.println("\n-- Bills (" + list.size() + ") --");
        for (Bill b : list) System.out.println(b.getSummary());
        System.out.println("Total Revenue: Rs." + String.format("%.0f", service.totalRevenue()) + "\n");
    }

    private static void generateBillFlow() {
        System.out.println("\n-- Generate Bill --");
        String id = prompt("Bill ID");
        String patientId = prompt("Patient ID");
        double consultation = promptDouble("Consultation Fee");
        double medicine = promptDouble("Medicine Charges");
        double test = promptDouble("Test Charges");
        double room = promptDouble("Room Charges");

        String error = service.addBill(id, patientId, consultation, medicine, test, room);
        System.out.println(error == null ? "Bill generated successfully.\n" : error + "\n");
    }

    private static void payBillFlow() {
        String id = prompt("\nEnter Bill ID to mark as paid");
        boolean ok = service.payBill(id);
        System.out.println(ok ? "Payment successful.\n" : "Bill not found.\n");
    }

    // ---------------- INPUT HELPERS ----------------

    private static String prompt(String label) {
        System.out.print(label + ": ");
        return sc.nextLine().trim();
    }

    private static int promptInt(String label) {
        while (true) {
            try {
                return Integer.parseInt(prompt(label));
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid whole number.");
            }
        }
    }

    private static double promptDouble(String label) {
        while (true) {
            try {
                return Double.parseDouble(prompt(label));
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number.");
            }
        }
    }
}
