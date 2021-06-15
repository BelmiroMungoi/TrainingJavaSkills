package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
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

    public List<UserBeans> listarUsuario() {
        List<UserBeans> lista = new ArrayList<>();
        try {
            String sql = "select * from usuario";
            PreparedStatement pst = connection.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                UserBeans beans = new UserBeans();
                beans.setIdUser(rs.getInt("idUser"));
                beans.setUserName(rs.getString("username"));
                beans.setPassword(rs.getString("password"));
                beans.setImage(rs.getString("imagem"));
                lista.add(beans);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Oops!\nErro ao listar usuario");
        }
        return lista;
    }

    public String buscaImagem(String idUser) {
        String sql = "select imagem from usuario where idUser =" + idUser;
        try {
            PreparedStatement pst = connection.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                return rs.getString("imagem");
            }
        } catch (SQLException ex) {
            Logger.getLogger(DaoUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

}
