package com.sjani.java.DynamicProgramming;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

class job implements Comparator<job>{
    String id;
    int deadline;
    int profit;

    public job(){};

    public job(String id, int deadline, int profit) {
        this.id = id;
        this.deadline = deadline;
        this.profit = profit;
    }


    @Override
    public int compare(job j1, job j2) {
        return j1.profit > j2.profit? -1: 1;
    }
}

public class JobScheduling {

    public void printSchedule(ArrayList<job> arr, int maxDeadline){

        Collections.sort(arr, new job());

        int n = arr.size();
        boolean slot[] = new boolean[n];

        for (int i=0; i<n; i++) {
            slot[i] = false;
        }

        for (job j: arr) {
            for (int i = Math.min(n, j.deadline)-1; i >=0; i--) {
                if (slot[i] == false) {
                    System.out.print(j.id + ", ");
                    slot[i] = true;
                    break;
                }
            }
        }
    }


    public static void main(String[] args) {
        ArrayList<job> arr = new ArrayList<job>();
        arr.add(new job("a",2,100));
        arr.add(new job("b",1,19));
        arr.add(new job("c",2,27));
        arr.add(new job("d",1,25));
        arr.add(new job("e",3,15));
        JobScheduling js =  new JobScheduling();
        js.printSchedule(arr,3);
    }
}
