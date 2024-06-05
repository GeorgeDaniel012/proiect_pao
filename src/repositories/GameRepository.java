package repositories;

import models.*;
import util.DatabaseConfiguration;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GameRepository implements IGameRepository {
//    test repo
//
    public static void main(String[] args) {
        GameRepository repo = new GameRepository();
        //System.out.println(repo.getAllGames());
        //System.out.println(repo.getGameById(1));
        System.out.println(repo.getCategoriesByGame(repo.getGameById(1)));
    }

//    public static void main(String[] args) {
//        GameRepository repo = new GameRepository();
//        Game game = repo.getGameById(1);
//        Category category = new Category("test2", "aaaa2", game, CategoryType.RUN, true);
//        repo.createCategory(category);
//    }

    @Override
    public void addGame(Game game) {
        Connection connection = null;
        try {
            connection = DatabaseConfiguration.getDatabaseConnection();
            String sql1 = "INSERT INTO Games(gameName, gameDescription) VALUES (?, ?);";

            PreparedStatement stmt1 =  connection.prepareStatement(sql1);
            stmt1.setString(1, game.getGameName());
            stmt1.setString(2, game.getGameDescription());

            stmt1.executeUpdate();

            String sql2 = "INSERT INTO GameModerators(userId, gameId) VALUES (?, ?)";

            PreparedStatement stmt2 = connection.prepareStatement(sql2);
            stmt2.setInt(1, game.getGameModerators().get(0));
            stmt2.setInt(2, game.getGameId());

            stmt2.executeUpdate();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void createCategory(Category category) {
        Connection connection = null;
        try {
            connection = DatabaseConfiguration.getDatabaseConnection();
            String sql = "INSERT INTO Categories(categoryName, categoryDescription, gameId, descending)" +
                    " VALUES (?, ?, ?, ?)";

            PreparedStatement stmt =  connection.prepareStatement(sql);
            stmt.setString(1, category.getCategoryName());
            stmt.setString(2, category.getCategoryDescription());
            stmt.setInt(3, category.getGame().getGameId());
            stmt.setBoolean(4, category.isDesc());

            stmt.executeUpdate();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Game getGameByName(String name) {
        Connection connection = null;

        try {
            connection = DatabaseConfiguration.getDatabaseConnection();
            String sql = "SELECT * FROM Games g WHERE g.gameName=?";

            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, name);

            ResultSet resultSet = stmt.executeQuery();
            return mapToGame(resultSet, connection);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Game getGameById(int id) {
        Connection connection = null;

        try {
            connection = DatabaseConfiguration.getDatabaseConnection();
            String sql = "SELECT * FROM Games g WHERE g.gameId=?";

            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, id);

            ResultSet resultSet = stmt.executeQuery();
            return mapToGame(resultSet, connection);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Game> getAllGames() {
        Connection connection = null;

        try {
            connection = DatabaseConfiguration.getDatabaseConnection();
            String sql = "SELECT * FROM Games g LEFT JOIN GameModerators gm ON " +
                    "g.gameId = gm.gameId";

            PreparedStatement stmt = connection.prepareStatement(sql);

            ResultSet resultSet = stmt.executeQuery();
            return mapToGameList(resultSet, connection);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public ArrayList<Category> getCategoriesByGame(Game game) {
        Connection connection = null;
        ArrayList<Category> categories = new ArrayList<>();

        try {
            connection = DatabaseConfiguration.getDatabaseConnection();
            String sql = "SELECT * FROM categories c WHERE c.gameId = ?";

            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, game.getGameId());

            ResultSet resultSet = stmt.executeQuery();
            return mapToCategoryList(resultSet, connection);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void updateGameName(int id, String newName) {
        Connection connection = null;

        try {
            connection = DatabaseConfiguration.getDatabaseConnection();
            String sql = "UPDATE Games SET gameName=? WHERE gameId=?";

            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, newName);
            stmt.setInt(2, id);

            int rows = stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void removeGame(int id) {
        Connection connection = null;

        try {
            connection = DatabaseConfiguration.getDatabaseConnection();
            String sql = "DELETE FROM Games WHERE gameId=?";

            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, id);

            int rows = stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private Game mapToGame(ResultSet rs, Connection connection) throws SQLException {
        // daca nu a fost returnat nimic
        if (!rs.next()) {
            return null;
        }

        int gameId = rs.getInt("gameId");
        String gameName = rs.getString("gameName");
        String gameDescription = rs.getString("gameDescription");

        // luam categoriile
        ArrayList<Integer> categoryList = getCategoryList(connection, gameId);

        // luam moderatorii
        ArrayList<Integer> userList = getUserList(connection, gameId);

        return new Game(gameId, gameName, gameDescription, userList, categoryList);
    }

    private List<Game> mapToGameList(ResultSet rs, Connection connection) throws SQLException {
        List<Game> gameList = new ArrayList<>();

        while(rs.next()){
            int gameId = rs.getInt("gameId");
            String gameName = rs.getString("gameName");
            String gameDescription = rs.getString("gameDescription");

            // luam categoriile
            ArrayList<Integer> categoryList = getCategoryList(connection, gameId);

            // luam moderatorii
            ArrayList<Integer> userList = getUserList(connection, gameId);

            gameList.add(new Game(gameId, gameName, gameDescription, userList, categoryList));
        }


        return gameList;
    }

    private ArrayList<Integer> getCategoryList(Connection connection, int gameId) throws SQLException {
        String sql = "SELECT * FROM Categories WHERE gameId = ?";
        PreparedStatement catStmt = connection.prepareStatement(sql);
        catStmt.setInt(1, gameId);

        ArrayList<Integer> categoryList = new ArrayList<>();
        ResultSet rsc = catStmt.executeQuery();

        while (rsc.next()) {
            categoryList.add(rsc.getInt(1)); // Assuming categoryId is the first column
        }

        return categoryList;
    }

//    private ArrayList<Category> getCategoryListCat(Connection connection, int gameId) throws SQLException {
//        String sql = "SELECT * FROM Categories WHERE gameId = ?";
//        PreparedStatement catStmt = connection.prepareStatement(sql);
//        catStmt.setInt(1, gameId);
//
//        ArrayList<Integer> categoryList = new ArrayList<>();
//        ResultSet rsc = catStmt.executeQuery();
//
//        while (rsc.next()) {
//            categoryList.add(rsc.getInt(1)); // Assuming categoryId is the first column
//        }
//
//        return categoryList;
//    }

    private ArrayList<Integer> getUserList(Connection connection, int gameId) throws SQLException {
        String sql = "SELECT * FROM GameModerators WHERE gameId = ?";
        PreparedStatement userStmt = connection.prepareStatement(sql);
        userStmt.setInt(1, gameId);

        ArrayList<Integer> userList = new ArrayList<>();
        ResultSet rs = userStmt.executeQuery();

        while (rs.next()) {
            userList.add(rs.getInt(1)); // Assuming categoryId is the first column
        }

        return userList;
    }

    private ArrayList<Category> mapToCategoryList(ResultSet rs, Connection connection) throws SQLException {
        ArrayList<Category> categories = new ArrayList<>();

        while(rs.next()) {
            int categoryId = rs.getInt("categoryId");
            String categoryName = rs.getString("categoryName");
            String categoryDescription = rs.getString("categoryDescription");
            int gameId = rs.getInt("gameId");
            boolean desc = rs.getBoolean("descending");
            ArrayList<Integer> runList = getRunList(connection, categoryId);

            categories.add(new Category(categoryId, categoryName, categoryDescription, getGameById(gameId), CategoryType.RUN, desc, runList));
        }

        return categories;
    }

    private ArrayList<Integer> getRunList(Connection connection, int categoryId) throws SQLException {
        String sql = "SELECT * FROM Runs WHERE categoryId = ?";
        PreparedStatement runStmt = connection.prepareStatement(sql);
        runStmt.setInt(1, categoryId);

        ArrayList<Integer> runList = new ArrayList<>();
        ResultSet rsr = runStmt.executeQuery();

        while (rsr.next()) {
            runList.add(rsr.getInt(1)); // Assuming categoryId is the first column
        }

        return runList;
    }
}
