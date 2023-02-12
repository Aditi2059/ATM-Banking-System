package atmStim;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class SignUpTwo extends JFrame implements ActionListener {
        JTextField pan, Aadhar;
        JComboBox religion,category, income, education, occupation;
        JButton next;
        JRadioButton syes, sno, eyes, eno;
        String formNo;
        SignUpTwo(String formNo){
            this.formNo = formNo;

            setLayout(null);
            setTitle("New Account Application Form -PAGE 2");

            JLabel AdditionalDetails = new JLabel("Page 2: Additional Details");
            AdditionalDetails.setFont(new Font("Raleway", Font.BOLD, 22));
            AdditionalDetails.setBounds(290,80,400,30);
            add(AdditionalDetails);

            JLabel Religion = new JLabel("Religion:");
            Religion.setFont(new Font("Raleway", Font.BOLD, 30));
            Religion.setBounds(100,140,150,30);
            add(Religion);

            String valReligion[] ={"Hindu", "Muslim", "Sikh","Buddhist", "Christain", "Others"};
            religion = new JComboBox(valReligion);
            religion .setBounds(400,140,400,30);
            religion.setBackground(Color.WHITE);
            add(religion );

            JLabel Category = new JLabel("Category:");
            Category.setFont(new Font("Raleway", Font.BOLD, 30));
            Category.setBounds(100,190,750,30);
            add(Category);

            String valcategory[] ={"General", "OBC", "SC","ST","Others"};
            category = new JComboBox(valcategory);
            category.setBounds(400,190,400,30);
            category.setBackground(Color.WHITE);
            add(category);

            JLabel Income = new JLabel("Income:");
            Income.setFont(new Font("Raleway", Font.BOLD, 30));
            Income.setBounds(100,240,250,30);
            add(Income);

            String incomecategory[] ={"Null", "<1,50,00", "<2,50,00","<5,00,000","Upto 10,00,000"};
            income = new JComboBox(incomecategory);
            income.setBounds(400,240,400,30);
            income.setBackground(Color.WHITE);
            add(income);

            JLabel Educational = new JLabel("Educational");
            Educational.setFont(new Font("Raleway", Font.BOLD, 30));
            Educational.setBounds(100,290,200,30);
            add(Educational);

            JLabel Qualification = new JLabel("Qualification:");
            Qualification.setFont(new Font("Raleway", Font.BOLD, 30));
            Qualification.setBounds(100,320,200,30);
            add(Qualification);

            String eduValue[] ={"Non-Graduate", "Graduate", "Post-Gradate","Doctrate","Others"};
            education = new JComboBox(eduValue);
            education.setBounds(400,315,400,30);
            education.setBackground(Color.WHITE);
            add(education);

            JLabel Occupation = new JLabel("Occupation:");
            Occupation.setFont(new Font("Raleway", Font.BOLD, 30));
            Occupation.setBounds(100,390,300,30);
            add(Occupation);

            String occupationValue[] ={"Salaried", "Self-Employed", "Business","Retired","Student","Others"};
            occupation= new JComboBox(occupationValue);
            occupation.setBounds(400,390,400,30);
            occupation.setBackground(Color.WHITE);
            add(occupation);

            JLabel PanNo = new JLabel("Pan No:");
            PanNo.setFont(new Font("Raleway", Font.BOLD, 30));
            PanNo.setBounds(100,440,250,30);
            add(PanNo);

            pan= new JTextField();
            pan.setFont(new Font("Raleway", Font.BOLD,14));
            pan.setBounds(400,440,400,30);
            add(pan);

            JLabel AadharCard = new JLabel("Aadhar No:");
            AadharCard.setFont(new Font("Raleway", Font.BOLD, 30));
            AadharCard.setBounds(100,490,250,30);
            add(AadharCard);

            Aadhar= new JTextField();
            Aadhar .setFont(new Font("Raleway", Font.BOLD,14));
            Aadhar.setBounds(400,490,400,30);
            add(Aadhar);

            JLabel Senior = new JLabel("Senior Citizen:");
            Senior.setFont(new Font("Raleway", Font.BOLD, 30));
            Senior.setBounds(100,590,250,30);
            add(Senior);

            syes = new JRadioButton("Yes");
            syes.setBounds(400, 590, 100,30);
            syes.setBackground(Color.WHITE);
            add(syes);

            sno = new JRadioButton("No");
            sno.setBounds(550, 590, 100,30);
            sno.setBackground(Color.WHITE);
            add(sno);

            ButtonGroup SeniorCitizen = new ButtonGroup();
            SeniorCitizen.add(syes);
            SeniorCitizen.add(sno);

            JLabel Existing = new JLabel("Existing Account:");
            Existing.setFont(new Font("Raleway", Font.BOLD, 30));
            Existing.setBounds(100,540,350,30);
            add(Existing);

            eyes = new JRadioButton("Yes");
            eyes.setBounds(400, 540, 100,30);
            eyes.setBackground(Color.WHITE);
            add(eyes);

            eno = new JRadioButton("No");
            eno.setBounds(550, 540, 100,30);
            eno.setBackground(Color.WHITE);
            add(eno);

            ButtonGroup existAcc = new ButtonGroup();
            existAcc.add(eyes);
            existAcc.add(eno);

            next = new JButton("Next");
            next.setBackground(Color.BLACK);
            next.setForeground(Color.WHITE);
            next.setFont(new Font("Raleway",Font.BOLD, 14));
            next.setBounds(720, 660, 80, 30);
            next.addActionListener(this);
            add(next);

            getContentPane().setBackground(Color.WHITE);

            setSize(850,800);
            setLocation(350,10);
            setVisible(true);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        }
        @Override
        public void actionPerformed(ActionEvent ae) {
            //String formNo = "" +random;
            String sreligion = (String) religion.getSelectedItem();
            String scategory = (String) category.getSelectedItem();
            String sincome = (String) income.getSelectedItem();
            String seducation = (String) education.getSelectedItem();
            String soccupation = (String) occupation.getSelectedItem();
            String seniorcitizen = null;
            if (syes.isSelected()){
                seniorcitizen = "YES";
            } else if (sno.isSelected()) {
                seniorcitizen = "NO";
            }
            String existingaccount = null;
            if (eyes.isSelected()){
                existingaccount = "YES";
            } else if (eno.isSelected()) {
                existingaccount = "NO";
            }

            String span = pan.getText();
            String sadhar = Aadhar.getText();

            try {
                Conn conn = new Conn();
                String query = "insert into signupTwo values('" + formNo + "','" + sreligion + "' , '" + scategory + "' , '" + sincome + "','" + seducation + "' , '" + soccupation + "' , '" + span + "' , '" + sadhar + "', '" + seniorcitizen + "' , '" + existingaccount + "')";
                conn.s.executeUpdate(query);

                setVisible(false);
                new signupThree(formNo).setVisible(true);
        }catch (Exception e){
                System.out.println(e);
            }
        }
        public static void main(String[] args) {

            new atmStim.SignUpTwo("");
        }

    }
