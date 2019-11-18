package frc.robot;

import frc.robot.commands.*;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import frc.robot.utilities.F310Controller;
//import frc.robot.subsystems.*;


/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
    public JoystickButton brakeButton, liftButton, debugButton, suckButton, spitButton;
    public F310Controller driveStick, manipulatorStick;

    public OI() {
        //driveStick is plugged into the first USB port
        driveStick = new F310Controller(0);
        
        //Use the B Button to activate the brakes
        brakeButton = new JoystickButton(driveStick, 2);
        brakeButton.whileActive(new Brakes());
        
        //Use the R3 Button to activate the Lifter
        liftButton = new JoystickButton(driveStick, 10);
        liftButton.whileActive(new Lifter());
        
        //Use the X Button to activate Debug Output
        debugButton = new JoystickButton(driveStick, 3);
        debugButton.toggleWhenPressed(new DebugOutput());
        
        //manipulatorStick is plugged into the second USB port
        manipulatorStick = new F310Controller(1);

        //Use the X Button to activate the Ball Input mechanism
        suckButton = new JoystickButton(manipulatorStick, 3);
        suckButton.whileActive(new SuckBall());

        //Use the Y Button to activate the Ball Output mechanism
        spitButton = new JoystickButton(manipulatorStick, 4);
        spitButton.whileActive(new SpitBall());

        //Place buttons on the dashboard for resetting the Encoders and Gyroscope
        SmartDashboard.putData("ResetEncoders", new ResetEncoders());
        SmartDashboard.putData("ResetGyro", new ResetGyro());
    }

    //Pass on a copy of the driveStick
    public F310Controller getDriveStick() {
        return driveStick;
    }

    //Pass on a copy of the manipulatorStick
    public F310Controller getManipulatorStick() {
        return manipulatorStick;
    }
}
