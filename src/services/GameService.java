package services;

import models.*;

import java.util.ArrayList;

public class GameService {
    private static ArrayList<Game> games = new ArrayList<>();

    private GameService(){}

    public static void addGame(Game game){
        games.add(game);
    }

    public static void addGame(String gameName, String gameDescription, User moderator1){
        Game game = new Game(gameName, gameDescription, moderator1);
        games.add(game);
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

    public static void addRunCategory(Game game, String categoryName, String categoryDescription, boolean desc){
        Category cat = new Category(categoryName, categoryDescription, game, CategoryType.RUN, desc);
        game.addCategory(cat);
    }

    public static void addCounterRecordCategory(Game game, String categoryName, String categoryDescription, String counterType, boolean desc){
        Category cat = new Category(categoryName, categoryDescription, game, CategoryType.COUNTER, counterType, desc);
        game.addCategory(cat);
    }

    public static void show(){
        System.out.println("Games:\n");
        for(Game game: games){
            System.out.println(game.toString());
        }
    }
}
