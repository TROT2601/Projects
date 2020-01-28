package pe.isil.base.web;

import pe.isil.base.model.Course;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "CursoServlet", displayName = "CursoServlet", urlPatterns = "/CursoServlet")
public class CourseServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if(action.equalsIgnoreCase("load")){

            List<Course> courses = new ArrayList<>();
            // teacherService.getAll()

            req.setAttribute("cursos",courses);
            req.setAttribute("pageInclude", "/pe/isil/cursos/cursos_main.jsp");
            getServletContext().getRequestDispatcher("/pe/isil/principal.jsp").forward(req, resp);

        }


    }
}
