package ro.ase.acs.withoutRepository.interfaces;

import java.sql.Connection;
import java.sql.SQLException;

public interface DataReader {
    void readData(Connection connection) throws SQLException;
}
