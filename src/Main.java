import domain.Game;
import domain.Country;
import domain.CategoryType;
import domain.User;

public class Main {
    public static void main(String[] args) {
        Country t1 = new Country();
        //System.out.println(t1.getNume_tara() + " " + t1.getId_tara());
        Country t2 = new Country("Romania");
        Country t3 = new Country("Statele Unite");
        //System.out.println(t2.getNume_tara() + " " + t2.getId_tara());
        User u1 = new User("george", t2, "email@test.com", "masculin");
        User u2 = new User("ioana", t3, "email2@test.com", "feminin");
//        System.out.println(u1.getNume_utilizator() + " " + u1.getId_utilizator() + " " +
//                u1.getTara().getNume_tara());

        Game j1 = new Game("Minecraft", u1);
        Game j2 = new Game("Celeste", u2);
        j1.addGameModerator(u2);
        //System.out.println(j1.getNume_joc() + " " + j1.getId_joc() + " ");
        //System.out.println("Moderator joc: " + j1.getModeratori_joc().getFirst().getNume_utilizator());
        j1.addCategory("Any%", "", CategoryType.RUN, false);
        j1.show();
        j1.showGameModerators();
        j1.showCategories();
        System.out.println();
        j2.addCategory("Most berries", "", CategoryType.COUNTER, "berries", true);
        j2.show();
        j2.showGameModerators();
        j2.showCategories();

    }
}