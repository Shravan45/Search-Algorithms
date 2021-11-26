import java.util.Arrays;

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
    int resultIndex = binarySearchUsingRecursion(temp, 0, temp.length, item);

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

  private int binarySearchUsingRecursion(int[] arr, int lowerBound, int upperBound, int item) {
    if (upperBound > lowerBound) {

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
}

