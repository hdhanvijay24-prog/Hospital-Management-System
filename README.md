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
