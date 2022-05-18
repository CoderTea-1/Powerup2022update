// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Intake extends SubsystemBase {
  private final VictorSPX LeftIntake = new VictorSPX(Constants.LeftIntake);
  private final VictorSPX RightIntake = new VictorSPX(Constants.RightIntake);

  /** Creates a new Intake. */
  public Intake() {
    LeftIntake.setInverted(false);
    RightIntake.setInverted(true);
  }

  public void intakeRun(double speed) {
    LeftIntake.set(ControlMode.PercentOutput, speed);
    RightIntake.set(ControlMode.PercentOutput, speed);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
