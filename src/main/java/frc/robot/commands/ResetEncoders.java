package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

/**
 * This class resets the encoders to a count of zero.
 */
public class ResetEncoders extends Command {

    public ResetEncoders() {
    	requires(Robot.chassis);
    }

    // Called just before this Command runs the first time
    @Override
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    @Override
    protected void execute() {
    	Robot.chassis.resetEncoders();
    }

    // Make this return true when this Command no longer needs to run execute()
    @Override
    protected boolean isFinished() {
        if(Robot.chassis.getEncoderData(1) == 0 && Robot.chassis.getEncoderData(2) == 0 &&
        		Robot.chassis.getEncoderData(3) == 0 && Robot.chassis.getEncoderData(4) == 0) return true;
        	else return false;
    }

    // Called once after isFinished returns true
    @Override
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    @Override
    protected void interrupted() {
    	this.end();
    }
}
