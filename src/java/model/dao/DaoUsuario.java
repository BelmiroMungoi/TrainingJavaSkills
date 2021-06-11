package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import model.beans.UserBeans;
import model.connection.SingleConnection;

/**
 *
 * @author bbm29
 */
public class DaoUsuario {

    private Connection connection;

    public DaoUsuario() {
        connection = SingleConnection.getConnection();
    }

    public void salvarUsuario(UserBeans usuario) {
        String sql = "insert into usuario(username, password, imagem) values(?,?,?)";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, usuario.getUserName());
            ps.setString(2, usuario.getPassword());
            ps.setString(3, usuario.getImage());
            ps.execute();
            connection.commit();
        } catch (SQLException e) {
            try {
                e.printStackTrace();
                connection.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }

    }

}
