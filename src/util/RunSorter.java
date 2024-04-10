package util;

import models.Run;

import java.util.Comparator;

public class RunSorter implements Comparator<Run> {
    public int compare(Run r1, Run r2){
        return r1.getTimer().toString().compareTo(r2.getTimer().toString());
    }
}
