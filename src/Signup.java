import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Image;
import java.util.Random;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import com.toedter.calendar.JDateChooser;

public class Signup extends JFrame{

    Image _imageIcon = new ImageIcon("lib/icon.png").getImage();
    JTextField _fullNameTextField, _motherMaidenNameTextField, _emailAddressTextField, _addressTextField, _cityTextField, _stateTextField, _postalCodeTextField;

    public Signup() {
        setIconImage(_imageIcon);
        setTitle("Automated Bank System - Sign Up");
        setLayout(null);

        Random _randomUtil = new Random();
        long _randomNumber = Math.abs((_randomUtil.nextLong() % 9000L) + 1000L);

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

        JDateChooser _dobChooser = new JDateChooser();
        _dobChooser.setBounds(370, 250, 430, 40);
        _dobChooser.setFont(new Font("Century Gothic", Font.BOLD, 20));
        _dobChooser.setForeground(new Color(105, 105, 105));
        add(_dobChooser);

        JLabel _gender = new JLabel("Gender: ");
        _gender.setBounds(70, 300, 200, 40);
        _gender.setFont(new Font("Century Gothic", Font.BOLD, 24));
        add(_gender);

        JRadioButton _male = new JRadioButton("Male");
        _male.setBounds(370, 300, 210, 40);
        _male.setFont(new Font("Century Gothic", Font.BOLD, 24));
        add(_male);

        JRadioButton _female = new JRadioButton("Female");
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

        JRadioButton _single = new JRadioButton("Single");
        _single.setBounds(370, 400, 100, 40);
        _single.setFont(new Font("Century Gothic", Font.BOLD, 24));
        add(_single);

        JRadioButton _married = new JRadioButton("Married");
        _married.setBounds(533, 400, 150, 40);
        _married.setFont(new Font("Century Gothic", Font.BOLD, 24));
        add(_married);

        JRadioButton _others = new JRadioButton("Others");
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

        JButton _saveAndNext = new JButton("Save and Next");
        _saveAndNext.setBackground(Color.BLACK);
        _saveAndNext.setForeground(Color.WHITE);
        _saveAndNext.setFont(new Font("Century Gothic", Font.BOLD, 32));
        _saveAndNext.setBounds(70, 680, 730, 50);
        _saveAndNext.setBorder(null);
        _saveAndNext.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        _saveAndNext.setFocusPainted(false);
        add(_saveAndNext);

        setSize(850, 800);
        setLocation(350, 10);
        setVisible(true);
    }

    public static void main(String[] args){
        new Signup();
    }
    
}
