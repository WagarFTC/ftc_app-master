package org.firstinspires.ftc.teamcode.DACows;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.teamcode.General.PossibleColors;


@Autonomous

public class JewelTestAutonomous extends LinearOpMode {
    Robot7902 robot = new Robot7902();
    public void runOpMode ()throws InterruptedException{
        robot.init(hardwareMap);
        waitForStart();
        robot.setJewelServoPosition(0);
        robot.writePowers();
        double t0 = this.getRuntime();
        while (opModeIsActive() && this.getRuntime() - t0 < 2){

        }
        if (robot.colorSensorSeesColor(PossibleColors.RED)){
            robot.tankDrive(.7,-.7);
        } else if(robot.colorSensorSeesColor(PossibleColors.BLUE)){
            robot.tankDrive(-.7,.7);
        }
        robot.writePowers();
         t0 = this.getRuntime();
        while (opModeIsActive() && this.getRuntime() -t0 < .2){

        }
        robot.tankDrive(0,0);
        robot.setJewelServoPosition(1);
        robot.writePowers();
    }

}
