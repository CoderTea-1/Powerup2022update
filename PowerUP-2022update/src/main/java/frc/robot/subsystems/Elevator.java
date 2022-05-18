// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.InvertType;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Elevator extends SubsystemBase {
  private final TalonSRX LeftElevatorMaster = new WPI_TalonSRX(Constants.LeftElevatorMaster);
  private final VictorSPX LeftElevatorSlave = new VictorSPX(Constants.LeftElevatorSlave);
  private final TalonSRX RightElevatorMaster = new WPI_TalonSRX(Constants.RightElevatorMaster);;
  private final VictorSPX RightElevatorSlave = new VictorSPX(Constants.RightElevatorMaster);;

  // private final VictorSPX LeftElevatorSlave = new
  // WPI_VictorSPX(Constants.LeftElevatorSlave);
  // private final TalonSRX RightElevatorMaster = new
  // WPI_TalonSRX(Constants.RightElevatorMaster);
  // private final VictorSPX RightElevatorSlave = new
  // WPI_VictorSPX(Constants.RightElevatorSlave);
  /** Creates a new Elevator. */
  public Elevator() {
    LeftElevatorMaster.setInverted(false);
    LeftElevatorSlave.setInverted(false);
    LeftElevatorSlave.follow(LeftElevatorMaster);
    RightElevatorMaster.setInverted(InvertType.InvertMotorOutput);
    RightElevatorSlave.follow(RightElevatorMaster);

    // RightElevatorSlave.setInverted(InvertType.FollowMaster);
  }

  public void elevatorDrive(double speed) {
    LeftElevatorMaster.set(ControlMode.PercentOutput, speed);
    RightElevatorMaster.set(ControlMode.PercentOutput, speed);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
