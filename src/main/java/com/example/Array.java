package com.example;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.Vector;
import java.util.Arrays;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/*********************************************************************
*
* Class Name: Array
* Class description: 
**********************************************************************
*/

public class Array {
    static Map<Long, Object[]> data= new TreeMap<Long, Object[]>();
    static int excelrow=1;

    /*********************************************************************
    *
    * Method name: fileArray
    *
    * Description of the Method: This method read a file and convert the values to an rray .
    *
    * Calling arguments: String fileName, its the file that we are going to read.
    *
    * Return value: toIntArray(integers), we convert the integers into an array.
    *
    * Required Files: We need the file the program is goint to read.
    *
    * IOException: When there is an error in input or output.
    *
    *********************************************************************/
    
    public static int[] fileArray(String fileName){
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

        return toIntArray(integers);
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
    * Method name: toArrayList.
    *
    * Description of the Method: Convert one-dimensional array to a list.
    *
    * Calling arguments: int[], vector, we call a one-dimensional array.
    *
    * Return value: ArrayList list1, it's a list with the numbers of the array.
    *
    *********************************************************************/
    
    public static List<Integer> toArrayList(int[] vector){
        ArrayList<Integer> list1 = new ArrayList<Integer>();
        for(int i : vector) list1.add(i);  

        return list1;
    }
    
    /*********************************************************************
    *
    * Method name: toIntArray.
    *
    * Description of the Method: Convert a list to a one-dimensional array.
    *
    * Calling arguments: List<Integer> integers, we call a list.
    *
    * Return value: int[], ret, it's an array.
    *
    *********************************************************************/
    
    public static int[] toIntArray(List<Integer> integers)
    {
        int[] ret = new int[integers.size()];
        for (int i=0; i < ret.length; i++)
        {
            ret[i] = integers.get(i).intValue();
        }
        return ret;
    }

    /*********************************************************************
    *
    * Method name: copy.
    *
    * Description of the Method: Generate a copy of a one-dimensional array.
    *
    * Calling arguments: int[], vector, it's a one-dimensional array.
    *
    *********************************************************************/
    
    public static void copy(int[] vector){
    	int [] vector2=Arrays.copyOf(vector, vector.length);
    }

    /*********************************************************************
    *
    * Method name: equal.
    *
    * Description of the Method: Check if an array is equal to another.
    *
    * Calling arguments: int[], vector1, we call a one-dimensional array.
    *                    int[], vector2, we call a one-dimensional array.
    *
    * Return value: boolean equal, if it's true the vectors are equal and if it's false they aren't equal.
    *
    *********************************************************************/
    
    public static Boolean equal(int[] vector1, int[] vector2){
        boolean equal=true;
        if(vector1.length!=vector2.length) equal=false;

        for(int i=0;i<vector1.length-1;i++){
            if(vector1[i]!=vector2[i]){
                equal=false;
                break;
            }
        }

        return equal;
    }
    

    /*********************************************************************
    *
    * Method name: display.
    *
    * Description of the Method: Print the array.
    *
    * Calling arguments: int[], vector, it's a one-dimensional array.
    *
    *********************************************************************/
    
    public static void display(int[] vector1){
        for(int i=0;i<vector1.length;i++) System.out.print(vector1[i]+" ");
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

    /*********************************************************************
    *
    * Method name: toDecreasingOrder.
    *
    * Description of the Method: Sorts an array in descending order, for that it is passed to a list it is sorted
    * and passed back to an array.
    *
    * Calling arguments: int[], vector, it's a one-dimensional array.
    *
    * Return value: int[] Array.toIntArray.(list1), returns one-dimensional array sorted in decreasing order.
    *
    *********************************************************************/
    
    public static int[] toDecreasingOrder(int[] vector){
        ArrayList<Integer> list1 =new ArrayList<Integer>(Array.toArrayList(vector));
        Collections.sort(list1, Collections.reverseOrder());
        return Array.toIntArray(list1);
    }





}
