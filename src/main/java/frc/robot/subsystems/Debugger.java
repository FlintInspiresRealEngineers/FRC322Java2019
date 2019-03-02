/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.Robot;
import frc.robot.commands.*;

/**
 * Add your docs here.
 */
public class Debugger extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  public void debugOutput() {
    System.out.println("Gyro Angle X" + Robot.chassisSensors.getAngleX());
	  System.out.println("Gyro Angle Y" + Robot.chassisSensors.getAngleY());
	  System.out.println("Gyro Angle Z" + Robot.chassisSensors.getAngleZ());
   	System.out.println();
   	System.out.println("X-Axis " + Robot.chassisSensors.getAccelX());
   	System.out.println("Y-Axis " + Robot.chassisSensors.getAccelY());
   	System.out.println("Z-Axis " + Robot.chassisSensors.getAccelZ());
   	System.out.println();
   	System.out.println("Left Front Distance " + Robot.chassis.getEncoderData(1));
    System.out.println("Right Front Distance " + Robot.chassis.getEncoderData(3));
   	System.out.println();
    System.out.println();
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
    setDefaultCommand(new DebugOutput());
  }
}
