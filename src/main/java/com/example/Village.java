package com.example;

import java.util.List;

/*********************************************************************
*
* Class Name: Village
*
* Class description: In this class we create the object Village with two atributes
* id and weight.
*
**********************************************************************
*/

public class Village implements Comparable<Village> {
    private int id;
    private int weight;
    
    /*********************************************************************
    *
    * Method name: Village
    *
    * Description of the Method: An object call Village
    *
    * Calling arguments: int, id, the number of village
    *                    int, weight, the kg of food in each village
    *
    *********************************************************************/

    public Village(int id, int weight) {
        this.id = id;
        this.weight = weight;
    }

    /*********************************************************************
    *
    * Method name: display
    *
    * Description of the Method: Print the list of kg of each village.
    *
    * Calling arguments: List, villages.
    *
    *********************************************************************/

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
