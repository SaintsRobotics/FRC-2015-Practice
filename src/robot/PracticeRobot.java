package robot;

import edu.wpi.first.wpilibj.IterativeRobot;
import robot.util.control.XboxController;
import robot.util.drive.RobotDrive;
import robot.util.drive.WoodchuckDrive;

/**
 * A practice robot.
 * 
 * @author Programming Team
 */
public class PracticeRobot extends IterativeRobot {
    
    RobotDrive drive;
    public XboxController controller;
    
    RobotComponent[] components = new RobotComponent[3];
    
    public void robotInit() {
        drive = new WoodchuckDrive();
        controller = new XboxController();
        
        components[0] = new Drive();
        components[1] = new Hydraulics();
        components[2] = new Shooter();
        //components[3] = new Vision();
        
        for (int i=0;i<components.length;i++)
            components[i].init();
    }
    
    public void teleopPeriodic() {
        for (int i=0;i<components.length;i++)
            components[i].teleop();
    }
    
    public void autonPeriodic() {
        for (int i=0;i<components.length;i++)
            components[i].auton();
    }
    
    public void testPeriodic() {
        for (int i=0;i<components.length;i++)
            components[i].test();
    }
}
