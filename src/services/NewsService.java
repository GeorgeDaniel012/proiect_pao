package services;

import models.Game;
import models.News;
import models.User;

import java.util.ArrayList;

public class NewsService {
    private static ArrayList<News> newsList = new ArrayList<>();

    private NewsService(){}

    public static News addNewsToGame(Game game, User author, String header, String content){
        News n = new News(author, header, content);

        game.addNews(n);
        newsList.add(n);
        return n;
    }

    public static ArrayList<News> getNewsFromGame(Game game){
        return game.getNewsList();
    }

    public static void showNewsFromGame(Game game){
        for(News news: game.getNewsList()){
            System.out.println(news.toString());
        }
    }
}
