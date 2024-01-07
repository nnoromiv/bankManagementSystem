package Authenications;

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
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import Connector.Connector;

import javax.swing.JComboBox;


public class AdditionalDetails extends JFrame implements ActionListener{

    Image _imageIcon = new ImageIcon("lib/icon.png").getImage();
    String _religionValues[] = {"Christianity", "Islam", "Judaism", "Buddhism", "Hindu", "Sikh", "Others"};
    String _categoryValues[] = {"General", "OBC", "SC", "ST", "Others"};
    String _incomeValues[] = {"Null", "< 150 000", "<250 000", "< 500 000", "up to 1 000 000", "Others"};
    String _qualificationValues[] = {"Non Graduate", "Graduate", "Post Graduate", "Doctorate", "Others"};
    String _occupationValues[] = {"Salaries", "Self-Employed", "Student", "Retired", "Others"};
    JComboBox<String> _religionField, _categoryField, _incomeField, _qualificationField, _occupationField;
    JTextField _panNumberTextField;
    JButton _saveAndNext, _cancel;
    String _formNumber;

    
    /**
     * The AdditionalDetails function is used to get the additional details of a user.
     * 
     *
     * @param String _formNumber Display the form number on the top of the frame
     *
     * @return The following:
     *
     * @nnoromiv https://www.linkedin.com/in/nnorom
     */
    public AdditionalDetails(String _formNumber) {
        this._formNumber = _formNumber;
        setIconImage(_imageIcon);
        setTitle("Automated Bank System - Sign Up - Additional Details");
        setLayout(null);

        JLabel _formPage = new JLabel("Additional Details For: " + _formNumber);
        _formPage.setBounds(200, 40, 500, 40);
        _formPage.setFont(new Font("Century Gothic", Font.BOLD, 32));
        add(_formPage);

        JLabel _pageName = new JLabel("Additional Details");
        _pageName.setBounds(350, 80, 200, 40);
        _pageName.setFont(new Font("Century Gothic", Font.BOLD, 20));
        add(_pageName);

        JLabel _religion = new JLabel("Religion: ");
        _religion.setBounds(70, 120, 200, 40);
        _religion.setFont(new Font("Century Gothic", Font.BOLD, 24));
        add(_religion);

        _religionField = new JComboBox<>(_religionValues);
        _religionField.setBounds(370, 120, 430, 40);
        _religionField.setBorder(null);
        _religionField.setBackground(Color.WHITE);
        _religionField.setFocusable(false);
        _religionField.setFont(new Font("Century Gothic", Font.BOLD, 20));
        add(_religionField);

        JLabel _category = new JLabel("Category: ");
        _category.setBounds(70, 220, 300, 40);
        _category.setFont(new Font("Century Gothic", Font.BOLD, 24));
        add(_category);

        _categoryField = new JComboBox<>(_categoryValues);
        _categoryField.setBounds(370, 220, 430, 40);
        _categoryField.setBorder(null);
        _categoryField.setBackground(Color.WHITE);
        _categoryField.setFocusable(false);
        _categoryField.setFont(new Font("Century Gothic", Font.BOLD, 20));
        add(_categoryField);

        JLabel _income = new JLabel("Income: ");
        _income.setBounds(70, 320, 200, 40);
        _income.setFont(new Font("Century Gothic", Font.BOLD, 24));
        add(_income);

        _incomeField = new JComboBox<>(_incomeValues);
        _incomeField.setBounds(370, 320, 430, 40);
        _incomeField.setBackground(Color.WHITE);
        _incomeField.setFocusable(false);
        _incomeField.setFont(new Font("Century Gothic", Font.BOLD, 20));
        _incomeField.setForeground(new Color(105, 105, 105));
        add(_incomeField);

        JLabel _qualification = new JLabel("Qualification: ");
        _qualification.setBounds(70, 420, 200, 40);
        _qualification.setFont(new Font("Century Gothic", Font.BOLD, 24));
        add(_qualification);

        _qualificationField = new JComboBox<>(_qualificationValues);
        _qualificationField.setBounds(370, 420, 430, 40);
        _qualificationField.setBorder(null);
        _qualificationField.setBackground(Color.WHITE);
        _qualificationField.setFocusable(false);
        _qualificationField.setFont(new Font("Century Gothic", Font.BOLD, 20));
        add(_qualificationField);

        JLabel _occupation = new JLabel("Occupation: ");
        _occupation.setBounds(70, 520, 200, 40);
        _occupation.setFont(new Font("Century Gothic", Font.BOLD, 24));
        add(_occupation);

        _occupationField = new JComboBox<>(_occupationValues);
        _occupationField.setBounds(370, 520, 430, 40);
        _occupationField.setBorder(null);
        _occupationField.setBackground(Color.WHITE);
        _occupationField.setFocusable(false);
        _occupationField.setFont(new Font("Century Gothic", Font.BOLD, 20));
        add(_occupationField);

        JLabel _panNumber = new JLabel("PAN Number: ");
        _panNumber.setBounds(70, 620, 200, 40);
        _panNumber.setFont(new Font("Century Gothic", Font.BOLD, 24));
        add(_panNumber);

        _panNumberTextField = new JTextField();
        _panNumberTextField.setBounds(370, 620, 430, 40);
        _panNumberTextField.setBorder(null);
        _panNumberTextField.setFont(new Font("Century Gothic", Font.BOLD, 20));
        add(_panNumberTextField);

        _cancel = new JButton("Cancel");
        _cancel.setBackground(Color.RED);
        _cancel.setForeground(Color.WHITE);
        _cancel.setFont(new Font("Century Gothic", Font.BOLD, 32));
        _cancel.setBounds(70, 680, 300, 50);
        _cancel.setBorder(null);
        _cancel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        _cancel.setFocusPainted(false);
        _cancel.addActionListener(this);
        add(_cancel);

        _saveAndNext = new JButton("Save and Next");
        _saveAndNext.setBackground(Color.BLACK);
        _saveAndNext.setForeground(Color.WHITE);
        _saveAndNext.setFont(new Font("Century Gothic", Font.BOLD, 32));
        _saveAndNext.setBounds(470, 680, 300, 50);
        _saveAndNext.setBorder(null);
        _saveAndNext.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        _saveAndNext.setFocusPainted(false);
        _saveAndNext.addActionListener(this);
        add(_saveAndNext);

        setSize(850, 800);
        setLocation(350, 10);
        setVisible(true);
    }

    
    /**
     * The actionPerformed function is the function that is called when an action event occurs.
     * An action event can be a button click, or a text field change, etc.
     * The function checks which component triggered the event and then performs some operation based on it.
     
     *
     * @param ActionEvent _actionEvent Determine which button was clicked
     *
     * @return Void
     *
     * @nnoromiv https://www.linkedin.com/in/nnorom
     */
    @Override
    public void actionPerformed(ActionEvent _actionEvent) {
        if(_actionEvent.getSource() == _saveAndNext){
            String _religion = (String) _religionField.getSelectedItem();
            String _category = (String) _categoryField.getSelectedItem();
            String _income = (String) _incomeField.getSelectedItem();
            String _qualification = (String) _qualificationField.getSelectedItem();
            String _occupation = (String) _occupationField.getSelectedItem();
            String _panNumber = _panNumberTextField.getText();

            try {
                Connector _connector = new Connector();
                String _query = "INSERT INTO SIGNUP_ADDITIONAL_DETAILS VALUES('"+_formNumber+"', '"+_religion+"', '"+_category+"', '"+_income+"', '"+_qualification+"', '"+_occupation+"', '"+_panNumber+"')";
                _connector._stmt.executeUpdate(_query);

                setVisible(false);
                new AccountDetails(_formNumber).setVisible(true);
            } catch (Exception _error) {
                JOptionPane.showMessageDialog(null, "An Error has Occurred", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else if(_actionEvent.getSource() == _cancel) {
            int _cancelChoice = JOptionPane.showConfirmDialog(null, "Are you sure? This would take you back", "Warning", JOptionPane.YES_NO_OPTION);
            if(_cancelChoice == JOptionPane.YES_OPTION) {
                setVisible(false);
                new Signup().setVisible(true);
            } else {
                // DO NOTHING
            }
        }
    }

    
    /**
     * The main function of the AdditionalDetails class.
     * 
     *
     * @param String[] args Pass arguments to the main method
     *
     * @return Nothing, so the return type is void
     *
     * @nnoromiv https://www.linkedin.com/in/nnorom
     */
    public static void main(String[] args){
        new AdditionalDetails("");
    }
    
}
