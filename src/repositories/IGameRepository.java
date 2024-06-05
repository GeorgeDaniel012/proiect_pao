package repositories;

import models.Category;
import models.Game;

import java.util.ArrayList;
import java.util.List;

public interface IGameRepository {
    //create
    void addGame(Game game);
    void createCategory(Category category);

    //read
    Game getGameByName(String name);
    Game getGameById(int id);
    List<Game> getAllGames();
    ArrayList<Category> getCategoriesByGame(Game game);

    //update
    void updateGameName(int id, String newName);

    //delete
    void removeGame(int id);
}
