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

    public void addRun(Run run){
        runRepository.addRun(run);
    }

    public List<Run> getRunsByCategory(int categoryId){
        return runRepository.getRunsByCategory(categoryId);
    }

    public List<Run> getRunsByUser(User user){
        return runRepository.getRunsByUser(user);
    }

    public Run getRunById(int id){
        return runRepository.getRunById(id);
    }

    public void updateLink(int id, String newLink){
        runRepository.updateLink(id, newLink);
    }

    public void removeRun(int id){
        runRepository.removeRun(id);
    }
}
