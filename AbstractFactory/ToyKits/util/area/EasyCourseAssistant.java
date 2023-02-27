package ToyKits.util.area;

import ToyKits.util.product.Mini4WD;

public class EasyCourseAssistant extends CourseAssistant {
    public EasyCourseAssistant() {
      super(false, 0, 4);
    }
  
    @Override
    public void race(Mini4WD machine) {
      System.out.println("easy");
    }
}
