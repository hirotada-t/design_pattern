package ToyKits.util;
import ToyKits.CreateOrder;

// AbstractFactory
public interface Mini4WDFactory {
  abstract public Structure createStructure(CreateOrder order);

  abstract public Mini4WD createMini4WD(CreateOrder order);

  abstract public Parts createBody(CreateOrder order);

  abstract public Parts createBattery();
}