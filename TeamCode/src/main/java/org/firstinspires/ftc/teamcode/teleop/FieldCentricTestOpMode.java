package org.firstinspires.ftc.teamcode.teleop;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.seattlesolvers.solverslib.command.CommandBase;
import com.seattlesolvers.solverslib.command.CommandOpMode;
import com.seattlesolvers.solverslib.gamepad.GamepadEx;
import com.seattlesolvers.solverslib.gamepad.GamepadKeys;

import java.util.function.DoubleSupplier;

import org.firstinspires.ftc.teamcode.subsystems.Flywheel;
import org.firstinspires.ftc.teamcode.subsystems.Intake;
import org.firstinspires.ftc.teamcode.subsystems.MecanumDriveReal;


@TeleOp(name = "Field Centric Test OpMode")
public class FieldCentricTestOpMode extends CommandOpMode {
    private MecanumDriveReal drive;
    private GamepadEx pad;

    private Flywheel flywheel;

    private Intake intake;

    private double leftTrig;

    private GamepadEx driverPad;

    @Override
    public void initialize() {
        flywheel = new Flywheel(hardwareMap, "fly1", "fly2");
        intake = new Intake(hardwareMap, "it");
        drive = new MecanumDriveReal(hardwareMap);
        pad = new GamepadEx(gamepad1);
        drive.setMaxSpeed(0.9);
        driverPad = new GamepadEx(gamepad1);
        register(drive);
        register(intake);
        register(flywheel);


    }

    @Override
    public void run() {
        super.run();
        double strafe = driverPad.getLeftX();
        double forward = driverPad.getLeftY();
        double turn =  driverPad.getRightX();
        drive.driveFieldCentric(strafe,forward,turn);

        leftTrig = driverPad.getTrigger(GamepadKeys.Trigger.LEFT_TRIGGER);



        flywheel.prepLaunch(leftTrig);

        if (driverPad.getButton(GamepadKeys.Button.A)) {
            intake.takeIn();
        }

        if (driverPad.getButton(GamepadKeys.Button.B)) {
            intake.expel();
        }





        telemetry.addData("Heading (deg)", drive.getHeadingDegrees());
        telemetry.addData("Strafe", strafe);
        telemetry.addData("Forward", forward);
        telemetry.addData("Turn",    turn);
        telemetry.update();
    }
}

