package robot;

import robot.util.control.XboxController;
import robot.util.drive.WoodchuckDrive;

public class Drive implements RobotComponent {

    public XboxController controller;
    public WoodchuckDrive drive;
    public void init() {
        controller = new XboxController();
        drive = new WoodchuckDrive();
        
    }

    public void teleop() {
        double leftStickX = controller.getAxis(XboxController.LEFT_X);
        double leftStickY = controller.getAxis(XboxController.LEFT_Y);
        double rightStickX = controller.getAxis(XboxController.RIGHT_X);
        double rightStickY = controller.getAxis(XboxController.RIGHT_Y);
        
        //tankDrive
        //drive.setLeft(leftStickY);
        //drive.setRight(rightStickY);
        
        //arcadeDrive
        drive.setLeft(leftStickY + rightStickX);
        drive.setRight(leftStickY - rightStickX);
    
    }
    public void auton() {
    }

    public void test() {
    }
}
