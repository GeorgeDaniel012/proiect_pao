//package repositories;
//
//import models.Category;
//import models.CategoryType;
//import models.Game;
//import util.DatabaseConfiguration;
//
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.util.ArrayList;
//import java.util.List;
//
//public class CategoryRepository implements ICategoryRepository {
//
//    @Override
//    public void addCategory(Category category) {
//        Connection connection = null;
//        try {
//            connection = DatabaseConfiguration.getDatabaseConnection();
//            String sql = "INSERT INTO Categories(categoryName, categoryDescription, gameId, descending)" +
//                    "VALUES (?, ?, ?, ?);";
//
//            PreparedStatement stmt =  connection.prepareStatement(sql);
//            stmt.setString(1, category.getCategoryName());
//            stmt.setString(2, category.getCategoryDescription());
//            stmt.setInt(3, category.getGame().getGameId());
//
//            stmt.executeUpdate();
//        }
//        catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
//
//    @Override
//    public Category getCategoryByGame(Game game) {
//        Connection connection = null;
//
//        try {
//            connection = DatabaseConfiguration.getDatabaseConnection();
//            String sql = "SELECT * FROM Categories c LEFT JOIN Runs r" +
//                    " WHERE c.gameId=?";
//
//            PreparedStatement stmt = connection.prepareStatement(sql);
//            stmt.setInt(1, game.getGameId());
//
//            ResultSet resultSet = stmt.executeQuery();
//            return mapToCategory(resultSet, connection);
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return null;
//    }
//
//    @Override
//    public Category getCategoryById(int id) {
//        Connection connection = null;
//
//        try {
//            connection = DatabaseConfiguration.getDatabaseConnection();
//            String sql = "SELECT * FROM Categories c WHERE c.categoryId=?";
//
//            PreparedStatement stmt = connection.prepareStatement(sql);
//            stmt.setInt(1, id);
//
//            ResultSet resultSet = stmt.executeQuery();
//            return mapToCategory(resultSet, connection);
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return null;
//    }
//
//    @Override
//    public List<Category> getAllCategories() {
//        Connection connection = null;
//
//        try {
//            connection = DatabaseConfiguration.getDatabaseConnection();
//            String sql = "SELECT * FROM Categories c";
//
//            PreparedStatement stmt = connection.prepareStatement(sql);
//
//            ResultSet resultSet = stmt.executeQuery();
//            return mapToCategoryList(resultSet, connection);
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return null;
//    }
//
//    @Override
//    public void updateCategoryName(int id, String newName) {
//        Connection connection = null;
//
//        try {
//            connection = DatabaseConfiguration.getDatabaseConnection();
//            String sql = "UPDATE Categories SET categoryName=? WHERE categoryId=?";
//
//            PreparedStatement stmt = connection.prepareStatement(sql);
//            stmt.setString(1, newName);
//            stmt.setInt(2, id);
//
//            int rows = stmt.executeUpdate();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
//
//    @Override
//    public void removeCategory(int id) {
//        Connection connection = null;
//
//        try {
//            connection = DatabaseConfiguration.getDatabaseConnection();
//            String sql = "DELETE FROM Categories WHERE categoryId=?";
//
//            PreparedStatement stmt = connection.prepareStatement(sql);
//            stmt.setInt(1, id);
//
//            int rows = stmt.executeUpdate();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
//
//    private Category mapToCategory(ResultSet rs, Connection connection) throws SQLException {
//        // daca nu a fost returnat nimic
//        if (!rs.next()) {
//            return null;
//        }
//
//        int categoryId = rs.getInt("categoryId");
//        String categoryName = rs.getString("categoryName");
//        String categoryDescription = rs.getString("categoryDescription");
//        int gameId = rs.getInt("gameId");
//        boolean desc = rs.getBoolean("descending");
//
//        // luam categoriile
//        ArrayList<Integer> runList = getRunList(connection, gameId);
//
//        return new Category(categoryId, categoryName, categoryDescription,
//                new Game(), CategoryType.RUN, desc, runList);
//    }
//
//    private List<Category> mapToCategoryList(ResultSet rs, Connection connection) throws SQLException {
//        List<Category> categoryList = new ArrayList<>();
//
//        while(rs.next()){
//            int categoryId = rs.getInt("categoryId");
//            String categoryName = rs.getString("categoryName");
//            String categoryDescription = rs.getString("categoryDescription");
//            int gameId = rs.getInt("gameId");
//            boolean desc = rs.getBoolean("descending");
//
//            // luam categoriile
//            ArrayList<Integer> runList = getRunList(connection, gameId);
//
//            categoryList.add(new Category(categoryId, categoryName, categoryDescription, CategoryType.RUN, desc, runList));
//        }
//
//
//        return categoryList;
//    }
//
//    private ArrayList<Integer> getRunList(Connection connection, int gameId) throws SQLException {
//        String sql = "SELECT * FROM Runs WHERE recordId = ?";
//        PreparedStatement recStmt = connection.prepareStatement(sql);
//        recStmt.setInt(1, gameId);
//
//        ArrayList<Integer> categoryList = new ArrayList<>();
//        ResultSet rsr = recStmt.executeQuery();
//
//        while (rsr.next()) {
//            categoryList.add(rsr.getInt(1)); // Assuming categoryId is the first column
//        }
//
//        return categoryList;
//    }
//}
