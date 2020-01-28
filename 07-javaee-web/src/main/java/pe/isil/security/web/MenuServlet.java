package pe.isil.security.web;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "MenuServlet", displayName = "MenuServlet", urlPatterns = "/MenuServlet")
public class MenuServlet extends HttpServlet {

    private Map<String, String> menu;

    @Override
    public void init() throws ServletException {
        menu = new HashMap<>();
        menu.put("profesor","/ProfesorServlet?action=load");
        menu.put("curso","/CursoServlet?action=load");
        menu.put("estudiante","/EstudianteServlet?action=load");
        menu.put("matricula","/MatriculaServlet?action=load");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String dispatch = req.getParameter("dispatch");
        String forward = menu.get(dispatch);
        getServletContext().getRequestDispatcher(forward).forward(req, resp);
    }
}
