package org.usfirst.frc.team3478.robot;

import org.usfirst.frc.team3478.robot.subsystems.Breaker;
import org.usfirst.frc.team3478.robot.subsystems.Drive;
import org.usfirst.frc.team3478.robot.subsystems.Intake;
import org.usfirst.frc.team3478.robot.subsystems.Shooter;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
    // For example to map the left and right motors, you could define the
    // following variables to use with your drivetrain subsystem.
    // public static int leftMotor = 1;
    // public static int rightMotor = 2;
    
    // If you are using multiple modules, make sure to define both the port
    // number and the module. For example you with a rangefinder:
    // public static int rangefinderPort = 1;
    // public static int rangefinderModule = 1;
	/*
	JoystickButton intakePivotButton;
	JoystickButton shooterSwitchButton;
	JoystickButton breakerFwdButton;
	JoystickButton breakerRevButton;
	
	CANTalon driveL1;
	CANTalon driveL2;
	CANTalon driveR1;
	CANTalon driveR2;

	CANTalon intake;
	
	CANTalon breaker;
	
	CANTalon shooter1;
	CANTalon shooter2;
	 */
	// Controller sensitivity constants
	public static final double LEFT_JOYSTICK_BOUND=-0.15;
	public static final double RIGHT_JOYSTICK_BOUND=0.15;
	public static final double FAR_LEFT_JOYSTICK_BOUND=-0.95;
	public static final double FAR_RIGHT_JOYSTICK_BOUND=0.95;
	
	
	
	public static final double LOWER_TRIGGER_BOUND=-1.1;
	public static final double UPPER_TRIGGER_BOUND=1.0;
	
	// Controller axes constants
	public static final int XBOX_DRIVE_X_AXIS=0;
	public static final int XBOX_CONTROLLER_L_TRIGGER_AXIS=2;
	public static final int XBOX_CONTROLLER_R_TRIGGER_AXIS=3;
	
	
	// Button index constants
	public static final int INTAKE_HINGE_BUTTON_AXIS=1;
	public static final int SHOOTER_SWITCH_BUTTON_AXIS=2;
	public static final int BREAKER_FWD_BUTTON_AXIS=3;
	public static final int BREAKER_REV_BUTTON_AXIS=4;
	// Drive CANTalon port constants
	public static final int DRIVE_L1_MOTOR_PORT=2;
	public static final int DRIVE_L2_MOTOR_PORT=3;
	public static final int DRIVE_R1_MOTOR_PORT=0;
	public static final int DRIVE_R2_MOTOR_PORT=1;
	// Mechanism CANTalon port constants
	public static final int INTAKE_MOTOR_PORT=6;
	public static final int BREAKER_MOTOR_PORT=7;
	public static final int SHOOTER_MOTOR_PORT1=4;
	public static final int SHOOTER_MOTOR_PORT2=5;
	// Mechanism PCM solenoid port constants
	public static final int INTAKE_PISTON1_VALVE_PORT=0;
	public static final int INTAKE_PISTON2_VALVE_PORT=1;
	// Drive side operation constants
	public static final int LEFT_DRIVE=0;
	public static final int RIGHT_DRIVE=1;
	
	public static CANTalon DRIVE_L1_MOTOR;
	public static CANTalon DRIVE_L2_MOTOR;
	public static CANTalon DRIVE_R1_MOTOR;
	public static CANTalon DRIVE_R2_MOTOR;
	
	public static CANTalon INTAKE_MOTOR;
	public static CANTalon SHOOTER_MOTOR1;
	public static CANTalon SHOOTER_MOTOR2;
	public static CANTalon BREAKER_MOTOR;
	
	public static Solenoid INTAKE_SOLENOID1;
	public static Solenoid INTAKE_SOLENOID2;
	
	public static Compressor COMPRESSOR;
	
	
	
	public static void init(){
		DRIVE_L1_MOTOR = new CANTalon(DRIVE_L1_MOTOR_PORT);
		DRIVE_L2_MOTOR = new CANTalon(DRIVE_L2_MOTOR_PORT);
		DRIVE_R1_MOTOR = new CANTalon(DRIVE_R1_MOTOR_PORT);
		DRIVE_R2_MOTOR = new CANTalon(DRIVE_R2_MOTOR_PORT);
		
		INTAKE_MOTOR = new CANTalon(INTAKE_MOTOR_PORT);
		SHOOTER_MOTOR1 = new CANTalon(SHOOTER_MOTOR_PORT1);
		SHOOTER_MOTOR2 = new CANTalon(SHOOTER_MOTOR_PORT2);
		BREAKER_MOTOR = new CANTalon(BREAKER_MOTOR_PORT);
		
		INTAKE_SOLENOID1 = new Solenoid(INTAKE_PISTON1_VALVE_PORT);
		INTAKE_SOLENOID2 = new Solenoid(INTAKE_PISTON2_VALVE_PORT);
		
		COMPRESSOR = new Compressor(0);
	}
}
