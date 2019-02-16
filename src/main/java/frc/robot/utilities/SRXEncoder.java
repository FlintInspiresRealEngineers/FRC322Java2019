package frc.robot.utilities;

import com.ctre.phoenix.motorcontrol.can.TalonSRX;    
import edu.wpi.first.wpilibj.SendableBase;
import edu.wpi.first.wpilibj.smartdashboard.SendableBuilder;

/**
 * A class that mimics {@link edu.wpi.first.wpilibj.Encoder a WPILib Encoder} sendable
 * properties, but gets data from a {@link TalonSRX} instead of digital input pins on
 * the roboRIO.
 */
public class SRXEncoder extends SendableBase {
    private final TalonSRX talon;
    
    private double distancePerPulse = 1;
    
    public SRXEncoder(TalonSRX talon) {
      this.talon = talon;
    }
    
    public void setDistancePerPulse(double distancePerPulse) {
      this.distancePerPulse = distancePerPulse;
    }
    
    public double getDistancePerPulse() {
      return distancePerPulse;
    }
    
    public double getDistance() {
      return talon.getSelectedSensorPosition(talon.getSelectedSensorPosition());
    }
    
    public double getRate() {
      return talon.getSelectedSensorVelocity(talon.getSelectedSensorVelocity());
    }

    public void reset() {
      talon.getSensorCollection().setQuadraturePosition(0, 0);
    }
    
    @Override
    public void initSendable(SendableBuilder builder) {
      builder.setSmartDashboardType("Encoder");
      builder.addDoubleProperty("Distance", this::getDistance, null);
      builder.addDoubleProperty("Speed", this::getRate, null);
      builder.addDoubleProperty("Distance per tick", this::getDistancePerPulse, null);
    }
}
