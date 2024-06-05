package repositories;

import models.Category;
import models.Run;
import models.User;

import java.util.List;

public interface IRunRepository {
    //create
    void addRun(Run run);

    //read
    List<Run> getRunsByCategory(Category category);
    List<Run> getRunsByUser(User user);
    Run getRunById(int id);

    //update
    void updateLink(int id, String newLink);

    //delete
    void removeRun(int id);
}
