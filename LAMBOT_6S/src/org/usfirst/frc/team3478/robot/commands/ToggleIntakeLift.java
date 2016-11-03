package org.usfirst.frc.team3478.robot.commands;

import org.usfirst.frc.team3478.robot.Robot;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Command;

public class ToggleIntakeLift extends Command{
	public ToggleIntakeLift(){
		requires(Robot.robotIntake);
	}
	
	@Override
	protected void initialize() {
		
	}

	@Override
	protected void execute() {
		Robot.robotIntake.toggleIntakeLift();
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
		
	}

}
