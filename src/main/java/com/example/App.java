package com.example;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        int[] pobladosEjemplo={5, 0, 24, 8, 8, 3, 4, 9, 6, 20, 14, 23, 13, 8, 2, 19, 0, 13, 2, 11, 22, 6, 14, 7, 15, 21, 12, 13, 11, 19};
        int maxPobladosEjemplo=7;
        int pesoMaxEjemplo=98;

        int [] pobladosEjemploOrdenado=Array.toDecreasingOrder(pobladosEjemplo);
        Array.display(pobladosEjemploOrdenado);
        System.out.println();

        int totalWeight=0;
        int i=0;
        int pobladosObtenidos=0;
        while(totalWeight<pesoMaxEjemplo && pobladosObtenidos<maxPobladosEjemplo){
            if((totalWeight+pobladosEjemploOrdenado[i])<=pesoMaxEjemplo){
                totalWeight=totalWeight+pobladosEjemploOrdenado[i];
                pobladosObtenidos++;
            }
            i++;
        }
        System.out.println(totalWeight);
    }
}
