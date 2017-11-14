package org.firstinspires.ftc.teamcode.Bulldozers;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.robotcore.internal.android.dx.ssa.BasicRegisterMapper;
import org.firstinspires.ftc.teamcode.General.PossibleColors;

/**
 * Created by nova on 11/9/2017.
 */
@Autonomous

public class AutonParking1 extends LinearOpMode{

    Robot7901 robot = new Robot7901();

    public void runOpMode ()throws InterruptedException {
        robot.init(hardwareMap);
        waitForStart();
        this.resetStartTime();
        robot.setDriveZeroPower(DcMotor.ZeroPowerBehavior.BRAKE);
        while (this.getRuntime() < 1 && opModeIsActive()) {
            robot.tankDrive(1, 1);
            robot.writePowers();

        }
        robot.tankDrive(0, 0);
        robot.writePowers();
    }






}
