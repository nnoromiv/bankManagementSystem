package Transactions;

import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.awt.Color;
import java.awt.Cursor;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import Connector.Connector;


public class BalanceEnquiry extends JFrame implements ActionListener {

    ImageIcon _backgroundImage = new ImageIcon(new ImageIcon("lib/atm.jpg").getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT));
    JButton _back;
    String _cardNumber;
    String _pin;
    
    
    /**
     * The BalanceEnquiry function is used to display the balance of a user's account.
     * 
     *
     * @param String _cardNumber Identify the user's account
     * @param String _pin Get the pin from the database
     *
     * @return The balance of the account
     *
     * @nnoromiv https://www.linkedin.com/in/nnorom
     */
    public BalanceEnquiry(String _cardNumber, String _pin){
        this._cardNumber = _cardNumber;
        this._pin = _pin;
        setLayout(null);

        JLabel _atmImage = new JLabel(_backgroundImage);
        _atmImage.setBounds(0, 0, 900, 900);
        add(_atmImage);

        _back = new JButton("Back");
        _back.setBackground(Color.RED);
        _back.setForeground(Color.WHITE);
        _back.setFont(new Font("Century Gothic", Font.BOLD, 20));
        _back.setBounds(323, 507, 200, 40);
        _back.setBorder(null);
        _back.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        _back.setFocusPainted(false);
        _back.addActionListener(this);
        _atmImage.add(_back);

        Connector _connector = new Connector();
        String _bankQuery = "SELECT * FROM BANK WHERE _pin = '"+_pin+"' AND _cardNumber = '"+_cardNumber+"'";
        String _signUpAccountDetailQuery = "SELECT * FROM SIGNUP_ACCOUNT_DETAILS WHERE _pin = '"+_pin+"' AND _cardNumber = '"+_cardNumber+"'";
            
        int _balance = 0;
        String _accountType = "";
        ResultSet _result, _signUpResult;

        try {
            _result = _connector._stmt.executeQuery(_bankQuery);
            while(_result.next()){
                if(_result.getString("_type").equals("Deposit")){
                    _balance += Integer.parseInt(_result.getString("_amount"));
                } else {
                    _balance -= Integer.parseInt(_result.getString("_amount"));
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }

        try {
            _signUpResult = _connector._stmt.executeQuery(_signUpAccountDetailQuery);

            while(_signUpResult.next()){
                _accountType += _signUpResult.getString("_accountType");
            }
        } catch (Exception e) {
            System.out.println(e);
        }

        JLabel _balanceEnquiry = new JLabel("Your " + _accountType + " balance is $ " + _balance);
        _balanceEnquiry.setBounds(140, 350, 700, 40);
        _balanceEnquiry.setForeground(Color.WHITE);
        _balanceEnquiry.setFont(new Font("Century Gothic", Font.BOLD, 18));
        _atmImage.add(_balanceEnquiry);

        setSize(900, 900);
        setLocation(300,0);
        setUndecorated(true);
        setVisible(true);
    }

    
    /**
     * The actionPerformed function is called when the user clicks on a button.
     * It will check which button was clicked and perform an action based on that.
     
     *
     * @param ActionEvent _actionEvent Determine which button was pressed
     *
     * @return Void, so it cannot be returned
     *
     * @nnoromiv https://www.linkedin.com/in/nnorom
     */
    @Override
    public void actionPerformed(ActionEvent _actionEvent) {
        if(_actionEvent.getSource() == _back){
            setVisible(false);
            new Transaction(_cardNumber, _pin).setVisible(true);
        }
    }

    
    /**
     * The main function of the program.
     * 
     *
     * @param String args[] Pass command line arguments to the main function
     *
     * @return Void
     *
     * @nnoromiv https://www.linkedin.com/in/nnorom
     */
    public static void main(String args[]) {
        new BalanceEnquiry("", "");
    }
}

