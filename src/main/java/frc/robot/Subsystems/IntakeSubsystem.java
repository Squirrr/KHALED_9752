// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.Subsystems;

import com.ctre.phoenix6.configs.TalonFXConfiguration;
import com.ctre.phoenix6.hardware.TalonFX;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class IntakeSubsystem extends SubsystemBase {
  /** Creates a new IntakeSubsystem. */
  private final TalonFX intakeMotor = new TalonFX(Constants.kIntakeMotorPort, "static");
  private TalonFXConfiguration intakeConfig = new TalonFXConfiguration();

  public IntakeSubsystem() {
    intakeConfig.CurrentLimits.SupplyCurrentLimitEnable = true;
    intakeConfig.CurrentLimits.SupplyCurrentLimit = 40;

    intakeMotor.getConfigurator().apply(intakeConfig);
  }

  public void setIntakeSpeed(double speed){
    intakeMotor.set(speed);
  }

  public Command DefaultCommand() {
    return run(
      () -> {
        intakeMotor.set(0);
      });
  }

  public Command Intake() {
    return run(
      () -> {
        intakeMotor.set(1);
      });
  }

  public Command Outtake() {
    return run(
      () -> {
        intakeMotor.set(-1);
      });
  }
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
