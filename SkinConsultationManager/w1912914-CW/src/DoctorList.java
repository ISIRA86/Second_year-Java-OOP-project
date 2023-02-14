import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Comparator;

public class DoctorList extends JFrame {

    private JButton back;
    private JButton reset;
     JButton Sort;

    DoctorList() {

        JLabel topic = new JLabel();
        topic.setText("ALL DOCTORS DETAILS");
        topic.setBounds(120, 20, 550, 20);
        topic.setFont(new Font(Font.DIALOG_INPUT, Font.BOLD, 20));
        topic.setForeground(new Color(17, 17, 17));

        String[] columnNames = {"Medical License Number", "Name", "Surname", "Date of Birth", "Mobile Number", "Specialization"};


        String[][] data = new String[WestminsterSkinConsultationManager.doctors.size()][6];
        for (int i = 0; i < WestminsterSkinConsultationManager.doctors.size(); i++) {
            data[i][0] = WestminsterSkinConsultationManager.doctors.get(i).getMedicalLicenseNumber();
            data[i][1] = WestminsterSkinConsultationManager.doctors.get(i).getName();
            data[i][2] = WestminsterSkinConsultationManager.doctors.get(i).getSurname();
            data[i][3] = WestminsterSkinConsultationManager.doctors.get(i).getDateOfBirth();
            data[i][4] = WestminsterSkinConsultationManager.doctors.get(i).getMobileNumber();
            data[i][5] = WestminsterSkinConsultationManager.doctors.get(i).getSpecialization();
        }



        JTable table = new JTable(data,columnNames);
        table.setBounds(0,0 , 1000, 700);
        table.setRowHeight(30);
        table.setFont(new Font(Font.DIALOG_INPUT, Font.BOLD, 12));
        table.setForeground(new Color(17, 17, 17));
        table.setVisible(true);



        JButton back = new JButton();
        back.setBounds(750, 700, 100, 50);
        back.setText("Back");
        back.setFocusable(false);
        back.setFont(new Font("MV Boli", Font.PLAIN, 15));

        JButton reset = new JButton();
        reset.setBounds(850, 700, 100, 50);
        reset.setText("Reset");
        reset.setFocusable(false);
        reset.setFont(new Font("MV Boli", Font.PLAIN, 15));

        JButton Sort = new JButton();
        Sort.setBounds(30, 700, 100, 50);
        Sort.setText("Sort");
        Sort.setFocusable(false);
        Sort.setFont(new Font("MV Boli", Font.PLAIN, 15));

        setTitle("View Doctor List");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1000, 800);
        setVisible(true);
        setLocationRelativeTo(null);
        setResizable(false);
        setLayout(null);
        //getContentPane().setBackground(new Color(65, 216, 250));

        back.addActionListener(e -> {
            this.dispose();
            new GUImain();
        } );

        reset.addActionListener(e -> {
            this.dispose();
            DoctorList doc = new DoctorList();
            doc.setVisible(true);
        } );

        Sort.addActionListener(e -> {
            WestminsterSkinConsultationManager.doctors.sort(Comparator.comparing(Person::getSurname));
            this.dispose();
            DoctorList doc = new DoctorList();
            doc.setVisible(true);
        } );


        add(back);
        add(reset);
        add(Sort);
        add(table);


    }




}
