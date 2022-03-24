import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

/**
 * 
 * @author Laura Penza
 */

public class Main 
{
    public static void main(String[] args)
    {
           new Main();      
    }
    /*
        The code for creating and writing to a .csv file was given by 
        Prof. A. Hernandez
    */
    public Main()
    {  
                    
        String outputFilename = "output.csv";
        
        PrintWriter output = null;
        try
        {
            output = new PrintWriter(new FileWriter(outputFilename));  
        } catch (IOException ex)
        {
            System.exit(1);
        }
        
        Random rand = new Random();
        
        //Because i is incrementing by 100, n is declared at 600,000 to allow for 
        //6000 runs
        int n = 600000;                    
        for(int i = 100; i < n; i += 100)
        {
            int[] array = new int[i];
            SearchingAlgorithms.fillArray(array);
            int x = rand.nextInt();
            
            SearchingAlgorithms.quickSort(array);
            
            //Running time is being done in Nano time and is taken from
            //Prof. A. Hernandex PPT's on Sequential Searches
            long startTime1 = System.nanoTime();
            SearchingAlgorithms.binarySearch(array, x);
            long elapshedTime1 = System.nanoTime() - startTime1;  
            
            long startTime2 = System.nanoTime();
            SearchingAlgorithms.sequentialSearch(array, x);
            long elapshedTime2 = System.nanoTime() - startTime2;
            
            long startTime3 = System.nanoTime();
            SearchingAlgorithms.sortedSearch(array, x);
            long elapshedTime3 = System.nanoTime() - startTime3;

           //For formatting
            output.println(i + "," + elapshedTime1 + "," + elapshedTime2 + "," + elapshedTime3);
        }
        
        output.close();
    }
}
