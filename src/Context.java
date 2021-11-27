import java.util.List;
import java.util.Map;

public class Context {
  private Strategy strategy;

  public void setStrategy(Strategy strategy) {
    this.strategy = strategy;
  }

  public int executeArraySearchStrategy(int[] arr, int item) {
    return this.strategy.search(arr, item);
  }

  public int executeGraphSearchStrategy(Map<Integer, List<Integer>> graph, int startNode,
                                        int item) {
    return this.strategy.graphSearch(graph, startNode, item);
  }
}
