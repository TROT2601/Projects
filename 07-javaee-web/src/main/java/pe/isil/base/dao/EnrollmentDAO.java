package pe.isil.base.dao;


import pe.isil.base.model.Enrollment;
import pe.isil.util.DataBaseHelper;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class EnrollmentDAO {

    public void create(Enrollment enrollment){
        try (Connection connection = DataBaseHelper.getConnection()){
            final String sql = "insert into tbl_dae1_enrollment(id,course_id,student_id,created_date,credit) values (?,?,?,?,?)";
            try (PreparedStatement statement = connection.prepareStatement(sql)){
                statement.setInt(1,enrollment.getId());
                statement.setInt(2,enrollment.getCourseId());
                statement.setInt(3,enrollment.getStudentId());
                statement.setDate(4,Date.valueOf(enrollment.getCreateDate()));
                statement.setInt(5,enrollment.getCredit());
                statement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void update(Enrollment enrollment){
        try (Connection connection = DataBaseHelper.getConnection()){
            final String sql = "update tbl_dae1_enrollment set course_id=?, set student_id=?, set created_date=?, credit=? where id=?";
            try (PreparedStatement statement = connection.prepareStatement(sql)){
                statement.setInt(1,enrollment.getCourseId());
                statement.setInt(2,enrollment.getStudentId());
                statement.setDate(3,Date.valueOf(enrollment.getCreateDate()));
                statement.setInt(4,enrollment.getCredit());
                statement.setInt(5,enrollment.getId());
                statement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void delete(Enrollment enrollment){
        try (Connection connection = DataBaseHelper.getConnection()){
            final String sql = "delete from tbl_dae1_enrollment where id=?";
            try (PreparedStatement statement = connection.prepareStatement(sql)){
                statement.setInt(1,enrollment.getId());
                statement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public List<Enrollment> geatAll(){
        List<Enrollment>enrollments = new ArrayList<>();
        try (Connection connection = DataBaseHelper.getConnection()){
            final String sql = "select*from tbl_dae1_enrollment";
            try (Statement statement = connection.createStatement()){
                //statement = consulta si parametros
                ResultSet resultSet = statement.executeQuery(sql);
                while (resultSet.next()){
                    int id = resultSet.getInt("id");
                    int courseId = resultSet.getInt("course_id");
                    int studentId = resultSet.getInt("student_id");
                    LocalDate createDate = resultSet.getDate("createdDate").toLocalDate();
                    int credit = resultSet.getInt("credit");


                    Enrollment enrollment = new Enrollment(id,courseId,studentId,createDate,credit);
                    enrollments.add(enrollment);
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return enrollments;
    }

}
