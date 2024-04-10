import models.*;

import java.lang.Record;

public class Main {
    public static void main(String[] args) {
        Country t1 = new Country();
        Country t2 = new Country("Romania");
        Country t3 = new Country("United States");

        User u1 = new User("george", t2, "email@test.com", "male");
        User u2 = new User("ioana", t3, "email2@test.com", "female");

        Game g1 = new Game("Minecraft", u1);
        Game g2 = new Game("Celeste", u2);

        g1.addGameModerator(u2);

        //g1.addCategory("Any%", "", CategoryType.RUN, false);
        Category c1 = new Category("Any%", "", g1, CategoryType.RUN, "", false);
        g1.addCategory(c1);
        g1.show();
        g1.showGameModerators();
        g1.showCategories();
        System.out.println();

        //g2.addCategory("Most berries", "", CategoryType.COUNTER, "berries", true);
        Category c2 = new Category("Most berries", "", g2, CategoryType.COUNTER, "berries", true);
        g2.addCategory(c2);
        g2.show();
        g2.showGameModerators();
        g2.showCategories();
        System.out.println();

        Run r1 = new Run("run 1", u1, c1, "link", 2, 3, 15, 120);
        c1.addRecord(r1);
        c1.show();
        
    }
}