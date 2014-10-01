package robot;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Jaguar;
import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.SpeedController;

public class Shooting {
    
    Relay arm;
    SpeedController flyWheel;
    DigitalInput tripWire;
    
    public Shooting() {
        arm = new Relay(1);
        flyWheel = new Jaguar(10);
        tripWire = new DigitalInput(2);
    }
    
    public void init() {
        flyWheel.set(1);
    }
    
    public void stop() {
        flyWheel.set(0);
    }
    
    public boolean shoot() {
        arm.set(Relay.Value.kForward);
        
    }
}
