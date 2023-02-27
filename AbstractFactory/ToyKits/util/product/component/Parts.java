package ToyKits.util.product.component;

public class Parts {
  private int costYen;
  private int weightG;

  public Parts(int costYen, int weightG) {
    this.costYen = costYen;
    this.weightG = weightG;
  }

  public int getCost() {
    return this.costYen;
  }

  public int getWeight() {
    return this.weightG;
  }
}
