package org.firstinspires.ftc.teamcode.subsystems;

import com.qualcomm.hardware.rev.RevHubOrientationOnRobot;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.IMU;
import com.seattlesolvers.solverslib.command.SubsystemBase;
import com.seattlesolvers.solverslib.hardware.motors.Motor;
import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;

public class MecanumDriveReal extends SubsystemBase {
    private MecanumDriveHelper drive;
    private IMU imu;

    public MecanumDriveReal(HardwareMap hw){
        Motor fL = new Motor(hw, "fL");
        Motor fR = new Motor(hw, "fR");
        Motor bR = new Motor(hw, "bR");
        Motor bL = new Motor(hw, "bL");

        fL.motor.setDirection(DcMotorEx.Direction.REVERSE);
        bL.motor.setDirection(DcMotorEx.Direction.REVERSE);

        drive = new MecanumDriveHelper(false, fL, fR, bL, bR);

        imu = hw.get(IMU.class, "imu");
        imu.initialize(new IMU.Parameters(new RevHubOrientationOnRobot(
                RevHubOrientationOnRobot.LogoFacingDirection.LEFT,
                RevHubOrientationOnRobot.UsbFacingDirection.UP
        )));
        imu.resetYaw();
    }

        public void driveFieldCentric(double strafe, double forward, double turn) {
            double heading = imu.getRobotYawPitchRollAngles().getYaw(AngleUnit.RADIANS);
            drive.driveFieldCentric(strafe,forward,turn, heading );

        }

        public double getHeadingDegrees(){
            return imu.getRobotYawPitchRollAngles().getYaw(AngleUnit.DEGREES);


    }


    public void setMaxSpeed(double v) {
        drive.setMaxSpeed(v);
    }
}
