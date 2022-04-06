package com.example;

import java.util.List;

public class Village implements Comparable<Village> {
    private int id;
    private int weight;
    
    public Village(int id, int weight) {
        this.id = id;
        this.weight = weight;
    }

    public static void display(List<Village> villages){
        for (Village village : villages) {
            System.out.print(village.getWeight()+" ");
        }
        System.out.println();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Village " + id + ", " + weight+"kg collected";
    }

    @Override
    public int compareTo(Village village) {
        return Integer.compare(this.weight,village.getWeight());
    }
}
