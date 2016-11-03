package org.usfirst.frc.team3478.robot.commands;

import org.usfirst.frc.team3478.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class BreakerLift extends Command{
	public BreakerLift(){
		requires(Robot.robotBreaker);
	}
	
	@Override
	protected void initialize() {
		Robot.robotBreaker.stop();
		Robot.robotBreaker.setSpeed(0.2);
	}

	@Override
	protected void execute() {
		Robot.robotBreaker.setBreaker(Robot.oi.breakerFwdButton, Robot.oi.breakerRevButton);
	}

	@Override
	protected boolean isFinished() {
		return false;
	}

	@Override
	protected void end() {
		Robot.robotBreaker.stop();
	}

	@Override
	protected void interrupted() {
		
	}

}
