// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.Subsystems;

import com.ctre.phoenix6.hardware.TalonFX;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class TransferSubsystem extends SubsystemBase {
  /** Creates a new TransferSubsystem. */
  private final TalonFX transferMotor = new TalonFX(Constants.kTransferMotorID, "static");
  public TransferSubsystem() {}

  public void setTransfer(double speed) {
    transferMotor.set(speed);
  }

  public Command DefaultCommand() {
    return run(
      () -> {
        transferMotor.set(0);
      }
    );
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
