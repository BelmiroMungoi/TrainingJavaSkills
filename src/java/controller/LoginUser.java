package controller;

import model.beans.UserBeans;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Belmiro-Mungoi
 */
@WebServlet("/LoginUser")
public class LoginUser extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String log = request.getParameter("log");
        if (log.equals("true")) {
            HttpServletRequest servletRequest = (HttpServletRequest) request;
            HttpSession session = servletRequest.getSession();
            session.invalidate();
            response.sendRedirect("login.jsp");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String userName = request.getParameter("nome");
        String password = request.getParameter("pass");
        String url = request.getParameter("url");
        if (userName.equals("admin") && password.equals("admin")) {

            UserBeans beans = new UserBeans();
            beans.setUserName(userName);
            beans.setPassword(password);

            HttpServletRequest servletRequest = (HttpServletRequest) request;
            HttpSession session = servletRequest.getSession();
            session.setAttribute("user", beans);

            RequestDispatcher dispatcher = request.getRequestDispatcher("jsp/index.jsp");
            dispatcher.forward(request, response);
        } else {
            RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
            dispatcher.forward(request, response);
        }
    }

}
