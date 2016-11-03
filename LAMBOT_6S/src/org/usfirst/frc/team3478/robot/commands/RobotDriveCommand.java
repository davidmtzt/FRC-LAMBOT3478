package org.usfirst.frc.team3478.robot.commands;

import org.usfirst.frc.team3478.robot.Robot;
import org.usfirst.frc.team3478.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

public class RobotDriveCommand extends Command{
	
	public RobotDriveCommand(){
		requires(Robot.robotDrive);
	}
	
	@Override
	protected void initialize() {
		Robot.robotDrive.stop();
	}

	@Override
	protected void execute() {
		Robot.robotDrive.drive(Robot.oi.joystick1);
	}

	@Override
	protected boolean isFinished() {
		return false;
	}

	@Override
	protected void end() {
		Robot.robotDrive.stop();
	}

	@Override
	protected void interrupted() {
	}

}
