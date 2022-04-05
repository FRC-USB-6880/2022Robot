// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import java.util.function.Supplier;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Launcher;

public class LauncherTeleopCommand extends CommandBase {
  private final Launcher m_launcher;
  private final Supplier<Integer> m_povSupplier;
  /** Creates a new LauncherTeleopCommand. */
  public LauncherTeleopCommand(Launcher launcher, Supplier<Integer> povSupplier) {
    m_launcher = launcher;
    m_povSupplier = povSupplier;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(m_launcher);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    int povValue = m_povSupplier.get();
    if (povValue == 180) {
      m_launcher.launchHigh();
    } else if (povValue == 0) {
      m_launcher.launchLow();
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
