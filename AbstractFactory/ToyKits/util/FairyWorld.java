package ToyKits.util;

import java.util.HashMap;

import ToyKits.util.area.ClimbCourse;
import ToyKits.util.area.CornerCourse;
import ToyKits.util.area.CourseAssistant;
import ToyKits.util.area.EasyCourse;
import ToyKits.util.area.HardCourse;
import ToyKits.util.area.StraightCourse;
import ToyKits.util.create.ClimbMini4WDFactory;
import ToyKits.util.create.Mini4WDFactory;
import ToyKits.util.create.NormalMini4WDFactory;
import ToyKits.util.create.StraightMini4WDFactory;
import ToyKits.util.product.Mini4WD;

public class FairyWorld {
  public HashMap<String, CourseAssistant> courseMap = new HashMap<>();
  public HashMap<String, Mini4WDFactory> mini4WDMap = new HashMap<>();

  public FairyWorld() {
    courseMap.put("easy", new EasyCourse());
    courseMap.put("straight", new StraightCourse());
    courseMap.put("climb", new ClimbCourse());
    courseMap.put("corner", new CornerCourse());
    courseMap.put("hard", new HardCourse());

    mini4WDMap.put("normal", new NormalMini4WDFactory());
    mini4WDMap.put("climb", new ClimbMini4WDFactory());
    mini4WDMap.put("straight", new StraightMini4WDFactory());
  }

  public void run(String courseKey, Mini4WDOrder order) {
    Mini4WD machine = mini4WDMap.get(order.getMachineKey()).createMini4WD(order);
    this.courseMap.get(courseKey).race(machine);
    System.out.println("test-OK");
  }
}