package org.usfirst.frc.team3478.robot.subsystems;

import org.usfirst.frc.team3478.robot.RobotMap;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Drive extends Subsystem{
	private boolean inverted;
	
	private CANTalon driveL1;
	private CANTalon driveL2;
	private CANTalon driveR1;
	private CANTalon driveR2;
	
	private double xAxisInput;
	private double lTriggerInput;
	private double rTriggerInput;
	private double outputSpeed;
	
	private double leftMotorSpeed;
	private double rightMotorSpeed;
	
	
	public Drive(){
		driveL1=RobotMap.DRIVE_L1_MOTOR;
		driveL2=RobotMap.DRIVE_L2_MOTOR;
		driveR1=RobotMap.DRIVE_R1_MOTOR;
		driveR2=RobotMap.DRIVE_R2_MOTOR;
		resetDirection();
	}
	
	public void resetDirection(){
		inverted=false;
	}
	
	public void stop(){
		driveL1.set(0.0);
		driveL2.set(0.0);
		driveR1.set(0.0);
		driveR2.set(0.0);
	}
	
	private double mapSpeed(double input, double minInput, double maxInput){
		if(input < minInput)
			return minInput;
		if(input > maxInput)
			return maxInput;
		return (input - minInput) / (maxInput - minInput);
	}
	
	private double groundSpeed(double speed, double lowerBoundSpeed, double upperBoundSpeed){
		if(speed < lowerBoundSpeed)
			return 0.0;
		if(speed > upperBoundSpeed)
			return upperBoundSpeed;
		return speed;
	}
	
	public void drive(Joystick xBoxController){
		xAxisInput=xBoxController.getRawAxis(RobotMap.XBOX_DRIVE_X_AXIS);
		if(inverted)
			xAxisInput*=-1;
		
		lTriggerInput=xBoxController.getRawAxis(RobotMap.XBOX_CONTROLLER_L_TRIGGER_AXIS);
		rTriggerInput=xBoxController.getRawAxis(RobotMap.XBOX_CONTROLLER_L_TRIGGER_AXIS);
		
		leftMotorSpeed=0.0;
		rightMotorSpeed=0.0;
		
		if(lTriggerInput > RobotMap.LOWER_TRIGGER_BOUND || rTriggerInput > RobotMap.LOWER_TRIGGER_BOUND){
			leftMotorSpeed-=mapSpeed(lTriggerInput, RobotMap.LOWER_TRIGGER_BOUND, 1.0);
			rightMotorSpeed-=mapSpeed(lTriggerInput, RobotMap.LOWER_TRIGGER_BOUND, 1.0);
			if(rTriggerInput > RobotMap.LOWER_TRIGGER_BOUND){
				leftMotorSpeed=groundSpeed(leftMotorSpeed+mapSpeed(rTriggerInput, RobotMap.LOWER_TRIGGER_BOUND, RobotMap.UPPER_TRIGGER_BOUND), 0.0, 1.0);
				rightMotorSpeed=groundSpeed(leftMotorSpeed+mapSpeed(rTriggerInput, RobotMap.LOWER_TRIGGER_BOUND,  RobotMap.UPPER_TRIGGER_BOUND), 0.0, 1.0);
			}
			if(xAxisInput < RobotMap.LEFT_JOYSTICK_BOUND){
				leftMotorSpeed*=mapSpeed(xAxisInput, RobotMap.FAR_LEFT_JOYSTICK_BOUND, RobotMap.LEFT_JOYSTICK_BOUND);
			}
			if(xAxisInput > RobotMap.RIGHT_JOYSTICK_BOUND){
				leftMotorSpeed*=1.0-mapSpeed(xAxisInput, RobotMap.RIGHT_JOYSTICK_BOUND, RobotMap.FAR_RIGHT_JOYSTICK_BOUND);
			}
		}
		else{
			if(xAxisInput < RobotMap.LEFT_JOYSTICK_BOUND){
				leftMotorSpeed=mapSpeed(xAxisInput, -1.0, RobotMap.LEFT_JOYSTICK_BOUND);
				rightMotorSpeed=-mapSpeed(xAxisInput, -1.0, RobotMap.LEFT_JOYSTICK_BOUND);
			}
			if(xAxisInput > RobotMap.RIGHT_JOYSTICK_BOUND){
				leftMotorSpeed=-mapSpeed(xAxisInput, RobotMap.RIGHT_JOYSTICK_BOUND, 1.0);
				rightMotorSpeed=mapSpeed(xAxisInput, RobotMap.RIGHT_JOYSTICK_BOUND, 1.0);
			}
		}
		
		
		driveL1.set(leftMotorSpeed);
		driveL2.set(leftMotorSpeed);
		driveR1.set(rightMotorSpeed);
		driveR2.set(rightMotorSpeed);
		/*if(side == RobotMap.LEFT_DRIVE){
			if(joystickAxisValue > RobotMap.UPPER_JOYSTICK_LIMIT){
				driveL1.set((joystickAxisValue-RobotMap.UPPER_JOYSTICK_LIMIT)/(0.9-RobotMap.UPPER_JOYSTICK_LIMIT));
				driveL2.set((joystickAxisValue-RobotMap.UPPER_JOYSTICK_LIMIT)/(0.9-RobotMap.UPPER_JOYSTICK_LIMIT));
			}
			else if(joystickAxisValue < RobotMap.LOWER_JOYSTICK_LIMIT){
				driveL1.set(-((joystickAxisValue-RobotMap.LOWER_JOYSTICK_LIMIT)/(-0.9-RobotMap.LOWER_JOYSTICK_LIMIT)));
				driveL2.set(-((joystickAxisValue-RobotMap.LOWER_JOYSTICK_LIMIT)/(-0.9-RobotMap.LOWER_JOYSTICK_LIMIT)));
			}
			else{
				driveL1.set(0.0);
				driveL2.set(0.0);
			}
		}
		else if(side == RobotMap.RIGHT_DRIVE){
			if(joystickAxisValue > RobotMap.UPPER_JOYSTICK_LIMIT){
				driveR1.set((joystickAxisValue-RobotMap.UPPER_JOYSTICK_LIMIT)/(0.9-RobotMap.UPPER_JOYSTICK_LIMIT));
				driveR2.set((joystickAxisValue-RobotMap.UPPER_JOYSTICK_LIMIT)/(0.9-RobotMap.UPPER_JOYSTICK_LIMIT));
			}
			else if(joystickAxisValue < RobotMap.LOWER_JOYSTICK_LIMIT){
				driveR1.set(-((joystickAxisValue-RobotMap.LOWER_JOYSTICK_LIMIT)/(-0.9-RobotMap.LOWER_JOYSTICK_LIMIT)));
				driveR2.set(-((joystickAxisValue-RobotMap.LOWER_JOYSTICK_LIMIT)/(-0.9-RobotMap.LOWER_JOYSTICK_LIMIT)));
			}
			else{
				driveR1.set(0.0);
				driveR2.set(0.0);
			}
		}*/
	}
	
	@Override
	protected void initDefaultCommand() {
		
	}
}
