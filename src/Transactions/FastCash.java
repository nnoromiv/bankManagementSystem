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
import javax.swing.JOptionPane;

import Connector.Connector;

import java.util.Date;


public class FastCash extends JFrame implements ActionListener {

    ImageIcon _backgroundImage = new ImageIcon(new ImageIcon("lib/atm.jpg").getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT));
    JButton _10_, _20_, _50_, _100_, _1000_, _2000_, _back;
    String _cardNumber;
    String _pin;
    
    
    /**
     * The FastCash function is a constructor that creates the FastCash GUI.
     * 
     *
     * @param String _cardNumber Pass the card number to this class
     * @param String _pin Get the pin number of the user
     *
     * @return The amount of cash withdrawn
     *
     * @nnoromiv https://www.linkedin.com/in/nnorom
     */
    public FastCash(String _cardNumber, String _pin){
        this._cardNumber = _cardNumber;
        this._pin = _pin;
        setLayout(null);

        JLabel _atmImage = new JLabel(_backgroundImage);
        _atmImage.setBounds(0, 0, 900, 900);
        add(_atmImage);

        JLabel _message = new JLabel("Select Withdrawal Amount ");
        _message.setBounds(200, 250, 700, 40);
        _message.setForeground(Color.WHITE);
        _message.setFont(new Font("Century Gothic", Font.BOLD, 20));
        _atmImage.add(_message);

        _10_ = new JButton("$ 10");
        _10_.setBackground(Color.WHITE);
        _10_.setForeground(Color.BLACK);
        _10_.setFont(new Font("Century Gothic", Font.BOLD, 20));
        _10_.setBounds(135, 372, 130, 40);
        _10_.setBorder(null);
        _10_.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        _10_.setFocusPainted(false);
        _10_.addActionListener(this);
        _atmImage.add(_10_);

        _20_ = new JButton("$ 20");
        _20_.setBackground(Color.WHITE);
        _20_.setForeground(Color.BLACK);
        _20_.setFont(new Font("Century Gothic", Font.BOLD, 20));
        _20_.setBounds(323, 372, 200, 40);
        _20_.setBorder(null);
        _20_.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        _20_.setFocusPainted(false);
        _20_.addActionListener(this);
        _atmImage.add(_20_);

        _50_ = new JButton("$ 50");
        _50_.setBackground(Color.WHITE);
        _50_.setForeground(Color.BLACK);
        _50_.setFont(new Font("Century Gothic", Font.BOLD, 20));
        _50_.setBounds(135, 417, 130, 40);
        _50_.setBorder(null);
        _50_.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        _50_.setFocusPainted(false);
        _50_.addActionListener(this);
        _atmImage.add(_50_);

        _100_ = new JButton("$ 100");
        _100_.setBackground(Color.WHITE);
        _100_.setForeground(Color.BLACK);
        _100_.setFont(new Font("Century Gothic", Font.BOLD, 20));
        _100_.setBounds(323, 417, 200, 40);
        _100_.setBorder(null);
        _100_.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        _100_.setFocusPainted(false);
        _100_.addActionListener(this);
        _atmImage.add(_100_);

        _1000_ = new JButton("$ 1000");
        _1000_.setBackground(Color.WHITE);
        _1000_.setForeground(Color.BLACK);
        _1000_.setFont(new Font("Century Gothic", Font.BOLD, 20));
        _1000_.setBounds(135, 462, 130, 40);
        _1000_.setBorder(null);
        _1000_.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        _1000_.setFocusPainted(false);
        _1000_.addActionListener(this);
        _atmImage.add(_1000_);

        _2000_ = new JButton("$ 2000");
        _2000_.setBackground(Color.WHITE);
        _2000_.setForeground(Color.BLACK);
        _2000_.setFont(new Font("Century Gothic", Font.BOLD, 20));
        _2000_.setBounds(323, 462, 200, 40);
        _2000_.setBorder(null);
        _2000_.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        _2000_.setFocusPainted(false);
        _2000_.addActionListener(this);
        _atmImage.add(_2000_);

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


        setSize(900, 900);
        setLocation(300,0);
        setUndecorated(true);
        setVisible(true);
    }

     
     /**
      * The actionPerformed function is called when an action event occurs.
      * 
      *
      * @param ActionEvent _actionEvent Determine which button was pressed
      *
      * @return Void, so the return statement is not valid
      *
      * @nnoromiv https://www.linkedin.com/in/nnorom
      */
     @Override
    public void actionPerformed(ActionEvent _actionEvent) {
        if(_actionEvent.getSource() == _back){
            setVisible(false);
            new Transaction(_cardNumber, _pin).setVisible(true);
        } else {
            String _amount = ((JButton)_actionEvent.getSource()).getText().substring(2);
            Connector _connector = new Connector();
            String _query = "SELECT * FROM BANK WHERE _pin = '"+_pin+"' AND _cardNumber = '"+_cardNumber+"'";
            try {
                ResultSet _result = _connector._stmt.executeQuery(_query);
                int _balance = 0;
                while(_result.next()){
                    if(_result.getString("_type").equals("Deposit")){
                        _balance += Integer.parseInt(_result.getString("_amount"));
                    } else {
                        _balance -= Integer.parseInt(_result.getString("_amount"));
                    }
                }

                if(_actionEvent.getSource() != _back && _balance < Integer.parseInt(_amount)){
                    JOptionPane.showMessageDialog(null, "Insufficient Funds", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                Date _date = new Date();
                String _query_1 = "INSERT INTO BANK VALUES('"+_date+"', '"+_amount+"','Withdraw','"+_pin+"','"+_cardNumber+"')";
                _connector._stmt.executeUpdate(_query_1);

                JOptionPane.showMessageDialog(null, "$ " + _amount + " Withdrawn Successfully");
                setVisible(false);
                new Transaction(_cardNumber, _pin).setVisible(true);

            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }

    
    /**
     * The main function of the FastCash class.
     * 
     *
     * @param String args[] Pass command line arguments to the program
     *
     * @return Void
     *
     * @nnoromiv https://www.linkedin.com/in/nnorom
     */
    public static void main(String args[]) {
        new FastCash("", "");
    }
}
