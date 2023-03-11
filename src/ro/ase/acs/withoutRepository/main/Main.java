package ro.ase.acs.withoutRepository.main;

import ro.ase.acs.withoutRepository.classes.Employee;
import ro.ase.acs.withoutRepository.classes.EmployeeInserter;
import ro.ase.acs.withoutRepository.classes.EmployeeReader;
import ro.ase.acs.withoutRepository.classes.SQLiteConnectionCreator;
import ro.ase.acs.withoutRepository.classes.TableCreator;
import ro.ase.acs.withoutRepository.interfaces.ConnectionCreator;
import ro.ase.acs.withoutRepository.interfaces.DataCreator;
import ro.ase.acs.withoutRepository.interfaces.DataInserter;
import ro.ase.acs.withoutRepository.interfaces.DataReader;

import java.sql.Connection;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        ConnectionCreator connectionCreator = new SQLiteConnectionCreator();
        try {
            Connection connection = connectionCreator.createConnection();

            DataCreator tableCreator = new TableCreator();
            tableCreator.createData(connection);

            DataInserter employeeInserter = new EmployeeInserter();
            employeeInserter.insertData(connection, new Employee(1, "Popescu Ion", "Bucharest", 4000));
            employeeInserter.insertData(connection, new Employee(2, "Ionescu Maria", "Bucharest", 5000));
            employeeInserter.insertData(connection, new Employee(3, "Vasilescu Vasile", "Bucharest", 6000));

            DataReader employeeReader = new EmployeeReader();
            employeeReader.readData(connection);

            connection.close();
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
