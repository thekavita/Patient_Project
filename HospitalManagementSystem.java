import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

class Patient {
    String Name;
    int Age;
    String Gender;
    double fee;
    int token;

    public Patient(String Name, int Age, String Gender, double fee, int token) {
        this.Name = Name;
        this.Age = Age;
        this.Gender = Gender;
        this.fee = fee;
        this.token = token;
    }
}

public class HospitalManagementSystem {
    static ArrayList<Patient> patients = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);  // using scanner for taking input from the user

    public static void main(String[] args) {
        int choice;
           System.out.println("Welcome to Our App .....What can I do for You...????");   
        do {
            System.out.println("1. New Patient Entry");
            System.out.println("2. Display all Patients");
            System.out.println("3. Remove Patient from list by token");
            System.out.println("4. Display Patients order by Name");
            System.out.println("5. Display Patients order by Gender");
            System.out.println("6. Display Patients order by token number");
            System.out.println("7. Display Patients order by Age");
            System.out.println("8. Update Patient’s fee");
            System.out.println("9. Exit");

            System.out.print("Enter Your Choice : ");
            choice = scanner.nextInt();

            // using Switch for Entry
            switch (choice) {
                case 1:
                    newPatientEntry();
                    break;
                case 2:
                    displayAllPatients();
                    break;
                case 3:
                    removePatientByToken();
                    break;
                case 4:
                    displayPatientsOrderByName();
                    break;
                case 5:
                    displayPatientsOrderByGender();
                    break;
                case 6:
                    displayPatientsOrderByToken();
                    break;
                case 7:
                    displayPatientsOrderByAge();
                    break;
                case 8:
                    updatePatientsFee();
                    break;
                case 9:
                    System.out.println("WE'll See You Soon.....Thank you.....!");
                    break;
                default:
                    System.out.println("Invalid Number. Please Enter a Valid Number.");
            }
        } while (choice != 9); 
    }
    // adding new patient information //
    private static void newPatientEntry() {
        System.out.println("Please Enter Patient Name: ");
        String Name = scanner.next();

        System.out.println("Please Enter Patient Age: ");
        int Age = scanner.nextInt();

        System.out.println("Please Enter Patient Gender: ");
        String Gender = scanner.next();

        System.out.println("Please Enter Patient Fee:");
        double fee = scanner.nextDouble();

        int token = patients.size() + 1;

        Patient patient = new Patient(Name, Age, Gender, fee, token);
        patients.add(patient);

        System.out.println("Patient added successfully with token number: " + token);
    }

    private static void displayAllPatients() {
        System.out.println("Here are All Patients : ....");

        for (Patient patient : patients) {
            System.out.println("Token : " + patient.token + ", Name : " + patient.Name + ", Age : " + patient.Age +
                    ", Gender : " + patient.Gender + ", Fee : " + patient.fee);
        }
    }

    private static void removePatientByToken() {
        System.out.println("Enter token number to remove the Patient Data:");
        int tokenToRemove = scanner.nextInt();

        for (Patient patient : patients) {
            if (patient.token == tokenToRemove) {
                patients.remove(patient);
                System.out.println("Patient with token number " + tokenToRemove + " removed successfully. Thank You");
                return;
            }
        }

        System.out.println("Patient with token number " + tokenToRemove + " not found. ");
        System.out.println("Please Try Again....");
    }
  // sorting by Name with the help of comparator
    private static void displayPatientsOrderByName() {
        Collections.sort(patients, Comparator.comparing(patient -> patient.Name));

        System.out.println("Patients ordered by Name:");
        displayAllPatients();
    }
//sorting by Gender with the help of comparator
    private static void displayPatientsOrderByGender() {
        Collections.sort(patients, Comparator.comparing(patient -> patient.Gender));

        System.out.println("Patients ordered by Gender:");
        displayAllPatients();
    }
//sorting by token number with the help of comparator
    private static void displayPatientsOrderByToken() {
        Collections.sort(patients, Comparator.comparingInt(patient -> patient.token));

        System.out.println("Patients ordered by token number:");
        displayAllPatients();
    }
 // sorting by Age with the help of comparator
    private static void displayPatientsOrderByAge() {
        Collections.sort(patients, Comparator.comparingInt(patient -> patient.Age));

        System.out.println("Patients ordered by Age:");
        displayAllPatients();
    }
   // Updating Patient Fees //
    private static void updatePatientsFee() {
        System.out.println("Enter token number to update the patient's fee:");
        int tokenToUpdate = scanner.nextInt();

        for (Patient patient : patients) {
            if (patient.token == tokenToUpdate) {
                System.out.println("Enter new fee for the patient:");
                double newFee = scanner.nextDouble();
                patient.fee = newFee;
                System.out.println("Patient's fee updated successfully.");
                return;
            }
        }
// When information is not available about the patient //
        System.out.println("Patient with token number " + tokenToUpdate + " not found.");
    }
}
