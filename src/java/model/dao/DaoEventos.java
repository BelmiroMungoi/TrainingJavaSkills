package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.beans.Eventos;
import model.connection.SingleConnection;

/**
 *
 * @author bbm29
 */
public class DaoEventos {

    private Connection connection;

    public DaoEventos() {
        connection = SingleConnection.getConnection();
    }

    public List<Eventos> getEventos() {
        List<Eventos> lista = new ArrayList<>();
        try {
            String sql = "select * from eventos";
            PreparedStatement pst = connection.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                Eventos eventos = new Eventos();
                eventos.setId(rs.getLong("id"));
                eventos.setDescricao(rs.getString("descricao"));
                eventos.setInicio(rs.getString("inicio"));
                eventos.setFim(rs.getString("fim"));
                lista.add(eventos);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return lista;
    }
}
