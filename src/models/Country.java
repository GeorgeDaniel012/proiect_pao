package models;

public class Country {
    private final int countryId;
    private static int maxCountryId = 0;
    private String countryName;

    public Country(int countryId, String countryName) {
        this.countryId = countryId;
        this.countryName = countryName;
    }

    public Country(String countryName) {
        this.countryId = maxCountryId;
        maxCountryId++;
        this.countryName = countryName;
    }

    public Country() {
        this.countryId = maxCountryId;
        maxCountryId++;
        this.countryName = "";
    }

    public int getCountryId() {
        return countryId;
    }

    public static int getMaxCountryId() {
        return maxCountryId;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public void show(){
        System.out.println("Country name: " + countryName);
        System.out.println("Country id: " + countryId);
    }

    @Override
    public String toString() {
        return "Country id: '" + countryId + "'\n" +
                "Country name: " + countryName + "'\n";
    }
}
