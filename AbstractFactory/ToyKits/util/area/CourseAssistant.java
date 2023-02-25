package ToyKits.util.area;

import ToyKits.util.Mini4WD;

public abstract class CourseAssistant {
  protected boolean laneChange;
  protected double upDown;
  protected int corners;
  
  public CourseAssistant(boolean laneChange, double upDown, int rightAngle) {
    this.laneChange = laneChange;
    this.upDown = upDown;
    this.corners = rightAngle * 4;
  }

  abstract public void race(Mini4WD machine);
}