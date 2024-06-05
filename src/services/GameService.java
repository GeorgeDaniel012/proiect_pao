package services;

import models.Category;
import models.Game;
import repositories.GameRepository;
import repositories.UserRepository;

import java.util.ArrayList;
import java.util.List;

public class GameService {
    private final GameRepository gameRepository;
    private static GameService gameService;

    private GameService() {
        this.gameRepository = new GameRepository();
    }

    public static GameService getInstance(){
        if(gameService == null){
            gameService = new GameService();
        }
        return gameService;
    }

    public void addGame(Game game){
        gameRepository.addGame(game);
    }

    public void createCategory(Category category){
        gameRepository.createCategory(category);
    }

    public Game getGameByName(String name){
        return gameRepository.getGameByName(name);
    }

    public Game getGameById(int id){
        return gameRepository.getGameById(id);
    }

    public List<Game> getAllGames(){
        return gameRepository.getAllGames();
    }

    public ArrayList<Category> getCategoriesByGame(Game game){
        return gameRepository.getCategoriesByGame(game);
    }

    public void updateGameName(int id, String newName){
        gameRepository.updateGameName(id, newName);
    }

    public void removeGame(int id){
        gameRepository.removeGame(id);
    }
}
