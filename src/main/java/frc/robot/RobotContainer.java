// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.PS5Controller;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.button.CommandPS5Controller;
import frc.robot.Commands.IntakeCommand;
import frc.robot.Commands.OuttakeCommand;
import frc.robot.Commands.ShootCommand;
import frc.robot.Commands.SmartIntakeCommand;
import frc.robot.Subsystems.IntakeSubsystem;
import frc.robot.Subsystems.ShooterSubsystem;
import frc.robot.Subsystems.TransferSubsystem;

public class RobotContainer {
  public IntakeSubsystem intake = new IntakeSubsystem();
  public TransferSubsystem transfer = new TransferSubsystem();
  public ShooterSubsystem shooter = new ShooterSubsystem();


  private final CommandPS5Controller base = new CommandPS5Controller(0);
  public RobotContainer() {
    
    intake.setDefaultCommand(intake.DefaultCommand());
    transfer.setDefaultCommand(transfer.DefaultCommand());
    shooter.setDefaultCommand(shooter.DefaultCommand());
    configureBindings();
  }

  private void configureBindings() {

    base.R1().whileTrue(new SmartIntakeCommand(transfer, intake));
    // base.R1().whileTrue(intake.Intake().alongWith(transfer.Transfer()));
    base.L1().whileTrue(intake.Outtake());

    base.R2().whileTrue(transfer.setTransfer(-0.2).withTimeout(0.5)
    .andThen(new ShootCommand(shooter, transfer)));
  }

  public Command getAutonomousCommand() {
    return Commands.print("No autonomous command configured");
  }
}
