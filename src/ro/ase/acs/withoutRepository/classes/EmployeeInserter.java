package ro.ase.acs.withoutRepository.classes;

import ro.ase.acs.withoutRepository.interfaces.DataInserter;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class EmployeeInserter implements DataInserter {
    @Override
    public void insertData(Connection connection, Object employee) throws SQLException {

        String sqlInsertWithParams = "INSERT INTO employees VALUES (?,?,?,?)";

        PreparedStatement preparedStatement = connection.prepareStatement(sqlInsertWithParams);

        preparedStatement.setInt(1, ((Employee) employee).getId());
        preparedStatement.setString(2, ((Employee) employee).getName());
        preparedStatement.setString(3, ((Employee) employee).getAddress());
        preparedStatement.setDouble(4, ((Employee) employee).getSalary());
        preparedStatement.executeUpdate();
        preparedStatement.close();

        connection.commit();
    }
}
