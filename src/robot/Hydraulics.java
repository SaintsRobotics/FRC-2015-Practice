package robot;

import edu.wpi.first.wpilibj.Jaguar;
import edu.wpi.first.wpilibj.SpeedController;
import robot.util.control.XboxController;

public class Hydraulics implements RobotComponent {

    private XboxController controller;
    private SpeedController motor1;
    private double value;

    public void init() {
        controller = new XboxController(1);
        motor1 = new Jaguar(6);
    }

    public void teleop() {
        if(controller.getButton(XboxController.X)) {
            motor1.set(0);
        } else {
            motor1.set(controller.getAxis(XboxController.TRIGGERS)/4);
        }
    }

    public void auton() {
    }

    public void test() {
    }
}
