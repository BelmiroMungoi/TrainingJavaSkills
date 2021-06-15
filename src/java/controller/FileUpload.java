package controller;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.beans.UserBeans;
import model.dao.DaoUsuario;
import org.apache.tomcat.util.codec.binary.Base64;

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

        String action = request.getParameter("action");

        if (action.equals("load")) {
            RequestDispatcher view = request.getRequestDispatcher("imageUpload.jsp");
            request.setAttribute("images", usuario.listarUsuario());
            view.forward(request, response);

        } else if (action.equals("download")) {
            String idUser = request.getParameter("idUser");
            String image = usuario.buscaImagem(idUser);

            if (image != null) {
                
                //Coloca um nome para a imagem baixada
                response.setHeader("Content-Disposition", "attachment;filename=imagem.png");
                
                // Pega a imagem em base64 e transforma em imagem pura.
                String photo = image.split(",")[1];

                //Vai converter a imagem para Bytes
                byte[] imageBytes = new Base64().decodeBase64(photo);

                // Vai colocar os Bytes em um objecto de entrada para processar 
                InputStream inputStream = new ByteArrayInputStream(imageBytes);

                // Saida dos dados ou da imagem/ responde ao navegador
                int read = 0;
                byte[] bytes = new byte[1024];
                OutputStream outputStream = response.getOutputStream();

                while ((read = inputStream.read(bytes)) != -1) {
                    outputStream.write(bytes, 0, read);
                }
                outputStream.flush();
                outputStream.close();
            }
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {

            String fileUpload = request.getParameter("fileUpload");

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
