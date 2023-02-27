package ToyKits.util.create;

import ToyKits.util.Mini4WDOrder;
import ToyKits.util.product.Mini4WD;
import ToyKits.util.product.NormalMini4WD;
import ToyKits.util.product.component.Battery;
import ToyKits.util.product.component.Body;
import ToyKits.util.product.component.Chassis;
import ToyKits.util.product.component.Motor;
import ToyKits.util.product.component.Parts;
import ToyKits.util.product.component.Rollers;
import ToyKits.util.product.component.Suspension;
import ToyKits.util.product.component.Tyres;

public class NormalMini4WDFactory implements Mini4WDFactory {
  @Override
  public Structure createStructure(Mini4WDOrder order) {
    Parts body = this.createBody(order);
    Parts battery = this.createBattery();
    return new Structure(body, battery);
  }

  @Override
  public Mini4WD createMini4WD(Mini4WDOrder order) {
    Structure structure = this.createStructure(order);
    return new NormalMini4WD(structure);
  }

  @Override
  public Body createBody(Mini4WDOrder order) {
    return new Body(order.getColorIndex());
  }

  @Override
  public Battery createBattery() {
    return new Battery();
  }

  @Override
  public Chassis createChassis(Mini4WDOrder order) {
    return null;
  }

  @Override
  public Motor createMotor(Mini4WDOrder order) {
    return null;
  }

  @Override
  public Tyres createTyres(Mini4WDOrder order) {
    return null;
  }

  @Override
  public Rollers createRollers(Mini4WDOrder order) {
    return null;
  }

  @Override
  public Suspension createSuspension(Mini4WDOrder order) {
    return null;
  }
}