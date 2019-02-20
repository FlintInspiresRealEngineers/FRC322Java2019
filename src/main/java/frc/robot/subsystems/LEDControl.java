package frc.robot.subsystems;

import frc.robot.Robot;
import frc.robot.RobotMap;
import frc.robot.commands.*;
import com.ctre.phoenix.CANifier;
import com.ctre.phoenix.CANifier.LEDChannel;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * This class defines the LED control system.
 */
public class LEDControl extends Subsystem {
	
	private final CANifier canifier = RobotMap.ledControlCANifier;
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	setDefaultCommand(new SetLED());
    }

    public void setRGB(double redIntensity, double greenIntensity, double blueIntensity, long blinkRate) throws InterruptedException {
    	canifier.setLEDOutput(redIntensity, LEDChannel.LEDChannelA);
    	canifier.setLEDOutput(greenIntensity, LEDChannel.LEDChannelB);
    	canifier.setLEDOutput(blueIntensity, LEDChannel.LEDChannelC);
    	Thread.sleep(blinkRate);
    	canifier.setLEDOutput(0.0, LEDChannel.LEDChannelA);
    	canifier.setLEDOutput(0.0, LEDChannel.LEDChannelB);
    	canifier.setLEDOutput(0.0, LEDChannel.LEDChannelC);
    }
    
    public void automaticLEDSetter() throws InterruptedException {
    	if(Robot.DS.isDisabled()) 				RobotMap.ledBlinkRate = 500;
    	else if(Robot.DS.isAutonomous())		RobotMap.ledBlinkRate = 200;
    	else if(Robot.DS.isOperatorControl())	RobotMap.ledBlinkRate = 100;
    	else									RobotMap.ledBlinkRate = 0;
    	
    	if(Robot.DS.getAlliance() == DriverStation.Alliance.Red) {
    		RobotMap.redInt = 100.0;
    		RobotMap.greenInt = 0.0;
    		RobotMap.blueInt = 0.0;
    	}
    	else if(Robot.DS.getAlliance() == DriverStation.Alliance.Blue) {
    		RobotMap.redInt = 0.0;
    		RobotMap.greenInt = 0.0;
    		RobotMap.blueInt = 100.0;
    	}
    	else if(Robot.DS.getAlliance() == DriverStation.Alliance.Invalid) {
    		RobotMap.redInt = 100.0;
    		RobotMap.greenInt = 0.0;
    		RobotMap.blueInt = 100.0;
    	}
    	else {
    		RobotMap.redInt = 0.0;
    		RobotMap.greenInt = 100.0;
    		RobotMap.blueInt = 0.0;
    	}
    	
    	setRGB(RobotMap.redInt, RobotMap.greenInt, RobotMap.blueInt, RobotMap.ledBlinkRate);
    }
}

