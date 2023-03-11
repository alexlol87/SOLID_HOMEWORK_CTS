package ro.ase.acs.withoutRepository.interfaces;

import java.sql.Connection;
import java.sql.SQLException;

public interface DataInserter {
    void insertData(Connection connection, Object object) throws SQLException;
}
