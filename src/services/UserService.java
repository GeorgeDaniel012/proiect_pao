package services;

import models.User;

import java.util.ArrayList;

public class UserService {
    private static ArrayList<User> users = new ArrayList<User>();

    private UserService(){}

    public static void addUser(User user){
        users.add(user);
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
        for(User user: users){
            System.out.println(user.toString());
        }
    }
}
