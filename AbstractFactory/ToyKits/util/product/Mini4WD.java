package ToyKits.util.product;

import ToyKits.util.Structure;

public class Mini4WD {
  protected Spec spec;
  protected Structure structure;

  public Mini4WD(Structure structure) {
    this.structure = structure;
  }

  public int getTotalCosts() {
    return 1;
  }

  public int getTotalWeight() {
    return 1;
  }
}