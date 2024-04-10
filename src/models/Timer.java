package models;

public class Timer {
    private int hours, minutes, seconds, milliseconds;

    public Timer(int hours, int minutes, int seconds, int milliseconds) {
        this.hours = hours;
        this.minutes = minutes;
        this.seconds = seconds;
        this.milliseconds = milliseconds;
    }

    public int getHours() {
        return hours;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }

    public int getMinutes() {
        return minutes;
    }

    public void setMinutes(int minutes) {
        this.minutes = minutes;
    }

    public int getSeconds() {
        return seconds;
    }

    public void setSeconds(int seconds) {
        this.seconds = seconds;
    }

    public int getMilliseconds() {
        return milliseconds;
    }

    public void setMilliseconds(int milliseconds) {
        this.milliseconds = milliseconds;
    }

    /*public void show(){
        System.out.println(hours + "h, " + minutes + "m, " + seconds + "s, " + milliseconds + "ms");
    }*/

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(hours + ":");

        // verificam daca minutele sunt de 2 cifre, daca nu adaugam 0
        if(minutes < 10){
            sb.append('0');
        }
        sb.append(minutes + ":");

        // verificam daca secundele sunt de 2 cifre, daca nu adaugam 0
        if(seconds < 10){
            sb.append('0');
        }
        sb.append(seconds + ":");

        // verificam daca milisecundele sunt de 3 cifre, daca nu adaugam unul sau doi de 0
        if(milliseconds < 10){
            sb.append("00");
        } else if(milliseconds < 100){
            sb.append('0');
        }
        sb.append(milliseconds);

        return sb.toString();
    }
}
