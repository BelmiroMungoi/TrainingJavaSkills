package model.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author Belmiro-Mungoi
 */
public class SingleConnection {

    private static Connection connection = null;
    public static Statement stm;
    public static ResultSet rs;
    private static String url = "jdbc:postgresql://localhost:5433/bdTestes";
    private static String user = "postgres";
    private static String password = "admin";
    
    static {
        connect();
    }
    
    public SingleConnection(){
        connect();
    }

    private static void connect() {
        try {
            if (connection == null) {
                Class.forName("org.postgresql.Driver");
                connection = DriverManager.getConnection(url, user, password);
                connection.setAutoCommit(false);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao conectar a base de dados\n" + e.getMessage());
            e.printStackTrace();
        }

    }
    
    public static Connection getConnection(){
        return connection;
    }
    
    public void executaSql(String sql){
        try {
            stm = connection.createStatement(rs.TYPE_SCROLL_INSENSITIVE,rs.CONCUR_READ_ONLY);
            rs = stm.executeQuery(sql);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null,"Erro ao executar Sql:\n" + ex.getMessage());
        }
    }
}
