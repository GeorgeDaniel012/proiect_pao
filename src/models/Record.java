package models;

public abstract class Record {
    protected final int recordId;
    protected static int maxRecordId = 0;
    protected String recordDescription;
    //protected final User user;
    protected final int userId;
    //protected final Category category;
    protected final int categoryId;
    protected String recordLink;

    public Record(int recordId, String recordDescription, int userId, int categoryId, String recordLink) {
        this.recordId = recordId;
        this.recordDescription = recordDescription;
        this.userId = userId;
        this.categoryId = categoryId;
        this.recordLink = recordLink;
    }

    public Record(String recordDescription, int userId, int categoryId, String recordLink) {
        this.recordId = maxRecordId;
        maxRecordId++;
        this.recordDescription = recordDescription;
        this.userId = userId;
        this.categoryId = categoryId;
        this.recordLink = recordLink;
    }

    public int getRecordId() {
        return recordId;
    }

    public static int getMaxIdRecord() {
        return maxRecordId;
    }

    public String getRecordDescription() {
        return recordDescription;
    }

    public void setRecordDescription(String recordDescription) {
        this.recordDescription = recordDescription;
    }

    public int getUserId() {
        return userId;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public String getRecordLink() {
        return recordLink;
    }

    public void setRecordLink(String recordLink) {
        this.recordLink = recordLink;
    }

//    @Override
//    public String toString() {
//        return "Runner: '" + userId + "'\n" +
//                "Game: '" + category.getGame().getGameName() + "'\n" +
//                "Category: '" + category.getCategoryName() + "'\n" +
//                "Link: '" + recordLink + "'\n" +
//                "Description: '" + recordDescription + "'\n";
//    }
    @Override
    public String toString() {
        return "Runner: '" + userId + "'\n" +
                "Category: '" + categoryId + "'\n" +
                "Link: '" + recordLink + "'\n" +
                "Description: '" + recordDescription + "'\n";
    }
}
