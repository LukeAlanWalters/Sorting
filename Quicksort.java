import java.util.Arrays;
import java.util.Comparator;

/**
 * Sort using Quicksort.
 *
 * @author Luke Walters
 * Worked with Kevin Johanson on this file
 */

public class Quicksort implements Sorter {

  // +--------+------------------------------------------------------
  // | Fields |
  // +--------+

  /**
   * The one sorter you can access.
   */
  public static Sorter SORTER = new Quicksort();

  // +--------------+------------------------------------------------
  // | Constructors |
  // +--------------+

  /**
   * Create a sorter.
   */
  Quicksort() {
  } // Quicksort()

  // +---------+-----------------------------------------------------
  // | Methods |
  // +---------+

  /**
   * @param values - A generic array to be sorted
   * @param order - The comparator which sorts the list
   */
  @Override
  public <T> void sort(T[] values, Comparator<? super T> order) {
    quickSort(values, 0, values.length, order);
  } // sort(T[], Comparator<? super T>


  /**
   * 
   * @param values - A generic array to be sorted
   * @param lb - lowerbound of the array to be sorted
   * @param ub - upperbound of the array to be sorted
   * @param order - Comparator used to sort the list
   */
  public static <T> void quickSort(T[] values,int lb, int ub, Comparator<? super T> order){
    if(lb >= ub-1){
      return;
    }//if
    else {
      int mid = partition(values,lb,ub,order);
      System.out.println(Arrays.toString(values));
      quickSort(values, lb, mid, order);
      quickSort(values, mid+1, ub, order);
    }//else
  }//quickSort



  
    /**
     * @param arr - A generic array to be partitioned
     * @param lb - lowerbound of the array to be partitioned
     * @param ub - upperbound of the array to be partitioned
     * @param order - Comparator used to sort the list
     * @return returns where the pivotValue ended at the end of the partition
     */
    private static <T> int partition(T[] arr, int lb, int ub, Comparator<? super T> order){
     int pivotIndex = (ub + lb)/2;
     swap(arr, lb, pivotIndex);


     int small = lb + 1;
     int large = ub;

     while (large != small){
      if(order.compare(arr[small], arr[lb]) > 0){
        swap(arr, small, large - 1);
        large--;
      }//if()
      else{
        small++;
      }//else
     }//while()

     swap(arr, lb, large - 1);

     return large - 1;
    }//partition

    /**
     * @param arr - The array which values will be swapped
     * @param i - First value to swap array location
     * @param j - second value to swap array location
     */
    public static <T> void swap (T[] arr, int i, int j){
      T tempVal = arr[i];
      arr[i] = arr[j];
      arr[j] = tempVal;
    }//swap
  

  
} // class Quicksort



