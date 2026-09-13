package org.firstinspires.ftc.teamcode.teleop;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.seattlesolvers.solverslib.command.CommandBase;
import com.seattlesolvers.solverslib.command.CommandOpMode;
import com.seattlesolvers.solverslib.gamepad.GamepadEx;

import java.util.function.DoubleSupplier;
import org.firstinspires.ftc.teamcode.subsystems.MecanumDriveReal;


@TeleOp(name = "Field Centric Test OpMode")
public class FieldCentricTestOpMode extends CommandOpMode {
    private MecanumDriveReal drive;
    private GamepadEx pad;

    @Override
    public void initialize() {
        drive = new MecanumDriveReal(hardwareMap);
        pad = new GamepadEx(gamepad1);
        drive.setMaxSpeed(0.5);
        register(drive);


    }

    @Override
    public void run() {
        super.run();
        double strafe = pad.getLeftX();
        double forward = -pad.getLeftY();
        double turn =  pad.getRightX();
        drive.driveFieldCentric(strafe,forward,turn);

        telemetry.addData("Heading (deg)", drive.getHeadingDegrees());
        telemetry.addData("Strafe", strafe);
        telemetry.addData("Forward", forward);
        telemetry.addData("Turn",    turn);
        telemetry.update();
    }
}

