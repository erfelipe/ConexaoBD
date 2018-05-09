package conexaobd;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConnectionFactory {

    public Connection getConnection() {
        String url = "jdbc:mysql://localhost:3306/escola";
        try {
            return (Connection) DriverManager.getConnection(url, "root", "1234");
        } catch (SQLException ex) {
            Logger.getLogger(ConnectionFactory.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Problema na conexão " + ex.getMessage());
            return null;
        }
    }

}

