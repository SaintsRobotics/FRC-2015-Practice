package robot;

import edu.wpi.first.wpilibj.Timer;
import robot.util.control.XboxController;
import robot.util.drive.WoodchuckDrive;

public class Drive implements RobotComponent {

    public XboxController controller;
    public WoodchuckDrive drive;
    
    int driveScheme = 0;
    boolean heldLastTimeleft = false;
    boolean heldLastTimeright = false;
    public void init() {
        controller = new XboxController();
        drive = new WoodchuckDrive();
        
    }

    public void teleop() {
        double leftStickY = controller.getAxis(XboxController.LEFT_Y);
        double rightStickX = controller.getAxis(XboxController.RIGHT_X);
        double rightStickY = controller.getAxis(XboxController.RIGHT_Y);
        double leftTrigger = controller.getAxis(XboxController.TRIGGERS);
        boolean heldRight = controller.getButton(XboxController.RB);
        boolean heldLeft = controller.getButton(XboxController.LB);
        
        if (heldLeft && !heldLastTimeleft) {
            driveScheme -= 1;
        }else if (heldRight && !heldLastTimeright) {
            driveScheme += 1;
        }
        switch(driveScheme){
            case 0:
                drive.setBoth(leftStickY , rightStickY);
                break;
            case 1:    
                drive.setBoth(leftStickY + rightStickX, leftStickY - rightStickX);
                break;
            case 2:
                
        }
        
        heldLastTimeleft = heldLeft;
        heldLastTimeright = heldRight;
    }
    
    public void auton() {
        drive.setBoth(1, 1);
        Timer.delay(1);
        drive.setBoth(0,0);
        if (true)
            return;
        drive.setBoth(34, 124);
    }

    public void test() {
    }
    void betterArcadeDrive(double leftStick, double rightStick, double triggervalue){
        double totalLeft;
        double totalRight;
        if(rightStick < 0){
            totalLeft = leftStick * (1 + rightStick);
            totalRight = leftStick;
        }else if(rightStick > 0){
            totalLeft = leftStick;
            totalRight = leftStick * (1 - rightStick);
        }else{
            totalLeft = leftStick;
            totalRight = rightStick;
        }
        totalLeft += triggervalue;
        totalRight -= triggervalue;
        drive.setBoth(totalLeft, totalRight);
    }
}
