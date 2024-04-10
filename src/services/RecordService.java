package services;

import models.*;
import models.Record;
import util.CounterRecordSorter;
import util.RunSorter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class RecordService {
    private static ArrayList<Record> records = new ArrayList<>();

    private RecordService(){}

    public static ArrayList<Record> getRecords() {
        return records;
    }

    public static Run addRunToCategory(Category cat, String recordDescription, User user, String recordLink, int hours, int minutes, int seconds, int milliseconds){
        if(cat == null){
            // categoria este nula, da eroare
            throw new NullPointerException();
        }
        if(!cat.getType().equals(CategoryType.RUN)) {
            // categoria nu este de tipul potrivit, da eroare
            throw new IllegalArgumentException("Not a Run category!");
        }

        Run r = new Run(recordDescription, user, cat, recordLink, hours, minutes, seconds, milliseconds);
        cat.addRecord(r);
        records.add(r);
        return r;
    }

    public static CounterRecord addCounterRecordToCategory(Category cat, String recordDescription, User user, String recordLink, int counter){
        if(cat == null){
            // categoria este nula, da eroare
            throw new NullPointerException();
        }
        if(!cat.getType().equals(CategoryType.COUNTER)) {
            // categoria nu este de tipul potrivit, da eroare
            throw new IllegalArgumentException("Not a Counter category!");
        }

        CounterRecord r = new CounterRecord(recordDescription, user, cat, recordLink, counter);
        cat.addRecord(r);
        records.add(r);
        return r;
    }

    public static void showRecordsByUser(User user){
        if(user == null){
            throw new NullPointerException();
        }

        System.out.println("Showing records for user " + user.getUsername());

        ArrayList<Record> results = new ArrayList<>();

        for(Record record: records){
            if(record.getUser().equals(user)){
                results.add(record);
            }
        }

        for(Record result: results){
            System.out.println(result);
            System.out.println();
        }
    }

    public static void showRecordsByCategory(Category cat){
        if(cat == null){
            throw new NullPointerException();
        }

        //ArrayList<Record> results = new ArrayList<>();

        System.out.println("Showing records for category " + cat.getCategoryName() + " of game " + cat.getGame().getGameName());

        if(cat.getType() == CategoryType.RUN){
            ArrayList<Run> results = new ArrayList<>();

            for(Record record: records){
                if(record.getCategory().equals(cat)){
                    results.add((Run) record);
                }
            }

            results.sort(new RunSorter());

            if(cat.isDesc()){
                Collections.reverse(results);
            }

            for(Record result: results){
                System.out.println(result);
                System.out.println();
            }
        }

/*        for(Record record: records){
            if(record.getCategory().equals(cat)){
                results.add(record);
            }
        }*/

        if(cat.getType() == CategoryType.COUNTER){
            ArrayList<CounterRecord> results = new ArrayList<>();

            for(Record record: records){
                if(record.getCategory().equals(cat)){
                    results.add((CounterRecord) record);
                }
            }

            results.sort(new CounterRecordSorter());

            if(cat.isDesc()){
                Collections.reverse(results);
            }

            for(Record result: results){
                System.out.println(result);
                System.out.println();
            }
        }
    }
}
