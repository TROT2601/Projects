package pe.isil.base;

import pe.isil.base.dao.CourseDAO;
import pe.isil.base.dao.EnrollmentDAO;
import pe.isil.base.dao.StudentDAO;
import pe.isil.base.dao.TeacherDAO;
import pe.isil.base.model.Course;
import pe.isil.base.model.Enrollment;
import pe.isil.base.model.Student;
import pe.isil.base.model.Teacher;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Teacher t = new Teacher(1, "Jose", "Ventura");
        Course c = new Course(1, "DAE1", 1);
        Student s = new Student(1, "ALUMNO01", "APE01", LocalDate.of(1992, 10, 23));
        Enrollment e = new Enrollment(1, 1,1, LocalDate.now(), 4);

        TeacherDAO teacherDao = new TeacherDAO();
        CourseDAO courseDao = new CourseDAO();
        StudentDAO studentDao = new StudentDAO();
        EnrollmentDAO enrollmentDao = new EnrollmentDAO();

        teacherDao.create(t);
        courseDao.create(c);
        studentDao.create(s);
        enrollmentDao.create(e);

        enrollmentDao.delete(e);
        studentDao.delete(s);
        courseDao.delete(c);
        teacherDao.delete(t);
    }
}
