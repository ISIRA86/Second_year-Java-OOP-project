import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import javax.swing.*;
import java.awt.*;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.time.DateTimeException;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeParseException;
import java.util.*;

public class AddConsultation extends JFrame implements Serializable {

    String selectedDoctor;
    String doctorlicense;
    private JTextField NICField;

    AddConsultation(){


        //------- creating panels ------------
        JPanel panel1 = new JPanel();
        panel1.setBounds(0,0,680,768);
        panel1.setBackground(new Color( 65, 216, 250));
        panel1.setLayout(null);

        JPanel panel2 = new JPanel();
        panel2.setBounds(680,0,680,384);
        panel2.setBackground(new Color( 250, 75, 65));
        panel2.setLayout(null);

        JPanel panel3 = new JPanel();
        panel3.setBounds(680,384,680,384);
        panel3.setBackground(new Color( 250, 75, 65));
        panel3.setLayout(null);

        //-------------- Labels and textfields -----------------
        JLabel label = new JLabel("Add A Consultation");
        label.setBounds(200, 0, 600, 50);
        label.setFont(new Font("MV Boli", Font.PLAIN, 30));
        label.setForeground(Color.BLACK);
        label.setVisible(true);
        panel1.add(label);


        JLabel name = new JLabel("Name:");
        name.setBounds(30,70,50,50);
        panel1.add(name);

        JTextField nameField = new JTextField();
        nameField.setBounds(250,82,200,30);
        panel1.add(nameField);


        JLabel surname = new JLabel("Surname:");
        surname.setBounds(30,120,150,50);
        panel1.add(surname);

        JTextField surnameField = new JTextField();
        surnameField.setBounds(250,132,200,30);
        panel1.add(surnameField);


        JLabel dateofbirth = new JLabel("Date of Birth:");
        dateofbirth.setBounds(30,170,150,50);
        panel1.add(dateofbirth);

        JTextField dateofbirthField = new JTextField();
        dateofbirthField.setBounds(250,182,200,30);
        panel1.add(dateofbirthField);


        JLabel mobilenumber = new JLabel("Mobile Number:");
        mobilenumber.setBounds(30,220,150,50);
        panel1.add(mobilenumber);

        JTextField mobilenumberField = new JTextField();
        mobilenumberField.setBounds(250,232,200,30);
        panel1.add(mobilenumberField);


        JLabel NIC = new JLabel("NIC Number:");
        NIC.setBounds(30,270,150,50);
        panel1.add(NIC);

        NICField = new JTextField();
        NICField.setBounds(250,282,200,30);
        panel1.add(NICField);

        JLabel Notes = new JLabel("Notes:");
        Notes.setBounds(30,320,150,50);
        panel1.add(Notes);

        JTextArea NotesField = new JTextArea();
        NotesField.setBounds(250,332,200,100);
        panel1.add(NotesField);

        JLabel dateLabel = new JLabel("Select Date");
        dateLabel.setBounds(30,132,200,30);
        panel2.add(dateLabel);

        JTextField dateField = new JTextField();
        dateField.setBounds(200,132,200,30);
        dateField.setEnabled(false);
        panel2.add(dateField);

        JLabel timeLabel = new JLabel("Select Start Time");
        timeLabel.setBounds(30,180,200,30);
        panel2.add(timeLabel);

        JTextField timeField = new JTextField();
        timeField.setBounds(200,182,100,30);
        timeField.setEnabled(false);
        panel2.add(timeField);

        JLabel timeLabel2 = new JLabel("Select End Time");
        timeLabel2.setBounds(30,230,200,30);
        panel2.add(timeLabel2);

        JTextField timeField2 = new JTextField();
        timeField2.setBounds(200,232,100,30);
        timeField2.setEnabled(false);
        panel2.add(timeField2);

        JLabel doctorLabel = new JLabel("Select Doctor");
        doctorLabel.setBounds(30,82,200,30);
        panel2.add(doctorLabel);

        //-------------- Creating the available doctor display box -----------------
        String [] doctorList = new String[WestminsterSkinConsultationManager.doctors.size()];
        for (int i = 0; i < WestminsterSkinConsultationManager.doctors.size(); i++) {
            doctorList[i]= WestminsterSkinConsultationManager.doctors.get(i).getName() + WestminsterSkinConsultationManager.doctors.get(i).getSurname() + WestminsterSkinConsultationManager.doctors.get(i).getMedicalLicenseNumber();
        }

        JComboBox<String> doctors = new JComboBox<>(doctorList);
        doctors.setBounds(200, 82,250,30);
        doctors.setBackground(Color.WHITE);
        doctors.setEnabled(false);
        panel2.add(doctors);

        JLabel doctor = new JLabel("Doctor :");
        doctor.setBounds(30,62,200,30);
        doctor.setVisible(false);
        panel3.add(doctor);

        JLabel starttime = new JLabel("Start Time :");
        starttime.setBounds(30,112,200,30);
        starttime.setVisible(false);
        panel3.add(starttime);

        JLabel endtime = new JLabel("End Time :");
        endtime.setBounds(30,162,200,30);
        endtime.setVisible(false);
        panel3.add(endtime);

        JLabel date = new JLabel("Date :");
        date.setBounds(30,212,200,30);
        date.setVisible(false);
        panel3.add(date);

        JLabel cost = new JLabel("Total Cost :");
        cost.setBounds(30,262,200,30);
        cost.setVisible(false);
        panel3.add(cost);

        JLabel doctorlabel = new JLabel();
        doctorlabel.setBounds(200,62,200,30);
        doctorlabel.setVisible(false);
        panel3.add(doctorlabel);

        JLabel starttimelabel = new JLabel();
        starttimelabel.setBounds(200,112,200,30);
        starttimelabel.setVisible(false);
        panel3.add(starttimelabel);

        JLabel endtimelabel = new JLabel();
        endtimelabel.setBounds(200,162,200,30);
        endtimelabel.setVisible(false);
        panel3.add(endtimelabel);

        JLabel datelabel = new JLabel();
        datelabel.setBounds(200,212,200,30);
        datelabel.setVisible(false);
        panel3.add(datelabel);

        JLabel costlabel = new JLabel();
        costlabel.setBounds(200,262,200,30);
        costlabel.setVisible(false);
        panel3.add(costlabel);





        //-------------- Buttons -----------------
        JButton saveDetails = new JButton("Save Details");
        saveDetails.setBounds(300,520,150,40);
        panel1.add(saveDetails);

        JButton checkAvailability = new JButton("Check Availability");
        checkAvailability.setBounds(300,320,150,40);
        //checkAvailability.setBackground(Color.decode("#e8d8ff"));
        checkAvailability.setEnabled(false);
        panel2.add(checkAvailability);

        JButton back = new JButton("Back");
        back.setBounds(450,300,150,40);
        //back.setBackground(Color.decode("#e8d8ff"));
        panel3.add(back);

        JButton confirm = new JButton("Confirm Consultation");
        confirm.setBounds(300,300,150,40);
        //confirm.setBackground(Color.decode("#e8d8ff"));
        panel3.add(confirm);




        //-------------- error messages -----------------
        JLabel Error1 = new JLabel("Name Can Only Have Letters");
        Error1.setFont(new Font("Calibri", Font.PLAIN, 10));
        Error1.setVisible(false);
        Error1.setForeground(Color.RED);
        Error1.setBounds(250,105,200,30);
        panel1.add(Error1);

        JLabel Error2 = new JLabel("Surname Can Only Have Letters");
        Error2.setFont(new Font("Arial", Font.PLAIN, 10));
        Error2.setVisible(false);
        Error2.setForeground(Color.RED);
        Error2.setBounds(250,155,200,30);
        panel1.add(Error2);

        JLabel Error3 = new JLabel("Use the Correct Format YYYY-MM-DD");
        Error3.setFont(new Font("Arial", Font.PLAIN, 10));
        Error3.setVisible(false);
        Error3.setForeground(Color.RED);
        Error3.setBounds(250,205,200,30);
        panel1.add(Error3);

        JLabel Error4 = new JLabel("Phone Number Format Error");
        Error4.setFont(new Font("Arial", Font.PLAIN, 10));
        Error4.setVisible(false);
        Error4.setForeground(Color.RED);
        Error4.setBounds(250,250,200,30);
        panel1.add(Error4);

        JLabel idNumberError = new JLabel("Enter ID Number without X or Y");
        idNumberError.setFont(new Font("Arial", Font.PLAIN, 10));
        idNumberError.setVisible(false);
        idNumberError.setForeground(Color.RED);
        idNumberError.setBounds(250,305,200,30);
        panel1.add(idNumberError);

        JLabel dateError = new JLabel("Select a Date");
        dateError.setFont(new Font("Arial", Font.PLAIN, 10));
        dateError.setVisible(false);
        dateError.setForeground(Color.RED);
        dateError.setBounds(200,155,200,30);
        panel2.add(dateError);

        JLabel timeError = new JLabel("Select a proper start Time");
        timeError.setFont(new Font("Arial", Font.PLAIN, 10));
        timeError.setVisible(false);
        timeError.setForeground(Color.RED);
        timeError.setBounds(200,210,200,30);
        panel2.add(timeError);

        JLabel timeError2 = new JLabel("Select a proper end Time");
        timeError2.setFont(new Font("Arial", Font.PLAIN, 10));
        timeError2.setVisible(false);
        timeError2.setForeground(Color.RED);
        timeError2.setBounds(200,258,200,30);
        panel2.add(timeError2);




        //-------------- Creating actions for buttons -----------------
        saveDetails.addActionListener(e -> {
            String name1 = nameField.getText();
            String surname1 = surnameField.getText();
            String dateofbirth1 = dateofbirthField.getText();
            String mobilenumber1 = mobilenumberField.getText();
            Random rand = new Random();
            int patientID = rand.nextInt(10);
            String NIC1 = NICField.getText();

            if (name1.matches("[a-zA-Z]+") && surname1.matches("[a-zA-Z]+") && dateofbirth1.matches("[0-9]{4}-[0-9]{2}-[0-9]{2}") && mobilenumber1.matches("[0-9]{10}") && NIC1.matches("[0-9]{12}")) {
                Patient.patients.add(new Patient(name1, surname1, dateofbirth1, mobilenumber1, patientID, NIC1));
                JOptionPane.showMessageDialog(null, "Patient Added Successfully");
                panel2.setBackground(new Color( 65, 216, 250));
                checkAvailability.setEnabled(true);
                doctors.setEnabled(true);
                timeField.setEnabled(true);
                dateField.setEnabled(true);
                timeField2.setEnabled(true);

            } else {
                if (!name1.matches("[a-zA-Z]+")) {
                    Error1.setVisible(true);
                } else {
                    Error1.setVisible(false);
                }
                if (!surname1.matches("[a-zA-Z]+")) {
                    Error2.setVisible(true);
                } else {
                    Error2.setVisible(false);
                }
                if (!dateofbirth1.matches("[0-9]{4}-[0-9]{2}-[0-9]{2}")) {
                    Error3.setVisible(true);
                } else {
                    Error3.setVisible(false);
                }
                if (!mobilenumber1.matches("[0-9]{10}")) {
                    Error4.setVisible(true);
                } else {
                    Error4.setVisible(false);
                }
                if (!NIC1.matches("[0-9]{12}")) {
                    idNumberError.setVisible(true);
                } else {
                    idNumberError.setVisible(false);
                }
            }
        });

        checkAvailability.addActionListener(e -> {
            try {
                LocalTime time1 = LocalTime.parse(timeField.getText());
                LocalTime time2 = LocalTime.parse(timeField2.getText());
                LocalDate date1 = LocalDate.parse(dateField.getText());
                if (date1.isBefore(LocalDate.now())) {
                    dateError.setVisible(true);
                } else {
                    dateError.setVisible(false);
                }
                if (time1.isBefore(LocalTime.now())) {
                    timeError.setVisible(true);
                } else {
                    timeError.setVisible(false);
                }
                if (time2.isBefore(time1)) {
                    timeError2.setVisible(true);
                } else {
                    timeError2.setVisible(false);
                }

                if (time1.isBefore(time2) && time1.isAfter(LocalTime.of(9, 0)) && time2.isBefore(LocalTime.of(17, 0))) {
                    timeError.setVisible(false);
                    timeError2.setVisible(false);
                    dateError.setVisible(false);
                    saveDetails.setEnabled(true);

                    //calculating hourly cost
                    Duration duration = Duration.between(time1, time2);
                    String nic = NICField.getText();
                    double totalTPrice;
                    int pricePerHour = 15;

                    for (Patient patient : Patient.patients) {
                        if (patient.getNIC().equals(nic)) {
                            pricePerHour = 25;
                            break;
                        }
                    }
                    totalTPrice = pricePerHour * duration.toHours();


                   if (WestminsterSkinConsultationManager.checkAvailability(time1.toString(), time2.toString(), date1.toString(), WestminsterSkinConsultationManager.doctors.get(doctors.getSelectedIndex()).getMedicalLicenseNumber())) {
                       JOptionPane.showMessageDialog(null, "Doctor is available");
                       doctor.setVisible(true);
                       starttime.setVisible(true);
                       endtime.setVisible(true);
                       date.setVisible(true);

                       doctorlabel.setText(WestminsterSkinConsultationManager.doctors.get(doctors.getSelectedIndex()).getName() + " " + WestminsterSkinConsultationManager.doctors.get(doctors.getSelectedIndex()).getSurname() + " " + WestminsterSkinConsultationManager.doctors.get(doctors.getSelectedIndex()).getMedicalLicenseNumber());
                       doctorlabel.setVisible(true);
                       starttimelabel.setText(time1.toString());
                       starttimelabel.setVisible(true);
                       endtimelabel.setText(time2.toString());
                       endtimelabel.setVisible(true);
                       datelabel.setText(date1.toString());
                       datelabel.setVisible(true);
                       cost.setVisible(true);
                       costlabel.setText(String.valueOf(totalTPrice));
                       costlabel.setVisible(true);
                       panel3.setBackground(new Color( 65, 216, 250));


                   }else {
                          JOptionPane.showMessageDialog(null, "Doctor is not available at this time");
                          doctorlabel.setVisible(false);
                          starttimelabel.setVisible(false);
                          endtimelabel.setVisible(false);
                          datelabel.setVisible(false);
                          costlabel.setVisible(false);
                          checkAvailability.setEnabled(false);
                   }
                   
                } else {
                    if (!time1.isBefore(time2)) {
                        timeError.setVisible(true);
                    } else {
                        timeError.setVisible(false);
                    }
                    if (!time1.isAfter(LocalTime.of(8, 0))) {
                        timeError.setVisible(true);
                    } else {
                        timeError.setVisible(false);
                    }
                    if (!time2.isBefore(LocalTime.of(17, 0))) {
                        timeError2.setVisible(true);
                    } else {
                        timeError2.setVisible(false);
                    }
                    if (!date1.isAfter(LocalDate.now())) {
                        dateError.setVisible(true);
                    } else {
                        dateError.setVisible(false);
                    }
                }
            } catch (DateTimeParseException e1) {
                dateError.setVisible(true);
            }
        });

        back.addActionListener(e -> {
            this.dispose();
            new GUImain();
        });

        confirm.addActionListener(e -> {
            Consultation.consultations.add(new Consultation(WestminsterSkinConsultationManager.doctors.get(doctors.getSelectedIndex()).getMedicalLicenseNumber(),WestminsterSkinConsultationManager.generateConsultationID(),WestminsterSkinConsultationManager.doctors.get(doctors.getSelectedIndex()),nameField.getText(),NICField.getText(), LocalDate.parse(dateField.getText()) , LocalTime.parse(timeField2.getText()),LocalTime.parse(timeField.getText()) , Double.parseDouble(costlabel.getText()), NotesField.getText()));
            JOptionPane.showMessageDialog(null, "Consultation Confirmed");
            System.out.println(NICField.getText());
            System.out.println(Consultation.consultations.get(0));


            try {
                String key = "abcdefghijklmnop";  // key must be 16 bytes long
                SecretKeySpec secretKey = new SecretKeySpec(key.getBytes(), "AES");
                Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");

                String message = NotesField.getText() ;
                System.out.println("Original message: " + message);

                // Encrypt the message
                cipher.init(Cipher.ENCRYPT_MODE, secretKey);
                byte[] encrypted = cipher.doFinal(message.getBytes());
                String encryptedString = Base64.getEncoder().encodeToString(encrypted);
                System.out.println("Encrypted message: " + encryptedString);
                Consultation.consultations.get(Consultation.consultations.size()-1).setNotes(encryptedString);
                WestminsterSkinConsultationManager.saveconsult();

                // Decrypt the message
                cipher.init(Cipher.DECRYPT_MODE, secretKey);
                byte[] decrypted = cipher.doFinal(Base64.getDecoder().decode(encryptedString));
                String decryptedString = new String(decrypted);
                System.out.println("Decrypted message: " + decryptedString);


            this.dispose();
            new GUImain();
        }   catch (Exception EX) {
                EX.printStackTrace();
            }
        });



        //-------------- frame -----------------
        setTitle("Add A Consultation");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1360, 768);
        setVisible(true);
        setLocationRelativeTo(null);
        setResizable(false);
        setLayout(null);
        getContentPane().setBackground(new Color(65, 216, 250));


        add(panel1);
        add(panel2);
        add(panel3);

    }





}
