package ro.ase.acs.withRepository.main;

import ro.ase.acs.withRepository.classes.Employee;
import ro.ase.acs.withRepository.classes.SQLiteEmployeeRepository;
import ro.ase.acs.withRepository.interfaces.EmployeeRepository;

import java.sql.Connection;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        try {
            EmployeeRepository repository = new SQLiteEmployeeRepository();
            Connection connection = repository.createConnection();

            repository.createTable(connection);
            repository.insertData(connection, new Employee(1, "Popescu Ion", "Bucharest", 4000));
            repository.insertData(connection, new Employee(2, "Ionescu Maria", "Bucharest", 5000));
            repository.insertData(connection, new Employee(3, "Vasilescu Vasile", "Bucharest", 6000));
            List<Employee> employees = repository.readData(connection);
            for (Employee employee : employees) {
                System.out.println(employee);
            }
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
