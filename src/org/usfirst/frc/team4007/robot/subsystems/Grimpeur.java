package org.usfirst.frc.team4007.robot.subsystems;

import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.Relay.Direction;
import edu.wpi.first.wpilibj.Relay.Value;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Grimpeur extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	public Relay moteur = new Relay(0);
	

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	
    }
    
    public void demarre(){
    	moteur.set(Value.kForward);
    }
    
    public void arret(){
    	moteur.set(Value.kOff);
    }
}

