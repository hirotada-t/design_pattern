package ToyKits.util.create;

import ToyKits.util.Mini4WDOrder;
import ToyKits.util.product.Mini4WD;
import ToyKits.util.product.component.Battery;
import ToyKits.util.product.component.Body;
import ToyKits.util.product.component.Chassis;
import ToyKits.util.product.component.Motor;
import ToyKits.util.product.component.Rollers;
import ToyKits.util.product.component.Suspension;
import ToyKits.util.product.component.Tyres;

// AbstractFactory
public interface Mini4WDFactory {
  abstract public Structure createStructure(Mini4WDOrder order);

  abstract public Mini4WD createMini4WD(Mini4WDOrder order);

  abstract public Body createBody(Mini4WDOrder order);

  abstract public Battery createBattery();

  abstract public Chassis createChassis(Mini4WDOrder order);

  abstract public Motor createMotor(Mini4WDOrder order);

  abstract public Tyres createTyres(Mini4WDOrder order);

  abstract public Rollers createRollers(Mini4WDOrder order);

  abstract public Suspension createSuspension(Mini4WDOrder order);
}