package context;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {

    private static Connection connection;
    private String db;
    private static ConnectionManager conectionDB;

    private ConnectionManager(String db){

        this.db = db;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://database-mysql.cow6pj5xhtjq.us-east-1.rds.amazonaws.com:3306/videojuegos", "admin", "!Administrador!");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static Connection getConnection(String db) {
        if(connection == null || !conectionDB.db.equals(db))
            conectionDB = new ConnectionManager(db);
        return connection;
    }
}
