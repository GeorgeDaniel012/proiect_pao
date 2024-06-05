package services;

import models.Category;
import models.Run;
import models.User;
import repositories.GameRepository;
import repositories.RunRepository;

import java.util.List;

public class RunService {
    private final RunRepository runRepository;
    private static RunService runService;

    private RunService() {
        this.runRepository = new RunRepository();
    }

    public static RunService getInstance(){
        if(runService == null){
            runService = new RunService();
        }
        return runService;
    }

    void addRun(Run run){
        runRepository.addRun(run);
    }

    List<Run> getRunsByCategory(Category category){
        return runRepository.getRunsByCategory(category);
    }

    List<Run> getRunsByUser(User user){
        return runRepository.getRunsByUser(user);
    }

    Run getRunById(int id){
        return runRepository.getRunById(id);
    }

    void updateLink(int id, String newLink){
        runRepository.updateLink(id, newLink);
    }

    void removeRun(int id){
        runRepository.removeRun(id);
    }
}
