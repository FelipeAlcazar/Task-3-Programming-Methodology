package com.example;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


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
}
