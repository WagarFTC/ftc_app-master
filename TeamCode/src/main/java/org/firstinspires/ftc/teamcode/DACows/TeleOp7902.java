package org.firstinspires.ftc.teamcode.DACows;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.Gamepad;

/**
 * Created by nova on 11/8/2017.
 */
@TeleOp
public class TeleOp7902  extends LinearOpMode {
    Robot7902 robot = new Robot7902();

    public void runOpMode() throws InterruptedException {
        robot.init(hardwareMap);
        waitForStart();
       while(opModeIsActive()) {
           robot.tankDrive(gamepad1.left_stick_y, gamepad1.right_stick_y);
           if(gamepad2.right_trigger > .02) {
               robot.setGlyphSmasherPower(gamepad2.right_trigger);
           } else if (gamepad2.left_trigger > .02){
               robot.setGlyphSmasherPower(-gamepad2.left_trigger);
           } else {
               robot.setGlyphSmasherPower(0);
           }

           if (gamepad1.right_trigger > .02){
               robot.setDriveBaseMultiplyer(.5);
           }else robot.setDriveBaseMultiplyer(1);

           robot.setGlyphLiftPower(gamepad2.left_stick_y);
           robot.writePowers();
       }

    }
}