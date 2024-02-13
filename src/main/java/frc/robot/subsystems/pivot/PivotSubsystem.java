package frc.robot.subsystems.pivot;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkLowLevel;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.SparkPIDController;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.subsystems.shooter.ShooterSubsystem.PIDF;

import java.util.function.DoubleSupplier;

public class PivotSubsystem extends SubsystemBase{
    private final CANSparkMax leftpivot;
    private final CANSparkMax rightpivot;

    private double targetAngle;

    private final SparkPIDController PIDController;
    private final RelativeEncoder rightEncoder;
    private final RelativeEncoder leftEncoder;

public PivotSubsystem() {
    leftpivot = new CANSparkMax(Constants.PivotConstants.leftpivotID, CANSparkLowLevel.MotorType.kBrushless);
    rightpivot = new CANSparkMax(Constants.PivotConstants.rightpivotID, CANSparkLowLevel.MotorType.kBrushless);
    leftpivot.restoreFactoryDefaults();
    rightpivot.restoreFactoryDefaults();
    leftpivot.follow(rightpivot);
    rightpivot.setInverted(true);
    leftpivot.setIdleMode(CANSparkMax.IdleMode.kBrake);
    rightpivot.setIdleMode(CANSparkMax.IdleMode.kBrake);
    rightEncoder = rightpivot.getEncoder();
    leftEncoder = leftpivot.getEncoder();
    PIDController = rightpivot.getPIDController();
    PIDController.setFeedbackDevice(rightEncoder);
    set(PIDF.PORPORTION, PIDF.INTEGRAL, PIDF.DERIVATIVE, PIDF.FEEDFORWARD, PIDF.INTEGRAL_ZONE);

    
}

public static class PIDF {
   /**
         * Feedforward constant for PID loop
         */
        public static final double FEEDFORWARD = 0.01;
        /**
         * Proportion constant for PID loop
         */
        public static final double PROPORTION = 0.05;
        /**
         * Integral constant for PID loop
         */
        public static final double INTEGRAL = 0.0;
        /**
         * Derivative constant for PID loop
         */
        public static final double DERIVATIVE = 0.0;
        /**
         * Integral zone constant for PID loop
         */
        public static final double INTEGRAL_ZONE = 0.0; 
}

public void changeAngle(double pivotPower) {
    rightpivot.set(pivotPower);
}

public void stop() {
    rightpivot.set(0);
}

public double getAngle() {
    return rightEncoder.getPosition()*360;
}

public void set(double p, double i, double d, double f, double iz)
    {
        PIDController.setP(p);
        PIDController.setI(i);
        PIDController.setD(d);
        PIDController.setFF(f);
        PIDController.setIZone(iz);
    }

public void runPID(double targetPosition) {
        PIDController.setReference(targetPosition, CANSparkMax.ControlType.kPosition);
    }

public Command setAngle(double degrees) {
    targetAngle = degrees;
    return run(() -> {
        runPID(degrees);
    });
}

public Command runManual(DoubleSupplier supplier) {
    double power = supplier.getAsDouble();
    return run(() -> {
        changeAngle(power);
    });

}

public enum PivotState {
    MAXANGLE(80),
    MIDANGLE(50),
    MINANGLE(30);

    public double angle;

    private PivotState(double angle) {
        this.angle = angle;
    }
}

@Override
public void periodic() {
    
}
}