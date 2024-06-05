package models;

public class User {
    private final int userId;
    private static int maxUserId = 0;
    private String username;
    private Country country;
    private String email;
    private String gender;

    public User(int userId, String username, Country country, String email, String gender) {
        this.userId = userId;
        this.username = username;
        this.country = country;
        this.email = email;
        this.gender = gender;
    }

    public User(String username, Country country, String email, String gender) {
        this.userId = maxUserId;
        maxUserId++;
        this.username = username;
        this.country = country;
        this.email = email;
        this.gender = gender;
    }

    public User(String username, Country country, String email) {
        this.userId = maxUserId;
        maxUserId++;
        this.username = username;
        this.country = country;
        this.email = email;
        this.gender = "";
    }

    public int getUserId() {
        return userId;
    }

    public static int getMaxUserId() {
        return maxUserId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

/*    public void show(){
        System.out.println("Username: " + username);
        System.out.println("User id: " + userId);
        System.out.println("User country: " + country.getCountryName());
        System.out.println("User email: " + email);
        System.out.println("User gender: " + gender);
    }*/

    @Override
    public String toString() {
        return "Id: " + userId + "\n" +
                "Username: '" + username + "'\n" +
                "Country: '" + country.getCountryName() + "'\n" +
                "Email: '" + email + "'\n" +
                "Gender: '" + gender + "'\n";
    }
}
