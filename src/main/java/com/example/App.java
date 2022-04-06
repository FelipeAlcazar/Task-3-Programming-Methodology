package com.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class App 
{
    public static void main( String[] args )
    {
        int maxVillages=7;
        int pesoMax=98;
        List<Integer> pobladosEjemplo=Array.fileArray("Villages.txt");
        List<Village> villages=getVillages(pobladosEjemplo);
        System.out.println("Total villages: "+villages.size()+"\n"+"Total villages to be visited in a day: "+maxVillages+"\n"+"Maximum weight of the sledge: "+pesoMax);
        System.out.println("---------------------------------\nWeight of Villages:");
        Village.display(villages);
        System.out.println("---------------------------------");
        Collections.sort(villages, Collections.reverseOrder());

        int visitedVillages=0;
        int currentWeight=0;
        System.out.println("Route to follow: ");
        for (int i=0;i<villages.size() && visitedVillages<=maxVillages;i++) {
            if(currentWeight+villages.get(i).getWeight()<=pesoMax && villages.get(i).getWeight()!=0){
                System.out.println(villages.get(i).toString());
                visitedVillages++;
                currentWeight=currentWeight+villages.get(i).getWeight();
            }
        }
        System.out.println("Result: "+visitedVillages+" villages visited and "+currentWeight+"kg of weight collected");

    }

    public static List<Village> getVillages(List<Integer> array){
        List<Village> villages = new ArrayList<>(array.size());
        for(int i=0;i<array.size();i++){
            villages.add(new Village(i, array.get(i)));
        }
        return villages;
    }
}
