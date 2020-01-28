package pe.isil.security.dao;

import pe.isil.security.model.User;
import pe.isil.util.DataBaseHelper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAO {

    public void loadUserByLoginAndPassword(User user) {

        try (Connection connection = DataBaseHelper.getConnection()) {
            String SQL = "SELECT id, login, password, name, is_active, expiration_date FROM tbl_dae1_users WHERE login = ? AND password = ?";
            try(PreparedStatement statement = connection.prepareStatement(SQL)) {
                statement.setString(1,user.getLogin());
                statement.setString(2, user.getPassword());
                try(ResultSet resultSet = statement.executeQuery()) {
                    if(resultSet.next()){
                        user.setId(resultSet.getInt(1));
                        user.setName(resultSet.getString(4));
                        user.setActive(resultSet.getBoolean(5));
                        user.setExpirationDate(resultSet.getDate(6).toLocalDate());
                    }
                }
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
