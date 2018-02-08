package BAckEnd;

import BAckEnd.DAO;
import BAckEnd.Filters.ClientType;
import DataBase.DataReturner;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(urlPatterns = "/timeaction", name = "MainServlet")
public class Servlet extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            req.setAttribute("posts", DAO.getPosts());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        req.getRequestDispatcher("WEB-INF/Hello.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("txtlogin");
        String password = req.getParameter("txtpassword");
        String registr = req.getParameter("reg");


            if (login.equals("Jeka") && password.equals("Tomas")) {
                HttpSession session = req.getSession();
                session.setAttribute("userType", ClientType.ADMIN);
                try {
                    req.setAttribute("posts", DAO.getPosts());
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                req.getRequestDispatcher("WEB-INF/Hello.jsp").forward(req, resp);
            } else {
                if (DataReturner.getClientTypeFromDB(login, password) == ClientType.GUEST) {
                    req.getRequestDispatcher("WEB-INF/guest.jsp").forward(req, resp);
                } else {
                    if (registr != null && registr.equals("Registration")) {
                        req.getRequestDispatcher("WEB-INF/registr.jsp").forward(req, resp);
                        return;
                    }else{
                        try{
                            req.getRequestDispatcher("/index.jsp").forward(req, resp);
                        }catch (Exception e){
                            resp.sendRedirect("index.jsp");
                        }
                    }
                }
            }
        }

}
