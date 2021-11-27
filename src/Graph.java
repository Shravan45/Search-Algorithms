import java.util.LinkedList;

public class Graph {
  private int vertexCount;
  private LinkedList<Integer> adjacencyList[];

  public Graph(int vertexCount) {
    this.vertexCount = vertexCount;
    this.adjacencyList = new LinkedList[vertexCount];
    for (int i = 0; i < vertexCount; i++) {
      adjacencyList[i] = new LinkedList<>();
    }
  }
}

