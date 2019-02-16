/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.subsystems.ChassisSensors;

public class ResetEncoders extends Command {
  public ResetEncoders() {
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
    requires(Robot.chassisSensors);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    Robot.chassisSensors.resetEncoders();
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    Robot.chassisSensors.resetEncoders();
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    if ((Robot.chassisSensors.getEncoderDistance(0) != 0) || (Robot.chassisSensors.getEncoderDistance(1) != 0))
        return false;
    else
      return true;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
    Robot.chassisSensors.resetEncoders();
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
    this.end();
  }
}
