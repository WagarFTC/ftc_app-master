package org.firstinspires.ftc.teamcode.Bulldozers;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.Bulldozers.Robot7901;
import org.firstinspires.ftc.teamcode.General.PossibleColors;

/**
 * Created by nova on 11/10/2017.
 */

public class JewelAutonRed1 extends LinearOpMode {
    Robot7901 robot = new Robot7901();

    public void runOpMode() throws InterruptedException{
        robot.init(hardwareMap);
        waitForStart();
        robot.setJewelServoDown();
        robot.writePowers();
        double t0 = this.getRuntime();
        while (opModeIsActive() && this.getRuntime() -t0 < .2){

        }
        if (robot.colorSensorSeesColor(PossibleColors.RED)){
            robot.tankDrive(-.7,.7);
        } else if(robot.colorSensorSeesColor(PossibleColors.BLUE)){
            robot.tankDrive(.7,-.7);
        }
        robot.writePowers();
        t0 = this.getRuntime();
        while (opModeIsActive() && this.getRuntime() -t0 < .2){

        }
        robot.tankDrive(0,0);
        robot.setJewelServoUp();
        robot.writePowers();

    }
}
