/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj.command.Subsystem;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import frc.robot.RobotMap;
import frc.robot.utilities.F310Controller;
import frc.robot.commands.*;

/**
 * This class describes the elevator.
 */
public class Elevator extends Subsystem {
  private final WPI_TalonSRX frontMotor = RobotMap.elevatorFrontMotor;
  private final WPI_TalonSRX rearMotor = RobotMap.elevatorRearMotor;
  private final SpeedControllerGroup elevatorMotors = RobotMap.elevatorMotors;

  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  public void moveElevator(F310Controller f310) {
    elevatorMotors.set(f310.getY(Hand.kRight));
  }

  public void stopElevator() {
    elevatorMotors.stopMotor();
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
    setDefaultCommand(new MoveElevator());
  }
}
