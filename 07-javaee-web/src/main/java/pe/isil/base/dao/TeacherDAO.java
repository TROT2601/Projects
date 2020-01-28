package pe.isil.base.dao;

import pe.isil.base.model.Teacher;
import pe.isil.util.DataBaseHelper;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TeacherDAO {

    public void create(Teacher teacher){
        try (Connection connection = DataBaseHelper.getConnection()){
            final String sql = "insert into tbl_dae1_teacher(id,name,last_name) values (?,?,?)";
            try (PreparedStatement statement = connection.prepareStatement(sql)){
                statement.setInt(1,teacher.getId());
                statement.setString(2,teacher.getName());
                statement.setString(3,teacher.getLastName());
                statement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void update(Teacher teacher){
        try (Connection connection = DataBaseHelper.getConnection()){
            final String sql = "update tbl_dae1_teacher set name=?, set last_name=? where id=?";
            try (PreparedStatement statement = connection.prepareStatement(sql)){
                statement.setString(1,teacher.getName());
                statement.setString(2,teacher.getLastName());
                statement.setInt(3,teacher.getId());
                statement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void delete(Teacher teacher){
        try (Connection connection = DataBaseHelper.getConnection()){
            final String sql = "delete from tbl_dae1_teacher where id=?";
            try (PreparedStatement statement = connection.prepareStatement(sql)){
                statement.setInt(1,teacher.getId());
                statement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public List<Teacher> geatAll(){
        List<Teacher>teachers = new ArrayList<>();
        try (Connection connection = DataBaseHelper.getConnection()){
            final String sql = "select*from tbl_dae1_teacher";
            try (Statement statement = connection.createStatement()){
                ResultSet resultSet = statement.executeQuery(sql);
                while (resultSet.next()){
                    int id = resultSet.getInt("id");
                    String name = resultSet.getString("name");
                    String lastName = resultSet.getString("last_name");

                    Teacher teacher = new Teacher(id,name,lastName);
                    teachers.add(teacher);
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return teachers;
    }
}
