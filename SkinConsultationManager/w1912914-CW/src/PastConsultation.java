import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class PastConsultation extends JFrame {

    PastConsultation(){

        JLabel label = new JLabel("Past Consultations");
        label.setBounds(500, 0, 600, 50);
        label.setFont(new Font("MV Boli", Font.PLAIN, 30));
        label.setVisible(true);
        label.setForeground(Color.BLACK);


        JPanel panel = new JPanel();
        panel.setBounds(30, 50, 300, 600);
        panel.setBackground(new Color(234, 177, 250));
        panel.setLayout(null);

        JPanel panel2 = new JPanel();
        panel2.setBounds(330, 50, 900, 600);
       // panel2.setBackground(new Color(234, 177, 250));
        panel2.setLayout(null);



        JLabel label1 = new JLabel("Enter NIC number");
        label1.setBounds(50, 250, 300, 50);
        label1.setFont(new Font("Arial", Font.PLAIN, 20));
        label1.setForeground(Color.BLACK);
        label1.setVisible(true);
        panel.add(label1);

        JTextField textfield = new JTextField();
        textfield.setBounds(30, 300, 150, 40);
        textfield.setFont(new Font("Arial", Font.PLAIN, 20));
        textfield.setForeground(Color.BLACK);
        textfield.setVisible(true);
        panel.add(textfield);

        JButton button = new JButton("Search");
        button.setBounds(70, 350, 100, 50);
        button.setFont(new Font("Arial", Font.PLAIN, 20));
        button.setForeground(Color.BLACK);
        button.setVisible(true);
        panel.add(button);

        JButton back = new JButton("Back");
        back.setBounds(700, 550, 100, 50);
        back.setFont(new Font("Arial", Font.PLAIN, 20));
        back.setForeground(Color.BLACK);
        back.setVisible(true);
        panel2.add(back);




        button.addActionListener(e -> {

            String nic = textfield.getText();

            String[] columnnames = {"doctorID, consultationID, doctorName, patientName, nic, date, starttime, endtime, price, notes "};

            DefaultTableModel doctor_table = new DefaultTableModel(columnnames, 0);
            JTable doctor = new JTable(doctor_table);
            doctor.setAutoCreateRowSorter(true);

            for (int i = 0; i < Consultation.consultations.size(); i++) {
                String idnum = Consultation.consultations.get(i).getNic();
                if (nic.equals(idnum)) {
                    JOptionPane.showMessageDialog(null, "Consultations available");
                    String ID = Consultation.consultations.get(i).getDoctorID();
                    String consultID = Consultation.consultations.get(i).getConsultationID();
                    Doctor docname = Consultation.consultations.get(i).getDoctorName();
                    String name = Consultation.consultations.get(i).getPatientName();
                    String nicnum = Consultation.consultations.get(i).getNic();
                    LocalDate date = Consultation.consultations.get(i).getDate();
                    LocalTime sttime = Consultation.consultations.get(i).getStarttime();
                    LocalTime entime = Consultation.consultations.get(i).getEndtime();
                    double price = Consultation.consultations.get(i).getPrice();
                    String note = Consultation.consultations.get(i).getNotes();

                    Object[] row = {ID, consultID, docname, name, nicnum, date, sttime, entime, price, note};
                    doctor_table.addRow(row);


                    //String[] columnNames = {"Doctor Name", "Patient Name", "NIC", "Date", "Start Time", "End Time", "Price", "Notes"};


                    JScrollPane pane = new JScrollPane(doctor);
                    pane.setBounds(0, 0, 900, 600);
                    panel2.add(pane);

                }
            }
        });


        setTitle("Add A Consultation");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1280, 720);
        setVisible(true);
        setLocationRelativeTo(null);
        setResizable(false);
        setLayout(null);
        getContentPane().setBackground(new Color(65, 216, 250));
        add(label);
        add(panel);
        add(panel2);

    }
}
