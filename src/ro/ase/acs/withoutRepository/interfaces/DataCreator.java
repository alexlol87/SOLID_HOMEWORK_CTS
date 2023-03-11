package ro.ase.acs.withoutRepository.interfaces;

import java.sql.Connection;
import java.sql.SQLException;

public interface DataCreator {
    void createData(Connection connection) throws SQLException;
}
