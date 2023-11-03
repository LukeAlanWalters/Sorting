import java.util.Comparator;
import java.util.Random;


/**
 * Sort using Bozo sort which is a random search method that only swaps two values at a time.
 *
 * @author Luke Walters
 */


public class BozoSort implements Sorter{

  // +--------+------------------------------------------------------
  // | Fields |
  // +--------+

  /**
   * The one sorter you can access.
   */
  public static Sorter SORTER = new BozoSort();

  // +--------------+------------------------------------------------
  // | Constructors |
  // +--------------+

  /**
   * Create a sorter.
   */
  BozoSort() {
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
    if(values.length == 0){
      return;
    }
    Random rand = new Random();
    T tempVal;
    int rand1;
    int rand2;
    int i = 1;

    while(i != values.length){
        if(order.compare(values[i-1], values[i]) <= 0){
            i++;
        }//if(two values are in sorted order)
        else{
            rand1 = rand.nextInt(values.length);
            rand2 = rand.nextInt(values.length);
            tempVal = values[rand1];
            values[rand1] = values[rand2];
            values[rand2] = tempVal;
            i = 1;
        }//else
    }//while

  }// sort(T[], Comparator<? super T>

}

