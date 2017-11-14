package org.firstinspires.ftc.teamcode.Bulldozers;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

/**
 * Created by nova on 11/10/2017.
 */
@TeleOp
public class TeleOp7901 extends LinearOpMode {
    Robot7901 robot = new Robot7901();

    public void runOpMode() throws InterruptedException {
        robot.init(hardwareMap);
        waitForStart();
        while(opModeIsActive()) {
            robot.tankDrive(gamepad1.left_stick_y, gamepad1.right_stick_y);
            if(gamepad2.right_trigger > .02) {
                robot.setIntakePower(gamepad2.right_trigger, gamepad2.right_trigger);
            } else if (gamepad2.left_trigger > .02){
                robot.setIntakePower(-gamepad2.left_trigger, -gamepad2.left_trigger);
            } else {
                robot.setIntakePower(0, 0);
            }

            if (gamepad1.right_trigger > .02){
                robot.setDriveBaseMultiplier(.5);
            }else robot.setDriveBaseMultiplier(1);

            robot.setLiftPower(gamepad2.left_stick_y, gamepad2.right_stick_y);
            robot.writePowers();

        }

    }
}
