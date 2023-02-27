package ToyKits.util.constant;

import java.util.LinkedHashMap;

import ToyKits.util.create.ClimbMini4WDFactory;
import ToyKits.util.create.Mini4WDFactory;
import ToyKits.util.create.NormalMini4WDFactory;
import ToyKits.util.create.StraightMini4WDFactory;

public class FactoryMap {
  public static final LinkedHashMap<String, Mini4WDFactory> map = new LinkedHashMap<>(){
    {
      put("normal", new NormalMini4WDFactory());
      put("straight", new StraightMini4WDFactory());
      put("climb", new ClimbMini4WDFactory());
      put("original", null);
    }
  };

  public static String[] machineKey() {
    int size = FactoryMap.map.size();
    return FactoryMap.map.keySet().toArray(new String[size]);
  }
}
