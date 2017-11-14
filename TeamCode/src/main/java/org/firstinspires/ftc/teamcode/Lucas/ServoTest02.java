package org.firstinspires.ftc.teamcode.Lucas;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.DACows.Robot7902;

@TeleOp
public class ServoTest02 extends LinearOpMode{
    Robot7902 robot = new Robot7902();

    public void runOpMode() throws InterruptedException{
        robot.init(hardwareMap);

        waitForStart();

        while(opModeIsActive()) {
            if (gamepad1.right_trigger > .02) {
                robot.setJewelServoPosition(gamepad1.right_trigger);
            } else if (gamepad1.left_trigger > .02) {
                robot.setJewelServoPosition(-gamepad1.left_trigger);
            } else {
                robot.setJewelServoPosition(0);
            }
            robot.writePowers();
        }
    }
}
