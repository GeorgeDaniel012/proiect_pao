import models.*;
import org.w3c.dom.css.Counter;
import services.GameService;
import services.RecordService;
import services.UserService;

public class Main {
    public static void main(String[] args) {
        //Country t1 = new Country();
        Country t2 = new Country("Romania");
        Country t3 = new Country("United States");

/*        User u1 = new User("george", t2, "email@test.com", "male");
        User u2 = new User("ioana", t3, "email2@test.com", "female");
        UserService.addUser(u1);
        UserService.addUser(u2);*/
        User u1 = UserService.addUser("george", t2, "email@test.com", "male");
        User u2 = UserService.addUser("ioana", t3, "email2@test.com", "female");

/*        Game g1 = new Game("Minecraft", UserService.findUserByUsername("george"));
        Game g2 = new Game("Celeste", UserService.findUserByUsername("ioana"));*/
        GameService.addGame("Minecraft", "", u1);
        GameService.addGame("Celeste", "desc1", u2);
        Game g1 = GameService.findGameByName("Minecraft");
        Game g2 = GameService.findGameByName("Celeste");

        //g1.addGameModerator(UserService.findUserByUsername("ioana"));
        GameService.addModeratorToGame(g1, UserService.findUserByUsername("ioana"));

        //g1.addCategory("Any%", "", CategoryType.RUN, false);
        //Category c1 = new Category("Any%", "", g1, CategoryType.RUN, "", false);
        //g1.addCategory(c1);
        Category c1 = GameService.addRunCategory(g1, "Any%", "", false);
/*        g1.show();
        g1.showGameModerators();
        g1.showCategories();
        System.out.println();*/

        //g2.addCategory("Most berries", "", CategoryType.COUNTER, "berries", true);
        //Category c2 = new Category("Most berries", "", g2, CategoryType.COUNTER, "berries", true);
        //g2.addCategory(c2);
        Category c2 = GameService.addCounterRecordCategory(g2,"Least deaths","","deaths", true);
/*        g2.show();
        g2.showGameModerators();
        g2.showCategories();
        System.out.println();*/

        //Run r1 = new Run("run 1", UserService.findUserByUsername("george"), c1, "link", 2, 3, 15, 120);
        Run r1 = RecordService.addRunToCategory(c1, "", u1, "link1", 2, 3, 15, 129);
//        c1.addRecord(r1);
//        c1.show();

        //CounterRecord r2 = new CounterRecord("run 2", UserService.findUserByUsername("george"), c2, "link2", 17);
        CounterRecord r2 = RecordService.addCounterRecordToCategory(c2, "aaaa", u1, "link2", 17);
//        c2.addRecord(r2);
//        c2.show();

        Run r3 = RecordService.addRunToCategory(c1, "fsfs", u2, "jf", 3, 1, 5, 17);
        Run r4 = RecordService.addRunToCategory(c1, "fsfs", u2, "jf", 2, 3, 5, 17);

        CounterRecord r5 = RecordService.addCounterRecordToCategory(c2, "aaaa", u2, "link2", 23);

        UserService.show();

        RecordService.showRecordsByUser(u2);

        RecordService.showRecordsByCategory(c1);
        RecordService.showRecordsByCategory(c2);

        // codul de mai jos da o exceptie IllegalArgumentException
        //CounterRecord r6 = RecordService.addCounterRecordToCategory(c1, "aaaa", u2, "link2", 23);
    }
}