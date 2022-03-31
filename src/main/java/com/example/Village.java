package com.example;

public class Village {
    private int id;
    private int weight;
    
    public Village(int id, int weight) {
        this.id = id;
        this.weight = weight;
    }

    public int compareTo(Village village) {
        return village.getWeight()<=this.getWeight() ? this.id : village.id;
    }

    public Village[] getSledge(int[] array){
        Village[] villages=new Village[array.length];
        for (int i : array) {
            villages[i]=new Village(i, array[i]);
        }
        return villages;
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
        return "Village [id=" + id + ", weight=" + weight + "]";
    }
}
