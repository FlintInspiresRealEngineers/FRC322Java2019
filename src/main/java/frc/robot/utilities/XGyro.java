package frc.robot.utilities;

import edu.wpi.first.wpilibj.GyroBase;
import frc.robot.Robot;

public class XGyro extends GyroBase {
    public void calibrate() {
        Robot.chassisSensors.calibrate();
    }
    
    public void reset() {
        Robot.chassisSensors.resetXYZ();
    }
    
    public double getAngle(){
        return Robot.chassisSensors.getAngleX();
    }

    public double getRate() {
        return Robot.chassisSensors.getRateX();
    }
}
