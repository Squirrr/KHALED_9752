// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.Subsystems;

import com.ctre.phoenix6.hardware.TalonFX;

import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.Constants.ShooterConstants;

public class TransferSubsystem extends SubsystemBase {
  /** Creates a new TransferSubsystem. */
  private final TalonFX transferMotor = new TalonFX(Constants.kTransferMotorPort);
  private Servo gate = new Servo(ShooterConstants.kGateServoPort);
  public TransferSubsystem() {}

  public void setTransferSpeed(double speed) {
    transferMotor.set(speed);
  }

  public void open() {
    gate.setPosition(0.6);
  }
  public void close() {
    gate.setPosition(0.0);
  }
  public Command DefaultCommand() {
    return run(
      () -> {
        transferMotor.set(0);
      }
    );
  }

  public Command setTransfer(double tSpeed) {
    return run(
      () -> {
        close();
        transferMotor.set(tSpeed);
      });
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
