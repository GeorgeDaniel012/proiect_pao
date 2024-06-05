package models;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private final int gameId;
    private static int maxGameId = 0;
    private String gameName;
    private String gameDescription;
    //un joc are cel putin un moderator
    //private ArrayList<User> gameModerators = new ArrayList<>();
    private List<Integer> gameModerators = new ArrayList<>();
    //un joc poate avea mai multe categorii
    //private ArrayList<Category> categories = new ArrayList<>();
    private List<Integer> categories = new ArrayList<>();
    //un joc poate avea mai multe stiri (news)
    private ArrayList<News> newsList = new ArrayList<>();

    public Game(int gameId, String gameName, String gameDescription, User moderator1) {
        this.gameId = gameId;
        this.gameName = gameName;
        this.gameDescription = gameDescription;
        //this.gameModerators.add(moderator1);
        this.gameModerators.add(moderator1.getUserId());
    }

    public Game(String gameName, User moderator1) {
        // un joc trebuie sa aiba cel putin un moderator!
        this.gameId = maxGameId;
        maxGameId++;
        this.gameName = gameName;
        //this.gameModerators.add(moderator1);
        this.gameModerators.add(moderator1.getUserId());
        this.gameDescription = "";
    }

    public Game(String gameName, String gameDescription, User moderator1) {
        this.gameId = maxGameId;
        maxGameId++;
        this.gameName = gameName;
        //this.gameModerators.add(moderator1);
        this.gameModerators.add(moderator1.getUserId());
        this.gameDescription = gameDescription;
    }

    public Game(int gameId, String gameName, String gameDescription, ArrayList<Integer> gameModerators, ArrayList<Integer> categories) {
        this.gameId = gameId;
        this.gameName = gameName;
        this.gameDescription = gameDescription;
        this.gameModerators = gameModerators;
        this.categories = categories;
    }

    public int getGameId() {
        return gameId;
    }

    public static int getMaxGameId() {
        return maxGameId;
    }

    public String getGameName() {
        return gameName;
    }

    public void setGameName(String gameName) {
        this.gameName = gameName;
    }

    public String getGameDescription() {
        return gameDescription;
    }

    public void setGameDescription(String gameDescription) {
        this.gameDescription = gameDescription;
    }

    public List<Integer> getGameModerators() {
        return gameModerators;
    }

    public List<Integer> getCategories(){
        return categories;
    }

    public ArrayList<News> getNewsList() {
        return newsList;
    }

    public void addGameModerator(User u){
        this.gameModerators.add(u.getUserId());
    }

    public void addCategory(Category c){
        this.categories.add(c.getCategoryId());
    }

    //pt categorii de tip run
//    public void addCategory(String categoryName, String categoryDescription, CategoryType type, boolean desc){
//        Category c = new Category(categoryName, categoryDescription, type, desc);
//        this.categories.add(c.getCategoryId());
//    }
//
//    //pt categorii de tip counter
//    public void addCategory(String categoryName, String categoryDescription, CategoryType type, String counterType, boolean desc){
//        Category c = new Category(categoryName, categoryDescription, type, counterType, desc);
//        this.categories.add(c.getCategoryId());
//    }

    public void addNews(News n){
        this.newsList.add(n);
    }

    public void addNews(User author, String header, String content){
        News n = new News(author, header, content);
        this.newsList.add(n);
    }

//    public void showGameModerators(){
//        for(User u: this.gameModerators){
//            System.out.println(u.getUsername() + ", id: " + u.getUserId());
//        }
//    }

//    public void showCategories(){
//        for(Category c: this.categories){
//            System.out.println(c.getCategoryName());
//        }
//    }

    public void showNews(){
        for(News n: this.newsList){
            n.show();
        }
    }

    public void show(){
        System.out.println("Game name: " + gameName);
        System.out.println("Game id: " + gameId);
        System.out.println(gameModerators.size() + " moderators");
        System.out.println(categories.size() + " categories");
        System.out.println(newsList.size() + " news");
    }

    //verificam daca un user este moderator pt joc
    public boolean isModerator(User u){
        return gameModerators.contains(u.getUserId());
    }

    @Override
    public String toString() {
        return "Id: " + gameId + "\n" +
                "Name: '" + gameName + "'\n" +
                "Description: '" + gameDescription + "'\n" +
                "No of Moderators: " + gameModerators.size() + "\n" +
                "No of Categories: " + categories.size() + "\n" +
                "No of News: " + newsList.size() + "\n";
    }
}
