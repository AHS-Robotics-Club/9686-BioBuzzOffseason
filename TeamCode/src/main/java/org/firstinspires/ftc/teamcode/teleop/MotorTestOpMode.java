package org.firstinspires.ftc.teamcode.teleop;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.seattlesolvers.solverslib.command.CommandOpMode;
import com.seattlesolvers.solverslib.gamepad.GamepadEx;
import com.seattlesolvers.solverslib.gamepad.GamepadKeys;

@TeleOp
public class MotorTestOpMode extends CommandOpMode {
    GamepadEx driverPad;

    private DcMotorEx testMotor;

    public void initialize() {

        driverPad = new GamepadEx(gamepad1);
        testMotor = hardwareMap.get(DcMotorEx.class, "testmotor");




    }

    public void run() {

        if (driverPad.getButton(GamepadKeys.Button.X)) {

            testMotor.setPower(1);



        } else {

            testMotor.setPower(0);
        }

        if (driverPad.getButton(GamepadKeys.Button.A)) {

            testMotor.setPower(-1);



        } else {

            testMotor.setPower(0);
        }


    }
}
