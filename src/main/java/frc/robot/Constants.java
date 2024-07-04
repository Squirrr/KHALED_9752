// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import com.ctre.phoenix6.controls.PositionVoltage;

/** Add your docs here. */
public final class Constants {

        public static class Conversions {

                public static double falconToDegrees(double counts, double gearRatio) {
                        return counts * (360.0 / (gearRatio * 2048.0));
                }
                public static double degreesToFalcon(double degrees, double gearRatio) {
                        return degrees / (360.0 / (gearRatio * 2048.0));
                }
        }

        public static final int kIntakeMotorPort = 15;
        public static final int kTransferMotorPort = 20;

        public static class ShooterConstants{
                public static final int kLeftShooterMotorPort = 20;
                public static final int kRightShooterMotorPort = 21;
                public static final int kPivotMotorPort = 0;
                public static final int kGateServoPort = 9;

                // public static final int[] kPivotEncoderPort = {0,0};
                // public static final boolean kEncoderReversed = false;
        }
        

}
