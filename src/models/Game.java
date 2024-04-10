package models;

import java.util.ArrayList;

public class Game {
    private final int gameId;
    private static int maxGameId = 0;
    private String gameName;
    private String gameDescription;
    //un joc are cel putin un moderator
    private ArrayList<User> gameModerators = new ArrayList<User>();
    //un joc poate avea mai multe categorii
    private ArrayList<Category> categories = new ArrayList<Category>();
    //un joc poate avea mai multe stiri (news)
    private ArrayList<News> newsList = new ArrayList<News>();

    public Game(String gameName, User moderator1) {
        // un joc trebuie sa aiba cel putin un moderator!
        this.gameId = maxGameId;
        maxGameId++;
        this.gameName = gameName;
        this.gameModerators.add(moderator1);
        this.gameDescription = "";
    }

    public Game(String gameName, String gameDescription, User moderator1) {
        this.gameId = maxGameId;
        maxGameId++;
        this.gameName = gameName;
        this.gameModerators.add(moderator1);
        this.gameDescription = gameDescription;
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

    public ArrayList<User> getGameModerators() {
        return gameModerators;
    }

    public ArrayList<Category> getCategories(){
        return categories;
    }

    public void addGameModerator(User u){
        this.gameModerators.add(u);
    }

    public void addCategory(Category c){
        this.categories.add(c);
    }

    //pt categorii de tip run
    public void addCategory(String categoryName, String categoryDescription, CategoryType type, boolean desc){
        Category c = new Category(categoryName, categoryDescription, this, type, desc);
        this.categories.add(c);
    }

    //pt categorii de tip counter
    public void addCategory(String categoryName, String categoryDescription, CategoryType type, String counterType, boolean desc){
        Category c = new Category(categoryName, categoryDescription, this, type, counterType, desc);
        this.categories.add(c);
    }

    public void addNews(News n){
        this.newsList.add(n);
    }

    public void addNews(User author, String header, String content){
        News n = new News(author, header, content);
        this.newsList.add(n);
    }

    public void showGameModerators(){
        for(User u: this.gameModerators){
            System.out.println(u.getUsername() + ", id: " + u.getUserId());
        }
    }

    public void showCategories(){
        for(Category c: this.categories){
            System.out.println(c.getCategoryName());
        }
    }

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
        return gameModerators.contains(u);
    }
}
