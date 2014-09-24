package robot.util.drive;

/**
 * Abstraction over robot drivetrains.
 * 
 * @author Shreyas
 */
public abstract class RobotDrive {
    
    /**
     * Sets the right motor value.
     * 
     * @param val A double between -1.0 and 1.0, with -1.0 for full
     * power in reverse and 1.0 for full power forwards.
     */
    public abstract void setRight(double val);
    
    /**
     * Sets the left motor value.
     * 
     * @param val A double between -1.0 and 1.0, with -1.0 for full
     * power in reverse and 1.0 for full power forwards.
     */
    public abstract void setLeft(double val);
}
