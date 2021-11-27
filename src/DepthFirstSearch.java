import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class DepthFirstSearch implements Strategy {

  @Override
  public int search(int[] arr, int item) {
    return 0;
  }

  @Override
  public int graphSearch(Map<Integer, List<Integer>> graph, int startNode, int item) {
    Stack stack = new Stack();
    stack.push(startNode);
    List<Integer> exploredSet = new ArrayList<>();

    while (!stack.isEmpty()) {

      int currentNode = (int) stack.pop();
      exploredSet.add(currentNode);

      if (currentNode == item) {
        return currentNode;
      }

      List<Integer> neighbours = graph.get(currentNode);
      for (int neighbour : neighbours) {
        if (!exploredSet.contains(neighbour)) {
          stack.push(neighbour);
        }
      }
    }

    return -1;
  }
}

