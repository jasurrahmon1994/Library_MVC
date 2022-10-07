package uz.jasur.dao;

import uz.jasur.models.User;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class UserDAO {
    private static final String URL = "jdbc:postgresql://localhost:5432/library";
    private static final String USERNAME = "postgres";
    private static final String PASSWORD = "root123";

    private static Connection connection;

    static {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public List<User> showAllUsers() {
        List<User> users = new ArrayList<>();

        try {
            Statement statement = connection.createStatement();
            String SQL = "SELECT * FROM users";
            ResultSet resultSet = statement.executeQuery(SQL);

            while (resultSet.next()) {
                User user = new User();

                user.setId(resultSet.getInt("id"));
                user.setFullName(resultSet.getString("fullName"));

                users.add(user);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return users;
    }
}
