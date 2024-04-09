package domain;

public class News {
    private final int newsId;
    private static int maxNewsId = 0;
    //doar un moderator poate fi autor
    private final User author;
    private String header;
    private String content;

    public News(User author, String header, String content) {
        this.newsId = maxNewsId;
        maxNewsId++;
        this.author = author;
        this.header = header;
        this.content = content;
    }

    public int getNewsId() {
        return newsId;
    }

    public static int getMaxNewsId() {
        return maxNewsId;
    }

    public User getAuthor() {
        return author;
    }

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void show(){
        System.out.println("News id: " + newsId);
        System.out.println("News author: " + author.getUsername());
        System.out.println("Header: " + header);
        System.out.println("Content: " + content);
    }
}
