public class Doctor extends Person {

    private String medicalLicenseNumber;
    private String specialization;

    //constructor
    public Doctor(String name, String surname, String dateOfBirth, String mobileNumber, String medicalLicenseNumber, String specialization) {
        super(name, surname, dateOfBirth, mobileNumber);
        this.medicalLicenseNumber = medicalLicenseNumber;
        this.specialization = specialization;
    }

    //getters and setters
    public String getMedicalLicenseNumber() {
        return medicalLicenseNumber;
    }

    public void setMedicalLicenseNumber(String medicalLicenseNumber) {
        this.medicalLicenseNumber = medicalLicenseNumber;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

}


