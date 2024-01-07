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
import javax.swing.JTextField;
import javax.swing.JOptionPane;



import Connector.Connector;


import java.util.Date;

public class Deposit extends JFrame implements ActionListener {

    ImageIcon _backgroundImage = new ImageIcon(new ImageIcon("lib/atm.jpg").getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT));
    JButton _deposit,  _back;
    JTextField _amountToDepositTextField;
    String _cardNumber;
    String _pin;
    
    
    /**
     * The Deposit function is used to deposit money into the user's account.
     * 
     *
     * @param String _cardNumber Pass the card number from the previous screen to this one
     * @param String _pin Pass the pin number to this class
     *
     * @return A boolean value
     *
     * @nnoromiv https://www.linkedin.com/in/nnorom
     */
    public Deposit(String _cardNumber, String _pin){
        this._cardNumber = _cardNumber;
        this._pin = _pin;
        setLayout(null);

        JLabel _atmImage = new JLabel(_backgroundImage);
        _atmImage.setBounds(0, 0, 900, 900);
        add(_atmImage);

        JLabel _message = new JLabel("Enter amount you want to deposit ");
        _message.setBounds(160, 270, 700, 40);
        _message.setForeground(Color.WHITE);
        _message.setFont(new Font("Century Gothic", Font.BOLD, 20));
        _atmImage.add(_message);

        _amountToDepositTextField = new JTextField();
        _amountToDepositTextField.setBounds(140, 350, 380, 40);
        _amountToDepositTextField.setBorder(null);
        _amountToDepositTextField.setFont(new Font("Century Gothic", Font.BOLD, 20));
        add(_amountToDepositTextField);

        _deposit = new JButton("Deposit");
        _deposit.setBackground(Color.WHITE);
        _deposit.setForeground(Color.BLACK);
        _deposit.setFont(new Font("Century Gothic", Font.BOLD, 20));
        _deposit.setBounds(320, 463, 200, 40);
        _deposit.setBorder(null);
        _deposit.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        _deposit.setFocusPainted(false);
        _deposit.addActionListener(this);
        _atmImage.add(_deposit);


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

    
    /**
     * The actionPerformed function is an event handler that handles the events of the buttons in this class.
     * 
     *
     * @param ActionEvent _actionEvent Determine which button was pressed
     *
     * @return Void, so you cannot return anything from it
     *
     * @nnoromiv https://www.linkedin.com/in/nnorom
     */
    @Override
    public void actionPerformed(ActionEvent _actionEvent) {
        if(_actionEvent.getSource() == _back){
            setVisible(false);
            new Transaction(_cardNumber, _pin).setVisible(true);
        } else if (_actionEvent.getSource() == _deposit){
            String _amountToDeposit = _amountToDepositTextField.getText();
            Date _date = new Date();
            if (_amountToDeposit.equals("")){
                JOptionPane.showMessageDialog(null, "Empty Amount Cannot be deposited");
            } else {
                try {
                    Connector _connector = new Connector();
                    String _query = "INSERT INTO BANK VALUES('"+_date+"', '"+_amountToDeposit+"','Deposit','"+_pin+"','"+_cardNumber+"')";
                    _connector._stmt.executeUpdate(_query);

                    JOptionPane.showMessageDialog(null, "$ " + _amountToDeposit + " Deposited Successfully");
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
        new Deposit("", "");
    }
}
