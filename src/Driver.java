import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public class Driver {

  // This program uses Strategy Pattern to leverage different types of Search algorithms.
  public static void main(String[] args) {

    Context context = new Context();
    String strategy = "dfs";
    boolean isGraphSearch = false;

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
      case "bfs": {
        System.out.println("Using Breadth First Search! \n " +
                "Time Complexity (Using Adjacency list): O(V + E) where V is " +
                "number of vertices and E is number of edges" +
                "\n Time Complexity (Using Adjacency matrix): O(V^2)");
        context.setStrategy(new BreadthFirstSearch());
        isGraphSearch = true;
        break;
      }
      case "dfs": {
        System.out.println("Using Depth First Search! \n " +
                "Time Complexity (Using Adjacency list): O(V + E) where V is " +
                "number of vertices and E is number of edges" +
                "\n Time Complexity (Using Adjacency matrix): O(V^2)");
        context.setStrategy(new DepthFirstSearch());
        isGraphSearch = true;
        break;
      }
      default: {
        System.out.println("Invalid input!");
      }
    }

    if (!isGraphSearch) {
      int[] arr = {1, 3, 4, 5, 2};
      int resultIndex = context.executeArraySearchStrategy(arr, 3);
      if (resultIndex != -1) {
        System.out.println("Key exists at index " + resultIndex);
      } else {
        System.out.println("Key does not exists!");
      }
    } else {
      Map<Integer, List<Integer>> graph = getGraph();
      int result = context.executeGraphSearchStrategy(graph, 1, 1);
      if (result != -1) {
        System.out.println("Key exists!");
      } else {
        System.out.println("Key does not exists!");
      }
    }
  }

  private static Map<Integer, List<Integer>> getGraph() {
    Map<Integer, List<Integer>> graph = new HashMap<>();
    graph.put(1, new ArrayList<>() {{
      add(3);
      add(4);
    }});

    graph.put(2, new ArrayList<>() {{
      add(1);
    }});

    graph.put(3, new ArrayList<>() {{
      add(4);
      add(5);
    }});

    graph.put(4, new ArrayList<>() {{
      add(5);
    }});

    graph.put(5, new ArrayList<>() {{
      add(1);
      add(2);
    }});

    return graph;
  }
}

