// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.Commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Subsystems.IntakeSubsystem;
import frc.robot.Subsystems.TransferSubsystem;

public class SmartIntakeCommand extends Command {
  /** Creates a new TransferCommand. */
  private TransferSubsystem transfer;
  private IntakeSubsystem intake;
  public SmartIntakeCommand(TransferSubsystem t, IntakeSubsystem i) {
    transfer = t;
    intake = i;
    // this.intake = intake;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(transfer);
    // addRequirements(intake);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    transfer.close();
    intake.Intake();
    transfer.setTransfer(1);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
