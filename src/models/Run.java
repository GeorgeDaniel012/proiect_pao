package models;

public class Run extends Record {
    public Timer timer;

    public Run(int recordId, String recordDescription, int userId, int categoryId, String recordLink, int hours, int minutes, int seconds, int milliseconds) {
        super(recordId, recordDescription, userId, categoryId, recordLink);
        this.timer = new Timer(hours, minutes, seconds, milliseconds);
    }

    public Run(String recordDescription, int userId, int categoryId, String recordLink, int hours, int minutes, int seconds, int milliseconds) {
        super(recordDescription, userId, categoryId, recordLink);
        this.timer = new Timer(hours, minutes, seconds, milliseconds);
    }

    public Timer getTimer() {
        return timer;
    }

    public void setTimer(Timer timer) {
        this.timer = timer;
    }

    @Override
    public String toString() {
/*        return "Runner: '" + user.getUsername() + "'\n" +
                "Game: '" + category.getGame().getGameName() + "'\n" +
                "Category: '" + category.getCategoryName() + "'\n" +
                "Link: '" + recordLink + "'\n" +
                "Description: '" + recordDescription + "'\n" +
                timer.getHours() + ':' + timer.getMinutes() + ':' + timer.getSeconds() + ':' + timer.getMilliseconds() + "\n";*/

        return super.toString() +
                //timer.getHours() + ':' + timer.getMinutes() + ':' + timer.getSeconds() + ':' + timer.getMilliseconds() + "\n";
                timer.toString();
    }
}
