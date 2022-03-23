// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.InvertType;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Elevator extends SubsystemBase {
  private final TalonSRX LeftElevatorMaster = new WPI_TalonSRX(Constants.LeftElevatorMaster);
  private final TalonSRX LeftElevatorSlave = new WPI_TalonSRX(Constants.LeftElevatorSlave); 
  private final TalonSRX RightElevatorMaster = new WPI_TalonSRX(Constants.RightElevatorMaster); 
  private final TalonSRX RightElevatorSlave = new WPI_TalonSRX(Constants.RightElevatorSlave);  
  /** Creates a new Elevator. */
  public Elevator() {
    LeftElevatorSlave.follow(LeftElevatorMaster);

    RightElevatorSlave.follow(RightElevatorMaster);
    RightElevatorMaster.setInverted(InvertType.InvertMotorOutput);
    RightElevatorSlave.setInverted(InvertType.FollowMaster);
  }
  public void elevatorDrive(double speed) {
    LeftElevatorMaster.set(ControlMode.PercentOutput, speed);
    RightElevatorMaster.set(ControlMode.PercentOutput,speed);

  }
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
