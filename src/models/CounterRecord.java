package models;

public class CounterRecord extends Record {
    private int counter = 0;

    public CounterRecord(String recordDescription, User user, Category category, String recordLink,int counter) {
        super(recordDescription, user, category, recordLink);
        this.counter = counter;
    }

    public int getCounter() {
        return counter;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }

}
