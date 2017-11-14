package org.firstinspires.ftc.teamcode.DACows;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.General.PossibleColors;

/**
 * Created by nova on 11/8/2017.
 */
@Autonomous
public class colorTest extends LinearOpMode {

    Robot7902 robot = new Robot7902();
    public void runOpMode () throws InterruptedException{
        robot.init(hardwareMap);
        waitForStart();
        while (opModeIsActive()) {
            float[]  hsv = robot.colorSensorHSV();
            double hue = hsv[0];
            if (hue < 10 || hue > 177.5) {
                telemetry.addData("Color", "RED");
            } else if (hue > 150 && hue < 250) {
                telemetry.addData("Color", "BLUE");
            } else {
                telemetry.addData("Color", "UKN");
            }
            telemetry.addData("red", robot.colorSensorSeesColor(PossibleColors.RED));
            telemetry.addData("blue", robot.colorSensorSeesColor(PossibleColors.BLUE));
            telemetry.addData("unkown", robot.colorSensorSeesColor(PossibleColors.UNKOWN));
            telemetry.addData("H", hsv[0]);
            telemetry.addData("S", hsv[1]);
            telemetry.addData("V", hsv[2]);
            telemetry.update();
        }
    }
}
