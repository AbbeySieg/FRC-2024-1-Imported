package frc.robot.commands.swervedrive.pivot;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.pivot.*;;

public class SetPivotCommand extends Command {
    private final PivotSubsystem pivot;
    private double pivotPower;

public SetPivotCommand(PivotSubsystem pivot, double pivotPower) {
    this.pivot = pivot;
    this.pivotPower = pivotPower;
}

@Override
public void execute() {
    pivot.changeAngle(pivotPower);
}

@Override
public boolean isFinished() {
    return true;
}
}

