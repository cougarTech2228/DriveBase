
package org.usfirst.frc.team2228.robot;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.PowerDistributionPanel;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * MainClass
 */
public class Robot extends IterativeRobot {
    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
	
	double time;
	double oldTime = 0;
	double newTime = 0;
	
	DriveBase drive;
	PowerDistributionPanel panel;
	
    public void robotInit() {
    	panel = new PowerDistributionPanel();
    	drive = new DriveBase(0/*joy*/, Parameters.canID_FR, Parameters.canID_FL, Parameters.canID_BR, Parameters.canID_BL);
    	Parameters.smartdashboard_set();
    	//Logger.setUpFile();
    }

    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() {
    	
    }

    /**
     * This function is called periodically during operator control
     */
    public void teleopInit(){
    	Logger.resetTime();
    }
    
    public void teleopPeriodic() {
    	Parameters.smartdashboard_get();
    	
    	newTime = Timer.getFPGATimestamp();
    	time = newTime - oldTime;
    	oldTime = newTime;
    	
    	SmartDashboard.putNumber("time", time);
    	
    	panel.clearStickyFaults();
    	drive.mecanumDrive(time);
    	//Logger.log("DriveVoltage: " + drive.panel.getTemperature());
    }
    
    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() {
    	
    }
    
}
