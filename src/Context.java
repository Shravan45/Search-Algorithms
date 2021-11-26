public class Context {
  private Strategy strategy;
  public void setStrategy(Strategy strategy) {
    this.strategy = strategy;
  }

  public int executeStrategy(int[] arr, int item) {
    return this.strategy.search(arr, item);
  }
}
