package com.example;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;


/*********************************************************************
*
* Class Name: Array
* Class description: In this class read the file.
*
**********************************************************************
*/

public class Array {

    /*********************************************************************
    *
    * Method name: fileArray
    *
    * Description of the Method: This method read a file and convert the values to a list .
    *
    * Calling arguments: String fileName, It's the file that we are going to read.
    *
    * Return value: list of integer
    *
    * Required Files: We need the file the program is goint to read.
    *
    * IOException: When there is an error in input or output.
    *
    *********************************************************************/
    
    public static List<Integer> fileArray(String fileName){
        Path filePath = Paths.get(fileName);
        Scanner scanner;
        List<Integer> integers = new ArrayList<>();

        try {
            scanner = new Scanner(filePath);
            
            while (scanner.hasNext()) {
                if (scanner.hasNextInt())
                    integers.add(scanner.nextInt()); 
                else
                    scanner.next();
            }
        } catch (IOException e) {
            System.out.println("File not Found. Check the fileName");
        }

        return integers;
    }
    
    /*********************************************************************
    *
    * Method name: randomArray
    *
    * Description of the Method: In this method we create an array with random numbers.
    *
    * Calling arguments: int size, it is the size of the array we are going to create
    * int ls, it is the maximum value that a number can take in the array.
    *
    * Return value: int[], vector, we return a one-dimensional array.
    *
    *********************************************************************/

     public static int[] randomArray(int size, int ls){
        int[] vector=new int[size];

        for(int i=0;i<vector.length;i++){
            vector[i]=(int) ((Math.random()*(ls-0))+0);
        }

        return vector;
    }

    /*********************************************************************
    *
    * Method name: generateFile
    *
    * Description of the Method: In this method we create a file with the values of the array
    *
    * Calling arguments: int, N, size of the array.
    *                    int, ls, it is the maximum value that a number can take in the array.
    *                    String, filename, the name of the file to be created.
    *
    * Checked Exceptions: 
    * Exception: if the file cannot be written the exception is thrown.
    *
    *********************************************************************/
    
    
    public static void generateFile(int N, int ls, String fileName){
    	try{
            BufferedWriter writer = new BufferedWriter(new FileWriter(new File(fileName),true));
            int [] vector=randomArray(N, ls);
            for(int i=0;i<vector.length;i++){
            	writer.write(Integer.toString(vector[i]));
            	writer.newLine();
            }
            writer.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }    
    
}
