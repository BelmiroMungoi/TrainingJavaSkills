package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.connection.SingleConnection;

/**
 *
 * @author bbm29
 */
public class DaoData {

    private Connection connection;

    public DaoData() {
        connection = SingleConnection.getConnection();
    }

    public void salvarData(String date) {
        String sql = "insert into datas(ultima) values(?)";
        try {
            PreparedStatement pst = connection.prepareStatement(sql);
            pst.setString(1, date);
            pst.execute();
            connection.commit();
        } catch (SQLException ex) {
            Logger.getLogger(DaoData.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
