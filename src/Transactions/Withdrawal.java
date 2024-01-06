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

public class Withdrawal extends JFrame implements ActionListener {

    ImageIcon _backgroundImage = new ImageIcon(new ImageIcon("lib/atm.jpg").getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT));
    JButton _withdraw, _back;
    JTextField _amountToWithdrawTextField;
    String _cardNumber;
    String _pin;
    
    public Withdrawal(String _cardNumber, String _pin){
        this._cardNumber = _cardNumber;
        this._pin = _pin;
        setLayout(null);

        JLabel _atmImage = new JLabel(_backgroundImage);
        _atmImage.setBounds(0, 0, 900, 900);
        add(_atmImage);

        JLabel _message = new JLabel("Enter amount you want to withdraw ");
        _message.setBounds(160, 270, 700, 40);
        _message.setForeground(Color.WHITE);
        _message.setFont(new Font("Century Gothic", Font.BOLD, 20));
        _atmImage.add(_message);

        _amountToWithdrawTextField = new JTextField();
        _amountToWithdrawTextField.setBounds(140, 350, 380, 40);
        _amountToWithdrawTextField.setBorder(null);
        _amountToWithdrawTextField.setFont(new Font("Century Gothic", Font.BOLD, 20));
        add(_amountToWithdrawTextField);

        _withdraw = new JButton("Withdraw");
        _withdraw.setBackground(Color.WHITE);
        _withdraw.setForeground(Color.BLACK);
        _withdraw.setFont(new Font("Century Gothic", Font.BOLD, 20));
        _withdraw.setBounds(320, 463, 200, 40);
        _withdraw.setBorder(null);
        _withdraw.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        _withdraw.setFocusPainted(false);
        _withdraw.addActionListener(this);
        _atmImage.add(_withdraw);


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
        } else if (_actionEvent.getSource() == _withdraw){
            String _amountToWithdraw = _amountToWithdrawTextField.getText();
            Date _date = new Date();
            if (_amountToWithdraw.equals("")){
                JOptionPane.showMessageDialog(null, "Empty Amount Cannot be deposited");
            } else {
                try {
                    Connector _connector = new Connector();
                    String _query = "INSERT INTO BANK VALUES('"+_date+"', '"+_amountToWithdraw+"','Withdraw','"+_pin+"','"+_cardNumber+"')";
                    _connector._stmt.executeUpdate(_query);

                    JOptionPane.showMessageDialog(null, "$ " + _amountToWithdraw + " Withdrawn Successfully");
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
        new Withdrawal("", "");
    }
}
