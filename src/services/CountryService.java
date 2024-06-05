package services;

import models.Country;
import repositories.CountryRepository;

import java.util.List;

public class CountryService {
    private final CountryRepository countryRepository;
    private static CountryService countryService;

    private CountryService() {
        this.countryRepository = new CountryRepository();
    }

    public static CountryService getInstance(){
        if(countryService == null){
            countryService = new CountryService();
        }
        return countryService;
    }

    void addCountry(Country country){
        countryRepository.addCountry(country);
    }

    Country getCountryByName(String name){
        return countryRepository.getCountryByName(name);
    }

    Country getCountryById(int id){
        return countryRepository.getCountryById(id);
    }

    List<Country> getAllCountries(){
        return countryRepository.getAllCountries();
    }

    void updateCountryName(int id, String newName){
        countryRepository.updateCountryName(id, newName);
    }

    void removeCountry(int id){
        countryRepository.removeCountry(id);
    }
}
