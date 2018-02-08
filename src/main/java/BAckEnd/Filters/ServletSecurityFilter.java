package BAckEnd.Filters;


import BAckEnd.DAO;
import DataBase.DataReturner;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

@WebFilter(urlPatterns = "/controller", servletNames = "MainServlet")
public class ServletSecurityFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
            throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        HttpSession session = request.getSession();

        try {
            if (servletRequest.getParameter("txtlogin").equals("Jeka") &&
                    servletRequest.getParameter("txtpassword").equals("Tomas")) {
                filterChain.doFilter(request, response);
            }
        }catch(NullPointerException e){}

        ClientType type = (ClientType) session.getAttribute("userType");
        if(type == null){
            type = ClientType.GUEST;
            session.setAttribute("userType",type);
            RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/index.jsp");
            dispatcher.forward(request,response);
            return;
        }

        if(type == ClientType.GUEST){
            RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/index.jsp");
            dispatcher.forward(request,response);
            return;
        }

        if (type == ClientType.ADMIN) {
            filterChain.doFilter(request,response);
            return;
        }

        filterChain.doFilter(request,response);
    }

    @Override
    public void destroy() {

    }
}
