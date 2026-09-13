package org.firstinspires.ftc.teamcode.teleop;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.seattlesolvers.solverslib.command.CommandOpMode;
import com.seattlesolvers.solverslib.gamepad.GamepadEx;
import com.seattlesolvers.solverslib.gamepad.GamepadKeys;
import com.seattlesolvers.solverslib.hardware.motors.Motor;

@TeleOp (name = "motorrun")
public class MotorMoveOpMode extends CommandOpMode {
    Motor motor1, motor2;
    GamepadEx gamepadEx;
    @Override
    public void initialize() {
        motor1 = new Motor (hardwareMap, "motor1");
        motor2 = new Motor (hardwareMap, "motor2");
        gamepadEx = new GamepadEx(gamepad1);
    }

    public void run(){
        if(gamepadEx.getTrigger(GamepadKeys.Trigger.RIGHT_TRIGGER)>0){
            telemetry.addData("working", gamepadEx.getTrigger(GamepadKeys.Trigger.RIGHT_TRIGGER));
            motor1.set(1);
            motor2.set(-1);
        }
        if(gamepadEx.getTrigger(GamepadKeys.Trigger.LEFT_TRIGGER)>0){
            telemetry.addData("working", gamepadEx.getTrigger(GamepadKeys.Trigger.LEFT_TRIGGER));
            motor1.set(-1);
            motor2.set(1);
        }
        if(gamepadEx.getButton(GamepadKeys.Button.A)){
            motor1.set(0);
            motor2.set(0);
        }
        super.run();
    }
}
