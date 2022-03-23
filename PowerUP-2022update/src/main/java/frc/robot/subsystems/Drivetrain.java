// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;


import com.ctre.phoenix.motorcontrol.InvertType;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Drivetrain extends SubsystemBase {

  private final WPI_TalonSRX leftMaster = new WPI_TalonSRX(Constants.leftMaster);
  private final WPI_TalonSRX rightMaster = new WPI_TalonSRX(Constants.rightMaster);

  private final WPI_VictorSPX leftSlave1 = new WPI_VictorSPX(Constants.leftSlave1);
  private final WPI_VictorSPX rightSlave1 = new WPI_VictorSPX(Constants.rightSlave1);

  private final WPI_VictorSPX leftSlave2 = new WPI_VictorSPX(Constants.leftSlave2);
  private final WPI_VictorSPX rightSlave2 = new WPI_VictorSPX(Constants.rightSlave2);

  private final DifferentialDrive drive = new DifferentialDrive(leftMaster, rightMaster);


  
  /** Creates a new Drivetrain. */
  public Drivetrain() {
    leftSlave1.follow(leftMaster);
    leftSlave2.follow(leftMaster);

    rightSlave1.follow(rightMaster);
    rightSlave2.follow(rightMaster);

    // leftMaster.setInverted(false);
    // leftSlave1.setInverted(InvertType.FollowMaster);
    // leftSlave2.setInverted(InvertType.FollowMaster);
    // rightMaster.setInverted(true);
    // rightSlave1.setInverted(InvertType.FollowMaster);
    // rightSlave2.setInverted(InvertType.FollowMaster);

    //drive.setRightSideInverted(false);

  }
  
  public void arcadeDrive(double throttle, double turn) {
    drive.arcadeDrive(throttle, turn);

  }
  // public void ElevatorDrive(double throttle) {
  //   ElevatorDrive(throttle);
  // }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
