package controller;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.beans.Eventos;
import model.dao.DaoEventos;

/**
 *
 * @author bbm29
 */
@WebServlet("/jsp/buscarCalendario")
public class CalendarController extends HttpServlet {

    private DaoEventos daoEventos = new DaoEventos();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        List<Eventos> lista = daoEventos.getEventos();
        String dates = "[";

        if (!lista.isEmpty()) {
            for (Eventos eventos : lista) {
                dates += "{"
                        + "\"title\": \""+eventos.getDescricao()+"\","
                        + "\"start\": \""+eventos.getInicio()+"\","
                        + "\"end\": \""+eventos.getFim()+"\""
                        + " }";
            }
            dates += "]";
            response.setStatus(200);
            response.getWriter().write(dates);
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

}
