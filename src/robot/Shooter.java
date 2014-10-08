package robot;

import robot.util.control.XboxController;

public class Shooter implements RobotComponent {

    private boolean shooting;
    private Shooting shooter;
    private XboxController controller;

    public void init() {
        shooter = new Shooting();
        shooting = false;
        controller = new XboxController();
    }

    public void teleop() {
        if (shooting) {
            shooting = shooter.shouldStopshoot();
            if(shooter.shouldStopshoot()){
                shooter.stop();
            }
        } else {
            if (controller.getButton(XboxController.X)) {
                shooting = true;
                shooter.startShoot();
            }
        }
    }

    public void auton() {
    }

    public void test() {
    }
}
