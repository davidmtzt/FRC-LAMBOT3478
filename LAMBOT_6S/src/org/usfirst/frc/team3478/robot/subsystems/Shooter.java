package org.usfirst.frc.team3478.robot.subsystems;

import org.usfirst.frc.team3478.robot.RobotMap;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.command.Subsystem;
public class Shooter extends Subsystem{
	private CANTalon shooterMotor1;
	private CANTalon shooterMotor2;
	private double speed;
	
	public Shooter(){
		shooterMotor1=RobotMap.SHOOTER_MOTOR1;
		shooterMotor2=RobotMap.SHOOTER_MOTOR2;
		speed=0.0;
	}
	
	public void setSpeed(double speed){
		this.speed=speed;
	}
	
	public void activateShooter(){
		shooterMotor1.set(speed);
		shooterMotor2.set(-speed);
	}
	
	public void stopShooter(){
		shooterMotor1.set(0.0);
		shooterMotor2.set(0.0);
	}
	
	@Override
	protected void initDefaultCommand() {
		
	}

}
