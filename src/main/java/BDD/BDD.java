package BDD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BDD {
    public Connection getCnx() {
        return cnx;
    }

    private final Connection cnx = DriverManager.getConnection(
            "jdbc:mysql://localhost:3306/fto_instafich?serverTimezone=UTC",
            "root",
            ""
    );

    public BDD() throws SQLException {
    }


}
