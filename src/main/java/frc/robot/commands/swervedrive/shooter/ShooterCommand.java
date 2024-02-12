package frc.robot.commands.swervedrive.shooter;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.shooter.ShooterSubsystem;

public class ShooterCommand extends Command {
    private final ShooterSubsystem shooter;
    private double power;

public ShooterCommand(ShooterSubsystem shooter, double power) {
    this.shooter = shooter;
    this.power = power;
}

@Override
public void execute() {
    shooter.shoot(power);
}

@Override
public boolean isFinished() {
    return true;
    }   
}

