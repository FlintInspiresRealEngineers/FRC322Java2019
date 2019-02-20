package frc.robot.commands;

import frc.robot.Robot;
import frc.robot.RobotMap;
import frc.robot.OI;
import edu.wpi.first.wpilibj.command.Command;

/**
 * This class controls LED's on the Robot.
 */
public class SetLED extends Command {

    public SetLED() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.ledControl);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	try {
			Robot.ledControl.automaticLEDSetter();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	try {
			Robot.ledControl.setRGB(100.0, 100.0, 100.0, 0);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	this.end();
    }
}
