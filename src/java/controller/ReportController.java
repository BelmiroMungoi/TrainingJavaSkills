package controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.beans.UserBeans;
import model.dao.DaoUsuario;
import services.ReportService;

/**
 *
 * @author bbm29
 */
@WebServlet("/jsp/reports")
public class ReportController extends HttpServlet {

    private ReportService reportService = new ReportService();
    private DaoUsuario daoUsuario = new DaoUsuario();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            String reportType = request.getParameter("reportType");
            List<UserBeans> usuarios = daoUsuario.listarUsuario();
            List dados = new ArrayList();
            dados.add(usuarios);
            String reportUrl = reportService.generateReport(dados, new HashMap(),
                    "rel_usuario", "rel_usuario", request.getServletContext());

            //Constroi o caminho do arquivo
            File downloadFile = new File(reportUrl);
            FileInputStream inputStream = new FileInputStream(downloadFile);

            //Obtem o tipo MIME do arquivo
            String mimeType = request.getServletContext().getMimeType(reportUrl);
            if (mimeType == null) {
                //definir um tipo binário se o mapeamento mime nao for encontrado
                mimeType = "application/octet-stream";

                //definir os atributos da resposta
                response.setContentType(mimeType);
                response.setContentLength((int) downloadFile.length());

                // define o cabecalho da resposta
                String headerKey = "Content-Disposition";
                String headerValue = String.format("attachment; filename=\"%s\"",
                        downloadFile.getName());

                // obtem o fluxo de saida da resposta
                OutputStream outputStream = response.getOutputStream();
                byte[] buffer = new byte[4096];
                int byteReader = -1;

                //Escrever os bytes lidos apartir do fluxo de entrada para o fluxo de saida
                while ((byteReader = inputStream.read(buffer)) != -1) {
                    outputStream.write(buffer, 0, byteReader);
                }
                inputStream.close();
                outputStream.close();

            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

}
