package ToyKits.util;
import ToyKits.CreateOrder;
import ToyKits.util.component.Parts;
import ToyKits.util.product.Mini4WD;

// AbstractFactory
public interface Mini4WDFactory {
  abstract public Structure createStructure(CreateOrder order);

  abstract public Mini4WD createMini4WD(CreateOrder order);

  abstract public Parts createBody(CreateOrder order);

  abstract public Parts createBattery();
}