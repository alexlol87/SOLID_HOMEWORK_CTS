package ro.ase.acs.withoutRepository.classes;

import ro.ase.acs.withoutRepository.interfaces.DataReader;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class EmployeeReader implements DataReader {

    @Override
    public void readData(Connection connection) throws SQLException {
        String sqlSelect = "SELECT * FROM employees";
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery(sqlSelect);

        while (rs.next()) {
            int id = rs.getInt("id");

            String name = rs.getString(2);
            String address = rs.getString("address");
            double salary = rs.getDouble("salary");

            Employee employee = new Employee(id, name, address, salary);
            System.out.println(employee);
        }
        rs.close();
        statement.close();
    }
}
