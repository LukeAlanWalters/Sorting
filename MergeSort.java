import java.util.Comparator;
import java.util.List;
import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * Sort using merge sort.
 *
 * @author Luke Walters
 * Worked with Kevin J and Maria Rodriguez
 */

public class MergeSort implements Sorter {

  // +--------+------------------------------------------------------
  // | Fields |
  // +--------+

  /**
   * The one sorter you can access.
   */
  public static Sorter SORTER = new MergeSort();




  // +--------------+------------------------------------------------
  // | Constructors |
  // +--------------+

  /**
   * Create a sorter.
   */
  MergeSort() {
  } // MergeSort()

  // +---------+-----------------------------------------------------
  // | Methods |
  // +---------+



  @Override
  /**
   * @param values - A generic array to be sorted
   * @param order - The comparator which sorts the list
   */
  public <T> void sort(T[] values, Comparator<? super T> order) {
    if (values == null || values.length <= 1) {
      return;
    } 
    else{
      //calls mergesort on the array
      MergeSort(values, order, 0, values.length);
      //merges all the split (sorted) arrays
      merge(values, 0, values.length/2, values.length, order);
    }//else
  } // sort(T[], Comparator<? super T>


  /**
   * @param values - a generic array to be sorted
   * @param order - comparator to order things in
   * @param lb - lower-bound of values
   * @param ub - upperbound of values
   */
  public static <T> void MergeSort(T[] values, Comparator<? super T> order, int lb, int ub){
    if(lb >= ub-1){
      return;
    } else{

      //these get reset during every recursive call to mergesort
      int lo = lb;
      int hi = ub-1;
      int mid = lo + (ub - lo)/2;

      //sorts the left half of the split array
      while(lo < mid){
        if(order.compare(values[lo], values[lo+1]) > 0){
          swap(values, lo, lo+1);
        }
        lo++;
      }//while

      //sorts the right half of the split array
      while(mid < hi){
        if(order.compare(values[mid], values[mid+1]) > 0){
          swap(values, mid, mid+1);
        }
        mid++;
      }//while

      //recursively calls mergeSort
      MergeSort(values, order, lb, mid);
      MergeSort(values, order, mid+1, ub);
    }//else  
  }//MergeSort



  /**
    * @param arr - The array which values will be swapped
    * @param i - First value to swap array location
    * @param j - second value to swap array location
    */
  public static <T> void swap (T[] arr, int i, int j){
    T tempVal = arr[i];
    arr[i] = arr[j];
    arr[j] = tempVal;
  }//swap()



  /**
   * Merge the values from positions [lo..mid) and [mid..hi) back into the original array
   *
   * Preconditions: Each subarray is sorted accorting to comparator.
   */
  static <T> void merge(T[] vals, int lo, int mid, int hi, Comparator<? super T> comparator) {
    T[] merged = java.util.Arrays.copyOfRange(vals, lo, hi);
    //int left = hi -1;
    int right = mid+1;
    int current = lo;

    //performs the while loop until either the left subarray or right subarray is completely sorted
    while((lo <= lo + (mid - lo)) && (right <= hi-1)){
      //if the left array has a smaller val
      if(comparator.compare(vals[lo], vals[right]) <= 0){
        merged[current++] = vals[lo++];
      }//if
      //if the right array has a smaller val
      else {
        merged[current++] = vals[right++];
      }//else
    }//while

    //move over left
    //might not be mid+1
    while(lo < mid+1){
      merged[current++] = vals[lo++];
    }//while

    //move over right
    //might be hi+1
    while(right < hi){
      merged[current++] = vals[right++];
    }//while

    for(int i = 0; i< vals.length; i++){
      vals[i] = merged[i];
    }//for
  } // merge


} // class MergeSort
