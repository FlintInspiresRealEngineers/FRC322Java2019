package frc.robot.subsystems;

import com.analog.adis16448.frc.ADIS16448_IMU;

import edu.wpi.first.wpilibj.PowerDistributionPanel;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.interfaces.Accelerometer;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.RobotMap;
import frc.robot.utilities.IMUAccelerometer;
import frc.robot.utilities.SRXEncoder;
import frc.robot.utilities.XGyro;
import frc.robot.utilities.YGyro;
import frc.robot.utilities.ZGyro;

/**
 * This class defines sensors on the chassis.
 */
public class ChassisSensors extends Subsystem {
    private final PowerDistributionPanel powerDistributionPanel = RobotMap.chassisSensorspowerDistributionPanel;
	private final ADIS16448_IMU IMU = RobotMap.chassisSensorsIMU;
	private final XGyro XGyro = RobotMap.chassisSensorsXGyro;
	private final YGyro YGyro = RobotMap.chassisSensorsYGyro;
	private final ZGyro ZGyro = RobotMap.chassisSensorsZGyro;
	private final IMUAccelerometer IMUAccel = RobotMap.chassisSensorsIMUAccelerometer;
	private final SRXEncoder leftEncoder = RobotMap.chassisSensorsLeftEncoder;
    private final SRXEncoder rightEncoder = RobotMap.chassisSensorsRightEncoder;

    @Override
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        // setDefaultCommand(new MySpecialCommand());
    }

    @Override
    public void periodic() {
        // Put code here to be run every loop
    	dashboardUpdater();
    }

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	public double getAngleX() {
		return IMU.getGyroAngleX();
	}

	public double getAngleY() {
		return IMU.getGyroAngleY();
	}

	public double getAngleZ() {
		return IMU.getGyroAngleZ();
	}

	public void getRate() {
		IMU.getRate();
	}
	
	public double getRateX() {
		return IMU.getGyroInstantX();
	}

	public double getRateY() {
		return IMU.getGyroInstantY();
	}

	public double getRateZ() {
		return IMU.getGyroInstantZ();
	}

	public double getAccelX() {
	    return IMU.getAccelInstantX();
	}

	public double getAccelY() {
	    return IMU.getAccelInstantY();
	}

	public double getAccelZ() {
	    return IMU.getAccelInstantZ();
	}

	public double getTemperature() {
	    return IMU.getTemperature();
	}
	
	public void resetXYZ() {
		IMU.reset();
	}

	public void calibrateIMU() {
		IMU.calibrate();
	}

	public void resetEncoders() {
		leftEncoder.reset();
		rightEncoder.reset();
	}

	public double getEncoderDistance(int encoder) {
		switch(encoder)
		{
			case 0:
				return leftEncoder.getDistance();
			case 1:
				return rightEncoder.getDistance();
			default:
				return 0.0;
		}
	}

	public double getEncoderSpeed(int encoder) {
        switch(encoder)
    	{
    		case 0:
                return (double) leftEncoder.getRate();
    		case 1:
                return (double) rightEncoder.getRate();
    		default:
    			return 0.0;
    	}
    }

	public void calibrate() {
		IMU.calibrate();
	}

	public void setRange(Accelerometer.Range range) {
		return;
	}

	public void dashboardUpdater() {
		//SmartDashboard.putNumber("Gyro Angle X", IMU.getAngleX());
		//SmartDashboard.putNumber("Gyro Angle Y", IMU.getAngleY());
		//SmartDashboard.putNumber("Gyro Angle Z", IMU.getAngleZ());
		//SmartDashboard.putNumber("X-Axis Acceleration", IMU.getAccelX());
		//SmartDashboard.putNumber("Y-Axis Acceleration", IMU.getAccelY());
		//SmartDashboard.putNumber("Z-Axis Acceleration", IMU.getAccelZ());
		//SmartDashboard.putNumber("Temperature", IMU.getTemperature());
		SmartDashboard.putData("IMU", IMU);
		SmartDashboard.putData("PDP", powerDistributionPanel);
		SmartDashboard.putData("Gyro X", XGyro);
		SmartDashboard.putData("Gyro Y", YGyro);
		SmartDashboard.putData("Gyro Z", ZGyro);
		SmartDashboard.putData("Accelerometer", IMUAccel);
		SmartDashboard.putData("Left Encoder", leftEncoder);
        SmartDashboard.putData("Right Encoder", rightEncoder);
	}
}
