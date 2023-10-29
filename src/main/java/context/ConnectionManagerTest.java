package context;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManagerTest {
    private static Connection connection;
    private static ConnectionManagerTest conectionDB;

    private ConnectionManagerTest(){

        try {
            connection = DriverManager.getConnection("jdbc:mysql://database-mysql.cow6pj5xhtjq.us-east-1.rds.amazonaws.com:3306/videojuegostest", "admin", "!Administrador!");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static Connection getConnection() {
        if(connection == null)
            conectionDB = new ConnectionManagerTest();
        return connection;
    }
}

