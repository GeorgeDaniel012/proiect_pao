package services;

import models.*;
import models.Record;

import java.util.ArrayList;

public class RecordService {
    private static ArrayList<Record> records = new ArrayList<>();

    private RecordService(){}

    public static void addRunToCategory(Category cat, String recordDescription, User user, String recordLink, int hours, int minutes, int seconds, int milliseconds){
        if (cat == null){
            // categoria este nula, da eroare
            throw new NullPointerException();
        }
        if(!cat.getType().equals(CategoryType.RUN)) {
            // categoria nu este de tipul potrivit, da eroare
            throw new IllegalArgumentException();
        }

        Run r = new Run(recordDescription, user, cat, recordLink, hours, minutes, seconds, milliseconds);
        cat.addRecord(r);
    }

    public static void addCounterRecordToCategory(Category cat, String recordDescription, User user, String recordLink, int counter){
        if (cat == null){
            // categoria este nula, da eroare
            throw new NullPointerException();
        }
        if(!cat.getType().equals(CategoryType.COUNTER)) {
            // categoria nu este de tipul potrivit, da eroare
            throw new IllegalArgumentException();
        }

        CounterRecord r = new CounterRecord(recordDescription, user, cat, recordLink, counter);
        cat.addRecord(r);
    }
}
