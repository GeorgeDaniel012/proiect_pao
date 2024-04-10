package models;

public abstract class Record {
    protected final int recordId;
    protected static int maxRecordId = 0;
    protected String recordDescription;
    protected final User user;
    protected final Category category;
    protected String recordLink;

    public Record(String recordDescription, User user, Category category, String recordLink) {
        this.recordId = maxRecordId;
        maxRecordId++;
        this.recordDescription = recordDescription;
        this.user = user;
        this.category = category;
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

    public User getUser() {
        return user;
    }

    public Category getCategory() {
        return category;
    }

    public String getRecordLink() {
        return recordLink;
    }

    public void setRecordLink(String recordLink) {
        this.recordLink = recordLink;
    }
}
