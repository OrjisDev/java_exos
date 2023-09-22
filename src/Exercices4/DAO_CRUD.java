package Exercices4;

import java.sql.*;

public class DAO_CRUD {
        static String url = "jdbc:mysql://localhost:3306";
        static String uname = "root";
        static String password = "";

        //Requêtes
        private static final String INSERT_USER = "INSERT INTO users.users (username,password,email) VALUES (?,?,?)";
        private static final String SELECT_USER_BY_ID = "SELECT * FROM users.users WHERE id = ?";
        private static final String UPDATE_USER = "UPDATE users.users SET username=?, password=?, email=? WHERE id = ?";
        private static final String DELETE_USER = "DELETE FROM users.users WHERE id = ?";
    public static void addUser(User user){
        try (Connection connection = DriverManager.getConnection(url,uname,password);
             PreparedStatement statement = connection.prepareStatement(INSERT_USER)){
            statement.setString(1, user.getUsername());
            statement.setString(2,user.getPassword());
            statement.setString(3,user.getEmail());
            statement.executeUpdate();
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static User getUserById(int id){
        try (Connection connection = DriverManager.getConnection(url,uname,password);
             PreparedStatement statement = connection.prepareStatement(SELECT_USER_BY_ID)){
            statement.setInt(1, id);
            ResultSet result = statement.executeQuery();
            if(result.next()){
                return fromResultSetToUser(result);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }
    public static void updateUser(String username, String password, String email ,int id){
        try (Connection connection = DriverManager.getConnection(url,uname,password);
             PreparedStatement statement = connection.prepareStatement(UPDATE_USER)){
            statement.setString(1, username);
            statement.setString(2, password);
            statement.setString(3, email);
            statement.setInt(4,id);
            statement.executeUpdate();
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void deleteUser(int id){
        try (Connection connection = DriverManager.getConnection(url,uname,password);
             PreparedStatement statement = connection.prepareStatement(DELETE_USER)){
            statement.setInt(1, id);
            statement.executeUpdate();
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }
    private static User fromResultSetToUser(ResultSet result) throws SQLException{
        User user = new User(result.getString("username"),result.getString("password"),result.getString("email"));
        return user;
    }

}
