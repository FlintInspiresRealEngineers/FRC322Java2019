package frc.robot;

import frc.robot.commands.*;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import frc.robot.subsystems.*;
import frc.robot.utilities.F310Controller;


/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
    public JoystickButton brakeButton, liftButton, debugButton, suckButton, spitButton;
    public F310Controller driveStick, manipulatorStick;

    public OI() {
        driveStick = new F310Controller(0);
        brakeButton = new JoystickButton(driveStick, 2);
        brakeButton.whileActive(new Brakes());
        liftButton = new JoystickButton(driveStick, 10);
        liftButton.whileActive(new Lifter());
        debugButton = new JoystickButton(driveStick, 3);
        debugButton.toggleWhenPressed(new DebugOutput());
        manipulatorStick = new F310Controller(1);
        suckButton = new JoystickButton(manipulatorStick, 3);
        suckButton.whileActive(new SuckBall());
        spitButton = new JoystickButton(manipulatorStick, 4);
        spitButton.whileActive(new SpitBall());
        SmartDashboard.putData("ResetEncoders", new ResetEncoders());
        SmartDashboard.putData("ResetGyro", new ResetGyro());
    }

    public F310Controller getDriveStick() {
        return driveStick;
    }

    public F310Controller getManipulatorStick() {
        return manipulatorStick;
    }
}
