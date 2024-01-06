package Transactions;

import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.Color;
import java.awt.Cursor;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;

import Connector.Connector;

public class PinChange extends JFrame implements ActionListener {

    ImageIcon _backgroundImage = new ImageIcon(new ImageIcon("lib/atm.jpg").getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT));
    JButton _change,  _back;
    JPasswordField _newPinTextField, _reEnteredPin;
    String _cardNumber;
    String _pin;
    
    public PinChange(String _cardNumber, String _pin){
        this._cardNumber = _cardNumber;
        this._pin = _pin;
        setLayout(null);

        JLabel _atmImage = new JLabel(_backgroundImage);
        _atmImage.setBounds(0, 0, 900, 900);
        add(_atmImage);

        JLabel _newPin = new JLabel("New Pin: ");
        _newPin.setBounds(140, 250, 700, 40);
        _newPin.setForeground(Color.WHITE);
        _newPin.setFont(new Font("Century Gothic", Font.BOLD, 20));
        _atmImage.add(_newPin);

        _newPinTextField = new JPasswordField();
        _newPinTextField.setBounds(140, 300, 380, 40);
        _newPinTextField.setBorder(null);
        _newPinTextField.setFont(new Font("Century Gothic", Font.BOLD, 20));
        add(_newPinTextField);

        JLabel _reEnterPin = new JLabel("Re- Enter New Pin: ");
        _reEnterPin.setBounds(140, 350, 700, 40);
        _reEnterPin.setForeground(Color.WHITE);
        _reEnterPin.setFont(new Font("Century Gothic", Font.BOLD, 20));
        _atmImage.add(_reEnterPin);

        _reEnteredPin = new JPasswordField();
        _reEnteredPin.setBounds(140, 400, 380, 40);
        _reEnteredPin.setBorder(null);
        _reEnteredPin.setFont(new Font("Century Gothic", Font.BOLD, 20));
        add(_reEnteredPin);

        _change = new JButton("Change");
        _change.setBackground(Color.WHITE);
        _change.setForeground(Color.BLACK);
        _change.setFont(new Font("Century Gothic", Font.BOLD, 20));
        _change.setBounds(320, 463, 200, 40);
        _change.setBorder(null);
        _change.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        _change.setFocusPainted(false);
        _change.addActionListener(this);
        _atmImage.add(_change);


        _back = new JButton("Back");
        _back.setBackground(Color.RED);
        _back.setForeground(Color.WHITE);
        _back.setFont(new Font("Century Gothic", Font.BOLD, 20));
        _back.setBounds(320, 520, 200, 40);
        _back.setBorder(null);
        _back.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        _back.setFocusPainted(false);
        _back.addActionListener(this);
        _atmImage.add(_back);


        setSize(900, 900);
        setLocation(300,0);
        setUndecorated(true);
        setVisible(true);
    }

     @Override
    public void actionPerformed(ActionEvent _actionEvent) {
        if(_actionEvent.getSource() == _back){
            setVisible(false);
            new Transaction(_cardNumber, _pin).setVisible(true);
        } else if (_actionEvent.getSource() == _change){
            String _newPin = new String(_newPinTextField.getPassword());
            String _reEnteredNewPin = new String(_reEnteredPin.getPassword());
            if (!_newPin.equals(_reEnteredNewPin)){
                JOptionPane.showMessageDialog(null, "Pins Don't Match");
                return;
            } else if (_newPin.length() < 4 || _newPin.length() > 4){
                JOptionPane.showMessageDialog(null, "Pin Must be 4 digits only");
                return;
            } else if (_reEnteredNewPin.length() < 4 || _reEnteredNewPin.length() > 4){
                JOptionPane.showMessageDialog(null, "Pin Must be 4 digits only");
                return;
            } else if (_newPin.equals("") || _reEnteredNewPin.equals("")){
                JOptionPane.showMessageDialog(null, "Pin Should not be Empty");
            } else if (_newPin.equals(_reEnteredNewPin)){
                try {
                    Connector _connector = new Connector();
                    String _bankQuery = "UPDATE BANK SET _pin = '"+_newPin+"' WHERE _pin = '"+_pin+"' AND _cardNumber = '"+_cardNumber+"'";
                    String _loginQuery = "UPDATE LOGIN SET _pin = '"+_newPin+"' WHERE _pin = '"+_pin+"' AND _cardNumber = '"+_cardNumber+"'";
                    String _signUpAccountDetailsQuery = "UPDATE SIGNUP_ACCOUNT_DETAILS SET _pin = '"+_newPin+"' WHERE _pin = '"+_pin+"' AND _cardNumber = '"+_cardNumber+"'";
                    
                    _connector._stmt.executeUpdate(_bankQuery);
                    _connector._stmt.executeUpdate(_loginQuery);
                    _connector._stmt.executeUpdate(_signUpAccountDetailsQuery);


                    JOptionPane.showMessageDialog(null, "Pin Successfully Changed");
                    setVisible(false);
                    new Transaction(_cardNumber, _pin).setVisible(true);

                } catch (SQLException e) {
                    System.out.println(e);
                    JOptionPane.showMessageDialog(null, "An Error has Occurred", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }

    public static void main(String args[]) {
        new PinChange("", "");
    }
}
