Hospital Management System


A simple console-based Hospital Management System built in Java. It lets an admin log in and manage patients, doctors, appointments, and billing through a 
menu-driven terminal interface.


Features

The system is organized into four core modules:

1. Login
   Admin authentication before accessing the system.
   Up to 3 login attempts allowed; the program exits after repeated failures.
2. Patient Management
   Add a new patient (ID, name, age, gender, contact, disease, address, status).
   View all registered patients.
   Delete a patient by ID.
3. Doctor & Appointment Management
   Add a new doctor (ID, name, age, gender, contact, specialization, available time).
   View all registered doctors.
   Book an appointment linking a patient, a doctor, date, time, and reason.
   View all appointments.
   Cancel an appointment by ID.
4. Billing
   Generate a bill for a patient with consultation, medicine, test, and room charges.
   View all bills along with total revenue collected.
   Mark a bill as paid.



How It Works

Main.java displays a text-based menu in the terminal and routes each choice to the corresponding method in HospitalService, 
which holds the underlying data and business logic. Sample data is loaded automatically after a successful login so the system has some patients, doctors, 
appointments, and bills to explore right away.




Default Login Credentials

   Username: admin
   Password: 1234
   Menu Options

Once logged in, you'll see the following menu:

---------------- MENU ----------------
 1. View Dashboard
 2. View Patients
 3. Add Patient
 4. Delete Patient
 5. View Doctors
 6. Add Doctor
 7. View Appointments
 8. Book Appointment
 9. Cancel Appointment
10. View Bills
11. Generate Bill
12. Pay Bill
 0. Logout / Exit



Sample Usage
Launch the program and log in with the default credentials.
Choose 1 to view the dashboard summary.
Choose 3 to add a new patient, then 2 to confirm it appears in the list.
Choose 6 to add a doctor, then 8 to book an appointment between a patient and doctor.
Choose 11 to generate a bill for a patient, and 12 to mark it as paid once settled.
Choose 0 to log out and exit.


Tech Stack
Language: Java (core, no external dependencies)
Interface: Command-line / console (Scanner-based input)


Future Improvements
Persist data to a file or database (currently data resets on each run).
Add role-based logins (admin, doctor, receptionist).
Add input validation for dates/times and duplicate appointment slots.
Build a GUI (JavaFX/Swing) or web front end on top of HospitalService.






HOSPITAL MANAGEMENT SYSTEM -JAVA 
====================================

This is a standalone Java console application demonstrating Object-
Oriented Programming (OOP). It is NOT connected to the website
(index.html/style.css/script.js) â€” the two are separate deliverables
that model the same hospital data, as suggested in the website's
own README.

FILES
-----
Person.java            Abstract base class (encapsulation, abstraction)
Patient.java            Extends Person (inheritance, polymorphism)
Doctor.java              Extends Person (inheritance, polymorphism)
Appointment.java         Links a Patient and a Doctor (composition)
Bill.java                Invoice for a patient
HospitalService.java      Business logic: add/find/delete/list, in-memory storage
Main.java                Console menu â€” program entry point

OOP CONCEPTS DEMONSTRATED
--------------------------
- Encapsulation : private fields with public getters/setters (all classes)
- Abstraction   : Person is abstract, defines getSummary() without
                  implementing it
- Inheritance   : Patient and Doctor both extend Person
- Polymorphism  : getSummary() behaves differently for Patient vs Doctor
- Composition   : Appointment "has a" Patient and a Doctor;
                  Bill "has a" Patient

REQUIREMENTS
------------
- Java JDK 8 or newer installed (JDK, not just JRE â€” you need "javac").
- Check with:  java -version   and   javac -version
- If you don't have a JDK: download it from https://adoptium.net
  (choose the version matching your OS, e.g. Windows x64 .msi installer).

HOW TO RUN IN VS CODE
----------------------
1. Install the "Extension Pack for Java" from the Extensions tab in
   VS Code (search "Extension Pack for Java" by Microsoft).
2. Open this folder (HospitalManagementJava) in VS Code:
   File > Open Folder.
3. Open Main.java.
4. Click the "Run" button that appears above the `public static void
   main` line (or press Ctrl+F5 / the Run icon in the top-right).
5. A terminal panel opens at the bottom â€” type your input there.

HOW TO RUN FROM THE COMMAND LINE (no VS Code needed)
------------------------------------------------------
1. Open a terminal / command prompt.
2. Navigate into this folder:
       cd path/to/HospitalManagementJava
3. Compile all files:
       javac *.java
4. Run the program:
       java Main

LOGIN
-----
Username: admin
Password: 1234
(You get 3 attempts before the program exits.)

USING THE APP
--------------
After logging in you'll see a numbered menu (1-12, plus 0 to exit).
Type a number and press Enter to:
  1  View dashboard stats (patients, doctors, appointments, revenue)
  2  View all patients
  3  Add a new patient
  4  Delete a patient by ID
  5  View all doctors
  6  Add a new doctor
  7  View all appointments
  8  Book a new appointment (checks for duplicate booking/time clashes)
  9  Cancel an appointment by ID
 10  View all bills and total revenue
 11  Generate a new bill for a patient
 12  Mark a bill as paid by ID
  0  Logout / exit the program

NOTE ON DATA
------------
Data lives only in memory (ArrayLists) while the program runs. Closing
the program discards any changes â€” same starting sample data (4
patients, 3 doctors, 3 appointments, 3 bills) loads every time you
restart, matching the demo data in the website's script.js.

This was compiled and test-run successfully with OpenJDK 21 before
being handed to you â€” it will build and run with zero errors.
