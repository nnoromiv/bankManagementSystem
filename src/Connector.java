import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Connector {

    Connection _connection;
    Statement _stmt;
    
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
