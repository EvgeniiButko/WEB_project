package BAckEnd;

import DataBase.UserRegister;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/regAction")
public class RegisterServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("txtlogin");
        String password = req.getParameter("txtpassword");
        String mail = req.getParameter("txtmail");

        if(login != null && password != null && mail != null){
            UserRegister.addUser(login,password,mail);
        }

        RequestDispatcher dispatcher = req.getRequestDispatcher("/timeaction");
        dispatcher.forward(req,resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
