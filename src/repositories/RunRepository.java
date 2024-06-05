package repositories;

import models.*;
import util.DatabaseConfiguration;

import javax.xml.transform.Result;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RunRepository implements IRunRepository {
//    test repo
//
    public static void main(String[] args) {
        GameRepository gameRepo = new GameRepository();
        RunRepository runRepo = new RunRepository();
        Category category = gameRepo.getCategoriesByGame(gameRepo.getGameById(1)).get(0);
        //Run r = new Run(1, "run1", 1, 1, "link", 7, 32, 2, 255);
        //runRepo.addRun(r);
        System.out.println(runRepo.getRunsByCategory(category.getCategoryId()));
    }

//    public static void main(String[] args) {
//        GameRepository repo = new GameRepository();
//        Game game = repo.getGameById(1);
//        Category category = new Category("test2", "aaaa2", game, CategoryType.RUN, true);
//        repo.createCategory(category);
//    }

    @Override
    public void addRun(Run run) {
        Connection connection = null;
        try {
            connection = DatabaseConfiguration.getDatabaseConnection();
            String sql = "INSERT INTO Runs(recordId, recordDescription, userId, categoryId, recordLink, hours, minutes, seconds, milliseconds)" +
                    " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?);";

            PreparedStatement stmt =  connection.prepareStatement(sql);
            stmt.setInt(1, run.getRecordId());
            stmt.setString(2, run.getRecordDescription());
            stmt.setInt(3, run.getUserId());
            stmt.setInt(4, run.getCategoryId());
            stmt.setString(5, run.getRecordLink());
            stmt.setInt(6, run.getTimer().getHours());
            stmt.setInt(7, run.getTimer().getMinutes());
            stmt.setInt(8, run.getTimer().getSeconds());
            stmt.setInt(9, run.getTimer().getMilliseconds());

            stmt.executeUpdate();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Run getRunById(int id) {
        Connection connection = null;

        try {
            connection = DatabaseConfiguration.getDatabaseConnection();
            String sql = "SELECT * FROM Runs WHERE recordId=?";

            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, id);

            ResultSet resultSet = stmt.executeQuery();
            return mapToRun(resultSet, connection);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Run> getRunsByUser(User user) {
        Connection connection = null;

        try {
            connection = DatabaseConfiguration.getDatabaseConnection();
            String sql = "SELECT * FROM Runs WHERE userId = ?";

            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, user.getUserId());

            ResultSet resultSet = stmt.executeQuery();
            return mapToRunList(resultSet, connection);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Run> getRunsByCategory(int categoryId) {
        Connection connection = null;

        try {
            connection = DatabaseConfiguration.getDatabaseConnection();
            String sql = "SELECT * FROM Runs WHERE categoryId = ?";

            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, categoryId);

            ResultSet resultSet = stmt.executeQuery();
            return mapToRunList(resultSet, connection);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void updateLink(int id, String newLink) {
        Connection connection = null;

        try {
            connection = DatabaseConfiguration.getDatabaseConnection();
            String sql = "UPDATE Runs SET recordLink=? WHERE recordId=?";

            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, newLink);
            stmt.setInt(2, id);

            int rows = stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void removeRun(int id) {
        Connection connection = null;

        try {
            connection = DatabaseConfiguration.getDatabaseConnection();
            String sql = "DELETE FROM Runs WHERE recordId=?";

            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, id);

            int rows = stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private Run mapToRun(ResultSet rs, Connection connection) throws SQLException {
        // daca nu a fost returnat nimic
        if (!rs.next()) {
            return null;
        }

        int recordId = rs.getInt("recordId");
        String recordDescription = rs.getString("recordDescription");
        int userId = rs.getInt("userId");
        int categoryId = rs.getInt("categoryId");
        String recordLink = rs.getString("recordLink");
        int hours = rs.getInt("hours");
        int minutes = rs.getInt("minutes");
        int seconds = rs.getInt("seconds");
        int milliseconds = rs.getInt("milliseconds");

        return new Run(recordId, recordDescription, userId, categoryId, recordLink, hours, minutes, seconds, milliseconds);
    }

    private ArrayList<Run> mapToRunList(ResultSet rs, Connection connection) throws SQLException {
        ArrayList<Run> runList = new ArrayList<>();

        while(rs.next()){
            int recordId = rs.getInt("recordId");
            String recordDescription = rs.getString("recordDescription");
            int userId = rs.getInt("userId");
            int categoryId = rs.getInt("categoryId");
            String recordLink = rs.getString("recordLink");
            int hours = rs.getInt("hours");
            int minutes = rs.getInt("minutes");
            int seconds = rs.getInt("seconds");
            int milliseconds = rs.getInt("milliseconds");

            runList.add(new Run(recordId, recordDescription, userId, categoryId, recordLink, hours, minutes, seconds, milliseconds));
        }


        return runList;
    }
}
