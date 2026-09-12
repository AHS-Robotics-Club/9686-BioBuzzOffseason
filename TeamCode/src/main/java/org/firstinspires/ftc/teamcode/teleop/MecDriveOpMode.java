package org.firstinspires.ftc.teamcode.teleop;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.seattlesolvers.solverslib.command.CommandOpMode;
import com.seattlesolvers.solverslib.gamepad.GamepadEx;
import com.seattlesolvers.solverslib.gamepad.GamepadKeys;
import com.seattlesolvers.solverslib.hardware.motors.Motor;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.IMU;
import com.seattlesolvers.solverslib.hardware.RevIMU;

import org.firstinspires.ftc.teamcode.subsystems.MecanumDrive;


@TeleOp
public class MecDriveOpMode extends CommandOpMode {
    private Motor fL, fR, bL, bR;
    private MecanumDrive drive;
    private GamepadEx driverOp;

    @Override
    public void initialize(){
        drive = new MecanumDrive(fL,fR,bL,bR);
        driverOp = new GamepadEx(gamepad1);
        fL = new Motor(hardwareMap, "fL");
        bR = new Motor(hardwareMap, "bR");
        fR = new Motor(hardwareMap, "fR");
        bL = new Motor(hardwareMap, "bL");

        RevIMU imu = new RevIMU(hardwareMap, "imu");
        imu.init();
        double heading = imu.getHeading();


    }

    @Override
    public void run(){
        drive.driveRobotCentric(
                driverOp.getLeftX(),
                driverOp.getLeftY(),
                driverOp.getRightX()
        );
    }
}
