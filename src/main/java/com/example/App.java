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
        Scanner reader = new Scanner(System.in);
        System.out.println("Introduce the number of Villages");
        int Villages= reader.nextInt();  //Number of total Villages
        
        //int Villages=90;
        int maxVillages=(int) (Math.random()*Villages); //Max villages for visit in a day
       
        //int maxVillages=7;
        System.out.println("Introduce the maximun weight for village");
        int peso= reader.nextInt(); //Maximum value of kg for village
        reader.close();
        //int pesoMax=98;
        int pesoMax=(maxVillages*peso)/2; //Maximun kg for sledges
       
        Array.deleteFile("Villages.txt");

       // int[] randomarray=Array.randomArray(Villages,peso);
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
        while(visitedVillages<=maxVillages && currentWeight<pesoMax){
            if(currentWeight+villages.get(i).getWeight()<=pesoMax && villages.get(i).getWeight()!=0){
                System.out.println(villages.get(i).toString());
                visitedVillages++;
                currentWeight=currentWeight+villages.get(i).getWeight();
            }
            i++;
        }
        System.out.println("Result: "+visitedVillages+" villages visited and "+currentWeight+"kg of weight collected");

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
