package frc.robot.utilities;

import edu.wpi.first.wpilibj.interfaces.Accelerometer;
import edu.wpi.first.wpilibj.ADXL345_I2C;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.wpilibj.SendableBase;
import edu.wpi.first.wpilibj.smartdashboard.SendableBuilder;
import frc.robot.Robot;

public class IMUAccelerometer extends SendableBase implements Accelerometer {
    public void setRange(Range range) {
        Robot.chassisSensors.setRange(range);
    }

    public double getX(){
        return Robot.chassisSensors.getAccelX();
    }

    public double getY(){
        return Robot.chassisSensors.getAccelY();
    }

    public double getZ(){
        return Robot.chassisSensors.getAccelZ();
    }

    public void initSendable(SendableBuilder builder) {
        builder.setSmartDashboardType("3AxisAccelerometer");
        NetworkTableEntry entryX = builder.getEntry("X");
        NetworkTableEntry entryY = builder.getEntry("Y");
        NetworkTableEntry entryZ = builder.getEntry("Z");
        builder.setUpdateTable(() -> {
          entryX.setDouble(this.getX());
          entryY.setDouble(this.getY());
          entryZ.setDouble(this.getZ());
        });
    }
}
