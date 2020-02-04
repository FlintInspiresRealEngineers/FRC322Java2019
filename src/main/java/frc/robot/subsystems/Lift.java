/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;
import frc.robot.utilities.F310Controller;

/**
 * This class defines the robot lifting mechanism.
 */
public class Lift extends Subsystem {
  private final WPI_TalonSRX leftFrontMotor = RobotMap.liftLeftFrontMotor;
  private final WPI_TalonSRX leftRearMotor = RobotMap.liftLeftRearMotor;
  private final WPI_TalonSRX rightFrontMotor = RobotMap.liftRightFrontMotor;
  private final WPI_TalonSRX rightRearMotor = RobotMap.liftRightRearMotor;
  private final SpeedControllerGroup liftMotors = RobotMap.liftMotors;

  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  public void lift() {
    liftMotors.set(1.0);
  }

  public void lower() {
    liftMotors.set(-1.0);
  }

  public void stop() {
    liftMotors.set(0.0);
  }

  public void setLift(F310Controller controller) {
    liftMotors.set(controller.getY(Hand.kRight));
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
}
