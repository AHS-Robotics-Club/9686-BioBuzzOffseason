package org.firstinspires.ftc.teamcode.teleop;

import com.acmerobotics.dashboard.config.Config;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.seattlesolvers.solverslib.command.CommandOpMode;
import com.seattlesolvers.solverslib.hardware.motors.Motor;


@Config
@TeleOp(name = "Flywheeldirtest")
public class FlywheelDirTest extends CommandOpMode {

    private DcMotorEx flywheel1, flywheel2;

    private HardwareMap hMap;


    @Override
    public void initialize() {

        flywheel1 = hardwareMap.get(DcMotorEx.class, "fly1");
        flywheel2 = hardwareMap.get(DcMotorEx.class, "fly2");
        flywheel1.setZeroPowerBehavior(DcMotorEx.ZeroPowerBehavior.FLOAT);
        flywheel2.setZeroPowerBehavior(DcMotorEx.ZeroPowerBehavior.FLOAT);
    }

    @Override
    public void run() {
        super.run();

        flywheel1.setPower(1);




    }
}

