package services;

import models.Country;
import models.User;

import java.util.ArrayList;

public class UserService {
    private static ArrayList<User> users = new ArrayList<>();

    private UserService(){}

    public static User addUser(User user){
        users.add(user);
        return user;
    }

    public static User addUser(String username, Country country, String email, String gender){
        User user = new User(username, country, email, gender);
        users.add(user);
        return user;
    }

    public static ArrayList<User> getUsers() {
        return users;
    }

    public static User findUserByUsername(String username){
        for(User user: users){
            if(user.getUsername().equals(username)){
                return user;
            }
        }
        return null;
    }

    public static void show(){
        System.out.println("Users:\n");
        for(User user: users){
            System.out.println(user.toString());
        }
    }
}
