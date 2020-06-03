import java.util.*;

/*
*   Write a function that takes in a non-empty array of distinct integers and an
  integer representing a target sum. If any two numbers in the input array sum
  up to the target sum, the function should return them in an array, in any
  order. If no two numbers sum up to the target sum, the function should return
  an empty array.

  Space: O(n)
  Time: O(n)

* */

class TwoNumberSum {
  public static int[] twoNumberSum(int[] array, int targetSum) {

    Set<Integer> possibleYs = new HashSet<>();

    for(int i = 0; i < array.length; i++) {
      possibleYs.add(array[i]);
    }

    for(int i = 0; i < array.length; i++) {
      int res = targetSum - array[i];
      boolean cond = possibleYs.contains(res) && res != array[i];
      if (cond) {
        return new int[] {array[i], res};
      }
    }

    return new int[0];
  }
}
