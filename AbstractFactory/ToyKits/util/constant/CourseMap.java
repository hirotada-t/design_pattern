package ToyKits.util.constant;

import java.util.LinkedHashMap;

import ToyKits.util.area.ClimbCourseAssistant;
import ToyKits.util.area.CornerCourseAssistant;
import ToyKits.util.area.CourseAssistant;
import ToyKits.util.area.EasyCourseAssistant;
import ToyKits.util.area.HardCourseAssistant;
import ToyKits.util.area.StraightCourseAssistant;

public class CourseMap {
  public static final LinkedHashMap<String, CourseAssistant> map = new LinkedHashMap<>(){
    {
      put("easy", new EasyCourseAssistant());
      put("straight", new StraightCourseAssistant());
      put("climb", new ClimbCourseAssistant());
      put("corner", new CornerCourseAssistant());
      put("hard", new HardCourseAssistant());
    }
  };

  public static String[] courseKey() {
    int size = CourseMap.map.size();
    return CourseMap.map.keySet().toArray(new String[size]);
  }
}
