package repositories;

import models.Country;
import models.User;

import java.util.List;

public interface ICountryRepository {
    void addCountry(Country country);

    //read
    Country getCountryByName(String name);
    Country getCountryById(int id);
    List<Country> getAllCountries();

    //update
    void updateCountryName(int id, String newName);

    //delete
    void removeCountry(int id);
}
