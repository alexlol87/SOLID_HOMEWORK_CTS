package ro.ase.acs.withoutRepository.interfaces;

import java.sql.Connection;
import java.sql.SQLException;

public interface ConnectionCreator {
    Connection createConnection() throws ClassNotFoundException, SQLException;
}
