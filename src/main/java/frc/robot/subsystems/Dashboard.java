/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.RobotMap;
import frc.robot.Robot;
import frc.robot.commands.*;

/**
 * This subsystem describes a portion of the controls for the dashboard.
 */
public class Dashboard extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  public void getRoboPrefs() {
    RobotMap.autonDistance = RobotMap.dashboardRobotPrefs.getDouble("Autonomous Distance", RobotMap.autonDistance);
  	RobotMap.autonSpeed = RobotMap.dashboardRobotPrefs.getDouble("Autonomous Speed", RobotMap.autonSpeed);
	  RobotMap.autonRotation = RobotMap.dashboardRobotPrefs.getDouble("Autonomous Rotation", RobotMap.autonRotation);
    RobotMap.autonTime = RobotMap.dashboardRobotPrefs.getDouble("Autonomous Time", RobotMap.autonTime);
    SmartDashboard.putNumber("Autonomous Speed", RobotMap.autonSpeed);
    SmartDashboard.putNumber("Autonomous Rotation", RobotMap.autonRotation);
    SmartDashboard.putNumber("Autonomous Distance", RobotMap.autonDistance);
    SmartDashboard.putNumber("Autonomous Time", RobotMap.autonTime);
  }

  public void initializeDashboard() {
    SmartDashboard.putData("DriveWithJoystick", new DriveWithJoystick());
    SmartDashboard.putData("Brakes", new Brakes());
    SmartDashboard.putData("ResetEncoders", new ResetEncoders());
    SmartDashboard.putData("ResetGyro", new ResetGyro());
    SmartDashboard.putData("DoNothing", new DoNothing());
    SmartDashboard.putData("DriveForward", new DriveForward());
    SmartDashboard.putData("DriveBackward", new DriveBackward());
  }

  public void dashboardOutput() {
    SmartDashboard.putNumber("LimelightX", RobotMap.limelightX);
    SmartDashboard.putNumber("LimelightY", RobotMap.limelightY);
    SmartDashboard.putNumber("LimelightArea", RobotMap.limelightArea);
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
    setDefaultCommand(new DashboardOutput());
  }
}
