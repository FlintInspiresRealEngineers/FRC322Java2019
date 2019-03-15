/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;
import frc.robot.commands.*;

/**
 * This subsystem describes a small portion of the controls for the Limelight Vision
 * system.
 */
public class Limelight extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  public void readLimelight() {
    RobotMap.limelightX = RobotMap.limelighttx.getDouble(0.0);
    RobotMap.limelightY = RobotMap.limelightty.getDouble(0.0);
    RobotMap.limelightArea = RobotMap.limelightta.getDouble(0.0);
  }

  public void setCamMode(int mode) {
    switch (mode) {
      case 0:   RobotMap.limelightTable.getEntry("camMode").setNumber(0);
      break;
      
      case 1:   RobotMap.limelightTable.getEntry("camMode").setNumber(1);
      break;

      default:  RobotMap.limelightTable.getEntry("camMode").setNumber(0);
      break;
    }
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
    setDefaultCommand(new ReadLimelight());
  }
}
