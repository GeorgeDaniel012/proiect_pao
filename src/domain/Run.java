package domain;

public class Run extends Record {
    public Timer timer;

    public Run(String recordDescription, User user, Game game, String recordLink, int hours, int minutes, int seconds, int milliseconds) {
        super(recordDescription, user, game, recordLink);
        this.timer = new Timer(hours, minutes, seconds, milliseconds);
    }

    public Timer getTimer() {
        return timer;
    }

    public void setTimer(Timer timer) {
        this.timer = timer;
    }
}
