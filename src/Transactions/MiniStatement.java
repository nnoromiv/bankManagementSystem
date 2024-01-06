package Transactions;

import java.awt.Font;
import java.sql.ResultSet;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;

import Connector.Connector;

public class MiniStatement extends JFrame {
    
    String _cardNumber;
    String _pin;

    public MiniStatement(String _cardNumber, String _pin){
        this._cardNumber = _cardNumber;
        this._pin = _pin;

        setLayout(null);
        setTitle("Mini Statement");

        JLabel _bank = new JLabel("Nnorom Bank");
        _bank.setBounds(80, 20, 300, 70);
        _bank.setFont(new Font("Century Gothic", Font.BOLD, 32));
        add(_bank);

        JLabel _cardLabel = new JLabel("");
        _cardLabel.setBounds(20, 70, 400, 70);
        _cardLabel.setFont(new Font("Century Gothic", Font.BOLD, 17));
        add(_cardLabel);

        JLabel _accountType = new JLabel("");
        _accountType.setBounds(20, 100, 400, 70);
        _accountType.setFont(new Font("Century Gothic", Font.BOLD, 17));
        add(_accountType);

        JLabel _balance = new JLabel("");
        _balance.setBounds(20, 130, 400, 70);
        _balance.setFont(new Font("Century Gothic", Font.BOLD, 17));
        add(_balance);

        JLabel _statement = new JLabel();
        _statement.setBounds(10, 200, 380, 400);
        _statement.setFont(new Font("Century Gothic", Font.BOLD, 14));
        add(_statement);

        JScrollPane _scrollPane = new JScrollPane(_statement);
        _scrollPane.setBounds(10, 200, 360, 400);
        _scrollPane.setBorder(null);
        // _scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
        add(_scrollPane);

        Connector _connector = new Connector();
        String _loginQuery = "SELECT * FROM LOGIN WHERE _pin = '"+_pin+"' AND _cardNumber = '"+_cardNumber+"'";
        String _bankQuery = "SELECT * FROM BANK WHERE _pin = '"+_pin+"' AND _cardNumber = '"+_cardNumber+"'";
        String _signUpAccountDetailQuery = "SELECT * FROM SIGNUP_ACCOUNT_DETAILS WHERE _pin = '"+_pin+"' AND _cardNumber = '"+_cardNumber+"'";

        int _calculatedBalance = 0;
        ResultSet _loginResult, _bankResult, _signUpAccountDetailResult, _balanceResult;

        try {
            _loginResult = _connector._stmt.executeQuery(_loginQuery);
            while(_loginResult.next()){
                _cardLabel.setText("Card Number: " + _loginResult.getString("_cardNumber").substring(0,4) + "-XXXX-XXXX-" + _loginResult.getString("_cardNumber").substring(12));
            }
        } catch (Exception e) {
            System.out.println(e);
        }

        try {
            _bankResult = _connector._stmt.executeQuery(_bankQuery);
            while(_bankResult.next()){
                _statement.setText(
                    _statement.getText() + "<html>" + 
                    _bankResult.getString("_date") +
                    "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"
                    + _bankResult.getString("_amount") +
                    "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"
                    + _bankResult.getString("_type") + "<br><br><html>"
                );
            }
        } catch (Exception e) {
            System.out.println(e);
        }

        try {
            _signUpAccountDetailResult = _connector._stmt.executeQuery(_signUpAccountDetailQuery);

            while(_signUpAccountDetailResult.next()){
                _accountType.setText("Account Type: " + _signUpAccountDetailResult.getString("_accountType"));
            }
        } catch (Exception e) {
            System.out.println(e);
        }

        try {
            _balanceResult = _connector._stmt.executeQuery(_bankQuery);
            while(_balanceResult.next()){
                if(_balanceResult.getString("_type").equals("Deposit")){
                    _calculatedBalance += Integer.parseInt(_balanceResult.getString("_amount"));
                } else {
                    _calculatedBalance -= Integer.parseInt(_balanceResult.getString("_amount"));
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            _balance.setText("Balance: " + "$ " + _calculatedBalance);
        }



        setSize(400, 600);

        setLocation(20,20);
        setVisible(true);
    }

    public static void main(String args[]){
        new MiniStatement("","");
    }
}
