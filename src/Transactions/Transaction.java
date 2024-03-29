package Transactions;

import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import java.awt.Cursor;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class Transaction extends JFrame implements ActionListener {

    ImageIcon _backgroundImage = new ImageIcon(new ImageIcon("lib/atm.jpg").getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT));
    JButton _deposit, _cashWithdrawal, _fastCash, _miniStatement, _pinChange, _balanceEnquiry, _exit;
    String _cardNumber;
    String _pin;
    
    
    /**
     * The Transaction function is the constructor for the Transaction class.
     * It creates a new JFrame and adds all of the buttons to it.
     
     *
     * @param String _cardNumber Pass the card number from the login class to this class
     * @param String _pin Pass the pin number from the login class to this class
     *
     * @return Nothing
     *
     * @nnoromiv https://www.linkedin.com/in/nnorom
     */
    public Transaction(String _cardNumber, String _pin){
        this._cardNumber = _cardNumber;
        this._pin = _pin;
        setLayout(null);

        JLabel _atmImage = new JLabel(_backgroundImage);
        _atmImage.setBounds(0, 0, 900, 900);
        add(_atmImage);

        JLabel _message = new JLabel("Please select a Transaction ");
        _message.setBounds(200, 250, 700, 40);
        _message.setForeground(Color.WHITE);
        _message.setFont(new Font("Century Gothic", Font.BOLD, 20));
        _atmImage.add(_message);

        _deposit = new JButton("Deposit");
        _deposit.setBackground(Color.WHITE);
        _deposit.setForeground(Color.BLACK);
        _deposit.setFont(new Font("Century Gothic", Font.BOLD, 20));
        _deposit.setBounds(135, 372, 130, 40);
        _deposit.setBorder(null);
        _deposit.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        _deposit.setFocusPainted(false);
        _deposit.addActionListener(this);
        _atmImage.add(_deposit);

        _cashWithdrawal = new JButton("Cash Withdrawal");
        _cashWithdrawal.setBackground(Color.WHITE);
        _cashWithdrawal.setForeground(Color.BLACK);
        _cashWithdrawal.setFont(new Font("Century Gothic", Font.BOLD, 20));
        _cashWithdrawal.setBounds(323, 372, 200, 40);
        _cashWithdrawal.setBorder(null);
        _cashWithdrawal.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        _cashWithdrawal.setFocusPainted(false);
        _cashWithdrawal.addActionListener(this);
        _atmImage.add(_cashWithdrawal);

        _fastCash = new JButton("Fast Cash");
        _fastCash.setBackground(Color.WHITE);
        _fastCash.setForeground(Color.BLACK);
        _fastCash.setFont(new Font("Century Gothic", Font.BOLD, 20));
        _fastCash.setBounds(135, 417, 130, 40);
        _fastCash.setBorder(null);
        _fastCash.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        _fastCash.setFocusPainted(false);
        _fastCash.addActionListener(this);
        _atmImage.add(_fastCash);

        _miniStatement = new JButton("Mini Statement");
        _miniStatement.setBackground(Color.WHITE);
        _miniStatement.setForeground(Color.BLACK);
        _miniStatement.setFont(new Font("Century Gothic", Font.BOLD, 20));
        _miniStatement.setBounds(323, 417, 200, 40);
        _miniStatement.setBorder(null);
        _miniStatement.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        _miniStatement.setFocusPainted(false);
        _miniStatement.addActionListener(this);
        _atmImage.add(_miniStatement);

        _pinChange = new JButton("Pin Change");
        _pinChange.setBackground(Color.WHITE);
        _pinChange.setForeground(Color.BLACK);
        _pinChange.setFont(new Font("Century Gothic", Font.BOLD, 20));
        _pinChange.setBounds(135, 462, 130, 40);
        _pinChange.setBorder(null);
        _pinChange.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        _pinChange.setFocusPainted(false);
        _pinChange.addActionListener(this);
        _atmImage.add(_pinChange);

        _balanceEnquiry = new JButton("Balance Enquiry");
        _balanceEnquiry.setBackground(Color.WHITE);
        _balanceEnquiry.setForeground(Color.BLACK);
        _balanceEnquiry.setFont(new Font("Century Gothic", Font.BOLD, 20));
        _balanceEnquiry.setBounds(323, 462, 200, 40);
        _balanceEnquiry.setBorder(null);
        _balanceEnquiry.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        _balanceEnquiry.setFocusPainted(false);
        _balanceEnquiry.addActionListener(this);
        _atmImage.add(_balanceEnquiry);

        _exit = new JButton("Exit");
        _exit.setBackground(Color.RED);
        _exit.setForeground(Color.WHITE);
        _exit.setFont(new Font("Century Gothic", Font.BOLD, 20));
        _exit.setBounds(323, 507, 200, 40);
        _exit.setBorder(null);
        _exit.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        _exit.setFocusPainted(false);
        _exit.addActionListener(this);
        _atmImage.add(_exit);


        setSize(900, 900);
        setLocation(300,0);
        setUndecorated(true);
        setVisible(true);
    }

     
     /**
      * The actionPerformed function is the function that is called when a button on the ATM GUI is pressed.
      * It checks which button was pressed and then calls the appropriate class to handle it.
      
      *
      * @param ActionEvent _actionEvent Determine which button was clicked
      *
      * @return Void
      *
      * @nnoromiv https://www.linkedin.com/in/nnorom
      */
     @Override
    public void actionPerformed(ActionEvent _actionEvent) {
        if(_actionEvent.getSource() == _exit){
            System.exit(0);
        } else if (_actionEvent.getSource() == _deposit){
            setVisible(false);
            new Deposit(_cardNumber, _pin).setVisible(true);
        } else if (_actionEvent.getSource() == _cashWithdrawal){
            setVisible(false);
            new Withdrawal(_cardNumber, _pin).setVisible(true);
        }else if (_actionEvent.getSource() == _fastCash){
            setVisible(false);
            new FastCash(_cardNumber, _pin).setVisible(true);
        } else if (_actionEvent.getSource() == _pinChange){
            setVisible(false);
            new PinChange(_cardNumber, _pin).setVisible(true);
        }else if (_actionEvent.getSource() == _miniStatement){
            setVisible(false);
            new MiniStatement(_cardNumber, _pin).setVisible(true);
        }else if (_actionEvent.getSource() == _balanceEnquiry){
            setVisible(false);
            new BalanceEnquiry(_cardNumber, _pin).setVisible(true);
        }
    }

    
    /**
     * The main function of the program.
     * 
     *
     * @param String args[] Pass command line arguments to the main function
     *
     * @return Nothing
     *
     * @nnoromiv https://www.linkedin.com/in/nnorom
     */
    public static void main(String args[]) {
        new Transaction("", "");
    }
}
