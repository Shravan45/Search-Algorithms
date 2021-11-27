import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class BinarySearch implements Strategy {

  /**
   * Returns index of x if it is present in arr[l,r], else return -1.
   */
  @Override
  public int search(int[] arr, int item) {

    // Clone the array to preserve the original array.
    int[] temp = arr.clone();

    //1. Sort the array as Binary search only works on a sorted array.
    Arrays.sort(temp);

    //2. Perform Search
    //2.1 Using recursion. Uncomment below line to use recursion.
    //int resultIndex = binarySearchUsingRecursion(temp, 0, temp.length, item);

    //2.2 Using iteration.
    int resultIndex = binarySearchUsingIteration(temp, item);

    if (resultIndex == -1) {
      return -1;
    }

    //3. Return the index according to the original array.
    for (int i = 0; i < arr.length; i++) {
      if (temp[resultIndex] == arr[i]) {
        return i;
      }
    }
    return -1;
  }

  @Override
  public int graphSearch(Map<Integer, List<Integer>> graph, int startNode, int item) {
    return 0;
  }

  private int binarySearchUsingRecursion(int[] arr, int lowerBound, int upperBound, int item) {
    if (upperBound >= lowerBound) {

      int mid = lowerBound + (upperBound - lowerBound) / 2;

      if (item == arr[mid]) {
        return mid;
      }

      if (item < arr[mid]) {
        return binarySearchUsingRecursion(arr, lowerBound, mid - 1, item);
      }

      if (item > arr[mid]) {
        return binarySearchUsingRecursion(arr, mid + 1, upperBound, item);
      }
    }

    //We reach here when the element does not exist in the array.
    return -1;
  }

  private int binarySearchUsingIteration(int[] arr, int item) {
    int lowerBound = 0;
    int upperBound = arr.length - 1;

    while(lowerBound <= upperBound) {

      int mid = lowerBound + (upperBound - lowerBound)/2;

      if(arr[mid] == item){
        return mid;
      }

      if(item < arr[mid]){
        upperBound = mid - 1;
      }

      if(item > arr[mid]){
        lowerBound = mid + 1;
      }
    }

    return -1;
  }
}

