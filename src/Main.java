import models.*;
import services.GameService;
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
        UserService.addUser("george", t2, "email@test.com", "male");
        UserService.addUser("ioana", t3, "email2@test.com", "female");

/*        Game g1 = new Game("Minecraft", UserService.findUserByUsername("george"));
        Game g2 = new Game("Celeste", UserService.findUserByUsername("ioana"));*/
        GameService.addGame("Minecraft", "", UserService.findUserByUsername("george"));
        GameService.addGame("Celeste", "desc1", UserService.findUserByUsername("ioana"));
        Game g1 = GameService.findGameByName("Minecraft");
        Game g2 = GameService.findGameByName("Celeste");

        g1.addGameModerator(UserService.findUserByUsername("ioana"));

        //g1.addCategory("Any%", "", CategoryType.RUN, false);
        Category c1 = new Category("Any%", "", g1, CategoryType.RUN, "", false);
        g1.addCategory(c1);
/*        g1.show();
        g1.showGameModerators();
        g1.showCategories();
        System.out.println();*/

        //g2.addCategory("Most berries", "", CategoryType.COUNTER, "berries", true);
        Category c2 = new Category("Most berries", "", g2, CategoryType.COUNTER, "berries", true);
        g2.addCategory(c2);
/*        g2.show();
        g2.showGameModerators();
        g2.showCategories();
        System.out.println();*/

        Run r1 = new Run("run 1", UserService.findUserByUsername("george"), c1, "link", 2, 3, 15, 120);
        c1.addRecord(r1);
        c1.show();

        CounterRecord r2 = new CounterRecord("run 2", UserService.findUserByUsername("ioana"), c2, "link2", 17);
        c2.addRecord(r2);
        c2.show();

        UserService.show();
    }
}