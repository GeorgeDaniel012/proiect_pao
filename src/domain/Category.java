package domain;

import java.util.ArrayList;

public class Category {
    private final int categoryId;
    private static int maxCategoryId = 0;
    private String categoryName;
    private String categoryDescription = "";
    private final Game game;
    private final CategoryType type;
    //folosit doar daca categoryType e counter
    private String counterType = "";
    //sortare descrescatoare, default fals
    private boolean desc = false;
    private ArrayList<Record> records = new ArrayList<Record>();

/*    public Category(String categoryName, Game game, CategoryType type) {
        this.categoryId = maxCategoryId;
        maxCategoryId++;
        this.categoryName = categoryName;
        this.game = game;
        this.type = type;
    }*/

    public Category(String categoryName, String categoryDescription, Game game, CategoryType type, boolean desc) {
        this.categoryId = maxCategoryId;
        maxCategoryId++;
        this.categoryName = categoryName;
        this.categoryDescription = categoryDescription;
        this.game = game;
        this.type = type;
        this.desc = desc;
    }

    //folosit cand categoria e de tip counter
    public Category(String categoryName, String categoryDescription, Game game, CategoryType type, String counterType, boolean desc) {
        this.categoryId = maxCategoryId;
        maxCategoryId++;
        this.categoryName = categoryName;
        this.categoryDescription = categoryDescription;
        this.game = game;
        this.type = type;
        this.counterType = counterType;
        this.desc = desc;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public static int getMaxCategoryId() {
        return maxCategoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getCategoryDescription() {
        return categoryDescription;
    }

    public void setCategoryDescription(String categoryDescription) {
        this.categoryDescription = categoryDescription;
    }

    public Game getGame() {
        return game;
    }

    public CategoryType getType() {
        return type;
    }

    public String getCounterType() {
        return counterType;
    }

    public void setCounterType(String counterType) {
        this.counterType = counterType;
    }

    public boolean isDesc() {
        return desc;
    }

    public void setDesc(boolean desc) {
        this.desc = desc;
    }

    public ArrayList<Record> getRecords() {
        return records;
    }

    public void show(){
        System.out.println("Category name: " + categoryName);
        System.out.println("Category id: " + categoryId);
    }

}
