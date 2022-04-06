package com.example;



public class App 
{
    public static void main( String[] args )
    {
       //int[] pobladosEjemplo={5, 0, 24, 8, 8, 3, 4, 9, 6, 20, 14, 23, 13, 8, 2, 19, 0, 13, 2, 11, 22, 6, 14, 7, 15, 21, 12, 13, 11, 19};
       //String filename= "Villages.txt"; 
       int[] pobladosEjemplo=Array.fileArray("Villages.txt");
       int maxPobladosEjemplo=7;
       int pesoMaxEjemplo=98;

        int [] pobladosEjemploOrdenado=Array.toDecreasingOrder(pobladosEjemplo);
        Array.display(pobladosEjemploOrdenado);
        
    }



}
