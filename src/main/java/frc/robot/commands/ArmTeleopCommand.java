// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import java.util.function.Supplier;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.IntakeArm;

public class ArmTeleopCommand extends CommandBase {
  private final IntakeArm m_arm;
  private final Supplier<Double> m_leftTriggerAxisSupplier;
  private final Supplier<Double> m_rightTriggerAxisSupplier;
  /** Creates a new ArmTeleopCommand. */
  public ArmTeleopCommand(IntakeArm arm, 
      Supplier<Double> leftTriggerSupplier,
      Supplier<Double> rightTriggerSupplier) {
    m_arm = arm;
    m_leftTriggerAxisSupplier = leftTriggerSupplier;
    m_rightTriggerAxisSupplier = rightTriggerSupplier;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(m_arm);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    if (m_rightTriggerAxisSupplier.get() > 0) {
      m_arm.closeArm();
    } else if (m_leftTriggerAxisSupplier.get() > 0) {
      m_arm.openArm();
    }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
