package ToyKits.util.create;

import ToyKits.util.CreateOrder;
import ToyKits.util.product.Mini4WD;
import ToyKits.util.product.component.Parts;

// AbstractFactory
public interface Mini4WDFactory {
  abstract public Structure createStructure(CreateOrder order);

  abstract public Mini4WD createMini4WD(CreateOrder order);

  abstract public Parts createBody(CreateOrder order);

  abstract public Parts createBattery();

  abstract public Parts createChassis(CreateOrder order);

  abstract public Parts createMotor(CreateOrder order);

  abstract public Parts createTyres(CreateOrder order);

  abstract public Parts createRollers(CreateOrder order);

  abstract public Parts createSuspension(CreateOrder order);
}