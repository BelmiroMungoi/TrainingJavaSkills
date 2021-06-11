package controller;

import java.io.IOException;
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
@WebServlet("/jsp/fileUpload")
public class FileUpload extends HttpServlet {

    private DaoUsuario usuario = new DaoUsuario();
    private UserBeans beans = new UserBeans();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            String username = request.getParameter("user");
            String password = request.getParameter("pass");
            String fileUpload = request.getParameter("fileUpload");

            beans.setUserName(username);
            beans.setPassword(password);
            beans.setImage(fileUpload);
            usuario.salvarUsuario(beans);

            response.setStatus(200);
            response.getWriter().write(" Upload Realizado com Sucesso!!!");

        } catch (Exception e) {
            response.getWriter().write("Erro ao fazer o upload" + e.getMessage());
            e.printStackTrace();
        }

    }

}
