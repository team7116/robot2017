
package org.usfirst.frc.team4007.robot;

import edu.wpi.cscore.UsbCamera;
import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

import org.usfirst.frc.team4007.robot.commands.AutonomousCommands;
import org.usfirst.frc.team4007.robot.commands.DriveWithJoystick;
import org.usfirst.frc.team4007.robot.subsystems.DriveTrain;
import org.usfirst.frc.team4007.robot.subsystems.Gear;
import org.usfirst.frc.team4007.robot.subsystems.Grimpeur;

import com.ctre.CANTalon;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {
	
	public static DriveTrain driveTrain;
	public static Gear gear;
	public static Grimpeur grimpeur;
	public static OI oi;

	//CameraServer camServer = CameraServer.getInstance();
    
    //UsbCamera cam = CameraServer.getInstance().startAutomaticCapture("cam0", 0);
    
    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit() {
    	driveTrain = new DriveTrain();
    	gear = new Gear();
    	grimpeur = new Grimpeur();
		oi = new OI();

        /*cam.setFPS(30);
        cam.setResolution(320, 240);*/      
        
    }
	
	/**
     * This function is called once each time the robot enters Disabled mode.
     * You can use it to reset any subsystem information you want to clear when
	 * the robot is disabled.
     */
    public void disabledInit(){

    }
	
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

	/**
	 * This autonomous (along with the chooser code above) shows how to select between different autonomous modes
	 * using the dashboard. The sendable chooser code works with the Java SmartDashboard. If you prefer the LabVIEW
	 * Dashboard, remove all of the chooser code and uncomment the getString code to get the auto name from the text box
	 * below the Gyro
	 *
	 * You can add additional auto modes by adding additional commands to the chooser code above (like the commented example)
	 * or additional comparisons to the switch structure below with additional strings & commands.
	 */
    public void autonomousInit() {
		AutonomousCommands autonomous = new AutonomousCommands();
		autonomous.start();
    	
    }

    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() {
        Scheduler.getInstance().run();
    }

    public void teleopInit() {
    }

    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic() {
    	/*if(Robot.oi.joystickDroit.getRawButton(3)){
    		grimpeur.demarre();
    	}else {
			grimpeur.arret();
		}*/
    	
        driveTrain.drive(Robot.oi.joystickGauche, Robot.oi.joystickDroit);
        //System.out.println(Robot.oi.joystickDroit.getRawButton(RobotMap.btnGrimpeur));
    }
    
    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() {
        LiveWindow.run();
    }
}
