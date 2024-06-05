package repositories;

//import models.Country;
import models.Country;
import models.User;
import util.DatabaseConfiguration;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserRepository implements IUserRepository {
//    public static void main(String[] args) {
//        Country country = (new CountryRepository()).getCountryById(1);
//        User user = new User("abcdef", country, "abcd@email.com", "male");
//        UserRepository repo = new UserRepository();
//        repo.addUser(user);
//    }
    public static void main(String[] args) {
        UserRepository uRepo = new UserRepository();
        CountryRepository cRepo = new CountryRepository();
        User u = new User("u2", cRepo.getCountryById(2), "email2", "female");
        uRepo.addUser(u);
    }

    @Override
    public void addUser(User user) {
        Connection connection = null;
        try {
            connection = DatabaseConfiguration.getDatabaseConnection();
            String sql = "INSERT INTO Users(username, countryid, email, gender) VALUES (?, ?, ?, ?)";

            PreparedStatement stmt =  connection.prepareStatement(sql);
            stmt.setString(1, user.getUsername());
            stmt.setInt(2, user.getCountry().getCountryId());
            stmt.setString(3, user.getEmail());
            stmt.setString(4, user.getGender());

            stmt.executeUpdate();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public User getUserByName(String name) {
        Connection connection = null;

        try {
            connection = DatabaseConfiguration.getDatabaseConnection();
            String sql = "SELECT * FROM Users u LEFT JOIN Countries c ON " +
                    "u.countryId = c.countryId WHERE u.username=?";

            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, name);

            ResultSet resultSet = stmt.executeQuery();
            return mapToUser(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public User getUserById(int id) {
        Connection connection = null;

        try {
            connection = DatabaseConfiguration.getDatabaseConnection();
            String sql = "SELECT * FROM Users u LEFT JOIN Countries c ON " +
                    "u.countryId = c.countryId WHERE u.userId=?";

            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, id);

            ResultSet resultSet = stmt.executeQuery();
            return mapToUser(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<User> getAllUsers() {
        Connection connection = null;

        try {
            connection = DatabaseConfiguration.getDatabaseConnection();
            String sql = "SELECT * FROM Users u LEFT JOIN Countries c ON " +
                    "u.countryId = c.countryId";

            PreparedStatement stmt = connection.prepareStatement(sql);

            ResultSet resultSet = stmt.executeQuery();
            return mapToUserList(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void updateUsername(int id, String newName){
        Connection connection = null;

        try {
            connection = DatabaseConfiguration.getDatabaseConnection();
            String sql = "UPDATE Users SET username=? WHERE userId=?";

            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, newName);
            stmt.setInt(2, id);

            int rows = stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void removeUser(int id) {
        Connection connection = null;

        try {
            connection = DatabaseConfiguration.getDatabaseConnection();
            String sql = "DELETE FROM Users WHERE userId=?";

            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, id);

            int rows = stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private User mapToUser(ResultSet rs) throws SQLException {
        if (rs.next()) {
            return new User(rs.getInt("userId"), rs.getString("username"),
                    new Country(rs.getInt("countryId"), rs.getString("countryName")),
                    rs.getString("email"), rs.getString("gender"));
        }
        return null;
    }

    private List<User> mapToUserList(ResultSet rs) throws SQLException {
        List<User> userList = new ArrayList<>();
        while(rs.next()){
            User u = new User(rs.getInt("userId"), rs.getString("username"),
                    new Country(rs.getInt("countryId"), rs.getString("countryName")),
                    rs.getString("email"), rs.getString("gender"));
            userList.add(u);
        }
        return userList;
    }
}
