package ToyKits.util.area;

import ToyKits.util.Mini4WD;

public class EasyCourse extends CourseAssistant {
    public EasyCourse() {
      super(false, 0, 4);
    }
  
    @Override
    public void race(Mini4WD machine) {
      System.out.println("easy");
    }
}
