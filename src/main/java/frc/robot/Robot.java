/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.cscore.UsbCamera;
import edu.wpi.first.cameraserver.CameraServer;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.buttons.InternalButton;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.commands.*;
import frc.robot.subsystems.*;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the TimedRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.gradle file in the
 * project.
 */
public class Robot extends TimedRobot {
  Command autonomousCommand;
  SendableChooser<String> chooser = new SendableChooser<>();

  public static OI oi;
  public static Chassis chassis;
  public static Elevator elevator;
  public static Lift lift;
  public static Manipulator manipulator;
  public static DriverStation DS;
  public static UsbCamera frontCameraServer;
  public static UsbCamera rearCameraServer;
  public InternalButton getRoboPrefsButton, readLimelightButton, initializeDashboardButton, dashboardOutputButton;

  /**
   * This function is run when the robot is first started up and should be
   * used for any initialization code.
   */
  @Override
  public void robotInit() {
    RobotMap.init();

    chassis = new Chassis();
    elevator = new Elevator();
    lift = new Lift();
    manipulator = new Manipulator();
    
    // OI must be constructed after subsystems. If the OI creates Commands
    //(which it very likely will), subsystems are not guaranteed to be
    // constructed yet. Thus, their requires() statements may grab null
    // pointers. Bad news. Don't move it.
    oi = new OI();
    
    DS = DriverStation.getInstance();

    //Setup InternalButtons
    getRoboPrefsButton = new InternalButton();
    readLimelightButton = new InternalButton();
    initializeDashboardButton = new InternalButton();
    dashboardOutputButton = new InternalButton();

    //Setup Cameras
    frontCameraServer = CameraServer.getInstance().startAutomaticCapture();
    frontCameraServer.setResolution(320, 240);

    rearCameraServer = CameraServer.getInstance().startAutomaticCapture();
    rearCameraServer.setResolution(160, 120);

    // Add commands to Autonomous Sendable Chooser
    chooser.setDefaultOption("Do Nothing", "Do Nothing");
    chooser.addOption("Drive Forward", "Drive Forward");
    chooser.addOption("Drive Backward", "Drive Backward");
    SmartDashboard.putData("Auto mode", chooser);
    Scheduler.getInstance().run();
  }

  /**
   * This function is called every robot packet, no matter the mode. Use
   * this for items like diagnostics that you want ran during disabled,
   * autonomous, teleoperated and test.
   *
   * <p>This runs after the mode specific periodic functions, but before
   * LiveWindow and SmartDashboard integrated updating.
   */
  @Override
  public void robotPeriodic() {
    //readLimelightButton.setPressed(true);
    //readLimelightButton.whenActive(new ReadLimelight());
    //readLimelightButton.setPressed(false);
    //dashboardOutputButton.setPressed(true);
    //dashboardOutputButton.whenActive(new DashboardOutput());
    //dashboardOutputButton.setPressed(false);
  }
  
  @Override
  public void disabledInit(){
  }

  /**
   * This autonomous (along with the chooser code above) shows how to select
   * between different autonomous modes using the dashboard. The sendable
   * chooser code works with the Java SmartDashboard.
   *
   * <p>You can add additional auto modes by adding additional comparisons to
   * the switch structure below with additional strings. If using the
   * SendableChooser make sure to add them to the chooser code above as well.
   */
  @Override
  public void autonomousInit() {
    switch (chooser.getSelected()) {
      case "Do Nothing":				  autonomousCommand = new DoNothing();
      break;
          
      default: 						        autonomousCommand = new DoNothing();
      break;
    }
    
    if (autonomousCommand != null) autonomousCommand.start();
  }

  @Override
  public void testInit() {
  }

  
  @Override
  public void disabledPeriodic() {
    Scheduler.getInstance().run();
  }

  /**
   * This function is called periodically during autonomous.
   */
  @Override
  public void autonomousPeriodic() {
    Scheduler.getInstance().run();
  }

  /**
   * This function is called periodically during operator control.
   */
  @Override
  public void teleopPeriodic() {
    Scheduler.getInstance().run();
  }

  /**
   * This function is called periodically during test mode.
   */
  @Override
  public void testPeriodic() {
  }
}
