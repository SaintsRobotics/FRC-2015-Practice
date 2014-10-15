package robot.util.drive;

import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Talon;

/**
 * Drive for the Woodchuck robot.
 * 
 * @author Shreyas
 */
public class WoodchuckDrive extends RobotDrive {
    
    private SpeedController motorRight;
    private SpeedController motorLeft;
    
    /**
     * Creates a new drive for the Woodchuck robot.
     * 
     * This robot has two Jaguars, the right on port 2, and the
     * left on port 3. The left motor is also inverted.
     */
    public WoodchuckDrive() {
        motorRight = new Talon(2);
        motorLeft = new Talon(3);
    }
    
    public void setRight(double val) {
        if(val > 1){
            val = 1;
        }
        if(val < -1){
            val = -1;
        }
        motorRight.set(val);
    }
    
    public void setLeft(double val) {
        if(val > 1){
            val = 1;
        }
        if(val < -1){
            val = -1;
        }
        motorLeft.set(-val);
    }
    public void setBoth(double left, double right){
        this.setLeft(left);
        this.setRight(right);
    }
}