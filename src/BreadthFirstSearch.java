import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class BreadthFirstSearch implements Strategy {

  @Override
  public int search(int[] arr, int item) {
    return -1;
  }

  @Override
  public int graphSearch(Map<Integer, List<Integer>> graph, int startNode, int item) {
    List<Integer> queue = new ArrayList<>();
    queue.add(startNode);
    List<Integer> exploredNodes = new ArrayList<>();

    while (!queue.isEmpty()) {
      int currentNode = queue.get(0);
      exploredNodes.add(currentNode);
      queue.remove(0);

      if (currentNode == item) {
        return currentNode;
      }

      List<Integer> neighbours = graph.get(currentNode);
      for (int neighbour : neighbours) {
        if (!exploredNodes.contains(neighbour)) {
          queue.add(neighbour);
        }
      }
    }
    return -1;
  }
}

