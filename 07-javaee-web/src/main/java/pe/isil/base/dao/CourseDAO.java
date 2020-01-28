package pe.isil.base.dao;

import pe.isil.base.model.Course;

import pe.isil.util.DataBaseHelper;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CourseDAO {

    public void create(Course course){
        try (Connection connection = DataBaseHelper.getConnection()){
            final String sql = "insert into tbl_dae1_course(id,name,teacher_id) values (?,?,?)";
            try (PreparedStatement statement = connection.prepareStatement(sql)){
                statement.setInt(1,course.getId());
                statement.setString(2,course.getName());
                statement.setInt(3,course.getTeacherId());
                statement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void update(Course course){
        try (Connection connection = DataBaseHelper.getConnection()){
            final String sql = "update tbl_dae1_course set name=?, set teacher_id=? where id=?";
            try (PreparedStatement statement = connection.prepareStatement(sql)){
                statement.setString(1,course.getName());
                statement.setInt(2,course.getTeacherId());
                statement.setInt(3,course.getId());
                statement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void delete(Course course){
        try (Connection connection = DataBaseHelper.getConnection()){
            final String sql = "delete from tbl_dae1_course where id=?";
            try (PreparedStatement statement = connection.prepareStatement(sql)){
                statement.setInt(1,course.getId());
                statement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public List<Course> geatAll(){
        List<Course>courses = new ArrayList<>();
        try (Connection connection = DataBaseHelper.getConnection()){
            final String sql = "select*from tbl_dae1_course";
            try (Statement statement = connection.createStatement()){
                ResultSet resultSet = statement.executeQuery(sql);
                while (resultSet.next()){
                    int id = resultSet.getInt("id");
                    String name = resultSet.getString("name");
                    int teacherId = resultSet.getInt("teacher_id");

                    Course course = new Course(id,name,teacherId);
                    courses.add(course);
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return courses;
    }
}
