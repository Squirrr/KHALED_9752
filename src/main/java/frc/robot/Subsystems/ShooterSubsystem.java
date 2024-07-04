// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.Subsystems;

import com.ctre.phoenix6.hardware.TalonFX;
import com.revrobotics.CANSparkFlex;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.SparkPIDController;
import com.revrobotics.CANSparkLowLevel.MotorType;
import com.revrobotics.CANSparkMax;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.motorcontrol.Spark;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.Constants.Conversions;
import frc.robot.Constants.ShooterConstants;

public class ShooterSubsystem extends SubsystemBase {
  /** Creates a new ShooterSubsystem. */
  private final CANSparkFlex leftShooter = new CANSparkFlex(ShooterConstants.kLeftShooterMotorPort, MotorType.kBrushless);
  private final CANSparkFlex rightShooter = new CANSparkFlex(ShooterConstants.kRightShooterMotorPort, MotorType.kBrushless);
  private final TalonFX pivotMotor = new TalonFX(ShooterConstants.kPivotMotorPort, "static");
  
  private final RelativeEncoder leftShooterEncoder;
  private final RelativeEncoder rightShooterEncoder;
  
  private SparkPIDController left_pidController;
  private SparkPIDController right_pidController;

  public double desiredShooterSpeed;
  public boolean speedReached = false;

  public ShooterSubsystem() {
    rightShooter.restoreFactoryDefaults();
    leftShooter.restoreFactoryDefaults();

    leftShooterEncoder  = leftShooter.getEncoder();
    rightShooterEncoder  = rightShooter.getEncoder();
    left_pidController = leftShooter.getPIDController();
    right_pidController = rightShooter.getPIDController();


    leftShooter.setSmartCurrentLimit(80);
    rightShooter.setSmartCurrentLimit(80);

    right_pidController.setP(0.001);
    right_pidController.setI(0);
    right_pidController.setD(0.00);
    right_pidController.setFF(0.0002);
    right_pidController.setOutputRange(0, 6000);

    left_pidController.setP(0.001);
    left_pidController.setI(0);
    left_pidController.setD(0.0);
    left_pidController.setFF(0.0002);
    left_pidController.setOutputRange(0, 6000);

    rightShooterEncoder.setMeasurementPeriod(20);
    rightShooterEncoder.setAverageDepth(4);

    leftShooterEncoder.setMeasurementPeriod(20);
    leftShooterEncoder.setAverageDepth(4);

    rightShooter.burnFlash();
    leftShooter.burnFlash();
  }

  public void set(double rightFlyWheelRPM, double leftFlyWheelRPM){
    desiredShooterSpeed = rightFlyWheelRPM;
    right_pidController.setReference(rightFlyWheelRPM, CANSparkMax.ControlType.kVelocity);
    left_pidController.setReference(leftFlyWheelRPM, CANSparkMax.ControlType.kVelocity);
  }

  public void pivotToAngle(double angle) {}

  public Command DefaultCommand() {
    return run(
      () -> {
        leftShooter.set(0);
        rightShooter.set(0);

      }
    );
  }
  
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    speedReached = (rightShooterEncoder.getVelocity() > 4000 ? true : false);
  }
}
