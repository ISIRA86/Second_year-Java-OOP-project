import java.io.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;
import java.util.concurrent.CompletionService;

public class WestminsterSkinConsultationManager implements SkinConsultationManager, Serializable {

    public static ArrayList<Doctor> doctors = new ArrayList<Doctor>(10);

    public static void main(String[] args) {

        WestminsterSkinConsultationManager consult = new WestminsterSkinConsultationManager();

        while (true) {
            System.out.println("""
                                            
                    1. Add a doctor
                    2. Delete a doctor
                    3. Print list of doctors
                    4. Save in a file
                    5. Load from a file
                    6. Load GUI
                    7. Exit
                                            
                                            
                    Enter your choice :
                    """);
            int choice = intValidation();

            switch (choice) {
                case 1:
                    consult.addDoctor();
                    break;
                case 2:
                    consult.deleteDoctor();
                    break;
                case 3:
                    consult.printListOfDoctors();
                    break;
                case 4:
                    consult.savefile();
                    break;
                case 5:
                    consult.loadfile();
                    break;
                case 6:
                    new GUImain();
                    break;
                case 7:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice");
            }
        }
    }

    public void addDoctor() {
        if (doctors.size() < 10) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter the name of the doctor : ");
            String name = stringValidation();

            System.out.println("Enter the surname of the doctor : ");
            String surname = stringValidation();

            System.out.println("Enter the date of birth date of the doctor (yyyy-mm-dd) : ");
            String dateOfBirth = dateValidation();

            System.out.println("Enter the mobile number of the doctor : ");
            String mobileNumber = mobileNumberValidation();

            System.out.println("Enter the medical license number of the doctor : ");
            String medicalLicenseNumber = MedicalNumberUnique();

            System.out.println("Enter the specialization of the doctor : ");
            String specialization = stringValidation();

            doctors.add(new Doctor(name, surname, dateOfBirth, mobileNumber, medicalLicenseNumber, specialization));
            System.out.println("Doctor added successfully");
        } else {
            System.out.println("Doctor list is full");
        }
    }

    public void deleteDoctor() {
        //method to delete a doctor from the list by getting the medical license number
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the MedicalLicenseNumber of the doctor to be deleted :");
        String license = sc.nextLine();
        for (int i = 0; i < doctors.size(); i++) {
            if (doctors.get(i).getMedicalLicenseNumber().equals(license)) {
                doctors.remove(i);
                System.out.println("Doctor deleted successfully");
                break;
            } else {
                System.out.println("No Doctor Found Who goes by that license number");
            }
        }
    }


    public void printListOfDoctors() {
        Scanner sc = new Scanner(System.in);
        System.out.println("List of doctors :");
        int count = 0;
        if (doctors.size() == 0) {
            System.out.println("No doctors in the list");
        }
        doctors.sort(Comparator.comparing(Person::getSurname));

        for (int i = 0; i < doctors.size(); i++) {
            count += 1;
            System.out.println("Doctor " + count + " details  ------------------\n");
            System.out.println("Name : " + doctors.get(i).getName());
            System.out.println("Surname : " + doctors.get(i).getSurname());
            System.out.println("Date of Birth : " + doctors.get(i).getDateOfBirth());
            System.out.println("Mobile Number : " + doctors.get(i).getMobileNumber());
            System.out.println("Medical License Number : " + doctors.get(i).getMedicalLicenseNumber());
            System.out.println("Specialization : " + doctors.get(i).getSpecialization());
            System.out.println("\n");
        }
    }

    public void savefile() {
        try {
            FileOutputStream fos = new FileOutputStream("doctors.txt");
            ObjectOutputStream oos = new ObjectOutputStream(fos);

            for (Doctor doctor : doctors) {
                oos.writeObject(doctor);
            }
            System.out.println("File saved successfully");
            //oos.writeObject(doctors);
            oos.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void saveconsult(){
        try{
            FileOutputStream fos = new FileOutputStream("consult.txt");
            ObjectOutputStream oos = new ObjectOutputStream(fos);

            for (Consultation consult : Consultation.consultations) {
                oos.writeObject(consult);
            }

            oos.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }




    public void loadfile(){
        try {
            FileInputStream fis = new FileInputStream("doctors.txt");
            ObjectInputStream ois = new ObjectInputStream(fis);

            while (fis.available() > 0){
                doctors.add((Doctor) ois.readObject());
            }
            System.out.println("File loaded successfully");
            ois.close();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

    }


    //String validator
    public static String stringValidation() {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        while (!input.matches("[a-zA-Z]+")) {
            System.out.println("Invalid input. Please enter a valid input : ");
            input = sc.nextLine();
        }
        return input;
    }

    //integer validation method
    public static int intValidation() {
        Scanner sc = new Scanner(System.in);
        while (!sc.hasNextInt()) {
            System.out.println("Invalid input. Please enter a number");
            sc.next();
        }
        return sc.nextInt();
    }


    //date validation method
    public String dateValidation() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            try {
                String date = sc.nextLine();
                LocalDate.parse(date);
                return date;
            } catch (DateTimeParseException e) {
                System.out.println("Invalid date. Please enter a valid date");
            }
        }
    }

    //validating the mobile number
    public static String mobileNumberValidation() {
        Scanner sc = new Scanner(System.in);
        String mobileNumber = sc.nextLine();
        while (true) {
            if (mobileNumber.matches("[0-9]{10}")) {
                return mobileNumber;
            } else {
                System.out.println("Invalid mobile number. Please enter a valid mobile number : ");
                mobileNumber = sc.nextLine();
            }
        }
    }

    //Checking if medicallicensenumber is unique
    public String MedicalNumberUnique() {
        Scanner sc = new Scanner(System.in);
        String medicalLicenseNumber = sc.nextLine();
        for (int i = 0; i < doctors.size(); i++) {
            if (doctors.get(i).getMedicalLicenseNumber().equals(medicalLicenseNumber)) {
                System.out.println("Medical License Number already exists. Please enter a unique medical license number : ");
                medicalLicenseNumber = sc.nextLine();
            } else {
                return medicalLicenseNumber;
            }
        }
        return medicalLicenseNumber;
    }
    public static boolean checkAvailability(String starttime, String endtime, String date, String medicalLicenseNumber) {
        for (int i = 0; i < Consultation.consultations.size(); i++) {
//            if (Consultation.consultations.get(i).getDoctorID().equals(medicalLicenseNumber) && Consultation.consultations.get(i).getDate().equals(date)){
//                if (LocalTime.parse(starttime).isBefore(Consultation.consultations.get(i).getEndtime())&& LocalTime.parse(endtime).isAfter(Consultation.consultations.get(i).getStarttime()) ){
//                    return false;
//                }
//            }
//
//
//        }
            if (Consultation.consultations.get(i).getDoctorID().equals(WestminsterSkinConsultationManager.doctors.get(i).getMedicalLicenseNumber())) {
                if (Consultation.consultations.get(i).getDate().isEqual(LocalDate.parse(date))) {
                    if ((Consultation.consultations.get(i).getStarttime().isBefore(LocalTime.parse(starttime))) && (Consultation.consultations.get(i).getEndtime().isAfter(LocalTime.parse(starttime))) ||
                            (Consultation.consultations.get(i).getStarttime().isBefore(LocalTime.parse(endtime))) && ((Consultation.consultations.get(i).getEndtime()).isAfter(LocalTime.parse(endtime)))) {
                        return false;

                    }
                }
            }
        }
        return true;
    }



//        return true;



    public static String generateConsultationID() {
        String id = "";
        for (int i = 0; i < 5; i++) {
            id += (int) (Math.random() * 10);
        }
        return id;
    }
}

