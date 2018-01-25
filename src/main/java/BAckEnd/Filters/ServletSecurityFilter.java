package BAckEnd.Filters;


import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
@WebFilter(urlPatterns = "/controller", servletNames = "Servlet")
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

        ClientType type = (ClientType) session.getAttribute("userType");
        if(type == null){
            type = ClientType.GUEST;
            session.setAttribute("userType", type);
            RequestDispatcher dispatcher = servletRequest.getServletContext().getRequestDispatcher("guest.jsp");
            dispatcher.forward(request,response);
            return;
        }

        filterChain.doFilter(request,response);
    }

    @Override
    public void destroy() {

    }
}
