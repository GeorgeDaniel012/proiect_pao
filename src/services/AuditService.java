package services;

import repositories.GameRepository;

import java.io.FileWriter;
import java.time.LocalDateTime;

public class AuditService {
    private static final String filename = "audit.csv";
    private static AuditService auditService;

    private AuditService() {};

    public static AuditService getInstance(){
        if(auditService == null){
            auditService = new AuditService();
        }
        return auditService;
    }

    public void log(String action) {
        try {
            FileWriter writer = new FileWriter(filename, true);
            String text = action + "," + LocalDateTime.now() + "\n";
            writer.append(text);
            writer.close();
        } catch (Exception e) {
            System.out.println("Error while writing to file");
        }
    }
}