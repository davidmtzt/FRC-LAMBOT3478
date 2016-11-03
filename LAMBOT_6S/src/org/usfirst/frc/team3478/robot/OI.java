package org.usfirst.frc.team3478.robot;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

import org.usfirst.frc.team3478.robot.commands.ToggleIntakeLift;
import org.usfirst.frc.team3478.robot.commands.ShooterToggle;
import org.usfirst.frc.team3478.robot.subsystems.Breaker;
import org.usfirst.frc.team3478.robot.subsystems.Drive;
import org.usfirst.frc.team3478.robot.subsystems.Intake;
import org.usfirst.frc.team3478.robot.subsystems.Shooter;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
    //// CREATING BUTTONS
    // One type of button is a joystick button which is any button on a joystick.
    // You create one by telling it which joystick it's on and which button
    // number it is.
    // Joystick stick = new Joystick(port);
    // Button button = new JoystickButton(stick, buttonNumber);
    
    // There are a few additional built in buttons you can use. Additionally,
    // by subclassing Button you can create custom triggers and bind those to
    // commands the same as any other Button.
    
    //// TRIGGERING COMMANDS WITH BUTTONS
    // Once you have a button, it's trivial to bind it to a button in one of
    // three ways:
    
    // Start the command when the button is pressed and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenPressed(new ExampleCommand());
    
    // Run the command while the button is being held down and interrupt it once
    // the button is released.
    // button.whileHeld(new ExampleCommand());
    
    // Start the command when the button is released  and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenReleased(new ExampleCommand());
	public Joystick joystick1;
	public Joystick joystick2;
	/*
	 AnalogSticks->Drive RL & Intake
	 Buttons->IntakeSwitch(1), Shooter(1) & Breaker(2)
	 */
	public JoystickButton intakeHingeButton;
	public JoystickButton shooterSwitchButton;
	public JoystickButton breakerFwdButton;
	public JoystickButton breakerRevButton;
	
	public OI(){
		joystick1=new Joystick(0);
		joystick2=new Joystick(1);
		
		intakeHingeButton=new JoystickButton(joystick1, RobotMap.INTAKE_HINGE_BUTTON_AXIS);
		shooterSwitchButton=new JoystickButton(joystick2, RobotMap.SHOOTER_SWITCH_BUTTON_AXIS);
		breakerFwdButton=new JoystickButton(joystick1, RobotMap.BREAKER_FWD_BUTTON_AXIS);
		breakerRevButton=new JoystickButton(joystick1, RobotMap.BREAKER_REV_BUTTON_AXIS);
		
		intakeHingeButton.whenPressed(new ToggleIntakeLift());
		shooterSwitchButton.whenPressed(new ShooterToggle());
	}
}

