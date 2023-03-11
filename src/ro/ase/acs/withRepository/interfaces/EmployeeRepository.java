package ro.ase.acs.withRepository.interfaces;

import ro.ase.acs.withRepository.classes.Employee;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public interface EmployeeRepository {
    List<Employee> readData(Connection connection) throws SQLException;

    void insertData(Connection connection, Employee employee) throws SQLException;

    void createTable(Connection connection) throws SQLException;

    Connection createConnection() throws ClassNotFoundException, SQLException;
}
