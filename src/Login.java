import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Login extends JFrame implements ActionListener {

    JButton _loginButton, _clearButton, _signUpButton;
    JTextField _cardNumberTextField;
    JPasswordField _pinTextField;
    Image _imageIcon = new ImageIcon("lib/icon.png").getImage();
    ImageIcon __imageIcon = new ImageIcon(new ImageIcon("lib/icon.png").getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT));

    private boolean isWhitespace(char[] password) {
        for (char c : password) {
            if (!Character.isWhitespace(c)) {
                return false;
            }
        }
        return true;
    }

    
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
        _clearButton.setBounds(300, 350, 120, 50);
        _clearButton.setBackground(Color.BLACK);
        _clearButton.setForeground(Color.white);
        _clearButton.setFont(new Font("Century Gothic", Font.BOLD, 24));
        _clearButton.setBorder(null);
        _clearButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        _clearButton.setFocusPainted(false);
        _clearButton.addActionListener(this);
        add(_clearButton);

        _signUpButton = new JButton("Sign Up");
        _signUpButton.setBounds(480, 350, 120, 50);
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
    
    @Override
    public void actionPerformed(ActionEvent _actionEvent) {
        if (_actionEvent.getSource() == _clearButton) {
            if(!_cardNumberTextField.getText().isEmpty() || !isWhitespace(_pinTextField.getPassword())) {
                _cardNumberTextField.setText("");
                _pinTextField.setText("");
            }          
        } else if(_actionEvent.getSource() == _signUpButton) {
            setVisible(false);
            new Signup().setVisible(true);            
        } else if (_actionEvent.getSource() == _loginButton){

        } else {
            throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
        }
    }

    public static void main(String[] args) {
        new Login();
    }

}