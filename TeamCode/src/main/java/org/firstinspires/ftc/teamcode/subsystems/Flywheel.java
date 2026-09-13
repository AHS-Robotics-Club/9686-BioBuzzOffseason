package org.firstinspires.ftc.teamcode.subsystems;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.seattlesolvers.solverslib.command.SubsystemBase;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.seattlesolvers.solverslib.controller.PIDController;
import com.seattlesolvers.solverslib.controller.PIDFController;

public class Flywheel extends SubsystemBase {
    private  DcMotorEx flywheel1, flywheel2;

    private PIDController flywheelpid;

    private double currentVelo, targetVelo, output;

    //6k cpr = 28, 28 * 6000





    public Flywheel(final HardwareMap hMap) {

        flywheel1 = hMap.get(DcMotorEx.class, "fly1");
        flywheel2 = hMap.get(DcMotorEx.class, "fly2");

        flywheel1.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        flywheel2.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        flywheel1.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);
        flywheel2.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);

        flywheel1.setDirection(DcMotorSimple.Direction.REVERSE);

        flywheelpid = new PIDController(0,0,0);



    }

    public double velocityGetter() {

        currentVelo = flywheel1.getVelocity();
        return currentVelo;

    }

    public void setTargetVelo(double tVelo) {
        targetVelo = tVelo;

    }

    public double targetVeloGetter() {
    return targetVelo;

    }





    public void setPID(double kP, double kI, double kD) {

        flywheelpid.setPID(kP, kI, kD);



    }



    @Override
    public void periodic() {

        currentVelo = flywheel1.getVelocity();


        if (currentVelo < targetVelo - 20) {
            flywheel1.setPower(1);
        } else {

            flywheel1.setPower(0);
        }


//        output = flywheelpid.calculate(currentVelo,targetVelo);
//        flywheel1.setPower(output);



    }


}
