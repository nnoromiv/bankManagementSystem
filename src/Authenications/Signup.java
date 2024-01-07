package Authenications;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import com.toedter.calendar.JDateChooser;

import Connector.Connector;

public class Signup extends JFrame implements ActionListener{

    // Creates the image to display in the form. This is called when the user clicks on the button
    Image _imageIcon = new ImageIcon("lib/icon.png").getImage();
    long _randomNumber;
    JTextField _fullNameTextField, _motherMaidenNameTextField, _emailAddressTextField, _addressTextField, _cityTextField, _stateTextField, _postalCodeTextField;
    JDateChooser _dobChooser;
    JRadioButton _male, _female, _single, _married, _others;
    JButton _saveAndNext;

    // This is the method that is called when the user clicks on the Signup button
    
    /**
     * The Signup function is used to create a new account for the user.
     * 
     *
     *
     * @return Nothing
     *
     * @nnoromiv https://www.linkedin.com/in/nnorom
     */
    public Signup() {
        setIconImage(_imageIcon);
        setTitle("Automated Bank System - Sign Up - Personal Details");
        setLayout(null);

        Random _randomUtil = new Random();
        _randomNumber = Math.abs((_randomUtil.nextLong() % 9000L) + 1000L);

        JLabel _formPage = new JLabel("Application Form NO: " + _randomNumber);
        _formPage.setBounds(200, 40, 500, 40);
        _formPage.setFont(new Font("Century Gothic", Font.BOLD, 32));
        add(_formPage);

        JLabel _pageName = new JLabel("Personal Details");
        _pageName.setBounds(350, 80, 200, 40);
        _pageName.setFont(new Font("Century Gothic", Font.BOLD, 20));
        add(_pageName);

        JLabel _fullName = new JLabel("Full Name: ");
        _fullName.setBounds(70, 150, 200, 40);
        _fullName.setFont(new Font("Century Gothic", Font.BOLD, 24));
        add(_fullName);

        _fullNameTextField = new JTextField();
        _fullNameTextField.setBounds(370, 150, 430, 40);
        _fullNameTextField.setBorder(null);
        _fullNameTextField.setFont(new Font("Century Gothic", Font.BOLD, 20));
        add(_fullNameTextField);

        JLabel _motherMaidenName = new JLabel("Mother's Maiden Name: ");
        _motherMaidenName.setBounds(70, 200, 300, 40);
        _motherMaidenName.setFont(new Font("Century Gothic", Font.BOLD, 24));
        add(_motherMaidenName);

        _motherMaidenNameTextField = new JTextField();
        _motherMaidenNameTextField.setBounds(370, 200, 430, 40);
        _motherMaidenNameTextField.setBorder(null);
        _motherMaidenNameTextField.setFont(new Font("Century Gothic", Font.BOLD, 20));
        add(_motherMaidenNameTextField);

        JLabel _dob = new JLabel("Date of Birth: ");
        _dob.setBounds(70, 250, 200, 40);
        _dob.setFont(new Font("Century Gothic", Font.BOLD, 24));
        add(_dob);

        _dobChooser = new JDateChooser();
        _dobChooser.setBounds(370, 250, 430, 40);
        _dobChooser.setFont(new Font("Century Gothic", Font.BOLD, 20));
        _dobChooser.setForeground(new Color(105, 105, 105));
        add(_dobChooser);

        JLabel _gender = new JLabel("Gender: ");
        _gender.setBounds(70, 300, 200, 40);
        _gender.setFont(new Font("Century Gothic", Font.BOLD, 24));
        add(_gender);

        _male = new JRadioButton("Male");
        _male.setBounds(370, 300, 210, 40);
        _male.setFont(new Font("Century Gothic", Font.BOLD, 24));
        add(_male);

        _female = new JRadioButton("Female");
        _female.setBounds(595, 300, 210, 40);
        _female.setFont(new Font("Century Gothic", Font.BOLD, 24));
        add(_female);

        ButtonGroup _genderGroup = new ButtonGroup();
        _genderGroup.add(_male);
        _genderGroup.add(_female);

        JLabel _emailAddress = new JLabel("Email Address: ");
        _emailAddress.setBounds(70, 350, 200, 40);
        _emailAddress.setFont(new Font("Century Gothic", Font.BOLD, 24));
        add(_emailAddress);

        _emailAddressTextField = new JTextField();
        _emailAddressTextField.setBounds(370, 350, 430, 40);
        _emailAddressTextField.setBorder(null);
        _emailAddressTextField.setFont(new Font("Century Gothic", Font.BOLD, 20));
        add(_emailAddressTextField);

        JLabel _maritalStatus = new JLabel("Marital Status: ");
        _maritalStatus.setBounds(70, 400, 200, 40);
        _maritalStatus.setFont(new Font("Century Gothic", Font.BOLD, 24));
        add(_maritalStatus);

        _single = new JRadioButton("Single");
        _single.setBounds(370, 400, 100, 40);
        _single.setFont(new Font("Century Gothic", Font.BOLD, 24));
        add(_single);

        _married = new JRadioButton("Married");
        _married.setBounds(533, 400, 150, 40);
        _married.setFont(new Font("Century Gothic", Font.BOLD, 24));
        add(_married);

        _others = new JRadioButton("Others");
        _others.setBounds(695, 400, 100, 40);
        _others.setFont(new Font("Century Gothic", Font.BOLD, 24));
        add(_others);

        ButtonGroup _maritalStatusGroup = new ButtonGroup();
        _maritalStatusGroup.add(_single);
        _maritalStatusGroup.add(_married);
        _maritalStatusGroup.add(_others);

        JLabel _address = new JLabel("Address: ");
        _address.setBounds(70, 450, 200, 40);
        _address.setFont(new Font("Century Gothic", Font.BOLD, 24));
        add(_address);

        _addressTextField = new JTextField();
        _addressTextField.setBounds(370, 450, 430, 40);
        _addressTextField.setBorder(null);
        _addressTextField.setFont(new Font("Century Gothic", Font.BOLD, 20));
        add(_addressTextField);

        JLabel _city = new JLabel("City: ");
        _city.setBounds(70, 500, 200, 40);
        _city.setFont(new Font("Century Gothic", Font.BOLD, 24));
        add(_city);

        _cityTextField = new JTextField();
        _cityTextField.setBounds(370, 500, 430, 40);
        _cityTextField.setBorder(null);
        _cityTextField.setFont(new Font("Century Gothic", Font.BOLD, 20));
        add(_cityTextField);

        JLabel _state = new JLabel("State: ");
        _state.setBounds(70, 550, 200, 40);
        _state.setFont(new Font("Century Gothic", Font.BOLD, 24));
        add(_state);

        _stateTextField = new JTextField();
        _stateTextField.setBounds(370, 550, 430, 40);
        _stateTextField.setBorder(null);
        _stateTextField.setFont(new Font("Century Gothic", Font.BOLD, 20));
        add(_stateTextField);

        JLabel _postalCode = new JLabel("Postal Code: ");
        _postalCode.setBounds(70, 600, 200, 40);
        _postalCode.setFont(new Font("Century Gothic", Font.BOLD, 24));
        add(_postalCode);

        _postalCodeTextField = new JTextField();
        _postalCodeTextField.setBounds(370, 600, 430, 40);
        _postalCodeTextField.setBorder(null);
        _postalCodeTextField.setFont(new Font("Century Gothic", Font.BOLD, 20));
        add(_postalCodeTextField);

        _saveAndNext = new JButton("Save and Next");
        _saveAndNext.setBackground(Color.BLACK);
        _saveAndNext.setForeground(Color.WHITE);
        _saveAndNext.setFont(new Font("Century Gothic", Font.BOLD, 32));
        _saveAndNext.setBounds(70, 680, 730, 50);
        _saveAndNext.setBorder(null);
        _saveAndNext.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        _saveAndNext.setFocusPainted(false);
        _saveAndNext.addActionListener(this);
        add(_saveAndNext);

        setSize(850, 800);
        setLocation(350, 10);
        setVisible(true);
    }

    
    /**
     * The actionPerformed function is called when the user clicks on a button.
     * It creates a form number from the text fields and inserts or updates the record in the database.
     
     *
     * @param ActionEvent _actionEvent Determine which button was clicked
     *
     * @return Void, so it can't be used as a return value
     *
     * @nnoromiv https://www.linkedin.com/in/nnorom
     */
    @Override
    public void actionPerformed(ActionEvent _actionEvent) {
        // Creates a form number from the text fields. This is used to create the form
        String _formNumber = "" + _randomNumber;
        String _fullName = _fullNameTextField.getText();
        String _motherMaidenName = _motherMaidenNameTextField.getText();
        String _emailAddress = _emailAddressTextField.getText();
        String _address = _addressTextField.getText();
        String _city = _cityTextField.getText();
        String _state = _stateTextField.getText();
        String _postalCode = _postalCodeTextField.getText();
        String _dob = ((JTextField) _dobChooser.getDateEditor().getUiComponent()).getText();
        String _gender = "";
        if(_male.isSelected()){
            _gender = "Male";
        } else if (_female.isSelected()){
            _gender = "Female";
        } else {
            _gender = "";
        }
        String _maritalStatus = "";
        if(_single.isSelected()){
            _maritalStatus = "Single";
        } else if (_married.isSelected()){
            _maritalStatus = "Married";
        } else if (_others.isSelected()) {
            _maritalStatus = "Other";
        } else {
            _maritalStatus = "";
        }

        // Inserts or updates the record in the database. This is called when the user clicks the insert button
        try {
            if (_fullName.equals("")) {
                JOptionPane.showMessageDialog(null, "Enter your full name");               
            } else if(_motherMaidenName.equals("")){
                JOptionPane.showMessageDialog(null, "Enter your Mother's Maiden name");
            } else if(_emailAddress.equals("")){
                JOptionPane.showMessageDialog(null, "Enter a unique email");
            } else if(_dob.equals("")){
                JOptionPane.showMessageDialog(null, "You must be born to continue");
            } else if(_gender.equals("")){
                JOptionPane.showMessageDialog(null, "Binary gender is required");
            } else if(_maritalStatus.equals("")){
                JOptionPane.showMessageDialog(null, "You should at least tick Single");
            } else {
                Connector _connector = new Connector();
                String _query = "INSERT INTO SIGNUP VALUES('"+_formNumber+"', '"+_fullName+"', '"+_motherMaidenName+"', '"+_emailAddress+"', '"+_address+"', '"+_city+"', '"+_state+"', '"+_postalCode+"', '"+_dob+"', '"+_gender+"', '"+_maritalStatus+"')";
                _connector._stmt.executeUpdate(_query);

                setVisible(false);
                new AdditionalDetails(_formNumber).setVisible(true);
            }
        } catch (Exception _error) {
            JOptionPane.showMessageDialog(null, "An Error has Occurred", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    
    
    /**
     * The main function of the program.
     * 
     *
     * @param String[] args Pass command line arguments to the program
     *
     * @return Nothing, so you should not add anything to the end of it
     *
     * @nnoromiv https://www.linkedin.com/in/nnorom
     */
    public static void main(String[] args){
        new Signup();
    }
    
}
