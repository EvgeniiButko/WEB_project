package BAckEnd;

import DataBase.DataStorer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/buying")

public class ServletForBuying extends HttpServlet{
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String city = req.getParameter("city");
        String name = req.getParameter("name");
        String sername = req.getParameter("sername");
        String number = req.getParameter("number");
        String mail = req.getParameter("mail");
        String timeId = req.getParameter("id");

        DataStorer.addOrder(city,name,sername,number,mail,Integer.parseInt(timeId));
        resp.sendRedirect("index.jsp");
    }
}
