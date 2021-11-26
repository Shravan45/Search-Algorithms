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
}

