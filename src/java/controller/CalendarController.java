package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author bbm29
 */
@WebServlet("/jsp/buscarCalendario")
public class CalendarController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("adhheuwwen");
        String dates = "[{ "
                + "\"title\": \"Fazer o jantar\","
                + "\"start\": \"2021-07-16\","
                + "\"end\": \"2021-07-17\""
                + " }]";
        response.setStatus(200);
        response.getWriter().write(dates);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

}
