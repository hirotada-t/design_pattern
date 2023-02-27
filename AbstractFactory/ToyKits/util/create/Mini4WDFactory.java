package ToyKits.util.create;

import ToyKits.util.Mini4WDOrder;
import ToyKits.util.product.Mini4WD;
import ToyKits.util.product.component.Parts;

// AbstractFactory
public interface Mini4WDFactory {
  abstract public Structure createStructure(Mini4WDOrder order);

  abstract public Mini4WD createMini4WD(Mini4WDOrder order);

  abstract public Parts createBody(Mini4WDOrder order);

  abstract public Parts createBattery();

  abstract public Parts createChassis(Mini4WDOrder order);

  abstract public Parts createMotor(Mini4WDOrder order);

  abstract public Parts createTyres(Mini4WDOrder order);

  abstract public Parts createRollers(Mini4WDOrder order);

  abstract public Parts createSuspension(Mini4WDOrder order);
}