package ToyKits.util.constant;

import java.util.HashMap;

import ToyKits.util.create.ClimbMini4WDFactory;
import ToyKits.util.create.Mini4WDFactory;
import ToyKits.util.create.NormalMini4WDFactory;
import ToyKits.util.create.StraightMini4WDFactory;

public class FactoryMap {
  public static final HashMap<String, Mini4WDFactory> map = new HashMap<>(){
    {
      put("normal", new NormalMini4WDFactory());
      put("climb", new ClimbMini4WDFactory());
      put("straight", new StraightMini4WDFactory());
      put("original", null);
    }
  };

  protected static String[] machineKey() {
    int size = FactoryMap.map.size();
    return FactoryMap.map.keySet().toArray(new String[size]);
  }
}
