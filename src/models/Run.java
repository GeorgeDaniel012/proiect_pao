package models;

public class Run extends Record {
    public Timer timer;

    public Run(String recordDescription, User user, Category category, String recordLink, int hours, int minutes, int seconds, int milliseconds) {
        super(recordDescription, user, category, recordLink);
        this.timer = new Timer(hours, minutes, seconds, milliseconds);
    }

    public Timer getTimer() {
        return timer;
    }

    public void setTimer(Timer timer) {
        this.timer = timer;
    }
}
