package robot;

import edu.wpi.first.wpilibj.Timer;
import robot.util.control.XboxController;
import robot.util.drive.WoodchuckDrive;

public class Drive implements RobotComponent {

    public XboxController controller;
    public WoodchuckDrive drive;
    
    boolean tankDrive = true;
    boolean heldLastTime = false;
    
    public void init() {
        controller = new XboxController();
        drive = new WoodchuckDrive();
        
    }

    public void teleop() {
        double leftStickY = controller.getAxis(XboxController.LEFT_Y);
        double rightStickX = controller.getAxis(XboxController.RIGHT_X);
        double rightStickY = controller.getAxis(XboxController.RIGHT_Y);
        
        boolean held = controller.getButton(XboxController.Y);
        
        if (held && !heldLastTime) {
            tankDrive = !tankDrive;
        }
        
        if (tankDrive) {
            drive.setLeft(leftStickY);
            drive.setRight(rightStickY);
        } else {
            drive.setLeft(leftStickY + rightStickX);
            drive.setRight(leftStickY - rightStickX);
        }
        
        heldLastTime = held;
    }
    
    public void auton() {
        drive.setBoth(1, 1);
        Timer.delay(1);
        drive.setBoth(0,0);
    }

    public void test() {
    }
}
