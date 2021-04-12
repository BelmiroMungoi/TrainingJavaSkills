package filter;

import model.beans.UserBeans;
import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Belmiro-Mungoi
 */
@WebFilter(urlPatterns = {"/jsp/*"})
public class AuthFilter implements Filter {

    public AuthFilter() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest servletRequest = (HttpServletRequest) request;
        HttpSession session = servletRequest.getSession();

        String urlAuth = servletRequest.getServletPath();
        UserBeans userBeans = (UserBeans) session.getAttribute("user");

        if (userBeans == null && !urlAuth.equals("/LoginUser")) {
            RequestDispatcher dispatcher = request.getRequestDispatcher("/login.jsp?url=" + urlAuth);
            dispatcher.forward(request, response);
            return;
        }
        chain.doFilter(request, response);
    }

}
