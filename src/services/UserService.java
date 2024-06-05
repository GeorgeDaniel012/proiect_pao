package services;

import models.User;
import repositories.CountryRepository;
import repositories.UserRepository;

import java.util.List;

public class UserService {
    private final UserRepository userRepository;
    private static UserService userService;

    private UserService() {
        this.userRepository = new UserRepository();
    }

    public static UserService getInstance(){
        if(userService == null){
            userService = new UserService();
        }
        return userService;
    }

    public  void addUser(User user){
        userRepository.addUser(user);
    }

    public User getUserByName(String name){
        return userRepository.getUserByName(name);
    }

    public User getUserById(int id){
        return userRepository.getUserById(id);
    }

    public List<User> getAllUsers(){
        return userRepository.getAllUsers();
    }

    public void updateUsername(int id, String newName){
        userRepository.updateUsername(id, newName);
    }

    public void removeUser(int id){
        userRepository.removeUser(id);
    }
}
