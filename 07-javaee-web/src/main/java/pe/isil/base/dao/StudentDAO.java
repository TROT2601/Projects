package pe.isil.base.dao;

import pe.isil.base.model.Student;
import pe.isil.util.DataBaseHelper;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO {

    public void create(Student student){
        try (Connection connection = DataBaseHelper.getConnection()){
            final String sql = "insert into tbl_dae1_student(id,name,last_name, birth_date) values (?,?,?,?)";
            try (PreparedStatement statement = connection.prepareStatement(sql)){
                statement.setInt(1,student.getId());
                statement.setString(2,student.getName());
                statement.setString(3,student.getLastName());
                statement.setDate(4, Date.valueOf(student.getBirthDate()));
                statement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void update(Student student){
        try (Connection connection = DataBaseHelper.getConnection()){
            final String sql = "update tbl_dae1_student set name=?, set last_name=?, set birth_name where id=?";
            try (PreparedStatement statement = connection.prepareStatement(sql)){
                statement.setString(1,student.getName());
                statement.setString(2,student.getLastName());
                statement.setDate(3, Date.valueOf(student.getBirthDate()));
                statement.setInt(4,student.getId());
                statement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void delete(Student student){
        try (Connection connection = DataBaseHelper.getConnection()){
            final String sql = "delete from tbl_dae1_student where id=?";
            try (PreparedStatement statement = connection.prepareStatement(sql)){
                statement.setInt(1,student.getId());
                statement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public List<Student> geatAll(){
        List<Student>students = new ArrayList<>();
        try (Connection connection = DataBaseHelper.getConnection()){
            final String sql = "select*from tbl_dae1_student";
            try (Statement statement = connection.createStatement()){
                ResultSet resultSet = statement.executeQuery(sql);
                while (resultSet.next()){
                    int id = resultSet.getInt("id");
                    String name = resultSet.getString("name");
                    String lastName = resultSet.getString("last_name");
                    LocalDate birthDate = resultSet.getDate("birth_date").toLocalDate();

                    Student student = new Student(id,name,lastName,birthDate);
                    students.add(student);
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return students;
    }
}
