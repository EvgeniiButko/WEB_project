package BAckEnd;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/order")
public class OrderServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        req.setAttribute("id",id);

        if(id.equals("Enter")){
            RequestDispatcher dispatcher = req.getRequestDispatcher("WEB-INF/enter.jsp");
            dispatcher.forward(req,resp);
        }else{
            RequestDispatcher dispatcher = req.getRequestDispatcher("WEB-INF/Selery.jsp");
            dispatcher.forward(req,resp);
        }
    }
}
