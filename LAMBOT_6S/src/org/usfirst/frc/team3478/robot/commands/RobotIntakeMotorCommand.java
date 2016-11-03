package org.usfirst.frc.team3478.robot.commands;

import org.usfirst.frc.team3478.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class RobotIntakeMotorCommand extends Command{
	public RobotIntakeMotorCommand(){
		requires(Robot.robotIntake);
	}
	
	@Override
	protected void initialize() {
		Robot.robotIntake.stopIntakeMotor();
	}

	@Override
	protected void execute() {
		Robot.robotIntake.setIntakeMotor(Robot.oi.joystick2.getY());
	}

	@Override
	protected boolean isFinished() {
		return false;
	}

	@Override
	protected void end() {
		Robot.robotIntake.stopIntakeMotor();
	}

	@Override
	protected void interrupted() {
		
	}

}
