import java.util.Comparator;

/**
 * Sort using insertion sort.
 *
 * @author Luke Walters
 * Worked alongside Kevin Johanson for this file
 */

public class InsertionSort implements Sorter {

  // +--------+------------------------------------------------------
  // | Fields |
  // +--------+

  /**
   * The one sorter you can access.
   */
  public static Sorter SORTER = new InsertionSort();

  // +--------------+------------------------------------------------
  // | Constructors |
  // +--------------+

  /**
   * Create a sorter.
   */
  InsertionSort() {
  } // InsertionSort()

  // +---------+-----------------------------------------------------
  // | Methods |
  // +---------+

  /**
   * @param values - A generic array to be sorted
   * @param order - The comparator which sorts the list
   */
  @Override
  public <T> void sort(T[] values, Comparator<? super T> order) {
    //Index at which the sorted values are at
    int insertPoint = 0;
    int reverseIndex = 1;
    T temp = null;

    if(values.length == 0){
      return;
    }

    for(int i = 1; i < values.length; i++){
      
      for(int j = 0; j < i; j++){

        if(order.compare(values[i], values[j]) <= 0 && temp == null){ // compares the value to be insorted and the already sorted array
          temp = values[i];
          insertPoint = j;
        }

        if(temp != null){
          values[i - reverseIndex + 1] = values[i - reverseIndex];
          reverseIndex++;
        }
        

        if(j == i - 1 && temp != null){
          values[insertPoint] = temp;
        }

       
      }
      temp = null;
      reverseIndex = 1;
      insertPoint = 0;

    }
  } // sort(T[], Comparator<? super T>


} // class InsertionSort
