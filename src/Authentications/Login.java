package Authentications;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JOptionPane;


import Connector.Connector;
import Transactions.Transaction;

public class Login extends JFrame implements ActionListener {

    JButton _loginButton, _clearButton, _signUpButton;
    JTextField _cardNumberTextField;
    JPasswordField _pinTextField;
    Image _imageIcon = new ImageIcon("lib/icon.png").getImage();
    ImageIcon __imageIcon = new ImageIcon(new ImageIcon("lib/icon.png").getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT));

    /**
    * Checks if the password is whitespace. This is used to detect passwords that contain spaces in their first and last characters.
    * 
    * @param password - The password to check. Must not be null.
    * 
    * @return true if the password is whitespace false otherwise. Note that whitespace is not considered a whitespace
    */
    private boolean isWhitespace(char[] password) {
        for (char c : password) {
            // Returns true if the character is a whitespace character.
            if (!Character.isWhitespace(c)) {
                return false;
            }
        }
        return true;
    }

    
    
    /**
     * The Login function is used to check if the user has entered a valid card number and pin.
     * If the user has entered a valid card number and pin, then they will be directed to the Transaction page.
     * If not, an error message will appear on screen telling them that their credentials are invalid. 
     
     *
     *
     * @return A boolean value
     *
     * @nnoromiv https://www.linkedin.com/in/nnorom
     */
    public Login() {
        setIconImage(_imageIcon);
        setTitle("Automated Bank System - Welcome");
        setLayout(null);
        
        JLabel _label = new JLabel(__imageIcon);
        _label.setBounds(170, 10, 100, 100);
        add(_label);

        JLabel _welcomeText = new JLabel("Welcome to the Bank");
        _welcomeText.setBounds(300, 40, 400, 40);
        _welcomeText.setFont(new Font("Century Gothic", Font.BOLD, 32));
        add(_welcomeText);

        JLabel _cardNumber = new JLabel("Card Number: ");
        _cardNumber.setBounds(70, 150, 200, 40);
        _cardNumber.setFont(new Font("Century Gothic", Font.BOLD, 24));
        add(_cardNumber);

        _cardNumberTextField = new JTextField();
        _cardNumberTextField.setBounds(300, 150, 300, 40);
        _cardNumberTextField.setBorder(null);
        _cardNumberTextField.setFont(new Font("Century Gothic", Font.BOLD, 20));
        add(_cardNumberTextField);

        JLabel _pin = new JLabel("Pin: ");
        _pin.setBounds(180, 200, 200, 40);
        _pin.setFont(new Font("Century Gothic", Font.BOLD, 24));
        add(_pin);

        _pinTextField = new JPasswordField();
        _pinTextField.setBounds(300, 200, 300, 40);
        _pinTextField.setBorder(null);
        _pinTextField.setFont(new Font("Century Gothic", Font.BOLD, 20));
        add(_pinTextField);

        _loginButton = new JButton("Login");
        _loginButton.setBounds(300, 280, 300, 50);
        _loginButton.setBackground(Color.BLACK);
        _loginButton.setForeground(Color.white);
        _loginButton.setFont(new Font("Century Gothic", Font.BOLD, 24));
        _loginButton.setBorder(null);
        _loginButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        _loginButton.setFocusPainted(false);
        _loginButton.addActionListener(this);
        add(_loginButton);

        _clearButton = new JButton("Clear");
        _clearButton.setBounds(300, 350, 145, 50);
        _clearButton.setBackground(Color.RED);
        _clearButton.setForeground(Color.WHITE);
        _clearButton.setFont(new Font("Century Gothic", Font.BOLD, 24));
        _clearButton.setBorder(null);
        _clearButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        _clearButton.setFocusPainted(false);
        _clearButton.addActionListener(this);
        add(_clearButton);

        _signUpButton = new JButton("Sign Up");
        _signUpButton.setBounds(460, 350, 145, 50);
        _signUpButton.setBackground(Color.BLACK);
        _signUpButton.setForeground(Color.white);
        _signUpButton.setFont(new Font("Century Gothic", Font.BOLD, 24));
        _signUpButton.setBorder(null);
        _signUpButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        _signUpButton.setFocusPainted(false);
        _signUpButton.addActionListener(this);
        add(_signUpButton);
        

        setSize(800, 480);
        setVisible(true);
        setLocation(350, 200);
    }
    
    /**
    * This method is called when one of the buttons is pressed. The button is set to clear if the text field is empty or contains whitespace.
    * 
    * @param _actionEvent - The event that triggered
    */
    @Override
    public void actionPerformed(ActionEvent _actionEvent) {
        // Action for the actionPerformed method.
        if (_actionEvent.getSource() == _clearButton) {
            // set the card number and pin text field
            if(!_cardNumberTextField.getText().isEmpty() || !isWhitespace(_pinTextField.getPassword())) {
                _cardNumberTextField.setText("");
                _pinTextField.setText("");
            }          
        // Action for the actionPerformed method.
        } else if(_actionEvent.getSource() == _signUpButton) {
            setVisible(false);
            new Signup().setVisible(true);            
        // ActionPerformed method for login button.
        } else if (_actionEvent.getSource() == _loginButton){
            Connector _connector = new Connector();
            String _cardNumber = _cardNumberTextField.getText();
            char[] _pinCharacters = _pinTextField.getPassword();
            String _pin = new String(_pinCharacters);

            String _query = "SELECT * FROM LOGIN WHERE _cardNumber = '"+_cardNumber+"' AND _pin = '"+_pin+"'";
            try {
                ResultSet _result = _connector._stmt.executeQuery(_query);
                // This method is called when the next transaction is available.
                if(_result.next()){
                    setVisible(false);
                    new Transaction(_cardNumber,_pin).setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(null, "Incorrect Card Number or Pin", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } catch (Exception _error) {
                JOptionPane.showMessageDialog(null, "An Error has Occurred", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
        }
    }

    /**
    * Entry point for the application. This is the entry point for the application.
    * 
    * @param args - Command line arguments not used in this program but
    */
    public static void main(String[] args) {
        new Login();
    }

}