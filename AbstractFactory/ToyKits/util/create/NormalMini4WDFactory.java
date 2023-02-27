package ToyKits.util.create;

import ToyKits.util.CreateOrder;
import ToyKits.util.product.Mini4WD;
import ToyKits.util.product.NormalMini4WD;
import ToyKits.util.product.component.Battery;
import ToyKits.util.product.component.Body;
import ToyKits.util.product.component.Parts;

public class NormalMini4WDFactory implements Mini4WDFactory {
  @Override
  public Structure createStructure(CreateOrder order) {
    Parts body = this.createBody(order);
    Parts battery = this.createBattery();
    return new Structure(body, battery);
  }

  @Override
  public Mini4WD createMini4WD(CreateOrder order) {
    Structure structure = this.createStructure(order);
    return new NormalMini4WD(structure);
  }

  @Override
  public Parts createBody(CreateOrder order) {
    return new Body(order.getColorIndex());
  }

  @Override
  public Parts createBattery() {
    return new Battery();
  }
}