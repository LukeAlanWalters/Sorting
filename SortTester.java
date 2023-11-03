import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;
import java.math.BigInteger;
import org.junit.jupiter.api.Test;

/**
 * Tests of Sorter objects.
 *
 * @author Luke Walters
 */
public class SortTester {

  // +---------+-----------------------------------------------------
  // | Globals |
  // +---------+

  Sorter sorter;

  // +-------+-------------------------------------------------------
  // | Tests |
  // +-------+





  @Test
  public void fakeTest() {
    assertTrue(true);
  } // fakeTest()

  @Test
  public void orderedStringTest() {
    String[] original = { "alpha", "bravo", "charlie", "delta", "foxtrot" };
    String[] expected = original.clone();
    sorter.sort(original, (x, y) -> x.compareTo(y));
    assertArrayEquals(original, expected);
  } // orderedStringTest

  @Test
  public void reverseOrderedStringTest() {
    String[] original = { "foxtrot", "delta", "charlie", "bravo", "alpha" };
    String[] expected = { "alpha", "bravo", "charlie", "delta", "foxtrot" };
    sorter.sort(original, (x, y) -> x.compareTo(y));
    assertArrayEquals(original, expected);
  } // orderedStringTest

  @Test
  public void orderedNumberTest() {
    Integer[] original = {1,2,3,4,5,6,7,8,10,11,12,15,35};
    Integer[] expected = {1,2,3,4,5,6,7,8,10,11,12,15,35};
    sorter.sort(original, (x,y) -> (x == y ? 0 : x < y ? -1 : 1));
    assertArrayEquals(original, expected);
  } // orderedNumberTest

  @Test
  public void MixedNumberTest() {
    Integer[] original = {2, 3, 10, 11, 5, 6, 4, 1, 7, 8, 12, 15, 35};
    Integer[] expected = {1,2,3,4,5,6,7,8,10,11,12,15,35};
    sorter.sort(original, (x,y) -> (x == y ? 0 : x < y ? -1 : 1));
    assertArrayEquals(original, expected);
  } // orderedNumberTest

  @Test
  public void NumberRepeatingTest() {
    Integer[] original = {1,2,1,4,3,2,1,3,4,2,2,1,2,3,4,2,1,3};
    Integer[] expected = {1,1,1,1,1,2,2,2,2,2,2,3,3,3,3,4,4,4};
    sorter.sort(original, (x,y) -> (x == y ? 0 : x < y ? -1 : 1));
    assertArrayEquals(original, expected);
  } // orderedNumberRepeatingTest

  @Test
  public void emptyArray() {
    Integer[] original = {};
    Integer[] expected = {};
    sorter.sort(original, (x,y) -> (x == y ? 0 : x < y ? -1 : 1));
    assertArrayEquals(original, expected);
  } // emptyArray

  @Test
  public void repeatingStrings(){
    String[] original = {"ai", "by", "cou", "by", "cou", "ai", "ai"};
    String[] expected = {"ai", "ai", "ai", "by", "by", "cou", "cou"};
    sorter.sort(original, (x, y) -> x.compareTo(y));
    assertArrayEquals(original, expected);
  }

} // class SortTester