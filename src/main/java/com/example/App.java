package com.example;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;


/*********************************************************************
*
* Class Name: App
* Author/s name: Felipe Alcázar Gómez and Elena Megía Cañaveras.
* Class description: In this class we execute de program.
*
**********************************************************************
*/


public class App 
{

    /*********************************************************************
    *
    * Method name: main
    *
    * Description of the Method: In this method we take all the kg of the villages and created a list,
    * whit all the data we create the route.
    *
    * Required Files: Villages.txt, it's a file with all the villages and the kg of food.
     * @throws IOException
    *
    *********************************************************************/
    public static void main( String[] args ) throws IOException
    {
        System.out.println("Welcome to the program, you are going to help naja on her trip by obtaining the best route she must take.\n");
        Scanner reader = new Scanner(System.in);

        int Villages=0, maxVillages, peso;
        do{
            System.out.println("Introduce the total number of Villages:");
            Villages= reader.nextInt();  //Number of total Villages
        }while(Villages<=0);
        
        do{
            maxVillages=(int) (Math.random()*Villages); //Max villages to be visited in a day
        }while(maxVillages==0);
       
        do{
            System.out.println("Introduce the maximun weight for each village:");
            peso=reader.nextInt(); //Maximum value of kg a village may offer
        }while(peso<=0);

        reader.close();

        int pesoMax=(maxVillages*peso)/2; //Maximun kg the slege can withstand
       
        Array.deleteFile("Villages.txt");

        Array.generateFile(Villages, peso,"Villages.txt"); //Method for generate a file with the data before
        
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

        int i=0;
        while(visitedVillages<maxVillages && currentWeight<pesoMax && i<Villages){
            if(currentWeight+villages.get(i).getWeight()<=pesoMax && villages.get(i).getWeight()!=0){
                System.out.println(villages.get(i).toString());
                visitedVillages++;
                currentWeight=currentWeight+villages.get(i).getWeight();
            }
            i++;
        }
        System.out.println("Result: "+visitedVillages+" village/s visited and "+currentWeight+"kg of weight collected");

    }

    /*********************************************************************
    *
    * Method name: getVillage
    *
    * Description of the Method: This method creates the List of the villages.
    *
    * Calling arguments: A list of the calling arguments, their types, and
    * brief explanations of what they do.
    *
    * Return value: List, villages.
    *
    *********************************************************************/

    public static List<Village> getVillages(List<Integer> array){
        List<Village> villages = new ArrayList<>(array.size());
        for(int i=0;i<array.size();i++){
            villages.add(new Village(i, array.get(i)));
        }
        return villages;
    }

   
}
