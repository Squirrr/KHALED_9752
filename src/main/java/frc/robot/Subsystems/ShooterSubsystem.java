// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.Subsystems;

import com.ctre.phoenix6.hardware.TalonFX;

import edu.wpi.first.wpilibj.motorcontrol.Spark;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.Constants.Conversions;
import frc.robot.Constants.ShooterConstants;

public class ShooterSubsystem extends SubsystemBase {
  /** Creates a new ShooterSubsystem. */
  private final Spark leftShooterMotor = new Spark(ShooterConstants.kLeftShooterMotorID);
  private final Spark rightShooterMotor = new Spark(ShooterConstants.kRightShooterMotorID);
  private final TalonFX pivotMotor = new TalonFX(ShooterConstants.kPivotMotorID, "static");

  public ShooterSubsystem() {}

  public void shoot(double speed) {
    leftShooterMotor.set(speed);
    rightShooterMotor.set(-1*speed);
  }

  public void pivotToAngle(double angle) {}

  
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
