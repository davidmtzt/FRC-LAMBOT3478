package org.usfirst.frc.team3478.robot.commands;

import org.usfirst.frc.team3478.robot.Robot;
import org.usfirst.frc.team3478.robot.subsystems.Shooter;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.command.Command;

public class ShooterToggle extends Command{
	private Shooter shooter;
	private boolean isActive;
	public ShooterToggle(){
		isActive=false;
		this.requires(Robot.robotShooter);
	}
	@Override
	protected void initialize() {
		Robot.robotShooter.stopShooter();
		Robot.robotShooter.setSpeed(0.7);
	}

	@Override
	protected void execute() {
		if(isActive){
			Robot.robotShooter.stopShooter();
			isActive=false;
		}
		else{
			Robot.robotShooter.activateShooter();
			isActive=true;
		}
	}

	@Override
	protected boolean isFinished() {
		return true;
	}

	@Override
	protected void end() {
		
	}

	@Override
	protected void interrupted() {
		Robot.robotShooter.stopShooter();
	}

}
