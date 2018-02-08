package BAckEnd.Filters;


import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(urlPatterns = "/jsp/*")
public class OrderFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        String t11 = request.getParameter("city");
        String t12 = request.getParameter("name");
        String t13 = request.getParameter("sername");
        String t14 = request.getParameter("number");
        String t15 = request.getParameter("mail");

        if(t11.length() < 3 && t12.length() < 3 && t13.length() < 3 && t14.length() != 10 && !t15.contains("@")) {
            RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/Selery.jsp");
            dispatcher.forward(request, response);
        }

        filterChain.doFilter(request,response);
    }

    @Override
    public void destroy() {

    }
}
