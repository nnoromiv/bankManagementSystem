package Connector;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Connector {

    Connection _connection;
    public Statement _stmt;
    
    
    /**
     * The Connector function is used to connect the Java program to the MySQL database.
     * It uses a try-catch block in order to catch any exceptions that may occur during 
     * this process. The function also creates a statement object which will be used later
     * on in the program for executing queries and updating tables. 
     
     *
     *
     * @return A connection to the database
     *
     * @nnoromiv https://www.linkedin.com/in/nnorom
     */
    public Connector(){
        try {
            // Class.forName(com.mysql.cj.jdbc.Driver);
            _connection = DriverManager.getConnection("jdbc:mysql:///bank_management_system", "root", "");     
            _stmt = _connection.createStatement();       
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
