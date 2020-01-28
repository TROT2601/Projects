package pe.isil.base.web;

import pe.isil.base.model.Teacher;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


@WebServlet(name = "ProfesorServlet", displayName = "ProfesorServlet", urlPatterns = "/ProfesorServlet")
public class TeacherServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if(action.equalsIgnoreCase("load")){

            List<Teacher> teachers = new ArrayList<>();
            // teacherService.getAll()

            req.setAttribute("profesores",teachers);
            req.setAttribute("pageInclude", "/pe/isil/profesores/profesores_main.jsp");
            getServletContext().getRequestDispatcher("/pe/isil/principal.jsp").forward(req, resp);

        }


    }
}
