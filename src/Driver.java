import java.util.Locale;

public class Driver {

  // This program uses Strategy Pattern to leverage different types of Search algorithms.
  public static void main(String[] args) {

    Context context = new Context();
    String strategy = "binary";
    switch (strategy.toLowerCase(Locale.ROOT)) {
      case "linear": {
        System.out.println("Using Linear Search! Time Complexity: O(n) where n is length of array");
        context.setStrategy(new LinearSearch());
        break;
      }
      case "binary": {
        System.out.println("Using Binary Search! Time Complexity: O(log n) where n is length of " +
                "array");
        context.setStrategy(new BinarySearch());
        break;
      }
      default: {
        System.out.println("Invalid input!");
      }
    }

    int[] arr = {1, 3, 4, 5, 2};
    int resultIndex = context.executeStrategy(arr, 5);
    if (resultIndex != -1) {
      System.out.println("Key exists at index " + resultIndex);
    } else {
      System.out.println("Key does not exists!");
    }
  }
}

