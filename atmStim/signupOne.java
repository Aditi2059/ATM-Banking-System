package atmStim;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import com.toedter.calendar.JDateChooser;

public class signupOne extends JFrame implements ActionListener {
    JTextField nameTextField, fNameTextField, emailTextField, addressTextField, CityTextField, StateTextField, PinTextField ;
    JDateChooser dateChooser;
    JButton next;
    JRadioButton other, male, female, married, unmarried;
    long random;
    signupOne(){

        setLayout(null);

        Random ran = new Random();
        random = Math.abs((ran.nextLong() % 9000L) + 1000L);

        JLabel formNo = new JLabel("Application Form no:" + random);
        formNo.setFont(new Font("Raleway", Font.BOLD, 30));
        formNo.setBounds(140,20,600,40);
        add(formNo);

        JLabel personalDetails = new JLabel("Page 1: Personal Details");
        personalDetails.setFont(new Font("Raleway", Font.BOLD, 22));
        personalDetails.setBounds(290,80,400,30);
        add(personalDetails);

        JLabel name = new JLabel("Name:");
        name.setFont(new Font("Raleway", Font.BOLD, 30));
        name.setBounds(100,140,100,30);
        add(name);

        nameTextField = new JTextField();
        nameTextField.setFont(new Font("Raleway", Font.BOLD,14));
        nameTextField.setBounds(400,140,400,30);
        add(nameTextField);

        JLabel fname = new JLabel("Father's Name:");
        fname.setFont(new Font("Raleway", Font.BOLD, 30));
        fname.setBounds(100,190,750,30);
        add(fname);

        fNameTextField = new JTextField();
        fNameTextField.setFont(new Font("Raleway", Font.BOLD,14));
        fNameTextField.setBounds(400,190,400,30);
        add(fNameTextField);

        JLabel dob = new JLabel("Date of Birth:");
        dob.setFont(new Font("Raleway", Font.BOLD, 30));
        dob.setBounds(100,240,250,30);
        add(dob);

        dateChooser = new JDateChooser();
        dateChooser.setBounds(400, 240, 400, 30);
        dateChooser.setBackground(new Color(105,105,105));
        add(dateChooser);

        JLabel gender = new JLabel("Gender:");
        gender.setFont(new Font("Raleway", Font.BOLD, 30));
        gender.setBounds(100,290,200,30);
        add(gender);

        male = new JRadioButton("Male");
        male.setBounds(400, 290, 60,30);
        male.setBackground(Color.WHITE);
        add(male);

        female = new JRadioButton("Female");
        female.setBounds(550, 290, 120,30);
        female.setBackground(Color.WHITE);
        add(female);

        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(male);
        genderGroup.add(female);

        JLabel email = new JLabel("Email:");
        email.setFont(new Font("Raleway", Font.BOLD, 30));
        email.setBounds(100,340,200,30);
        add(email);

        emailTextField = new JTextField();
        emailTextField.setFont(new Font("Raleway", Font.BOLD,14));
        emailTextField.setBounds(400,340,400,30);
        add(emailTextField);

        JLabel maritalStatus = new JLabel("Marital Status:");
        maritalStatus.setFont(new Font("Raleway", Font.BOLD, 30));
        maritalStatus.setBounds(100,390,300,30);
        add(maritalStatus);

        married = new JRadioButton("Married");
        married.setBounds(400, 390, 100,30);
        married.setBackground(Color.WHITE);
        add(married);

        unmarried = new JRadioButton("Unmarried");
        unmarried.setBounds(550, 390, 100,30);
        unmarried.setBackground(Color.WHITE);
        add(unmarried);

        other = new JRadioButton("Other ");
        other.setBounds(680, 390, 100,30);
        other.setBackground(Color.WHITE);
        add(other );

        ButtonGroup maritalStatusGroup = new ButtonGroup();
        maritalStatusGroup.add(married);
        maritalStatusGroup.add(unmarried);
        maritalStatusGroup.add(other);

        JLabel address = new JLabel("Address:");
        address.setFont(new Font("Raleway", Font.BOLD, 30));
        address.setBounds(100,440,250,30);
        add(address);

        addressTextField = new JTextField();
        addressTextField .setFont(new Font("Raleway", Font.BOLD,14));
        addressTextField .setBounds(400,440,400,30);
        add(addressTextField );

        JLabel City = new JLabel("City:");
        City.setFont(new Font("Raleway", Font.BOLD, 30));
        City.setBounds(100,490,250,30);
        add(City);

        CityTextField = new JTextField();
        CityTextField .setFont(new Font("Raleway", Font.BOLD,14));
        CityTextField .setBounds(400,490,400,30);
        add(CityTextField);

        JLabel State = new JLabel("State:");
        State.setFont(new Font("Raleway", Font.BOLD, 30));
        State.setBounds(100,590,250,30);
        add(State);

        StateTextField = new JTextField();
        StateTextField .setFont(new Font("Raleway", Font.BOLD,14));
        StateTextField .setBounds(400,590,400,30);
        add(StateTextField);

        JLabel PinCode = new JLabel("Pin Code:");
        PinCode.setFont(new Font("Raleway", Font.BOLD, 30));
        PinCode.setBounds(100,540,250,30);
        add(PinCode);

        PinTextField = new JTextField();
        PinTextField .setFont(new Font("Raleway", Font.BOLD,14));
        PinTextField .setBounds(400,540,400,30);
        add(PinTextField);

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
        String formNo = "" +random;
        String name = nameTextField.getText();
        String fname = fNameTextField.getText();
        String dob = ((JTextField) dateChooser.getDateEditor().getUiComponent()).getText();
        String gender = null;
        if (male.isSelected()){
            gender = "Male";
        } else if (female.isSelected()) {
            gender = "Female";
        }
        String email = emailTextField.getText();
        String maritalStatus = null;
        if (married.isSelected()){
            maritalStatus = "Married";
        } else if (unmarried.isSelected()) {
            maritalStatus = "Unmarried";
        } else if (other.isSelected()) {
            maritalStatus = "Other";
        }
        String address = addressTextField.getText();
        String City = CityTextField.getText();
        String State = StateTextField.getText();
        String PinCode = PinTextField.getText();

        try {
            if (name.equals("")){
                JOptionPane.showMessageDialog(null, "Name is required");
            }else {
                Conn conn = new Conn();
                String query = "insert into signup values('"+formNo+"' , '"+name+"' , '"+fname+"' , '"+dob+"','"+gender+"' , '"+email+"' , '"+maritalStatus+"' , '"+address+"', '"+City+"' , '"+State+"' , '"+PinCode+"')";
                conn.s.executeUpdate(query);

                setVisible(false);
                new SignUpTwo(formNo).setVisible(true);
            }
        }catch (Exception e){
            System.out.println(e);
        }
    }
    public static void main(String[] args) {

        new signupOne();
    }


}
