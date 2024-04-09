package domain;

public abstract class Record {
    protected final int recordId;
    protected static int maxRecordId = 0;
    protected String recordDescription;
    protected final User user;
    protected final Game game;
    protected String recordLink;

    public Record(String recordDescription, User user, Game game, String recordLink) {
        this.recordId = maxRecordId;
        maxRecordId++;
        this.recordDescription = recordDescription;
        this.user = user;
        this.game = game;
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

    public Game getGame() {
        return game;
    }

    public String getRecordLink() {
        return recordLink;
    }

    public void setRecordLink(String recordLink) {
        this.recordLink = recordLink;
    }
}
