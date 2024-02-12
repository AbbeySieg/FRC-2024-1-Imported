package frc.robot.subsystems.superstructure;

//import frc.robot.subsystems.Elevator.ElevatorSubsystem.ElevatorState;
//import frc.robot.subsystems.Intake.IntakeSubsystem.IntakeState;
//import frc.robot.subsystems.Feeder.FeederSubsystem.FeederState;
import frc.robot.subsystems.shooter.ShooterSubsystem.ShooterState;
//import frc.robot.subsystems.Climber.ClimberSubsystem.ClimberState;


public enum SuperState {

    /*
    States of Subsystems
    Intake - RETRACTED/EXTENDED
    Elevator - MAXANGLE/MIDANGLE/MINANGLE
    Feeder - FORWARD, OFF, REVERSE
    Shooter - HIGHPOWER, MIDPOWER, LOWPOWER, REVERSEDINTAKE, OFF
    Climber - RETRACTED/EXTENDED
     */
    SAFE(0,
         ShooterState.OFF),
    //GROUND_INTAKE(1,
    //        IntakeState.EXTENDED, FeederState.FORWARD, ElevatorState.MINANGLE, ShooterState.OFF, ClimberState.RETRACTED),
    //SOURCE_INTAKE(2,
          //  IntakeState.RETRACTED, FeederState.OFF, ElevatorState.MAXANGLE, ShooterState.REVERSEDINTAKE, ClimberState.RETRACTED),
    SCORE_AMP_SETUP(3,
             ShooterState.LOWPOWER),
    SCORE_SPEAKER_SETUP(4,
             ShooterState.MIDPOWER),
    SCORE_STAGE_PROTECTED_SETUP (5,
           ShooterState.HIGHPOWER),
    //CLIMB_REACH(6,
    //        IntakeState.RETRACTED, FeederState.OFF, ElevatorState.MINANGLE, ShooterState.OFF, ClimberState.EXTENDED),
    SHOOT_AMP(7,
          ShooterState.LOWPOWER),

    SHOOT_SPEAKER(8,
           ShooterState.MIDPOWER),

    SHOOT_PROTECTED(9,
             ShooterState.HIGHPOWER);

    public final int idx;
    //public final IntakeState intake;
    //public final FeederState feed;
//
    //public final ElevatorState elevator;
    public final ShooterState shoot;
    //public final ClimberState climb;

    private SuperState(int idx,  ShooterState shoot){
        this.idx = idx;
       
        this.shoot = shoot;
        
    }
}