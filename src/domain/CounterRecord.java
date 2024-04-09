package domain;

public class CounterRecord extends Record {
    private int counter = 0;

    public CounterRecord(String recordDescription, User user, Game game, String recordLink,int counter) {
        super(recordDescription, user, game, recordLink);
        this.counter = counter;
    }

    public int getCounter() {
        return counter;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }

}
