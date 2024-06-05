//import services.RecordService;


import models.*;
import services.*;

import java.util.Scanner;

public class Main {
    private static final CountryService countryService = CountryService.getInstance();
    private static final UserService userService = UserService.getInstance();
    private static final GameService gameService = GameService.getInstance();
    private static final RunService runService = RunService.getInstance();
    private static final AuditService auditService = AuditService.getInstance();

//    public static void main(String[] args) {
//        Country t1 = new Country("Jamaica");
//        Country t2 = new Country("Romania");
//        Country t3 = new Country("United States");
//        Country t4 = new Country("Bulgaria");
//
///*        User u1 = new User("george", t2, "email@test.com", "male");
//        User u2 = new User("maria", t3, "email2@test.com", "female");
//        UserService.addUser(u1);
//        UserService.addUser(u2);*/
//        User u1 = UserService.addUser("george", t2, "email@test.com", "male");
//        User u2 = UserService.addUser("maria", t3, "email2@test.com", "female");
//
//        User u3 = UserService.addUser("Pape", t4, "pape@gmail.com", "male");
//        User u4 = UserService.addUser("Explore", t1, "explore@yahoo.com", "female");
//        User u5 = UserService.addUser("koralreef", t3, "koralreef@outlook.com", "male");
//
///*        Game g1 = new Game("Minecraft", UserService.findUserByUsername("george"));
//        Game g2 = new Game("Celeste", UserService.findUserByUsername("maria"));*/
//        GameService.addGame("Grand Theft Auto: San Andreas", "", u1);
//        GameService.addGame("Celeste", "desc1", u2);
//        Game g1 = GameService.findGameByName("Grand Theft Auto: San Andreas");
//        Game g2 = GameService.findGameByName("Celeste");
//
//        //g1.addGameModerator(UserService.findUserByUsername("maria"));
//        GameService.addModeratorToGame(g1, UserService.findUserByUsername("maria"));
//
//        //g1.addCategory("Any%", "", CategoryType.RUN, false);
//        //Category c1 = new Category("Any%", "", g1, CategoryType.RUN, "", false);
//        //g1.addCategory(c1);
//
///*        g1.show();
//        g1.showGameModerators();
//        g1.showCategories();
//        System.out.println();*/
//
//        //g2.addCategory("Most berries", "", CategoryType.COUNTER, "berries", true);
//        //Category c2 = new Category("Most berries", "", g2, CategoryType.COUNTER, "berries", true);
//        //g2.addCategory(c2);
//
///*        g2.show();
//        g2.showGameModerators();
//        g2.showCategories();
//        System.out.println();*/
//
//        Category c1 = GameService.addRunCategory(g1, "Any%", "Beat the game as fast as possible!", false);
//        Category c2 = GameService.addCounterRecordCategory(g2,"Least deaths","Beat the game while having as few deaths as possible.",
//                "deaths", true);
//        Category c3 = GameService.addRunCategory(g2, "All Red Berries", "Complete the game with all red berries.", false);
//
//        //Run r1 = new Run("run 1", UserService.findUserByUsername("george"), c1, "link", 2, 3, 15, 120);
//
//
//        Run r1 = RecordService.addRunToCategory(c1, "", u3, "link1", 2, 58, 6, 129);
//        CounterRecord r2 = RecordService.addCounterRecordToCategory(c2, "aaaa", u1, "link2", 17);
//        Run r3 = RecordService.addRunToCategory(c1, "fsfs", u4, "jf", 3, 27, 40, 17);
//        Run r4 = RecordService.addRunToCategory(c1, "bsxcd", u1, "jfsc", 3, 11, 5, 447);
//        CounterRecord r5 = RecordService.addCounterRecordToCategory(c2, "aaaa", u2, "link2", 23);
//        Run r6 = RecordService.addRunToCategory(c3, "bsxcd", u5, "yay", 0, 45, 34, 144);
//
//        News n1 = NewsService.addNewsToGame(g2, u2, "Everest Core Update", "Everest had one of the biggest updates so far with Everest " +
//                "Core becoming the \"Stable\" version. Here is what you need to know as a player and what rule changes are happening:");
//
////        c1.addRecord(r1);
////        c1.show();
//
//        //CounterRecord r2 = new CounterRecord("run 2", UserService.findUserByUsername("george"), c2, "link2", 17);
//
////        c2.addRecord(r2);
////        c2.show();
//
//        UserService.show();
//
//        RecordService.showRecordsByUser(u2);
//
//        RecordService.showRecordsByCategory(c1);
//        RecordService.showRecordsByCategory(c2);
//
//        GameService.showGameDetailed(g1);
//        GameService.showGameDetailed(g2);
//
//        // codul de mai jos da o exceptie IllegalArgumentException
//        // deoarece incercam sa adaugam un counter record la o categorie de run-uri
//        //CounterRecord r7 = RecordService.addCounterRecordToCategory(c1, "aaaa", u2, "link2", 23);
//    }

    public static void main(String[] args) {
        System.out.println("Welcome to the Speedrunning Database App!");
        while(true){
            System.out.println("What would you like to do?");
            System.out.println("c - view or modify countries");
            System.out.println("u - view or modify users");
            System.out.println("g - view or modify games");
            System.out.println("r - view or modify runs");
            System.out.println("q - quit");

            Scanner scanner = new Scanner(System.in);
            String option = scanner.nextLine();

            switch(option){
                case "q":
                    System.exit(0);
                    break;
                case "c":
                    countryEdit();
                    break;
                case "u":
                    userEdit();
                    break;
                case "g":
                    gameEdit();
                    break;
                case "r":
                    runEdit();
                    break;
                default:
                    System.out.println("Invalid command.");
                    break;
            }
        }
    }

    private static void countryEdit() {
        System.out.println("What would you like to do with the countries?");
        System.out.println("a - add new country");
        System.out.println("cn - get country by name");
        System.out.println("ci - get country by id");
        System.out.println("ca - get all countries");
        System.out.println("u - update a country's name");
        System.out.println("r - remove a country");
        System.out.println("q - exit country menu");

        Scanner scanner = new Scanner(System.in);
        String option = scanner.nextLine();

        String name;
        int id;

        switch(option){
            case "q":
                break;
            case "a":
                auditService.log("addCountry");
                System.out.println("Country name:");
                name = scanner.nextLine();
                countryService.addCountry(new Country(name));
                break;
            case "cn":
                auditService.log("searchCountryByName");
                System.out.println("Country name:");
                name = scanner.nextLine();
                System.out.println(countryService.getCountryByName(name));
                break;
            case "ci":
                auditService.log("searchCountryById");
                System.out.println("Country id:");
                id = scanner.nextInt();
                scanner.nextLine();
                System.out.println(countryService.getCountryById(id));
                break;
            case "ca":
                auditService.log("showAllCountries");
                System.out.println(countryService.getAllCountries());
                break;
            case "u":
                auditService.log("updateCountryName");
                System.out.println("Country id:");
                id = scanner.nextInt();
                scanner.nextLine();
                System.out.println("New country name:");
                name = scanner.nextLine();
                countryService.updateCountryName(id, name);
                break;
            case "r":
                auditService.log("removeCountry");
                System.out.println("Country id:");
                id = scanner.nextInt();
                scanner.nextLine();
                countryService.removeCountry(id);
                break;
            default:
                System.out.println("Invalid command.");
                break;
        }
    }

    private static void userEdit() {
        System.out.println("What would you like to do with the users?");
        System.out.println("a - add new user");
        System.out.println("un - get user by name");
        System.out.println("ui - get user by id");
        System.out.println("ua - get all users");
        System.out.println("u - update an user's name");
        System.out.println("r - remove an user");
        System.out.println("q - exit user menu");

        Scanner scanner = new Scanner(System.in);
        String option = scanner.nextLine();

        String name, email, gender;
        int id;

        switch(option){
            case "q":
                break;
            case "a":
                auditService.log("addUser");
                System.out.println("Username:");
                name = scanner.nextLine();
                System.out.println("Country id:");
                id = scanner.nextInt();
                scanner.nextLine();
                System.out.println("Email:");
                email = scanner.nextLine();
                System.out.println("Gender:");
                gender = scanner.nextLine();
                userService.addUser(new User(name, countryService.getCountryById(id),
                        email, gender));
                break;
            case "un":
                auditService.log("searchUserByName");
                System.out.println("Username:");
                name = scanner.nextLine();
                System.out.println(userService.getUserByName(name));
                break;
            case "ui":
                auditService.log("searchUserById");
                System.out.println("User id:");
                id = scanner.nextInt();
                scanner.nextLine();
                System.out.println(userService.getUserById(id));
                break;
            case "ua":
                auditService.log("showAllUsers");
                System.out.println(userService.getAllUsers());
                break;
            case "u":
                auditService.log("updateUsername");
                System.out.println("User id:");
                id = scanner.nextInt();
                scanner.nextLine();
                System.out.println("New username:");
                name = scanner.nextLine();
                userService.updateUsername(id, name);
                break;
            case "r":
                auditService.log("removeUser");
                System.out.println("User id:");
                id = scanner.nextInt();
                scanner.nextLine();
                userService.removeUser(id);
                break;
            default:
                System.out.println("Invalid command.");
                break;
        }
    }

    private static void gameEdit() {
        System.out.println("What would you like to do with the games?");
        System.out.println("ag - add new game");
        System.out.println("gn - get game by name");
        System.out.println("gi - get game by id");
        System.out.println("ga - get all games");
        System.out.println("u - update a game's name");
        System.out.println("c - get a game's categories");
        System.out.println("ac - add new category to game");
        System.out.println("r - remove a game");
        System.out.println("q - exit game menu");

        Scanner scanner = new Scanner(System.in);
        String option = scanner.nextLine();

        String name, description;
        int id;

        switch(option){
            case "q":
                break;
            case "ag":
                auditService.log("addGame");
                System.out.println("Game name:");
                name = scanner.nextLine();
                System.out.println("Description:");
                description = scanner.nextLine();
                System.out.println("Id of first moderator:");
                id = scanner.nextInt();
                scanner.nextLine();
                gameService.addGame(new Game(name, description,
                        userService.getUserById(id)));
                break;
            case "gn":
                auditService.log("searchGameByName");
                System.out.println("Game name:");
                name = scanner.nextLine();
                System.out.println(gameService.getGameByName(name));
                break;
            case "gi":
                auditService.log("searchGameById");
                System.out.println("Game id:");
                id = scanner.nextInt();
                scanner.nextLine();
                System.out.println(gameService.getGameById(id));
                break;
            case "ga":
                auditService.log("showAllGames");
                System.out.println(gameService.getAllGames());
                break;
            case "u":
                auditService.log("updateGameName");
                System.out.println("Game id:");
                id = scanner.nextInt();
                scanner.nextLine();
                System.out.println("New game name:");
                name = scanner.nextLine();
                gameService.updateGameName(id, name);
                break;
            case "r":
                auditService.log("removeGame");
                System.out.println("Game id:");
                id = scanner.nextInt();
                scanner.nextLine();
                gameService.removeGame(id);
                break;
            case "c":
                auditService.log("getGameCategories");
                System.out.println("Game id:");
                id = scanner.nextInt();
                scanner.nextLine();
                System.out.println(
                        gameService.getCategoriesByGame(gameService.getGameById(id)));
            case "ac":
                auditService.log("createCategory");
                System.out.println("Game id:");
                id = scanner.nextInt();
                scanner.nextLine();
                System.out.println("Category name:");
                name = scanner.nextLine();
                System.out.println("Description:");
                description = scanner.nextLine();
                gameService.createCategory(new Category(
                        name, description, gameService.getGameById(id),
                        CategoryType.RUN, false
                ));
                break;
            default:
                System.out.println("Invalid command.");
                break;
        }
    }

    private static void runEdit() {
        System.out.println("What would you like to do with the runs?");
        System.out.println("a - add new run");
        System.out.println("ru - get runs by user");
        System.out.println("rc - get runs from category");
        System.out.println("ri - get run by id");
        System.out.println("u - update a run's link");
        System.out.println("r - remove a run");
        System.out.println("q - exit run menu");

        Scanner scanner = new Scanner(System.in);
        String option = scanner.nextLine();

        String link, description;
        int uid, cid, rid, h, m, s, ms;

        switch(option){
            case "q":
                break;
            case "a":
                auditService.log("addRun");
                System.out.println("User id:");
                uid = scanner.nextInt();
                scanner.nextLine();
                System.out.println("Category id:");
                cid = scanner.nextInt();
                scanner.nextLine();
                System.out.println("Description:");
                description = scanner.nextLine();
                System.out.println("Link:");
                link = scanner.nextLine();
                System.out.println("Hours, minutes, seconds, milliseconds");
                h = scanner.nextInt();
                m = scanner.nextInt();
                s = scanner.nextInt();
                ms = scanner.nextInt();
                scanner.nextLine();
                runService.addRun(new Run(description, uid, cid, link,
                        h, m, s, ms));
                break;
            case "ru":
                auditService.log("searchRunsByUser");
                System.out.println("User id:");
                uid = scanner.nextInt();
                scanner.nextLine();
                System.out.println(runService.getRunById(uid));
                break;
            case "rc":
                auditService.log("searchRunsFromCategory");
                System.out.println("Category id:");
                cid = scanner.nextInt();
                scanner.nextLine();
                System.out.println(runService.getRunsByCategory(cid));
                break;
            case "ri":
                auditService.log("searchRunById");
                System.out.println("Run id:");
                rid = scanner.nextInt();
                scanner.nextLine();
                System.out.println(runService.getRunById(rid));
                break;
            case "u":
                auditService.log("updateRunLink");
                System.out.println("Run id:");
                rid = scanner.nextInt();
                scanner.nextLine();
                System.out.println("New link:");
                link = scanner.nextLine();
                runService.updateLink(rid, link);
                break;
            case "r":
                auditService.log("removeRun");
                System.out.println("Run id:");
                rid = scanner.nextInt();
                scanner.nextLine();
                runService.removeRun(rid);
                break;
            default:
                System.out.println("Invalid command.");
                break;
        }
    }
}