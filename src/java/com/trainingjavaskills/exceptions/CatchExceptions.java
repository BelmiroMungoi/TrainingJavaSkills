package com.trainingjavaskills.exceptions;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Belmiro-Mungoi
 */
@WebServlet("/jsp/catchException")
public class CatchExceptions extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            String valor = request.getParameter("valor");
            Integer.parseInt(valor);

            response.setStatus(200);
            response.getWriter().write("Processado Com Sucesso");
        } catch (Exception e) {

            response.setStatus(500);
            response.getWriter().write("Error: " + e.getMessage());
        }

    }

}
