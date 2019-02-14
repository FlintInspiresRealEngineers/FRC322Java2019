package frc.robot.commands;
import edu.wpi.first.wpilibj.command.Command;

import frc.robot.OI;
import frc.robot.Robot;

/**
 * This class operates the Brake/Coast header on the TalonSRX Speed Controllers
 * on the drivetrain of the robot.
 */
public class Brakes extends Command {
    public Brakes() {
        requires(Robot.chassis);
    }

    // Called just before this Command runs the first time
    @Override
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    @Override
    protected void execute() {
    	Robot.chassis.brakesOn();
    }

    // Make this return true when this Command no longer needs to run execute()
    @Override
    protected boolean isFinished() {
    	if(Robot.oi.getDriveStick().getBButtonReleased()) {
    		return true;	
    	}
    	else
    		return false;
    }

    // Called once after isFinished returns true
    @Override
    protected void end() {
    	Robot.chassis.brakesOff();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    @Override
    protected void interrupted() {
    	this.isFinished();
    }
}
