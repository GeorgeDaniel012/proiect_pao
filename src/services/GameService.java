package services;

import models.*;

import java.util.ArrayList;

public class GameService {
    private static ArrayList<Game> games = new ArrayList<>();

    private GameService(){}

    public static Game addGame(Game game){
        games.add(game);
        return game;
    }

    public static Game addGame(String gameName, String gameDescription, User moderator1){
        if(moderator1 == null){
            throw new NullPointerException();
        }

        Game game = new Game(gameName, gameDescription, moderator1);
        games.add(game);
        return game;
    }

    public static ArrayList<Game> getGames() {
        return games;
    }

    public static Game findGameByName(String name){
        for(Game game: games){
            if(game.getGameName().equals(name)){
                return game;
            }
        }
        return null;
    }

    public static void addModeratorToGame(Game game, User user){
        if(user == null){
            throw new NullPointerException();
        }

        game.addGameModerator(user);
    }

    // metoda care adauga o categorie de tip run
    public static Category addRunCategory(Game game, String categoryName, String categoryDescription, boolean desc){
        if(game == null){
            throw new NullPointerException();
        }

        Category cat = new Category(categoryName, categoryDescription, game, CategoryType.RUN, desc);
        game.addCategory(cat);
        return cat;
    }

    // metoda care adauga o categorie de tip counter
    public static Category addCounterRecordCategory(Game game, String categoryName, String categoryDescription, String counterType, boolean desc){
        if(game == null){
            throw new NullPointerException();
        }

        Category cat = new Category(categoryName, categoryDescription, game, CategoryType.COUNTER, counterType, desc);
        game.addCategory(cat);
        return cat;
    }

    public static void show(){
        System.out.println("Games:\n");
        for(Game game: games){
            System.out.println(game.toString());
        }
    }
}
