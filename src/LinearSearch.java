import java.util.List;
import java.util.Map;

public class LinearSearch implements Strategy{

  //Performs linear search for finding the item in given integer array arr.
  @Override
  public int search(int[] arr, int item) {
    for(int i = 0; i < arr.length; i++){
      if(arr[i] == item){
        return i;
      }
    }
    return -1;
  }

  @Override
  public int graphSearch(Map<Integer, List<Integer>> graph, int startNode, int item) {
    return 0;
  }
}

