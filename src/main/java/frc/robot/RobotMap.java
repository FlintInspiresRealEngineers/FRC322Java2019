package frc.robot;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import edu.wpi.first.wpilibj.PowerDistributionPanel;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
    public static WPI_TalonSRX chassisleftFrontDriveMotor;
    public static WPI_TalonSRX chassisleftRearDriveMotor;
    public static SpeedControllerGroup chassisleftSideDriveMotors;
    public static WPI_TalonSRX chassisrightFrontDriveMotor;
    public static WPI_TalonSRX chassisrightRearDriveMotor;
    public static SpeedControllerGroup chassisrightSideDriveMotors;
    public static DifferentialDrive chassisrobotDrive;
    public static PowerDistributionPanel chassisSensorspowerDistributionPanel;
    public static WPI_TalonSRX elevatorFrontMotor;
    public static WPI_TalonSRX elevatorRearMotor;
    public static SpeedControllerGroup elevatorMotors;
    public static WPI_TalonSRX manipulatorPivotMotor;
    public static WPI_VictorSPX manipulatorLeftWheelMotor;
    public static WPI_VictorSPX manipulatorRightWheelMotor;
    public static SpeedControllerGroup manipulatorWheelMotors;
    public static WPI_TalonSRX liftLeftFrontMotor;
    public static WPI_TalonSRX liftLeftRearMotor;
    public static WPI_TalonSRX liftRightFrontMotor;
    public static WPI_TalonSRX liftRightRearMotor;
    public static SpeedControllerGroup liftMotors;

    public static double redInt, greenInt, blueInt;
    public static long ledBlinkRate;
    
    public static void init() {
        chassisleftFrontDriveMotor = new WPI_TalonSRX(1);
        chassisleftRearDriveMotor = new WPI_TalonSRX(2);
        
        chassisleftSideDriveMotors = new SpeedControllerGroup(chassisleftFrontDriveMotor, chassisleftRearDriveMotor);
        chassisleftSideDriveMotors.setInverted(true);
        chassisleftSideDriveMotors.setName("Chassis", "leftSideDriveMotors");
        
        chassisrightFrontDriveMotor = new WPI_TalonSRX(3);
        chassisrightRearDriveMotor = new WPI_TalonSRX(4);
                
        chassisrightSideDriveMotors = new SpeedControllerGroup(chassisrightFrontDriveMotor, chassisrightRearDriveMotor);
        chassisrightSideDriveMotors.setInverted(true);
        chassisrightSideDriveMotors.setName("Chassis", "rightSideDriveMotors");
        
        chassisrobotDrive = new DifferentialDrive(chassisleftSideDriveMotors, chassisrightSideDriveMotors);
        chassisrobotDrive.setSafetyEnabled(true);
        chassisrobotDrive.setExpiration(5.0);
        chassisrobotDrive.setMaxOutput(1.0);
        chassisrobotDrive.setName("Chassis", "robotDrive");

        elevatorFrontMotor = new WPI_TalonSRX(5);
        elevatorRearMotor = new WPI_TalonSRX(6);
        elevatorMotors = new SpeedControllerGroup(elevatorFrontMotor, elevatorRearMotor);
        elevatorMotors.setName("Elevator", "ElevatorMotors");

        manipulatorPivotMotor = new WPI_TalonSRX(7);
        manipulatorPivotMotor.setNeutralMode(NeutralMode.Brake);
        manipulatorPivotMotor.setName("Manipulator", "Pivot");
        manipulatorLeftWheelMotor = new WPI_VictorSPX(1);
        manipulatorLeftWheelMotor.setNeutralMode(NeutralMode.Coast);
        manipulatorRightWheelMotor = new WPI_VictorSPX(2);
        manipulatorRightWheelMotor.setNeutralMode(NeutralMode.Coast);
        manipulatorWheelMotors = new SpeedControllerGroup(manipulatorLeftWheelMotor, manipulatorRightWheelMotor);
        manipulatorWheelMotors.setName("Manipulator", "WheelMotors");

        liftLeftFrontMotor = new WPI_TalonSRX(8);
        liftLeftFrontMotor.setNeutralMode(NeutralMode.Brake);
        liftLeftRearMotor = new WPI_TalonSRX(9);
        liftLeftRearMotor.setNeutralMode(NeutralMode.Brake);
        liftRightFrontMotor = new WPI_TalonSRX(10);
        liftRightFrontMotor.setNeutralMode(NeutralMode.Brake);
        liftRightRearMotor = new WPI_TalonSRX(11);
        liftRightRearMotor.setNeutralMode(NeutralMode.Brake);
        liftMotors = new SpeedControllerGroup(liftLeftFrontMotor, liftLeftRearMotor, liftRightFrontMotor, liftRightRearMotor);
        liftMotors.setName("Lift", "LiftMotors");
    }
}
