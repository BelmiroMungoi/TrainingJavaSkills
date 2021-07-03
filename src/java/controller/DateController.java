package controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.dao.DaoData;

/**
 *
 * @author bbm29
 */
@WebServlet("/jsp/calcularData")
public class DateController extends HttpServlet {

    DaoData daoData = new DaoData();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            int hourDay = 8;
            Date calcDate = null;
            Double totalDays = 0.0;
            String date = request.getParameter("initialDate");
            int time = Integer.parseInt(request.getParameter("time"));

            if (time <= hourDay) {
                calcDate = new SimpleDateFormat("dd/MM/yyyy").parse(date);

            } else {
                totalDays = (double) (time / hourDay);

                if (totalDays <= 1) {
                    calcDate = new SimpleDateFormat("dd/MM/yyyy").parse(date);

                } else {
                    Date insertDate = new SimpleDateFormat("dd/MM/yyyy").parse(date);

                    Calendar calendar = Calendar.getInstance();
                    calendar.setTime(insertDate);
                    calendar.add(Calendar.DATE, totalDays.intValue());
                    calcDate = calendar.getTime();
                }
            }
            daoData.salvarData(new SimpleDateFormat("dd/MM/yyyy").format(calcDate));

            RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/dates.jsp");
            request.setAttribute("finalData", new SimpleDateFormat("dd/MM/yyyy").format(calcDate));
            request.setAttribute("dias", totalDays);
            dispatcher.forward(request, response);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
