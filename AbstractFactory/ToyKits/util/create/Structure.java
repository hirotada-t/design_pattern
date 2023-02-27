package ToyKits.util.create;

import ToyKits.util.product.component.Parts;

public class Structure {
  protected Parts body;
  protected Parts battery;

  public Structure(Parts body, Parts battery) {
    this.body = body;
    this.battery = battery;
  }
}