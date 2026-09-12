package org.firstinspires.ftc.teamcode.subsystems;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.seattlesolvers.solverslib.command.SubsystemBase;
import com.qualcomm.robotcore.hardware.DcMotorEx;

public class Flywheel extends SubsystemBase {
    private  DcMotorEx flywheel1, flywheel2;



    public Flywheel(final HardwareMap hMap) {

        flywheel1 = hMap.get(DcMotorEx.class, "fly1");
        flywheel2 = hMap.get(DcMotorEx.class, "fly2");

        flywheel1.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        flywheel2.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

        flywheel1.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);
        flywheel2.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);



    }

    @Override



    public void periodic() {


    }



}
