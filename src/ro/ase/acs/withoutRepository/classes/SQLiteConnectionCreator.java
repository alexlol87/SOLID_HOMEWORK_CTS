package ro.ase.acs.withoutRepository.classes;

import ro.ase.acs.withoutRepository.interfaces.ConnectionCreator;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SQLiteConnectionCreator implements ConnectionCreator {
    @Override
    public Connection createConnection() throws ClassNotFoundException, SQLException {
        Class.forName("org.sqlite.JDBC");
        Connection connection = DriverManager.getConnection("jdbc:sqlite:database.db");
        connection.setAutoCommit(false);

        return connection;
    }
}
