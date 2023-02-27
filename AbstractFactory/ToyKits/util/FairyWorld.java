package ToyKits.util;

import java.util.Arrays;
import java.util.HashMap;
import ToyKits.util.area.CourseAssistant;
import ToyKits.util.constant.CourseMap;
import ToyKits.util.constant.FactoryMap;
import ToyKits.util.constant.Func;
import ToyKits.util.create.Mini4WDFactory;
import ToyKits.util.product.Mini4WD;

public class FairyWorld {
  private final HashMap<String, CourseAssistant> courseMap = CourseMap.map;
  private final HashMap<String, Mini4WDFactory> mini4WDMap = FactoryMap.map;

  public void run(String courseKey, Mini4WDOrder order) throws InvalidOrderException {
    if (!Arrays.asList(CourseMap.courseKey()).contains(courseKey)) {
      throw new InvalidOrderException("Invalid courseKey: \n" + Func.arrToString(CourseMap.courseKey()));
    }
    Mini4WD machine = mini4WDMap.get(order.getMachineKey()).createMini4WD(order);
    this.courseMap.get(courseKey).race(machine);
    System.out.println("test-OK");
  }
}