import javax.swing.*;
import java.awt.*;

public class GUImain extends JFrame {

    GUImain(){


        JLabel label = new JLabel();

        ImageIcon image = new ImageIcon("doctor.jpg");
        label.setText("Skin Consultation Manager");
        label.setIcon(image);
        label.setHorizontalTextPosition(JLabel.CENTER);
        label.setVerticalTextPosition(JLabel.TOP);
        label.setForeground(Color.BLACK);
        label.setBounds(100,0,600,300);
        label.setFont(new Font("MV Boli", Font.PLAIN, 30));
        label.setIconTextGap(25);
        label.setBackground(new Color(234, 177, 250));

        JButton addConsult = new JButton();
        addConsult.setBounds(80, 350, 200, 50);
        addConsult.setText("Add Consultation");
        addConsult.setFocusable(false);
        addConsult.setFont(new Font("MV Boli", Font.PLAIN, 15));

        JButton availableDoctors = new JButton();
        availableDoctors.setBounds(300, 350, 200, 50);
        availableDoctors.setText("Available Doctors");
        availableDoctors.setFocusable(false);
        availableDoctors.setFont(new Font("MV Boli", Font.PLAIN, 15));

        JButton pastConsultaion = new JButton();
        pastConsultaion.setBounds(80, 450, 200, 50);
        pastConsultaion.setText("Past Consultation");
        pastConsultaion.setFocusable(false);
        pastConsultaion.setFont(new Font("MV Boli", Font.PLAIN, 15));

        JButton exit = new JButton();
        exit.setBounds(300, 450, 200, 50);
        exit.setText("Exit");
        exit.setFocusable(false);
        exit.setFont(new Font("MV Boli", Font.PLAIN, 15));

        setTitle("Skin Consultaion Manager");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 600);
        setVisible(true);
        setLocationRelativeTo(null);
        setResizable(false);
        setLayout(null);
        getContentPane().setBackground(new Color(65, 216, 250));

        addConsult.addActionListener(e -> {
            this.dispose();
            new AddConsultation();
        });

        availableDoctors.addActionListener(e -> {
            this.dispose();
            DoctorList doc = new DoctorList();
            doc.setVisible(true);
        } );

        pastConsultaion.addActionListener(e -> {
            this.dispose();
            new PastConsultation();
        } );

        exit.addActionListener(e -> {
            this.setVisible(false);
            System.exit(0);
        } );

        add(label);
        add(addConsult);
        add(availableDoctors);
        add(pastConsultaion);
        add(exit);


    }
}


