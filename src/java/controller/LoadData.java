package controller;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.beans.UserBeans;
import model.dao.DaoUsuario;

/**
 *
 * @author bbm29
 */
@WebServlet("/jsp/loadData")
public class LoadData extends HttpServlet {

    private DaoUsuario daoUsuario = new DaoUsuario();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        List<UserBeans> usuarios = daoUsuario.listarUsuario();
        int totalUsers = usuarios.size();
        int index = 1;

        if (!usuarios.isEmpty()) {
            String data = "";

            // codigo para processar os dados e colocar em json
            for (UserBeans usuario : usuarios) {
                data += "["
                        + "\"" + usuario.getIdUser() + "\","
                        + "\"" + usuario.getUserName() + "\","
                        + "\"" + usuario.getIdade() + "\","
                        + "\"" + usuario.getPassword()+ "\""
                        + "]";

                // caso exista mais usuarios ira colocar uma virgula no fim
                if (index < totalUsers) {
                    data += ",";
                }
                index++;
            }

            String json = "{"
                    + "\"draw\":1,"
                    + "\"recordsTotal\":" + usuarios.size() + ","
                    + "\"recordsFiltered\":" + usuarios.size() + ","
                    + "\"data\": [" + data
                    + "]" // fechamento dos dados
                    + "}"; // fechamento do json

            response.setStatus(200);
            response.getWriter().write(json);
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

}
