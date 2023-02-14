import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class Consultation implements Serializable {

    private String doctorID;
    private String consultationID;
    private Doctor doctorName;
    private String patientName;
    private String nic;
    private LocalDate date;
    private LocalTime starttime;
    private LocalTime endtime;
    private double price;
    private String notes;

    public static ArrayList <Consultation> consultations = new ArrayList<Consultation>();



    //constructor
    public Consultation(String doctorID, String consultationID, Doctor doctorName, String patientName, String nic, LocalDate date, LocalTime starttime, LocalTime endtime, double price, String notes) {
        this.doctorID = doctorID;
        this.consultationID = consultationID;
        this.doctorName = doctorName;
        this.patientName = patientName;
        this.nic = nic;
        this.date = date;
        this.starttime = starttime;
        this.endtime = endtime;
        this.price = price;
        this.notes = notes;
    }



    
    //getters and setters
    public Doctor getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(Doctor doctorName) {
        this.doctorName = doctorName;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public String getNic() {
        return nic;
    }

    public void setNic(String nic) {
        this.nic = nic;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalTime getStarttime() {
        return starttime;
    }

    public void setStarttime(LocalTime starttime) {
        this.starttime = starttime;
    }

    public LocalTime getEndtime() {
        return endtime;
    }

    public void setEndtime(LocalTime endtime) {
        this.endtime = endtime;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getDoctorID() {
        return doctorID;
    }

    public void setDoctorID(String doctorID) {
        this.doctorID = doctorID;
    }

    public String getConsultationID() {
        return consultationID;
    }

    public void setConsultationID(String consultationID) {
        this.consultationID = consultationID;
    }




}

