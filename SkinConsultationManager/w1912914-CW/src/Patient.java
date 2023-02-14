import java.util.ArrayList;

public class Patient extends Person {

    private int patientID;

    private String NIC;

    public static ArrayList<Patient> patients = new ArrayList<Patient>();

    //constructor
    public Patient(String name, String surname, String dateOfBirth, String mobileNumber, int patientID, String NIC) {
        super(name, surname, dateOfBirth, mobileNumber);
        this.patientID = patientID;
        this.NIC = NIC;
    }

    //getters and setters
    public int getPatientID() {
        return patientID;
    }

    public void setPatientID(int patientID) {
        this.patientID = patientID;
    }

    public String getNIC() {
        return NIC;
    }

    public void setNIC(String NIC) {
        this.NIC = NIC;
    }





}
