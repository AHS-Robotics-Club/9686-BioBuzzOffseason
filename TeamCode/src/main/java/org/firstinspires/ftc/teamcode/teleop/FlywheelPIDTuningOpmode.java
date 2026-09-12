package org.firstinspires.ftc.teamcode.teleop;

import com.acmerobotics.dashboard.FtcDashboard;
import com.acmerobotics.dashboard.config.Config;
import com.acmerobotics.dashboard.telemetry.TelemetryPacket;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.seattlesolvers.solverslib.command.CommandOpMode;


import org.firstinspires.ftc.teamcode.subsystems.Flywheel;

import com.seattlesolvers.solverslib.gamepad.GamepadEx;
import com.seattlesolvers.solverslib.gamepad.GamepadKeys;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
@Config
@TeleOp(name = "Flywheel PID Tuning Opmode")
public class FlywheelPIDTuningOpmode extends CommandOpMode {

    private Flywheel flywheel;

    private FtcDashboard dash;

    private DcMotorEx flywheel1, flywheel2;

    private GamepadEx driverPad;


    public static double kP = 0.000455; // Default PID constants
    public static double kI = 0.0000000;
    public static double kD = 0.00000;

    public static double pidTarget = 0;

    @Override
    public void initialize() {
        // Initialize the Spindex subsystem

        driverPad = new GamepadEx(gamepad1);
        dash = FtcDashboard.getInstance();
        flywheel = new Flywheel(hardwareMap);



        // Register the Spindex subsystem
        register(flywheel);

    }

    @Override
    public void run() {
        super.run();






        // Read the PID constants from the Dashboard sliders
        // Assuming these sliders are created on the Dashboard with the names "kP", "kI", "kD"// Default to current value if not set

        // Set the updated PID values in the Spindex subsystem
        flywheel.setPID(kP, kI, kD);

        // Get the current position and the target position
        double currentVelo = flywheel.velocityGetter();
        flywheel.setTargetVelo(pidTarget);

        // Calculate the PID error
        double error = Math.abs(pidTarget) - Math.abs(currentVelo);

        // Send the PID constants and the error to the telemetry

        TelemetryPacket packet = new TelemetryPacket();
        packet.put("PID kP", kP);
        packet.put("PID kI", kI);
        packet.put("PID kD", kD);
        packet.put("Current Velo(Ticks)", currentVelo);
        packet.put("Target Velo (Ticks)", pidTarget);
        packet.put("Error", error);
        dash.sendTelemetryPacket(packet);

    }
}