package BAckEnd;

import DataBase.DataStorer;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

//@WebServlet(name = "AddPost", urlPatterns = "/add")
public class AddPost extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
          String txt = request.getParameter("txt");
          String inform = request.getParameter("inform");
          if(txt.equals("ZAKAZI")){
              try {
                  request.setAttribute("orders", DataStorer.getOrders());
              } catch (SQLException e) {
                  e.printStackTrace();
              }

              RequestDispatcher requestDispatcher = request.getRequestDispatcher("WEB-INF/basket.jsp");
              requestDispatcher.forward(request,response);
          }else{
              DAO.addPost(txt,inform);
              response.sendRedirect("/timeaction");
          }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
