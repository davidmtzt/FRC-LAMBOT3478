package org.usfirst.frc.team3478.robot.subsystems;

import org.usfirst.frc.team3478.robot.RobotMap;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Breaker extends Subsystem{
	private double speed;
	private CANTalon breakerMotor;
	
	public Breaker(){
		breakerMotor=RobotMap.BREAKER_MOTOR;
		speed=0.0;
	}
	
	public void setSpeed(double speed){
		this.speed=speed;
	}
	
	public void stop(){
		breakerMotor.set(0.0);
	}
	
	public void setBreaker(JoystickButton button1,JoystickButton button2){
		if(button1.get()){
			breakerMotor.set(speed);
		}
		else if(button2.get()){
			breakerMotor.set(-speed);
		}
		else{
			breakerMotor.set(0.0);
		}
	}
	
	@Override
	protected void initDefaultCommand() {
		
	}

}
