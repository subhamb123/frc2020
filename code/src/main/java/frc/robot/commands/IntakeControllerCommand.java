package frc.robot.commands;

import com.google.inject.Inject;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.GenericHID.*;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import frc.robot.common.*;

public class IntakeControllerCommand extends TraceableCommand {

    private final IIntakeSubsystem _intake;
    private final XboxController _controller;

    @Inject

    public IntakeControllerCommand(final ILogger logger, IIntakeSubsystem intakeSubsystem) {
        super(logger);
        _intake = intakeSubsystem;
        _controller = new XboxController(1);
        addRequirements(_intake);

    }

    public void initialize() {
        super.initialize();
    }

    public void execute() {

        if (_controller.getBumper(Hand.kLeft)) {
            _intake.spinIntake();
        } else if (_controller.getBumper(Hand.kRight)) {
            _intake.spinOutake();
        } else {
            _intake.stopIntake();
        }
        if (_controller.getBackButton()) {
            _intake.raiseArm();
        } else if (_controller.getStartButton()) {
            _intake.lowerArm();
        }
    }

    public void raiseArm (){

    }

    public void lowerArm (){

    }

    public void stopArm (){
        
    }

    public boolean isFinished() {
        return false;
    }
}