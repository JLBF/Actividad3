package context;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {

    private static Connection connection;
    private static ConnectionManager conectionDB;

    private ConnectionManager(){

        try {
            connection = DriverManager.getConnection("jdbc:mysql://database-mysql.cow6pj5xhtjq.us-east-1.rds.amazonaws.com:3306/videojuegos", "admin", "!Administrador!");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static Connection getConnection() {
        if(connection == null)
            conectionDB = new ConnectionManager();
        return connection;
    }
}
