import java.util.List;
import java.util.Map;

public interface Strategy {
  int search(int[] arr, int item);
  int graphSearch(Map<Integer, List<Integer>> graph, int startNode, int item);
}

