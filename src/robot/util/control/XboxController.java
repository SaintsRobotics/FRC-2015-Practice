package robot.util.control;

import edu.wpi.first.wpilibj.Joystick;

/**
 * Class to simplify usage of the Joystick classes.
 * 
 * @author Shreyas
 */
public class XboxController {
    
    /** Horizontal axis on the left stick. */
    public static final int LEFT_X = 1;
    
    /** Vertical axis on the left stick. */
    public static final int LEFT_Y = 2;
    
    /** The right and left triggers. */
    public static final int TRIGGERS = 3;
    
    /** Horizontal axis on the right stick. */
    public static final int RIGHT_X = 4;
    
    /** Vertical axis on the right stick. */
    public static final int RIGHT_Y = 5;
    
    
    /** 'A' button. */
    public static final int A = 1;
    
    /** 'B' button. */
    public static final int B = 2;
    
    /** 'X' button. */
    public static final int X = 3;
    
    /** 'Y' button. */
    public static final int Y = 4;
    
    /** Left bumper. */
    public static final int LB = 5;
    
    /** Right bumper. */
    public static final int RB = 6;
    
    /** Back button. */
    public static final int BACK = 7;
    
    /** Start button. */
    public static final int START = 8;
    
    /** Press of the left stick. */
    public static final int L3 = 9;
    
    /** Press of the right stick. */
    public static final int R3 = 10;
    
    private Joystick joystick;
    
    /**
     * Creates a new XboxController on port 1 (default).
     */
    public XboxController() {
        this(1);
    }
    
    /**
     * Creates a new XboxController on a specified port.
     * 
     * @param port The port to create the controller on.
     */
    public XboxController(int port) {
        joystick = new Joystick(1);
    }
    
    /**
     * Gets an axis value as a double between -1.0 and 1.0.
     * 
     * @param axis The axis to get.
     * @return The value of the axis.
     */
    public double getAxis(int axis) {
        if (axis<1 || axis>5)
            return 0;
        return joystick.getRawAxis(axis);
    }
    
    /**
     * Gets whether or not a button is pressed.
     * 
     * @param button The button to get.
     * @return Whether or not the button is pressed.
     */
    public boolean getButton(int button) {
        if (button<1 || button>10)
            return false;
        return joystick.getRawButton(button);
    }
}