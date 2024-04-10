import models.*;
import org.w3c.dom.css.Counter;
import services.GameService;
import services.NewsService;
import services.RecordService;
import services.UserService;

public class Main {
    public static void main(String[] args) {
        Country t1 = new Country("Jamaica");
        Country t2 = new Country("Romania");
        Country t3 = new Country("United States");
        Country t4 = new Country("Bulgaria");

/*        User u1 = new User("george", t2, "email@test.com", "male");
        User u2 = new User("maria", t3, "email2@test.com", "female");
        UserService.addUser(u1);
        UserService.addUser(u2);*/
        User u1 = UserService.addUser("george", t2, "email@test.com", "male");
        User u2 = UserService.addUser("maria", t3, "email2@test.com", "female");

        User u3 = UserService.addUser("Pape", t4, "pape@gmail.com", "male");
        User u4 = UserService.addUser("Explore", t1, "explore@yahoo.com", "female");
        User u5 = UserService.addUser("koralreef", t3, "koralreef@outlook.com", "male");

/*        Game g1 = new Game("Minecraft", UserService.findUserByUsername("george"));
        Game g2 = new Game("Celeste", UserService.findUserByUsername("maria"));*/
        GameService.addGame("Grand Theft Auto: San Andreas", "", u1);
        GameService.addGame("Celeste", "desc1", u2);
        Game g1 = GameService.findGameByName("Grand Theft Auto: San Andreas");
        Game g2 = GameService.findGameByName("Celeste");

        //g1.addGameModerator(UserService.findUserByUsername("maria"));
        GameService.addModeratorToGame(g1, UserService.findUserByUsername("maria"));

        //g1.addCategory("Any%", "", CategoryType.RUN, false);
        //Category c1 = new Category("Any%", "", g1, CategoryType.RUN, "", false);
        //g1.addCategory(c1);

/*        g1.show();
        g1.showGameModerators();
        g1.showCategories();
        System.out.println();*/

        //g2.addCategory("Most berries", "", CategoryType.COUNTER, "berries", true);
        //Category c2 = new Category("Most berries", "", g2, CategoryType.COUNTER, "berries", true);
        //g2.addCategory(c2);

/*        g2.show();
        g2.showGameModerators();
        g2.showCategories();
        System.out.println();*/

        Category c1 = GameService.addRunCategory(g1, "Any%", "Beat the game as fast as possible!", false);
        Category c2 = GameService.addCounterRecordCategory(g2,"Least deaths","Beat the game while having as few deaths as possible.",
                "deaths", true);
        Category c3 = GameService.addRunCategory(g2, "All Red Berries", "Complete the game with all red berries.", false);

        //Run r1 = new Run("run 1", UserService.findUserByUsername("george"), c1, "link", 2, 3, 15, 120);


        Run r1 = RecordService.addRunToCategory(c1, "", u3, "link1", 2, 58, 6, 129);
        CounterRecord r2 = RecordService.addCounterRecordToCategory(c2, "aaaa", u1, "link2", 17);
        Run r3 = RecordService.addRunToCategory(c1, "fsfs", u4, "jf", 3, 27, 40, 17);
        Run r4 = RecordService.addRunToCategory(c1, "bsxcd", u1, "jfsc", 3, 11, 5, 447);
        CounterRecord r5 = RecordService.addCounterRecordToCategory(c2, "aaaa", u2, "link2", 23);
        Run r6 = RecordService.addRunToCategory(c3, "bsxcd", u5, "yay", 0, 45, 34, 144);

        News n1 = NewsService.addNewsToGame(g2, u2, "Everest Core Update", "Everest had one of the biggest updates so far with Everest " +
                "Core becoming the \"Stable\" version. Here is what you need to know as a player and what rule changes are happening:");

//        c1.addRecord(r1);
//        c1.show();

        //CounterRecord r2 = new CounterRecord("run 2", UserService.findUserByUsername("george"), c2, "link2", 17);

//        c2.addRecord(r2);
//        c2.show();

        UserService.show();

        RecordService.showRecordsByUser(u2);

        RecordService.showRecordsByCategory(c1);
        RecordService.showRecordsByCategory(c2);

        GameService.showGameDetailed(g1);
        GameService.showGameDetailed(g2);

        // codul de mai jos da o exceptie IllegalArgumentException
        //CounterRecord r7 = RecordService.addCounterRecordToCategory(c1, "aaaa", u2, "link2", 23);
    }
}