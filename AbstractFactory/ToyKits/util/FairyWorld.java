package ToyKits.util;

import java.util.HashMap;
import ToyKits.util.area.CourseAssistant;
import ToyKits.util.constant.FactoryMap;
import ToyKits.util.create.Mini4WDFactory;
import ToyKits.util.product.Mini4WD;

public class FairyWorld {
  private HashMap<String, CourseAssistant> courseMap = new HashMap<>();
  private HashMap<String, Mini4WDFactory> mini4WDMap = FactoryMap.map;

  public FairyWorld() {
  }

  public void run(String courseKey, Mini4WDOrder order) {
    Mini4WD machine = mini4WDMap.get(order.getMachineKey()).createMini4WD(order);
    this.courseMap.get(courseKey).race(machine);
    System.out.println("test-OK");
  }
}