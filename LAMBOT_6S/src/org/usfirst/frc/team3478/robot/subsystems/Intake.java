package org.usfirst.frc.team3478.robot.subsystems;

import org.usfirst.frc.team3478.robot.RobotMap;
import org.usfirst.frc.team3478.robot.commands.ToggleIntakeLift;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Intake extends Subsystem{
	private boolean active;
	private CANTalon intakeMotor;
	private Solenoid intakeSolenoid1;
	
	public Intake(){
		intakeMotor=RobotMap.INTAKE_MOTOR;
		intakeSolenoid1=RobotMap.INTAKE_SOLENOID1;
	}
	
	public void stopIntakeMotor(){
		intakeMotor.set(0.0);
	}
	
	public void setIntakeMotor(double joystickAxisInput){
		if(joystickAxisInput>0.15){

		}
		else if(joystickAxisInput<-0.15){
		
		}
		else{
			intakeMotor.set(0.0);
		}
	}
	
	public void liftIntake(){
		intakeSolenoid1.set(false);
	}
	
	public void lowerIntake(){
		intakeSolenoid1.set(true);
	}
	
	public void toggleIntakeLift(){
		if(intakeSolenoid1.get()){
			intakeSolenoid1.set(false);
		}
		else{
			intakeSolenoid1.set(true);
		}
	}
	@Override
	protected void initDefaultCommand() {
		
	}

}
