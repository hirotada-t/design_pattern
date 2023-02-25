package ToyKits;

import java.util.HashMap;
import ToyKits.util.area.CourseAssistant;
import ToyKits.util.area.EasyCourse;
import ToyKits.util.Mini4WDFactory;
import ToyKits.util.NormalMini4WDFactory;
import ToyKits.util.Mini4WD;

public class FairyWorld {
  public HashMap<String, CourseAssistant> courseMap = new HashMap<>();
  public HashMap<String, Mini4WDFactory> mini4WDMap = new HashMap<>();

  public FairyWorld() {
    courseMap.put("easy", new EasyCourse());

    mini4WDMap.put("normal", new NormalMini4WDFactory());
  }

  public void run(String courseKey, CreateOrder order) {
    Mini4WD machine = mini4WDMap.get(order.getMachineKey()).createMini4WD(order);
    this.courseMap.get(courseKey).race(machine);
    System.out.println("test-OK");
  }
}