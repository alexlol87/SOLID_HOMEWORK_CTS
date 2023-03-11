package ro.ase.acs.withRepository.classes;

import ro.ase.acs.withRepository.interfaces.EmployeeRepository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class SQLiteEmployeeRepository implements EmployeeRepository {

    @Override
    public List<Employee> readData(Connection connection) throws SQLException {
        String sqlSelect = "SELECT * FROM employees";
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery(sqlSelect);

        List<Employee> employees = new ArrayList<>();

        while (rs.next()) {
            int id = rs.getInt("id");

            String name = rs.getString(2);
            String address = rs.getString("address");
            double salary = rs.getDouble("salary");

            Employee employee = new Employee(id, name, address, salary);
            employees.add(employee);
        }
        rs.close();
        statement.close();

        return employees;
    }


    @Override
    public void insertData(Connection connection, Employee employee) throws SQLException {
        String sqlInsertWithParams = "INSERT INTO employees VALUES (?,?,?,?)";

        PreparedStatement preparedStatement =
                connection.prepareStatement(sqlInsertWithParams);
        preparedStatement.setInt(1, employee.getId());
        preparedStatement.setString(2, employee.getName());
        preparedStatement.setString(3, employee.getAddress());
        preparedStatement.setDouble(4, employee.getSalary());
        preparedStatement.executeUpdate();
        preparedStatement.close();

        connection.commit();
    }

    @Override
    public void createTable(Connection connection) throws SQLException {
        String sqlDrop = "DROP TABLE IF EXISTS employees";
        String sqlCreate = "CREATE TABLE employees(id INTEGER PRIMARY KEY,"
                + "name TEXT, address TEXT, salary REAL)";

        Statement statement = connection.createStatement();
        statement.executeUpdate(sqlDrop);
        statement.executeUpdate(sqlCreate);
        statement.close();
        connection.commit();
    }

    @Override
    public Connection createConnection() throws ClassNotFoundException, SQLException {
        Class.forName("org.sqlite.JDBC");
        Connection connection = DriverManager.getConnection("jdbc:sqlite:database.db");
        connection.setAutoCommit(false);

        return connection;
    }
}

