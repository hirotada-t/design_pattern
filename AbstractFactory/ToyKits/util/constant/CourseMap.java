package ToyKits.util.constant;

import java.util.HashMap;

import ToyKits.util.area.ClimbCourse;
import ToyKits.util.area.CornerCourse;
import ToyKits.util.area.CourseAssistant;
import ToyKits.util.area.EasyCourse;
import ToyKits.util.area.HardCourse;
import ToyKits.util.area.StraightCourse;

public class CourseMap {
  public static final HashMap<String, CourseAssistant> map = new HashMap<>(){
    {
      put("easy", new EasyCourse());
      put("straight", new StraightCourse());
      put("climb", new ClimbCourse());
      put("corner", new CornerCourse());
      put("hard", new HardCourse());
    }
  };

  public static String[] courseKey() {
    int size = CourseMap.map.size();
    return CourseMap.map.keySet().toArray(new String[size]);
  }
}