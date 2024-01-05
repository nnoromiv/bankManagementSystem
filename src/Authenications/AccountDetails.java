package Authenications;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;

import Connector.Connector;
import Transactions.Deposit;

import javax.swing.JCheckBox;


public class AccountDetails extends JFrame implements ActionListener{

    Image _imageIcon = new ImageIcon("lib/icon.png").getImage();
    long _randomNumber;
    JRadioButton _currentAccount, _fixedDeposit, _savingsAccount, _recurringDeposit;
    JCheckBox _atmCard, _internetBanking, _mobileBanking, _emailAndSMSAlerts, _chequeBook, _eStatement, _declaration;
    JButton _cancel, _save;
    Random _randomUtil = new Random();
    String _formNumber;

    public AccountDetails(String _formNumber) {
        this._formNumber = _formNumber;
        setIconImage(_imageIcon);
        setTitle("Automated Bank System - Sign Up - Account Details");
        setLayout(null);

        JLabel _formPage = new JLabel("Application Form NO: " + _formNumber);
        _formPage.setBounds(200, 40, 500, 40);
        _formPage.setFont(new Font("Century Gothic", Font.BOLD, 32));
        add(_formPage);

        JLabel _pageName = new JLabel("Account Details");
        _pageName.setBounds(350, 80, 200, 40);
        _pageName.setFont(new Font("Century Gothic", Font.BOLD, 20));
        add(_pageName);

        JLabel _accountType = new JLabel("Account Type: ");
        _accountType.setBounds(70, 150, 200, 40);
        _accountType.setFont(new Font("Century Gothic", Font.BOLD, 24));
        add(_accountType);

        _currentAccount = new JRadioButton("Current Account");
        _currentAccount.setBounds(370, 150, 400, 40);
        _currentAccount.setFocusable(false);
        _currentAccount.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        _currentAccount.setFont(new Font("Century Gothic", Font.BOLD, 24));
        add(_currentAccount);

        _fixedDeposit = new JRadioButton("Fixed Deposit Account");
        _fixedDeposit.setBounds(370, 190, 400, 40);
        _fixedDeposit.setFocusable(false);
        _fixedDeposit.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        _fixedDeposit.setFont(new Font("Century Gothic", Font.BOLD, 24));
        add(_fixedDeposit);

        _savingsAccount = new JRadioButton("Savings Account");
        _savingsAccount.setBounds(370, 230, 400, 40);
        _savingsAccount.setFocusable(false);
        _savingsAccount.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        _savingsAccount.setFont(new Font("Century Gothic", Font.BOLD, 24));
        add(_savingsAccount);

        _recurringDeposit = new JRadioButton("Recurring Deposit Account");
        _recurringDeposit.setBounds(370, 270, 400, 40);
        _recurringDeposit.setFocusable(false);
        _recurringDeposit.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        _recurringDeposit.setFont(new Font("Century Gothic", Font.BOLD, 24));
        add(_recurringDeposit);

        ButtonGroup _accountTypeGroup = new ButtonGroup();
        _accountTypeGroup.add(_currentAccount);
        _accountTypeGroup.add(_fixedDeposit);
        _accountTypeGroup.add(_savingsAccount);
        _accountTypeGroup.add(_recurringDeposit);

        JLabel _cardNumber = new JLabel("Card Number: ");
        _cardNumber.setBounds(70, 320, 300, 40);
        _cardNumber.setFont(new Font("Century Gothic", Font.BOLD, 24));
        add(_cardNumber);

        JLabel _cardNumberSubText = new JLabel("Your 16 Digit Card Number");
        _cardNumberSubText.setBounds(70, 339, 300, 40);
        _cardNumberSubText.setFont(new Font("Century Gothic", Font.BOLD, 12));
        add(_cardNumberSubText);

        JLabel _cardNumberTemplate = new JLabel("XXXX-XXXX-0190-8901 ");
        _cardNumberTemplate.setBounds(370, 320, 400, 40);
        _cardNumberTemplate.setFont(new Font("Century Gothic", Font.BOLD, 24));
        add(_cardNumberTemplate);

        JLabel _pin = new JLabel("Pin: ");
        _pin.setBounds(70, 370, 300, 40);
        _pin.setFont(new Font("Century Gothic", Font.BOLD, 24));
        add(_pin);

        JLabel _pinSubText = new JLabel("Your 4 Digit Pin");
        _pinSubText.setBounds(70, 389, 300, 40);
        _pinSubText.setFont(new Font("Century Gothic", Font.BOLD, 12));
        add(_pinSubText);

        JLabel _pinTemplate = new JLabel("XX90");
        _pinTemplate.setBounds(370, 370, 400, 40);
        _pinTemplate.setFont(new Font("Century Gothic", Font.BOLD, 24));
        add(_pinTemplate);

        JLabel _servicesRequired = new JLabel("Services Required: ");
        _servicesRequired.setBounds(70, 420, 300, 40);
        _servicesRequired.setFont(new Font("Century Gothic", Font.BOLD, 24));
        add(_servicesRequired);

        _atmCard = new JCheckBox("ATM Card");
        _atmCard.setBounds(370, 420, 130, 40);
        _atmCard.setFocusable(false);
        _atmCard.setFont(new Font("Century Gothic", Font.BOLD, 20));
        _atmCard.setForeground(new Color(105, 105, 105));
        add(_atmCard);

        _internetBanking = new JCheckBox("Internet Banking");
        _internetBanking.setBounds(520, 420, 230, 40);
        _internetBanking.setFocusable(false);
        _internetBanking.setFont(new Font("Century Gothic", Font.BOLD, 20));
        _internetBanking.setForeground(new Color(105, 105, 105));
        add(_internetBanking);

        _mobileBanking = new JCheckBox("Mobile Banking");
        _mobileBanking.setBounds(370, 470, 180, 40);
        _mobileBanking.setFocusable(false);
        _mobileBanking.setFont(new Font("Century Gothic", Font.BOLD, 20));
        _mobileBanking.setForeground(new Color(105, 105, 105));
        add(_mobileBanking);

        _emailAndSMSAlerts = new JCheckBox("Email & SMS Alerts");
        _emailAndSMSAlerts.setBounds(560, 470, 440, 40);
        _emailAndSMSAlerts.setFocusable(false);
        _emailAndSMSAlerts.setFont(new Font("Century Gothic", Font.BOLD, 20));
        _emailAndSMSAlerts.setForeground(new Color(105, 105, 105));
        add(_emailAndSMSAlerts);

        _chequeBook = new JCheckBox("Cheque Book");
        _chequeBook.setBounds(370, 520, 180, 40);
        _chequeBook.setFocusable(false);
        _chequeBook.setFont(new Font("Century Gothic", Font.BOLD, 20));
        _chequeBook.setForeground(new Color(105, 105, 105));
        add(_chequeBook);

        _eStatement = new JCheckBox("E-Statement");
        _eStatement.setBounds(560, 520, 430, 40);
        _eStatement.setFocusable(false);
        _eStatement.setFont(new Font("Century Gothic", Font.BOLD, 20));
        _eStatement.setForeground(new Color(105, 105, 105));
        add(_eStatement);

        _declaration = new JCheckBox("I hereby declare that the above entered details are correct to the best of my knowledge");
        _declaration.setBounds(70, 570, 630, 40);
        _declaration.setFocusable(false);
        _declaration.setFont(new Font("Century Gothic", Font.BOLD, 12));
        _declaration.setForeground(new Color(105, 105, 105));
        add(_declaration);

        _cancel = new JButton("Cancel");
        _cancel.setBackground(Color.RED);
        _cancel.setForeground(Color.WHITE);
        _cancel.setFont(new Font("Century Gothic", Font.BOLD, 32));
        _cancel.setBounds(70, 640, 300, 50);
        _cancel.setBorder(null);
        _cancel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        _cancel.setFocusPainted(false);
        _cancel.addActionListener(this);
        add(_cancel);

        _save = new JButton("Save");
        _save.setBackground(Color.BLACK);
        _save.setForeground(Color.WHITE);
        _save.setFont(new Font("Century Gothic", Font.BOLD, 32));
        _save.setBounds(470, 640, 300, 50);
        _save.setBorder(null);
        _save.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        _save.setFocusPainted(false);
        _save.addActionListener(this);
        add(_save);

        setSize(850, 800);
        setLocation(350, 10);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent _actionEvent) {
       if(_actionEvent.getSource() == _save) {
        String _accountType = "";
        if(_currentAccount.isSelected()){
            _accountType = "Current Account";
        } else if (_fixedDeposit.isSelected()){
            _accountType = "Fixed Deposit";
        }  else if (_savingsAccount.isSelected()){
            _accountType = "Savings Account";
        } else if (_recurringDeposit.isSelected()){
            _accountType = "Recurring Deposit";
        } else {
            _accountType = "";
        }

        String _cardNumber = String.format("%016d", Math.abs((_randomUtil.nextLong() % 90000000L) + 5040936000000000L));
        
        String _pin = String.format("%04d", Math.abs((_randomUtil.nextLong() % 9000L) + 1000L));

        String _servicesRequired = "";

        if(_atmCard.isSelected()){
            _servicesRequired = _servicesRequired + " ATM Card";
        } else if (_internetBanking.isSelected()){
            _servicesRequired = _servicesRequired + " Internet Banking";
        }  else if (_mobileBanking.isSelected()){
            _servicesRequired = _servicesRequired + " Mobile Banking";
        } else if (_emailAndSMSAlerts.isSelected()){
            _servicesRequired = _servicesRequired + " Email & SMS Services";
        }else if (_chequeBook.isSelected()){
            _servicesRequired = _servicesRequired + " Cheque Book";
        }else if (_eStatement.isSelected()){
            _servicesRequired = _servicesRequired + " E-Statement";
        } else {
            _servicesRequired = "";
        }
        try {
            if(_accountType.equals("")){
                JOptionPane.showMessageDialog(null, "Must Selected an account type", "Error", JOptionPane.ERROR_MESSAGE);
            } else if (_servicesRequired.equals("")){
                JOptionPane.showMessageDialog(null, "Must be signed to a service", "Error", JOptionPane.ERROR_MESSAGE);
            } else if (!_declaration.isSelected()){
                JOptionPane.showMessageDialog(null, "You should declare to continue", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Card Number is:" + _cardNumber + "\n" + "Pin is: " + _pin);
                Connector _connector = new Connector();
                String _query = "INSERT INTO SIGNUP_ACCOUNT_DETAILS VALUES('"+_formNumber+"', '"+_accountType+"', '"+_cardNumber+"', '"+_pin+"', '"+_servicesRequired+"')";
                String _query_1 = "INSERT INTO LOGIN VALUES('"+_formNumber+"', '"+_cardNumber+"', '"+_pin+"')";
                _connector._stmt.executeUpdate(_query);
                _connector._stmt.executeUpdate(_query_1);

                setVisible(false);
                new Deposit(_cardNumber, _pin).setVisible(true);
            }
        } catch (Exception _error) {
            JOptionPane.showMessageDialog(null, "An Error has Occurred", "Error", JOptionPane.ERROR_MESSAGE);
        } 
       } else if(_actionEvent.getSource() == _cancel){
            int _cancelChoice = JOptionPane.showConfirmDialog(null, "Are you sure? This would take you back", "Warning", JOptionPane.YES_NO_OPTION);
            if(_cancelChoice == JOptionPane.YES_OPTION) {
                setVisible(false);
                new AdditionalDetails(_formNumber).setVisible(true);
            } else {
                // DO NOTHING
            }
       }
    }

    public static void main(String[] args){
        new AccountDetails("");
    }
    
}
