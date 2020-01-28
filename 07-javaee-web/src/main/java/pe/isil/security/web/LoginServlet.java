package pe.isil.security.web;

import pe.isil.security.model.User;
import pe.isil.security.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "LoginServlet", displayName = "loginServlet", urlPatterns = "/login.do")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //super.doPost(req, resp);
        User user = new User();
        user.setLogin(req.getParameter("txtLogin"));
        user.setPassword(req.getParameter("txtPassword"));

        UserService userService = new UserService();

        try {
            userService.userValidation(user);

            req.getSession().setAttribute("usuario", user);
            req.getRequestDispatcher("/pe/isil/principal.jsp").forward(req, resp);

        }catch (Exception e){
            req.setAttribute("message", e.getMessage());
            req.getRequestDispatcher("/login.jsp").forward(req, resp);
        }

    }
}
