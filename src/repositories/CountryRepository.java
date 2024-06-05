package repositories;

import models.Country;
//import models.User;
import util.DatabaseConfiguration;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CountryRepository implements ICountryRepository {
//    repo test below
//
//    public static void main(String[] args) {
//        CountryRepository repo = new CountryRepository();
////        repo.addCountry(new Country("japan"));
////        repo.addCountry(new Country("romania"));
////        repo.addCountry(new Country("serbia"));
////        repo.removeCountry(1);
//        repo.updateCountry(2, "china");
//        System.out.println(repo.getAllCountries());
//    }
//
//    public static void main(String[] args) {
//        CountryRepository repo = new CountryRepository();
//        System.out.println(repo.getCountryByName("serbia"));
//        System.out.println(repo.getCountryById(1));
//    }

    @Override
    public void addCountry(Country country) {
        Connection connection = null;
        try {
            connection = DatabaseConfiguration.getDatabaseConnection();
            String sql = "INSERT INTO Countries(countryName) VALUES (?)";

            PreparedStatement stmt =  connection.prepareStatement(sql);
            stmt.setString(1, country.getCountryName());

            stmt.executeUpdate();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Country getCountryByName(String name) {
        Connection connection = null;

        try {
            connection = DatabaseConfiguration.getDatabaseConnection();
            String sql = "SELECT * FROM Countries WHERE countryName=?";

            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, name);

            ResultSet resultSet = stmt.executeQuery();
            return mapToCountry(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Country getCountryById(int id) {
        Connection connection = null;

        try {
            connection = DatabaseConfiguration.getDatabaseConnection();
            String sql = "SELECT * FROM Countries WHERE countryId=?";

            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, id);

            ResultSet resultSet = stmt.executeQuery();
            return mapToCountry(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Country> getAllCountries() {
        Connection connection = null;

        try {
            connection = DatabaseConfiguration.getDatabaseConnection();
            String sql = "SELECT * FROM Countries";

            PreparedStatement stmt = connection.prepareStatement(sql);

            ResultSet resultSet = stmt.executeQuery();
            return mapToCountryList(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void updateCountryName(int id, String newName) {
        Connection connection = null;

        try {
            connection = DatabaseConfiguration.getDatabaseConnection();
            String sql = "UPDATE Countries SET countryName=? WHERE countryId=?";

            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, newName);
            stmt.setInt(2, id);

            int rows = stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void removeCountry(int id) {
        Connection connection = null;

        try {
            connection = DatabaseConfiguration.getDatabaseConnection();
            String sql = "DELETE FROM Countries WHERE countryId=?";

            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, id);

            int rows = stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private Country mapToCountry(ResultSet rs) throws SQLException {
        if (rs.next()) {
            return new Country(rs.getInt(1), rs.getString(2));
        }
        return null;
    }

    private List<Country> mapToCountryList(ResultSet rs) throws SQLException {
        List<Country> countryList = new ArrayList<>();
        while(rs.next()){
            countryList.add(new Country(rs.getInt(1), rs.getString(2)));
        }
        return countryList;
    }
}
