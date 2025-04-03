import java.io.*;
import java.util.*;

// Base Class for Person
class Person {
    protected String name;
    protected int age;
    protected String gender;
    protected String contactNumber;

    public Person(String name, int age, String gender, String contactNumber) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.contactNumber = contactNumber;
    }

    // Getters and setters
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }

    public String getGender() { return gender; }
    public void setGender(String gender) { this.gender = gender; }

    public String getContactNumber() { return contactNumber; }
    public void setContactNumber(String contactNumber) { this.contactNumber = contactNumber; }
}

// Patient Class
class Patient extends Person {
    private static int idCounter = 1;
    private int patientId;
    private String address;
    private String medicalHistory;
    private String admissionDate;
    private boolean discharged;

    public Patient(String name, int age, String gender, String contactNumber, String address, String medicalHistory, String admissionDate) {
        super(name, age, gender, contactNumber);
        this.patientId = idCounter++;
        this.address = address;
        this.medicalHistory = medicalHistory;
        this.admissionDate = admissionDate;
        this.discharged = false;
    }

    public int getPatientId() { return patientId; }
    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }

    public String getMedicalHistory() { return medicalHistory; }
    public void setMedicalHistory(String medicalHistory) { this.medicalHistory = medicalHistory; }

    public String getAdmissionDate() { return admissionDate; }
    public void setAdmissionDate(String admissionDate) { this.admissionDate = admissionDate; }

    public boolean isDischarged() { return discharged; }
    public void discharge() { this.discharged = true; }

    @Override
    public String toString() {
        return "Patient ID: " + patientId + ", Name: " + name + ", Age: " + age + ", Gender: " + gender + ", Contact: " + contactNumber + ", Address: " + address + ", Medical History: " + medicalHistory + ", Admission Date: " + admissionDate + ", Discharged: " + discharged;
    }
}

// Staff Class
class Staff extends Person {
    private static int idCounter = 1;
    private int staffId;
    private String role;
    private String department;

    public Staff(String name, int age, String gender, String contactNumber, String role, String department) {
        super(name, age, gender, contactNumber);
        this.staffId = idCounter++;
        this.role = role;
        this.department = department;
    }

    public int getStaffId() { return staffId; }
    public String getRole() { return role; }
    public void setRole(String role) { this.role = role; }

    public String getDepartment() { return department; }
    public void setDepartment(String department) { this.department = department; }

    @Override
    public String toString() {
        return "Staff ID: " + staffId + ", Name: " + name + ", Age: " + age + ", Gender: " + gender + ", Contact: " + contactNumber + ", Role: " + role + ", Department: " + department;
    }
}

// Appointment Class
class Appointment {
    private static int idCounter = 1;
    private int appointmentId;
    private int patientId;
    private int doctorId;
    private String dateTime;
    private String reason;

    public Appointment(int patientId, int doctorId, String dateTime, String reason) {
        this.appointmentId = idCounter++;
        this.patientId = patientId;
        this.doctorId = doctorId;
        this.dateTime = dateTime;
        this.reason = reason;
    }

    public int getAppointmentId() { return appointmentId; }
    public int getPatientId() { return patientId; }
    public int getDoctorId() { return doctorId; }
    public String getDateTime() { return dateTime; }
    public String getReason() { return reason; }

    @Override
    public String toString() {
        return "Appointment ID: " + appointmentId + ", Patient ID: " + patientId + ", Doctor ID: " + doctorId + ", DateTime: " + dateTime + ", Reason: " + reason;
    }
}

// Main System Class
public class HospitalManagementSystem {
    private List<Patient> patients = new ArrayList<>();
    private List<Staff> staff = new ArrayList<>();
    private List<Appointment> appointments = new ArrayList<>();

    public void addPatient(Patient patient) {
        patients.add(patient);
        System.out.println("Patient added successfully.");
    }

    public void addStaff(Staff staffMember) {
        staff.add(staffMember);
        System.out.println("Staff member added successfully.");
    }

    public void scheduleAppointment(Appointment appointment) {
        appointments.add(appointment);
        System.out.println("Appointment scheduled successfully.");
    }

    public void displayPatients() {
        for (Patient patient : patients) {
            System.out.println(patient);
        }
    }

    public void displayStaff() {
        for (Staff staffMember : staff) {
            System.out.println(staffMember);
        }
    }

    public void displayAppointments() {
        for (Appointment appointment : appointments) {
            System.out.println(appointment);
        }
    }

    public static void main(String[] args) {
        HospitalManagementSystem hms = new HospitalManagementSystem();
        Scanner sc = new Scanner(System.in);

        // Example Data
        hms.addPatient(new Patient("John Doe", 30, "Male", "1234567890", "123 Street", "None", "2025-01-10"));
        hms.addStaff(new Staff("Dr. Smith", 45, "Male", "0987654321", "Doctor", "Cardiology"));
        hms.scheduleAppointment(new Appointment(1, 1, "2025-01-15 10:00", "Checkup"));

        // Menu
        while (true) {
            System.out.println("\nHospital Management System Menu");
            System.out.println("1. Add Patient\n2. Add Staff\n3. Schedule Appointment\n4. Display Patients\n5. Display Staff\n6. Display Appointments\n7. Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter name: ");
                    String pName = sc.next();
                    System.out.print("Enter age: ");
                    int pAge = sc.nextInt();
                    System.out.print("Enter gender: ");
                    String pGender = sc.next();
                    System.out.print("Enter contact number: ");
                    String pContact = sc.next();
                    System.out.print("Enter address: ");
                    String pAddress = sc.next();
                    System.out.print("Enter medical history: ");
                    String pHistory = sc.next();
                    System.out.print("Enter admission date: ");
                    String pDate = sc.next();
                    hms.addPatient(new Patient(pName, pAge, pGender, pContact, pAddress, pHistory, pDate));
                    break;

                case 2:
                    System.out.print("Enter name: ");
                    String sName = sc.next();
                    System.out.print("Enter age: ");
                    int sAge = sc.nextInt();
                    System.out.print("Enter gender: ");
                    String sGender = sc.next();
                    System.out.print("Enter contact number: ");
                    String sContact = sc.next();
                    System.out.print("Enter role: ");
                    String sRole = sc.next();
                    System.out.print("Enter department: ");
                    String sDept = sc.next();
                    hms.addStaff(new Staff(sName, sAge, sGender, sContact, sRole, sDept));
                    break;

                case 3:
                    System.out.print("Enter patient ID: ");
                    int apPatientId = sc.nextInt();
                    System.out.print("Enter doctor ID: ");
                    int apDoctorId = sc.nextInt();
                    System.out.print("Enter date and time: ");
                    String apDateTime = sc.next();
                    System.out.print("Enter reason: ");
                    String apReason = sc.next();
                    hms.scheduleAppointment(new Appointment(apPatientId, apDoctorId, apDateTime, apReason));
                    break;

                case 4:
                    hms.displayPatients();
                    break;

                case 5:
                    hms.displayStaff();
                    break;

                case 6:
                    hms.displayAppointments();
                    break;

                case 7:
                    System.out.println("Exiting...");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
}
