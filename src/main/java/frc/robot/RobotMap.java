package frc.robot;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.CANifier;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj.PowerDistributionPanel;
import edu.wpi.first.wpilibj.Preferences;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import com.analog.adis16448.frc.*;
import frc.robot.utilities.*;

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
    public static ADIS16448_IMU chassisSensorsIMU;
    public static XGyro chassisSensorsXGyro;
    public static YGyro chassisSensorsYGyro;
    public static ZGyro chassisSensorsZGyro;
    public static IMUAccelerometer chassisSensorsIMUAccelerometer;
    public static SRXEncoder chassisSensorsLeftEncoder;
    public static SRXEncoder chassisSensorsRightEncoder;
    public static WPI_TalonSRX elevatorFrontMotor;
    public static WPI_TalonSRX elevatorRearMotor;
    public static SpeedControllerGroup elevatorMotors;
    public static WPI_TalonSRX manipulatorPivotMotor;
    public static WPI_VictorSPX manipulatorLeftWheelMotor;
    public static WPI_VictorSPX manipulatorRightWheelMotor;
    public static SpeedControllerGroup manipulatorWheelMotors;
    public static CANifier ledControlCANifier;
    public static WPI_TalonSRX liftLeftFrontMotor;
    public static WPI_TalonSRX liftLeftRearMotor;
    public static WPI_TalonSRX liftRightFrontMotor;
    public static WPI_TalonSRX liftRightRearMotor;
    public static SpeedControllerGroup liftMotors;

    public static Preferences dashboardRobotPrefs;

    public static NetworkTable limelightTable;
    public static NetworkTableEntry limelighttx;
    public static NetworkTableEntry limelightty;
    public static NetworkTableEntry limelightta;
    public static double limelightX, limelightY, limelightArea;

    public static double autonDistance, autonRotation, autonSpeed, autonTime;
    private static final double WHEEL_DIAMETER = 8.375;
    public static final double WHEEL_DIAMETER_METRIC = 0.212725;   //In Meters for FRC Pathfinder
	private static final double ENCODER_GEAR_RATIO = 1.0;
	private static final double GEAR_RATIO = 1.0;
    private static final double FUDGE_FACTOR = 1.0;
	public static final double ENCODER_PULSE_DISTANCE = Math.PI * WHEEL_DIAMETER / ENCODER_GEAR_RATIO / GEAR_RATIO * FUDGE_FACTOR;
    public static final double AXLE_TRACK = 0.5398;              //In Meters for FRC Pathfinder
    public static final double MAX_VELOCITY = 1.0;              //In Meters per Second

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

        
        chassisSensorspowerDistributionPanel = new PowerDistributionPanel(0);
        chassisSensorspowerDistributionPanel.setName("ChassisSensors", "powerDistributionPanel");

        chassisSensorsIMU = new ADIS16448_IMU();
        chassisSensorsIMU.setName("ChassisSensors", "IMU");

        chassisSensorsXGyro = new XGyro();
        chassisSensorsXGyro.setName("ChassisSensors", "XGyro");
        chassisSensorsYGyro = new YGyro();
        chassisSensorsXGyro.setName("ChassisSensors", "YGyro");
        chassisSensorsZGyro = new ZGyro();
        chassisSensorsXGyro.setName("ChassisSensors", "ZGyro");

        chassisSensorsLeftEncoder = new SRXEncoder(RobotMap.chassisleftFrontDriveMotor);
        chassisSensorsLeftEncoder.setName("ChassisSensors", "LeftEncoder");
        chassisSensorsRightEncoder = new SRXEncoder(RobotMap.chassisrightFrontDriveMotor);
        chassisSensorsRightEncoder.setName("ChassisSensors", "RightEncoder");
        
        chassisSensorsIMUAccelerometer = new IMUAccelerometer();
        chassisSensorsIMUAccelerometer.setName("ChassisSensors", "IMUAccelerometer");

        elevatorFrontMotor = new WPI_TalonSRX(5);
        elevatorFrontMotor.setNeutralMode(NeutralMode.Brake);
        elevatorRearMotor = new WPI_TalonSRX(6);
        elevatorRearMotor.setNeutralMode(NeutralMode.Brake);
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

        ledControlCANifier = new CANifier(0);

        redInt = 100.0;
        greenInt = 100.0;
        blueInt = 100.0;
        ledBlinkRate = 500;
        
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

        dashboardRobotPrefs = Preferences.getInstance();

        limelightTable = NetworkTableInstance.getDefault().getTable("limelight");
        limelighttx = limelightTable.getEntry("tx");
        limelightty = limelightTable.getEntry("ty");
        limelightta = limelightTable.getEntry("ta");

        limelightX = 0.0;
        limelightY = 0.0;
        limelightArea = 0.0;
        
        RobotMap.autonDistance = 36.0;
        RobotMap.autonSpeed = 0.5;
        RobotMap.autonRotation = 0.0;
        RobotMap.autonTime = 5.0;
    }
}
