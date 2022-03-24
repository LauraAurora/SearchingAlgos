import java.util.Random;

/**
 * 
 * @author Laura Penza
 */

public class SearchingAlgorithms 
{
    /**Searches for an element in a SORTED array
     * 
     * Credit from Prof. A. Hernandez. COP3530 - Search Techniques slide:5
     * 
     * @param list
     * @param x
     * @return true if element is found, false otherwise
     */
    public static boolean binarySearch(int[] list, int x)                            
    {        
        int first = 0;
        int last = list.length - 1;
        int pivot;
        
        boolean found = false;
        while( first <= last && !found)                                         
        {
            pivot = (first + last) / 2;
            if(list[pivot] == x)
                   found = true;
            else
                 if (x < list[pivot]) 
                     last = pivot - 1;
                 else
                     first = pivot + 1;
        }
        
        if(found)
              return true;
        else
              return false;
    }
    
    /** This algorithm searches an unstructured array for a specific element.
     * 
     * Credit from Prof. A. Hernandez. COP3530 - Search Techniques slide:3
     * 
     * @param list
     * @param x
     * @return true if element is found, false otherwise
     */
    public static boolean sequentialSearch(int[] list, int x)
    {
        boolean found = false;
        
        for(int i = 0; i < list.length; i++)
        {
            if(list[i] == x)
            {
                found = true;
            }
            else return false;
        }
        
        if(found)
        {
          return true;  
        }
        else
          return false;                                                       
    }
    
    /**Searches an array in non decreasing order
     * 
     * Credit from Prof. A. Hernandez. COP3530 - Search Techniques slide:4
     * 
     * @param list
     * @param x
     * @return true if element is found, false otherwise
     */
    public static boolean sortedSearch(int[] list, int x)                        
    {
        int i = 0; 
        while (i < list.length && list[i] < x)                                           
            i++;
        
        if(i < list.length && list[i] == x)
            return true;
        else
            return false;     
    }
    
    /**
     * Recursive quickSort algorithm from Prof. A. Hernandez 
     * 
     * @param list 
     */
    public static void quickSort(int[] list)
    {
        quicksort(list, 0, list.length - 1);
    }
    
    private static void quicksort(int[] list, int begin, int end)
    {
        int temp;
        int pivot = findPivotLocation(begin, end);
        
        temp = list[pivot];
        list[pivot] = list[end];
        list[end] = temp;
        
        pivot = end;
        
        int i = begin;
        int j = end - 1;
        
        boolean iterationCompleted = false;
        while(!iterationCompleted)
        {
            while(list[i] < list[pivot])
                i++;
            while((j >= 0) && (list[pivot] < list[j]))
                j--;
            
            if(i < j)
            {
                temp = list[i];
                list[i] = list[j];
                list[j] = temp;
                
                i++;
                j--;           
            }
            else
                  iterationCompleted = true;
        }
        
        temp = list[i];
        list[i] = list[pivot];
        list[pivot] = temp;
        
        if(begin < i -1) 
            quicksort(list, begin, i - 1);
        if(i + 1 < end)
            quicksort(list, i + 1, end);         
    }
    
    /*
     * Computes the pivot and was give from Prof. A. Hernandez
    */
    private static int findPivotLocation(int b, int e)
    {
        return (b + e) / 2;
    }
            
    /*
       Algorithm was constructed in class for Prog19_01
    */
    public static void fillArray(int[] list)
    {
        Random random = new Random();
        for(int i = 0; i < list.length; i++)
            list[i] = random.nextInt();                                         
    }
    
    /*
        Algorithm was constructed in class for Prog19_01
    */
    public static void printArray(int[] list)
    {
       for(int i = 0; i < list.length; i++)
            System.out.print(list[i] + " ");
       
        System.out.println();
    } 
}
