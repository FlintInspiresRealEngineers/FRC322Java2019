/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;
import frc.robot.utilities.F310Controller;
import frc.robot.commands.*;

/**
 * This class describes the manipulator.
 */
public class Manipulator extends Subsystem {
  private final WPI_TalonSRX pivotMotor = RobotMap.manipulatorPivotMotor;
  private final WPI_TalonSRX leftWheelMotor = RobotMap.manipulatorLeftWheelMotor;
  private final WPI_TalonSRX rightWheelMotor = RobotMap.manipulatorRightWheelMotor;
  private final SpeedControllerGroup wheelMotors = RobotMap.manipulatorWheelMotors;

  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  public void pivot(F310Controller f310) {
    pivotMotor.set(f310.getY(Hand.kLeft));
  }

  public void suckBalls() {
    wheelMotors.set(1.0);
  }

  public void spitBalls() {
    wheelMotors.set(-1.0);
  }

  public void stopBallHandler() {
    wheelMotors.set(0.0);
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
    setDefaultCommand(new RunPivot());
  }
}
