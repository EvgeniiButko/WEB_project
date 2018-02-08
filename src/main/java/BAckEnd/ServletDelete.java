package BAckEnd;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//@WebServlet(name = "ServletDelete", urlPatterns = "/delete")
public class ServletDelete extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try{
            int id = Integer.parseInt(request.getParameter("id"));
            DAO.deletePost(id);
        }catch (NullPointerException e){
            int id = Integer.parseInt(request.getParameter("iidd"));
            DAO.deleteOrder(id);
        }catch(NumberFormatException e){
            int id = Integer.parseInt(request.getParameter("iidd"));
            DAO.deleteOrder(id);
        }finally {
            response.sendRedirect("/timeaction");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
