package org.firstinspires.ftc.teamcode.subsystems;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.seattlesolvers.solverslib.command.SubsystemBase;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.seattlesolvers.solverslib.controller.PIDController;
import com.seattlesolvers.solverslib.controller.PIDFController;

public class Intake extends SubsystemBase {
    private  DcMotorEx intake;

//    private PIDController flywheelpid;

//    private double currentVelo, targetVelo, output;

    //6k cpr = 28, 28 * 6000





    public Intake(final HardwareMap hMap, final String it) {

        intake = hMap.get(DcMotorEx.class, it);


        intake.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);


        intake.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);


        intake.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        intake.setDirection(DcMotorSimple.Direction.REVERSE);

//        flywheelpid = new PIDController(0,0,0);



    }

    public void expel() {

        intake.setPower(-1);
    }

    public void takeIn() {

        intake.setPower(1);
    }







    @Override
    public void periodic() {

        intake.setPower(0.6);

        }


//        output = flywheelpid.calculate(currentVelo,targetVelo);
//        flywheel1.setPower(output);



    }



